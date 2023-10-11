package com.example.musicapi.service;

import com.example.musicapi.domain.Artist;
import com.example.musicapi.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public Optional<Artist> findArtistById(Integer id) {
        return artistRepository.findById(id);
    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist findArtistByName(String name) {
        return artistRepository.findByName(name);
    }
}
