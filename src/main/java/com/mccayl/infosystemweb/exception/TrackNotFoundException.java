package com.mccayl.infosystemweb.exception;

public class TrackNotFoundException extends RuntimeException {

    public TrackNotFoundException(Long id) {
        super("Could not find track " + id);
    }

}