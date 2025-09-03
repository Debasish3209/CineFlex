package com.debasish.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debasish.dto.MovieDto;
import com.debasish.model.Movie;
import com.debasish.service.MovieService;
import com.debasish.utility.ResponseStructure;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

	private MovieService movieService;
	@PostMapping
	public ResponseEntity<ResponseStructure<Movie>>createMovie(@RequestBody MovieDto movieDto){
		return movieService.createMovie(movieDto);
	}
	@GetMapping("/{movieId}")
	public ResponseEntity<ResponseStructure<Movie>>findByMovieId(@PathVariable("movieId")String movieId){
		return movieService.findByMovieId(movieId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Movie>>> getAllMovies(){
		return movieService.getAllMovies();
	}
}
