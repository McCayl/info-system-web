package com.mccayl.infosystemweb.repository;

import com.mccayl.infosystemweb.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository <Track, Long> {

}