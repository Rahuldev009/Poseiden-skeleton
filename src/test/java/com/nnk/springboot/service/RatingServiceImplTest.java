package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingServiceImplTest {

    @InjectMocks
    RatingServiceImpl ratingService;

    @Mock
    RatingRepository ratingRepository;

    @Test
    public void getByRating() {
        Rating rating = new Rating();
        rating.setMoodysRating("Moodys Rating");
        rating.setSandPRating("Sand PRating");
        rating.setFitchRating("Fitch Rating");
        rating.setOrderNumber(10);
        rating.setId(1);
        Mockito.when(ratingRepository.findById(1)).thenReturn(java.util.Optional.of(rating));
        Rating rating1 = ratingService.getByRating(1);
        Assert.assertTrue(rating1.getId() == 1);
    }

    @Test
    public void getAllByRating() {
        ratingService.getAllByRating();
        Mockito.verify(ratingRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void saveRating() {
        ratingService.saveRating(new Rating());
        Mockito.verify(ratingRepository, Mockito.times(1)).save(Mockito.any(Rating.class));
    }

    @Test
    public void updateRating() {
        ratingService.updateRating(new Rating());
        Mockito.verify(ratingRepository, Mockito.times(1)).save(Mockito.any(Rating.class));
    }

    @Test
    public void deleteRating() {
        Rating rating = new Rating();
        rating.setMoodysRating("Moodys Rating");
        rating.setSandPRating("Sand PRating");
        rating.setFitchRating("Fitch Rating");
        rating.setOrderNumber(10);
        rating.setId(1);
        Mockito.when(ratingRepository.findById(1)).thenReturn(java.util.Optional.of(rating));
        ratingService.deleteRating(1);
        Mockito.verify(ratingRepository, Mockito.times(1)).delete(Mockito.any(Rating.class));
    }
}