package com.debasish.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedBack {

	@Id
	private String fId;
	private String movieId;
	private String custId;
	private int fRating;
	private String fComment;
	private LocalDateTime fTimeStamp;
}
