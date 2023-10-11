package com.example.musicapi.service;

import com.example.musicapi.domain.Artist;
import com.example.musicapi.domain.Track;
import com.example.musicapi.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;
    @Autowired
    private ArtistService artistService;

    public Track saveTrack(Track track) {
        Artist artist = track.getTrackArtist();
        if (artist != null && artist.getId() != 0) {
            Optional<Artist> existingArtist = artistService.findArtistById(artist.getId());
            if (existingArtist.isPresent())
                track.setTrackArtist(existingArtist.get());
            else
                throw new RuntimeException("Artist with id " + artist.getId() + " not found.");
        }
        return trackRepository.save(track);
    }

    public List<Track> findAllTracks() {
        return trackRepository.findAll();
    }

    public Track findTrack(int trackId) {
        Optional<Track> track = trackRepository.findById(trackId);
        return track.orElse(null);
    }

    public Boolean deleteTrack(int trackId) {
        Track track = findTrack(trackId);
        if (track == null)
            return false;
        trackRepository.delete(track);
        return true;
    }

    public List<Track> findTrackByArtistName(String artistName) {
        Artist artist = artistService.findArtistByName(artistName);
        if (artist == null) return null;

        return trackRepository.findByArtistName(artistName);
    }

}
