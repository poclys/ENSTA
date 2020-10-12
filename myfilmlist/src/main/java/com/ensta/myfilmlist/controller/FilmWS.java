package com.ensta.myfilmlist.controller;

import java.util.List;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ControllerException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.service.FilmService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController("FilmWS")
@RequestMapping(value = "/film")
public class FilmWS {

    private FilmService filmService;

    public FilmWS(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    @ApiOperation(value = "Récupère la liste des films")
    public ResponseEntity<List<FilmDTO>> retrieveFilm() throws ControllerException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(filmService.findAll());
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }

}