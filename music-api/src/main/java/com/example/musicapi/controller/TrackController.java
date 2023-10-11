package com.example.musicapi.controller;

import com.example.musicapi.domain.Artist;
import com.example.musicapi.domain.Track;
import com.example.musicapi.service.ArtistService;
import com.example.musicapi.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @GetMapping
    public ResponseEntity<?> findTracks(@RequestParam(required = false) String artistName) {
        if (artistName == null)
            return new ResponseEntity<>(trackService.findAllTracks(), HttpStatus.OK);

        List<Track> tracks = trackService.findTrackByArtistName(artistName);
        if (tracks == null)
            return new ResponseEntity<>("Artist Not Found", HttpStatus.NOT_FOUND);
        else if (tracks.isEmpty())
            return new ResponseEntity<>("No tracks found for that artist", HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(tracks, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Track> saveTrack(@RequestBody Track track) {
        return new ResponseEntity<>(trackService.saveTrack(track), HttpStatus.CREATED);
    }

    @GetMapping("/{trackId}")
    public ResponseEntity<Track> findTrack(@PathVariable int trackId) {
        Track track = trackService.findTrack(trackId);
        if (track == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(track, HttpStatus.OK);
    }

    @DeleteMapping("/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId) {
        Boolean deleted = trackService.deleteTrack(trackId);
        if (!deleted) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(HttpStatus.OK);
    }
}
