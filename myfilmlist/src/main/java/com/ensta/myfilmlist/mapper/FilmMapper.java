package com.ensta.myfilmlist.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.model.Film;

public class FilmMapper {

    public static FilmDTO filmToFilmDTO(Film film){
        return new FilmDTO(film.getId(),film.getTitre(), film.getDuration());
    }

    public static List<FilmDTO> listFilmToListFilmDTO(List<Film> listFilm){
        List<FilmDTO> listFilmDTO = new ArrayList<>();
        for (Film film : listFilm ){
            listFilmDTO.add(filmToFilmDTO(film));
        }
        return listFilmDTO;
    }
}