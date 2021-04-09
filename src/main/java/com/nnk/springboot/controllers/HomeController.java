package com.nnk.springboot.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
	private static final Logger logger = LogManager.getLogger(HomeController.class);
    /**
     * Loads home page
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
	@RequestMapping("/")
	public String home(Model model)
	{
		logger.info("Navigating to home");
		return "home";
	}

    /**
     * Load Bidlists
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
	@RequestMapping("/admin/home")
	public String adminHome(Model model)
	{
		logger.info("home page after login");
		return "redirect:/bidList/list";
	}

}
