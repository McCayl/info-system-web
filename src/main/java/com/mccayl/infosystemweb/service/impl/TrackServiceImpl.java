package com.mccayl.infosystemweb.service.impl;

import com.mccayl.infosystemweb.exception.TrackNotFoundException;
import com.mccayl.infosystemweb.model.Track;
import com.mccayl.infosystemweb.repository.TrackRepository;
import com.mccayl.infosystemweb.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackRepository trackRepo;

    @Override
    public Track addTrack(Track track) {
        return trackRepo.saveAndFlush(track);
    }

    @Override
    public void deleteTrackById(Long id) {
        trackRepo.deleteById(id);
    }

    @Override
    public Track editTrack(Long id, Track newTrack) {
        return trackRepo.findById(id).map(track -> {
            track.setName(newTrack.getName());
            track.setAuthor(newTrack.getAuthor());
            track.setGenre(newTrack.getGenre());
            track.setLength(newTrack.getLength());
            return trackRepo.saveAndFlush(track);
        }).orElseGet(() -> {
           newTrack.setId(id);
           return trackRepo.saveAndFlush(newTrack);
        });
    }

    @Override
    public List<Track> getAll() {
        return trackRepo.findAll();
    }

    @Override
    public Track getById(Long id) {
        return trackRepo.findById(id)
                .orElseThrow(() -> new TrackNotFoundException(id));
    }

}