package com.mccayl.infosystemweb.service.impl;

import com.mccayl.infosystemweb.exception.AlbumNotFoundException;
import com.mccayl.infosystemweb.model.Album;
import com.mccayl.infosystemweb.model.Track;
import com.mccayl.infosystemweb.repository.AlbumRepository;
import com.mccayl.infosystemweb.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepo;

    @Override
    public Album addAlbum(Album album) {
        return albumRepo.saveAndFlush(album);
    }

    @Override
    public void deleteAlbumById(Long id) {
        albumRepo.deleteById(id);
    }

    @Override
    public Album editAlbum(Long id, Album newAlbum) {
        return albumRepo.findById(id).map(album -> {
            album.setName(newAlbum.getName());
            album.setYear(newAlbum.getYear());
            return albumRepo.saveAndFlush(album);
        }).orElseThrow(() -> new AlbumNotFoundException(id));
    }

    @Override
    public List<Album> getAll() {
        return albumRepo.findAll();
    }

    @Override
    public Album getById(Long id) {
        return albumRepo.findById(id)
                .orElseThrow(() -> new AlbumNotFoundException(id));
    }

    @Override
    public Track addTrackToAlbum(Long id, Track track) {
        return albumRepo.findById(id).map(album -> {
            album.addTrack(track);
            albumRepo.saveAndFlush(album);
            return track;
        }).orElseThrow(() -> new AlbumNotFoundException(id));
    }

    @Override
    public void deleteTrackFromAlbum(Long id, Track track) {
        albumRepo.findById(id).map(album -> {
            album.deleteTrack(track);
            return albumRepo.saveAndFlush(album);
        }).orElseThrow(() -> new AlbumNotFoundException(id));
    }

    @Override
    public void deleteTrackFromAllAlbums(Track track) {
        albumRepo.findAll().forEach(el -> el.getTrackList().remove(track));
    }

    @Override
    public List<Track> getAlbumTracks(Long id) {
        return albumRepo.findById(id)
                .orElseThrow(() -> new AlbumNotFoundException(id))
                .getTrackList();
    }

}