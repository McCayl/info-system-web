package com.mccayl.infosystemweb.controller;

import com.mccayl.infosystemweb.model.Album;
import com.mccayl.infosystemweb.model.Track;
import com.mccayl.infosystemweb.service.AlbumService;
import com.mccayl.infosystemweb.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private TrackService trackService;

    @GetMapping
    public List<Album> getAll() {
        return albumService.getAll();
    }

    @GetMapping("{id}")
    public Album getAlbum(@PathVariable Long id) {
        return albumService.getById(id);
    }

    @PostMapping
    public Album addAlbum(@RequestBody Album album) {
        return albumService.addAlbum(album);
    }

    @DeleteMapping("{id}")
    public void delAlbum(@PathVariable Long id) {
        albumService.deleteAlbumById(id);
    }

    @PutMapping("{id}")
    public Album updateAlbum(@PathVariable Long id, @RequestBody Album album) {
        return albumService.editAlbum(id, album);
    }

    @PostMapping("{id}/tracks")
    public Track addTrack(@PathVariable Long id, @RequestBody Track track) {
        return albumService.addTrackToAlbum(id, track);
    }

    @PostMapping("{id}/tracks/{trId}")
    public Track addExstTrack(@PathVariable Long id, @PathVariable Long trId) {
        return albumService.addTrackToAlbum(id, trackService.getById(trId));
    }

    @DeleteMapping("{id}/tracks/{trId}")
    public void delTrack(@PathVariable Long id, @PathVariable Long trId) {
        albumService.deleteTrackFromAlbum(id, trackService.getById(trId));
    }

    @GetMapping("{id}/tracks")
    public List<Track> getTracks(@PathVariable Long id) {
        return albumService.getAlbumTracks(id);
    }

}