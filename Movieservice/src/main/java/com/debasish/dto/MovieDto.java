package com.debasish.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MovieDto {

	private String movieId;
	private String movieLocation;
	private String movieName;
	private String hallName;
	private int totalSeats;
	private int seatAvailables;
	private int bookedSeats;
	private int moviePrice;
}
