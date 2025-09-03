package com.debasish.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.debasish.dto.MovieDto;
import com.debasish.exceptions.MovieNotFoundByIdException;
import com.debasish.model.Movie;
import com.debasish.repo.MovieRepository;
import com.debasish.service.MovieService;
import com.debasish.utility.ResponseStructure;

@Service
public class MovieServiceImpl implements MovieService {
	
	private MovieRepository movieRepository;
	private ResponseStructure<Movie> responseStructure;
	private ResponseStructure<List<Movie>>rs;
	
	MovieServiceImpl(MovieRepository movieRepository,ResponseStructure<Movie> responseStructure, ResponseStructure<List<Movie>>rs ){
		super();
		this.movieRepository=movieRepository;
		this.responseStructure=responseStructure;
		this.rs=rs;
	}

	@Override
	public ResponseEntity<ResponseStructure<Movie>> createMovie(MovieDto movieDto) {
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Movie created successfully")
				.setData(movieRepository.save(mapToMovie(movieDto))));
				
	}

	private Movie mapToMovie(MovieDto movieDto) {
		String randomMovieId=UUID.randomUUID().toString();
		return Movie.builder()
				.movieName(movieDto.getMovieName())
				.movieLocation(movieDto.getMovieLocation())
				.hallName(movieDto.getHallName())
				.totalSeats(movieDto.getTotalSeats())
				.bookedSeats(movieDto.getBookedSeats())
				.seatAvailables(movieDto.getSeatAvailables())
				.moviePrice(movieDto.getMoviePrice())
				.movieId(randomMovieId).build();
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Movie>>> getAllMovies() {
		return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value())
				.setMessage("Movie data fetched successfully")
				.setData(movieRepository.findAll()));
				
	}

	@Override
	public ResponseEntity<ResponseStructure<Movie>> findByMovieId(String movieId) {
		return movieRepository.findById(movieId).map(movie->ResponseEntity.ok(
				responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Movie has been founded successfully").setData(movie)))
				.orElseThrow(()-> new MovieNotFoundByIdException("sorry movie is not available"));
	}

	
}
