package com.ensta.myfilmlist.service;

import java.util.List;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.DaoException;
import com.ensta.myfilmlist.mapper.FilmMapper;

import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private FilmDAO filmDAO;

    public FilmService(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    public List<FilmDTO> findAll() throws DaoException {
        return FilmMapper.listFilmToListFilmDTO(filmDAO.findAll());
    }
}