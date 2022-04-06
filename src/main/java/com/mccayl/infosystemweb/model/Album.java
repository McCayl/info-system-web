package com.mccayl.infosystemweb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer year;
    @ManyToMany(targetEntity = Track.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List <Track> trackList;

    public Album() {}

    public Album(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addTrack(Track track) {
        trackList.add(track);
    }

    public void deleteTrack(Track track) {
        trackList.remove(track);
    }

}