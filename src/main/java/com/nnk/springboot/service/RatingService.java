package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;

import java.util.List;

public interface RatingService {

    public Rating getByRating(int id);

    public List<Rating> getAllByRating();

    public void saveRating(Rating rating);

    public void updateRating(Rating rating);

    public void deleteRating(int id);

}
