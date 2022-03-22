package com.mccayl.infosystemweb.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumViewController {

    @RequestMapping("albums")
    public String getAlbumsPage() {
        return "something/index.html"; //add path to your html page
    }

    @RequestMapping("albums/tracks")
    public String getAlbumTracksPage() {
        return "something/index.html"; //add path to your html page
    }

}