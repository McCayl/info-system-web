package com.mccayl.infosystemweb.service;

import com.mccayl.infosystemweb.model.Album;
import com.mccayl.infosystemweb.model.Track;

import java.util.List;

public interface AlbumService {

    Album addAlbum(Album album);
    void deleteAlbumById(Long id);
    Album editAlbum(Long id, Album album);
    List<Album> getAll();
    Album getById(Long id);
    Track addTrackToAlbum(Long id, Track track);
    void deleteTrackFromAlbum(Long id, Track track);
    void deleteTrackFromAllAlbums(Track track);
    List<Track> getAlbumTracks(Long id);

}