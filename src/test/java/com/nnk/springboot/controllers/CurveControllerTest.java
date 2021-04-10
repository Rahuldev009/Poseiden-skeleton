package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;
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
public class CurveControllerTest {

    @Mock
    CurvePointService curvePointService;

    @InjectMocks
    CurveController curveController;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void home_validateResponseURL() {
        String s = curveController.home(model);
        Assert.assertEquals("curvePoint/list", s);
    }

    @Test
    public void addBidForm_validateResponseURL() {
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setId(1);
        curvePoint.setCurveId(10);
        curvePoint.setTerm(10d);
        curvePoint.setValue(30d);
        String s = curveController.addBidForm(curvePoint);
        Assert.assertEquals("curvePoint/add", s);
    }

    @Test
    public void validate_validateResponseURL() {
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setId(1);
        curvePoint.setCurveId(10);
        curvePoint.setTerm(10d);
        curvePoint.setValue(30d);
        String s = curveController.validate(curvePoint, bindingResult, model);
        Assert.assertEquals("redirect:/curvePoint/list", s);
    }

    @Test
    public void showUpdateForm_validateResponseURL() {
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setId(1);
        curvePoint.setCurveId(10);
        curvePoint.setTerm(10d);
        curvePoint.setValue(30d);
        Mockito.when(curvePointService.getCurvePointById(1)).thenReturn(curvePoint);
        String s = curveController.showUpdateForm(1, model);
        Assert.assertEquals("curvePoint/update", s);
    }

    @Test
    public void updateBid_validateResponseURL() {
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setId(1);
        curvePoint.setCurveId(10);
        curvePoint.setTerm(10d);
        curvePoint.setValue(30d);
        String s = curveController.updateBid(1, curvePoint, bindingResult, model);
        Assert.assertEquals("redirect:/curvePoint/list", s);
    }

    @Test
    public void deleteBid_validateResponseURL() {
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setId(1);
        curvePoint.setCurveId(10);
        curvePoint.setTerm(10d);
        curvePoint.setValue(30d);
        Mockito.when(curvePointService.getCurvePointById(1)).thenReturn(curvePoint);
        String s = curveController.deleteBid(1, model);
        Assert.assertEquals("redirect:/curvePoint/list", s);
    }

}