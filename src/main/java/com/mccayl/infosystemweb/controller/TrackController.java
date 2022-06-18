package com.mccayl.infosystemweb.controller;

import com.mccayl.infosystemweb.model.Track;
import com.mccayl.infosystemweb.service.TrackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tracks")
public class TrackController {

    private TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public List<Track> getAll() {
        return trackService.getAll();
    }

    @GetMapping("{id}")
    public Track getTrack(@PathVariable Long id) {
        return trackService.getById(id);
    }

    @PostMapping
    public Track addTrack(@RequestBody Track track) {
        return trackService.addTrack(track);
    }

    @DeleteMapping("{id}")
    public void delTrack(@PathVariable Long id) {
        trackService.deleteTrackById(id);
    }

    @PutMapping("{id}")
    public Track updateTrack(@PathVariable Long id, @RequestBody Track track) {
        return trackService.editTrack(id, track);
    }

}