package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RatingController {
    private static final Logger logger = LogManager.getLogger(RatingController.class);

    private RatingService ratingService;

    @Autowired
    public void RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    /**
     * The controller method which route to rating page and loads all the rating
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        List<Rating> ratings = ratingService.getAllByRating();
        model.addAttribute("ratings",ratings);
        return "rating/list";
    }

    /**
     * The controller method which route to add rating page
     * @param rating this contains the rating object needs to be updated in DB
     * @return String name of the web page to be loaded
     */
    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    /**
     * The controller method which checks for error in the rating object and if not found add the entry in the DB
     * @param rating this contains the rating object needs to be added in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            ratingService.saveRating(rating);
            model.addAttribute("ratings",ratingService.getAllByRating());
            return "redirect:/rating/list";
        }
        return "rating/add";
    }

    /**
     * The controller method which find the rating object needs to be updated
     * @param id of the rating object needs to be updated
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Rating rating = ratingService.getByRating(id);
        model.addAttribute("rating", rating);
        return "rating/update";
    }

    /**
     * The controller method which checks for error in the rating object and if not found update the entry in the DB
     * @param id of the rating object needs to be updated
     * @param rating this contains the rating object needs to be updated in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "rating/update";
        }
        rating.setId(id);
        ratingService.updateRating(rating);
        model.addAttribute("ratings",ratingService.getAllByRating());
        return "redirect:/rating/list";
    }

    /**
     * The controller method which find the rating object needs to be deleted
     * @param id of the rating object needs to be deleted
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        ratingService.deleteRating(id);
        model.addAttribute("ratings",ratingService.getAllByRating());
        return "redirect:/rating/list";
    }

}
