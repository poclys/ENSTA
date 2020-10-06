package com.ensta.myfilmlist.cli;

import java.util.List;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.DaoException;
import com.ensta.myfilmlist.service.FilmService;

import org.springframework.stereotype.Controller;

@Controller
public class Cli {
    FilmService filmService;

    public Cli(FilmService filmService) {
        this.filmService = filmService;
    }

    public void start() throws DaoException {
        System.out.println("Actions possibles : /n");
        System.out.println("1 - Liste des films");
        List<FilmDTO> listFilmDTO = filmService.findAll();
        for (FilmDTO filmDTO : listFilmDTO){
            System.out.println(filmDTO.toString());
        }
    }


}