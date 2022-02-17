package com.mccayl.infosystemweb.service;

import com.mccayl.infosystemweb.model.Track;

import java.util.List;

public interface TrackService {

    Track addTrack(Track track);
    void deleteTrackById(Long id);
    Track editTrack(Long id, Track track);
    List <Track> getAll();
    Track getById(Long id);

}