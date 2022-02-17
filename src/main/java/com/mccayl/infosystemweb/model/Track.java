package com.mccayl.infosystemweb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private String genre;
    private Integer length;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "track_albums",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private List <Album> albums;

    public Track() {}

    public Track(String name, String author, String genre, Integer length) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}