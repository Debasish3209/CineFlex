package com.debasish.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Movie {

	private String M_id;
	private String M_Location;
	private String M_Name;
	private String M_HallName;
	private String M_TotalSeats;
	private String M_SeatAvailables;
	private String M_BookedSeats;
	private String M_Price;
}
