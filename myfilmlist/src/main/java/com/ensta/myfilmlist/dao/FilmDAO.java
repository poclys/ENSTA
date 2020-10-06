package com.ensta.myfilmlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ensta.myfilmlist.exception.DaoException;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.persistence.ConnectionManager;

import org.springframework.stereotype.Repository;

@Repository
public class FilmDAO {
    private static final String FIND_FILMS_QUERY = "SELECT id, titre, duration FROM Film;";

    public List<Film> findAll() throws DaoException {
		List<Film> resultList = new ArrayList<>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(FIND_FILMS_QUERY);) {
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				Film film = new Film(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));

				resultList.add(film);
			}
			return resultList;

		} catch (SQLException e) {
			throw new DaoException("Erreur lors du SELECT : " + e.getMessage());
		}
	}
}