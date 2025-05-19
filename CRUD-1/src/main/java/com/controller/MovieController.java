package com.controller;

import java.util.List;

import com.dao.Moviedao;
import com.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController 
{
	@Autowired
	private Moviedao moviedao;
	
	@PostMapping("/add")
	public String addMovie(@RequestBody Movie movie)
	{
		moviedao.addMovie(movie);
		return "Movie Added!!!!!";
	}
	@GetMapping
	public List<Movie> getAllMovie()
	{
		return moviedao.getAllMovie();
	}
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable int id)
	{
		return moviedao.getMovieById(id);
	}
	@PutMapping("/update")
	public String updateMovie(@RequestBody Movie movie)
	{
		moviedao.addMovie(movie);
		return "Movie Updated!!!!!!";
	}
	@DeleteMapping("/{id}")
	public String deleteMovie(@PathVariable int id)
	{
		moviedao.deleteMovie(id);
		return "Deleted Movie!!!!";
	}
	
}
