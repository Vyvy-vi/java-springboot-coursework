package com.example.musicapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TrackDetails")
public class Track {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int trackId;

    private String trackName;
    private List<String> trackComments;
    private Float trackRating;

    @ManyToOne(cascade = CascadeType.ALL)
    private Artist trackArtist;
}
