package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingControllerTest {

    @Mock
    RatingService ratingService;

    @InjectMocks
    RatingController ratingController;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void home() {
        String s = ratingController.home(model);
        Assert.assertEquals("rating/list", s);
    }

    @Test
    public void addRatingForm_validateResponseURL() {
        Rating rating = new Rating();
        rating.setId(1);
        rating.setMoodysRating("Moodys Rating");
        rating.setSandPRating("Sand PRating");
        rating.setFitchRating("Fitch Rating");
        rating.setOrderNumber(10);
        String s = ratingController.addRatingForm(rating);
        Assert.assertEquals("rating/add", s);
    }

    @Test
    public void validate_validateResponseURL() {
        Rating rating = new Rating();
        rating.setId(1);
        rating.setMoodysRating("Moodys Rating");
        rating.setSandPRating("Sand PRating");
        rating.setFitchRating("Fitch Rating");
        rating.setOrderNumber(10);
        String s = ratingController.validate(rating, bindingResult, model);
        Assert.assertEquals("redirect:/rating/list", s);
    }

    @Test
    public void showUpdateForm_validateResponseURL() {
        Rating rating = new Rating();
        rating.setId(1);
        rating.setMoodysRating("Moodys Rating");
        rating.setSandPRating("Sand PRating");
        rating.setFitchRating("Fitch Rating");
        rating.setOrderNumber(10);
        Mockito.when(ratingService.getByRating(1)).thenReturn(rating);
        String s = ratingController.showUpdateForm(1, model);
        Assert.assertEquals("rating/update", s);
    }

    @Test
    public void updateRating_validateResponseURL() {
        Rating rating = new Rating();
        rating.setId(1);
        rating.setMoodysRating("Moodys Rating");
        rating.setSandPRating("Sand PRating");
        rating.setFitchRating("Fitch Rating");
        rating.setOrderNumber(10);
        String s = ratingController.updateRating(1, rating, bindingResult, model);
        Assert.assertEquals("redirect:/rating/list", s);
    }

    @Test
    public void deleteRating_validateResponseURL() {
        Rating rating = new Rating();
        rating.setId(1);
        rating.setMoodysRating("Moodys Rating");
        rating.setSandPRating("Sand PRating");
        rating.setFitchRating("Fitch Rating");
        rating.setOrderNumber(10);
        Mockito.when(ratingService.getByRating(1)).thenReturn(rating);
        String s = ratingController.deleteRating(1, model);
        Assert.assertEquals("redirect:/rating/list", s);
    }

}