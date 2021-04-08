package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public void UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * The controller method which route to user page and loads all the user
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @RequestMapping("/user/list")
    public String home(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        logger.info("all users list"+ users.toString());
        return "user/list";
    }

    /**
     * The controller method which route to add user page
     * @param bid this contains the user object needs to be updated in DB
     * @return String name of the web page to be loaded
     */
    @GetMapping("/user/add")
    public String addUser(User bid) {
        return "user/add";
    }

    /**
     * The controller method which checks for error in the user object and if not found add the entry in the DB
     * @param user this contains the user object needs to be added in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            userService.saveUser(user);
            model.addAttribute("users", userService.getAllUser());
            return "redirect:/user/list";
        }
        return "user/add";
    }

    /**
     * The controller method which find the user object needs to be updated
     * @param id of the user object needs to be updated
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.getByIdUser(id);
        user.setPassword("");
        model.addAttribute("user", user);
        return "user/update";
    }

    /**
     * The controller method which checks for error in the user object and if not found update the entry in the DB
     * @param id of the user object needs to be updated
     * @param user this contains the user object needs to be updated in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/update";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(id);
        userService.updateUser(user);
        model.addAttribute("users", userService.getAllUser());
        return "redirect:/user/list";
    }

    /**
     * The controller method which find the user object needs to be deleted
     * @param id of the user object needs to be deleted
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("users", userService.getAllUser());
        return "redirect:/user/list";
    }

}
