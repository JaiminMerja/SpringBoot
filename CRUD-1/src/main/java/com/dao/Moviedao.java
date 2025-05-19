package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.model.Movie;

@Repository
public class Moviedao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//CREATE
	public int addMovie(Movie movie)
	{
		String sql = "INSERT INTO movies (id, title, genre, rating) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql,movie.getId(), movie.getTitle(), movie.getGenre(), movie.getRating());
	}
	
	//READALL
	public List<Movie> getAllMovie()
	{
		return jdbcTemplate.query("SELECT * FROM movies", BeanPropertyRowMapper.newInstance(Movie.class));
	}
	
	//READONE
	public Movie getMovieById(int id)
	{
		String sql = "SELECT * FROM movies WHERE id = ?";
		return jdbcTemplate.queryForObject(sql,  BeanPropertyRowMapper.newInstance(Movie.class), id);
	}
	
	//UPDATE
	public int updateMovie(Movie  movie)
	{
		String sql = "UPDATE movies SET title = ?, genre = ?, rating = ? WHERE id = ?;";
		return jdbcTemplate.update(sql, movie.getTitle(), movie.getGenre(), movie.getRating());
	}
	
	//DELETE
	public int deleteMovie(int id)
	{
		return jdbcTemplate.update("DELETE FROM movies WHERE id = ?;");
	}
}
