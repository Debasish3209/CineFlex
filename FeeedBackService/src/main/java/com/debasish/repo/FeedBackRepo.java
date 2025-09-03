package com.debasish.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.debasish.model.FeedBack;

@Repository
public interface FeedBackRepo extends JpaRepository<FeedBack, String>{

	Optional<List<FeedBack>> findByCustId(String custId);
	Optional<List<FeedBack>> findByMovieId(String movieId);
}
