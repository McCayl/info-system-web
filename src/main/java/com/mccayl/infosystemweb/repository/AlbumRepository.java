package com.mccayl.infosystemweb.repository;

import com.mccayl.infosystemweb.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository <Album, Long> {

}