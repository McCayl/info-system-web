package com.mccayl.infosystemweb.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumViewController {

    @RequestMapping("albums")
    public String getAlbumsPage() {
        return "Albums.html"; //add path to your html page
    }

    @RequestMapping("albums-tracks")
    public String getAlbumTracksPage() {
        return "AlbumTracks.html"; //add path to your html page
    }

}