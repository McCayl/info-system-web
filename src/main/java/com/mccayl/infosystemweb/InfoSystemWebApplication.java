package com.mccayl.infosystemweb;

import com.mccayl.infosystemweb.controller.TrackController;
import com.mccayl.infosystemweb.model.Track;
import com.mccayl.infosystemweb.service.impl.TrackServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfoSystemWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoSystemWebApplication.class, args);
	}
}