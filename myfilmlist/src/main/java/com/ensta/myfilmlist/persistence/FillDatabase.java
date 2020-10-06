package com.ensta.myfilmlist.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2.tools.DeleteDbFiles;

public class FillDatabase {


    public static void main(String[] args) throws Exception {
        try {
            DeleteDbFiles.execute("~", "MyFilmListDatabase", true);
            insertWithPreparedStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	private static void insertWithPreparedStatement() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement createPreparedStatement = null;

        List<String> createTablesQueries = new ArrayList<String>();
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Film(id INT primary key auto_increment, film_id INT, titre VARCHAR(100), duration INT)");
        try {
            connection.setAutoCommit(false);

            for (String createQuery : createTablesQueries) {
            	createPreparedStatement = connection.prepareStatement(createQuery);
	            createPreparedStatement.executeUpdate();
	            createPreparedStatement.close();
            }

            // Remplissage de la base avec des Vehicules et des Clients
            Statement stmt = connection.createStatement();

            stmt.execute("INSERT INTO Film(titre, duration) VALUES('Matrix', 150)");
            
            connection.commit();
            System.out.println("Success!");
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}