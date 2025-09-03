package com.debasish.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.debasish.dto.MovieDto;
import com.debasish.model.Movie;
import com.debasish.utility.ResponseStructure;

public interface MovieService {

	public ResponseEntity<ResponseStructure<Movie>>createMovie(MovieDto movieDto);
	public ResponseEntity<ResponseStructure<List<Movie>>>getAllMovies();
	public ResponseEntity<ResponseStructure<Movie>> findByMovieId(String movieId);
}
