package com.debasish.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.debasish.dto.FeedBackDto;
import com.debasish.model.FeedBack;
import com.debasish.utility.ResponseStructure;
@Service
public interface FeedBackService {

	public ResponseEntity<ResponseStructure<FeedBack>>createFeedBack(FeedBackDto feedBackDto);
	public ResponseEntity<ResponseStructure<List<FeedBack>>>getAllFeedBack();
	public ResponseEntity<ResponseStructure<List<FeedBack>>> getFeedBackByCustId(String custId);
	public ResponseEntity<ResponseStructure<List<FeedBack>>> getFeedBackByMovieId(String movieId);
}
