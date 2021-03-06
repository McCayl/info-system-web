package com.mccayl.infosystemweb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AlbumsServiceErrorAdvice {

    @ResponseBody
    @ExceptionHandler(AlbumNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String albumNotFoundHandler(AlbumNotFoundException ex) {
        return ex.getMessage();
    }

}