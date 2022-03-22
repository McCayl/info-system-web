package com.mccayl.infosystemweb.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrackViewController {

    @RequestMapping("tracks")
    public String getTracksPage() {
        return "something/index.html"; //add path to your html page
    }

}