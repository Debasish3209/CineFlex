package com.debasish.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="movies")
public class Movie {

	@Id
	private String movieId;
	private String movieLocation;
	private String movieName;
	private String hallName;
	private int totalSeats;
	private int seatAvailables;
	private int bookedSeats;
	private int moviePrice;
}
