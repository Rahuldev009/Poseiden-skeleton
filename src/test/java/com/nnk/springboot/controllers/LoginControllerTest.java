package com.nnk.springboot.controllers;

import com.nnk.springboot.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {
    @InjectMocks
    LoginController loginController;

    @Mock
    ModelAndView modelAndView;

    @Mock
    UserRepository userRepository;

    @Test
    public void login() {
        ModelAndView modelAndView = loginController.login();
        Assert.assertEquals("login", modelAndView.getViewName());
    }

    @Test
    public void getAllUserArticles() {
        ModelAndView modelAndView = loginController.getAllUserArticles();
        Assert.assertEquals("user/list", modelAndView.getViewName());
    }

    @Test
    public void error() {
        ModelAndView modelAndView = loginController.error();
        Assert.assertEquals("403", modelAndView.getViewName());
    }

}