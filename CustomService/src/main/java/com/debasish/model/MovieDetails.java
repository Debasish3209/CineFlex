package com.debasish.model;

import java.sql.Date;
import java.util.List;

public class MovieDetails {

	private Long MD_id;
    private String MD_title;
    private String MD_description;
    private Date MD_releaseDate;
    private String MD_genre;
    private String MD_director;
    private List<String> MD_cast;
    private Double MD_rating;
    private Integer MD_duration;
}
