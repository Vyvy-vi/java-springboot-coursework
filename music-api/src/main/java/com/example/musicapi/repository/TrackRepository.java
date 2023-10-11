package com.example.musicapi.repository;

import com.example.musicapi.domain.Artist;
import com.example.musicapi.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    @Query("SELECT track FROM Track track WHERE track.trackArtist.name = :artistName")
    List<Track> findByArtistName(@Param("artistName") String artistName);
}
