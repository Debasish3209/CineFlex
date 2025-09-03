package com.debasish.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDetails {

	private String B_id;
    private String B_TicketNumber;
    private String B_CustomerName;
    private String B_MovieName;
    private String B_CustomerAddress;
    private String B_MovieLocation;
    private String B_SeatNumber;
    private String B_SeatPrice;
}
