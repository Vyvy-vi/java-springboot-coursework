package com.example.musicapi.repository;

import com.example.musicapi.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    public Artist findByName(String name);
}
