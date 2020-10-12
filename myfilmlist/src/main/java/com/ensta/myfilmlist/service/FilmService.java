package com.ensta.myfilmlist.service;

import java.util.List;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.DaoException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.mapper.FilmMapper;
import com.ensta.myfilmlist.model.Film;

import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private FilmDAO filmDAO;

    public FilmService(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    public List<FilmDTO> findAll() throws ServiceException {
        List<Film> listFilmModel;
        try {
            listFilmModel = FilmMapper.listFilmPojoToListFilm(filmDAO.findAll());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return FilmMapper.listFilmToListFilmDTO(listFilmModel);
    }
}