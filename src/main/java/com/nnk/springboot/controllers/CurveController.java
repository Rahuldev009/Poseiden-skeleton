package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;
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
public class CurveController {
    private static final Logger logger = LogManager.getLogger(CurveController.class);

    private CurvePointService curvePointService;

    @Autowired
    public void CurveController(CurvePointService curvePointService) {
        this.curvePointService = curvePointService;
    }

    /**
     * The controller method which route to curvepoint page and loads all the curvepoint
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @RequestMapping("/curvePoint/list")
    public String home(Model model) {
        List<CurvePoint> curvePoints = curvePointService.getAllCurvePoint();
        logger.info("all curvePoints list"+ curvePoints.toString());
        model.addAttribute("curvePoints", curvePoints);
        return "curvePoint/list";
    }

    /**
     * The controller method which route to add curvepoint page
     * @param bid this contains the curvepoint object needs to be updated in DB
     * @return String name of the web page to be loaded
     */
    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        logger.info("curvePoint to be added ");
        return "curvePoint/add";
    }

    /**
     * The controller method which checks for error in the curvepoint object and if not found add the entry in the DB
     * @param curvePoint this contains the curvepoint object needs to be added in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            logger.info("curvePoint to be added "+ curvePoint.toString());
            curvePointService.saveCurvePoint(curvePoint);
            model.addAttribute("curvePoints", curvePointService.getAllCurvePoint());
            return "redirect:/curvePoint/list";
        }
        return "curvePoint/add";
    }

    /**
     * The controller method which find the curvepoint object needs to be updated
     * @param id of the curvepoint object needs to be updated
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        CurvePoint curvePoint = curvePointService.getCurvePointById(id);
        logger.info("curvePoint to be updated "+ curvePoint.toString());
        model.addAttribute("curvePoint", curvePoint);
        return "curvePoint/update";
    }

    /**
     * The controller method which checks for error in the curvepoint object and if not found update the entry in the DB
     * @param id of the curvepoint object needs to be updated
     * @param curvePoint this contains the curvepoint object needs to be updated in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "curvePoint/update";
        }
        curvePoint.setId(id);
        logger.info("curvePoint to be updated "+ curvePoint.toString());
        curvePointService.updateCurvePoint(curvePoint);
        model.addAttribute("curvePoints", curvePointService.getAllCurvePoint());
        return "redirect:/curvePoint/list";
    }

    /**
     * The controller method which find the curvepoint object needs to be deleted
     * @param id of the curvepoint object needs to be deleted
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        logger.info("curvePoint to be deleted "+ curvePointService.getCurvePointById(id).toString());
        curvePointService.deleteCurvePoint(id);
        model.addAttribute("curvePoints", curvePointService.getAllCurvePoint());
        return "redirect:/curvePoint/list";
    }

}
