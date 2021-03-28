package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating getByRating(int id) {
        return ratingRepository.getOne(id);
    }

    @Override
    public List<Rating> getAllByRating() {
        return ratingRepository.findAll();
    }

    @Override
    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public void updateRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(int id) {
        ratingRepository.deleteById(id);
    }

}
