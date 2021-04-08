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

    /**
     * find the rating item by Id
     * @param id this is the id of rating item to be searched
     * @return rating object with the same Id
     */
    @Override
    public Rating getByRating(int id) {
        return ratingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Rating Id:" + id));
    }

    /**
     * find all items of rating
     * @return list of all rating items
     */
    @Override
    public List<Rating> getAllByRating() {
        return ratingRepository.findAll();
    }

    /**
     * save the rating item in the DB
     * @param rating this is the item to be saved in the DB
     */
    @Override
    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }

    /**
     * update the rating item in the DB
     * @param rating this is the item to be updated in the DB
     */
    @Override
    public void updateRating(Rating rating) {
        ratingRepository.save(rating);
    }

    /**
     * delete the rating item in the DB
     * @param id this is the id of rating item to be deleted
     */
    @Override
    public void deleteRating(int id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid Rating Id:" + id));
        ratingRepository.delete(rating);
    }

}
