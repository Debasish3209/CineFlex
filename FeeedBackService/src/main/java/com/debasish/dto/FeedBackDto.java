package com.debasish.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedBackDto {

	private String fId;
	private String movieId;
	private String custId;
	@JsonProperty("fRating")
	private int fRating;
	@JsonProperty("fComment")
	private String fComment;
	
	@JsonProperty("fTimeStamp")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime fTimeStamp;
}
