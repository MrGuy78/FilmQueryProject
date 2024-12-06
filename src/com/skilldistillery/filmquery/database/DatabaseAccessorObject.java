package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private String user = "student";
	private String pass = "student";

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String query = "SELECT * FROM film WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, filmId);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				film = new Film();
				film.setFilmId(rs.getInt("id"));
				film.setFilmTitle(rs.getString("title"));
				film.setFilmDesc(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLangId(rs.getInt("language_id"));
				film.setRentRate(rs.getInt("rental_Rate"));
				film.setFilmLength(rs.getInt("length"));
				film.setReplCost(rs.getDouble("replacement_cost"));
				film.setFilmRating(rs.getString("rating"));
				film.setSpecFeat(rs.getString("special_features"));
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String query = "SELECT * FROM actor WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, actorId);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				actor = new Actor();
				actor.setActorId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL);

			String query = "SELECT first_name, last_name FROM actor "
					+ " JOIN film_actor ON actor.id = film_actor.actor.id "
					+ " WHERE film_actor.film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load database driver:");
			e.printStackTrace();
			System.err.println("Exiting.");
			System.exit(1); // No point in continuing.
		}
	}
}