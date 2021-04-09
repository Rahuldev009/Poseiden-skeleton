package com.nnk.springboot.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTest {

    @InjectMocks
    HomeController homeController;

    @Mock
    Model model;

    @Test
    public void home() {
        String s = homeController.home(model);
        Assert.assertEquals("home", s);
    }

    @Test
    public void adminHome() {
        String s = homeController.adminHome(model);
        Assert.assertEquals("redirect:/bidList/list", s);
    }

}