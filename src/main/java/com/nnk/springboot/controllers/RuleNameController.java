package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RuleNameService;
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
public class RuleNameController {
    private static final Logger logger = LogManager.getLogger(RuleNameController.class);

    private RuleNameService ruleNameService;

    @Autowired
    public void RuleNameController(RuleNameService ruleNameService) {
        this.ruleNameService = ruleNameService;
    }

    /**
     * The controller method which route to rulename page and loads all the rulename
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @RequestMapping("/ruleName/list")
    public String home(Model model) {
        List<RuleName> ruleNames = ruleNameService.getAllRuleName();
        model.addAttribute("ruleNames", ruleNames);
        return "ruleName/list";
    }
    
    /**
     * The controller method which route to add rulename page
     * @param bid this contains the rulename object needs to be updated in DB
     * @return String name of the web page to be loaded
     */
    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
        return "ruleName/add";
    }

    /**
     * The controller method which checks for error in the rulename object and if not found add the entry in the DB
     * @param ruleName this contains the rulename object needs to be added in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            ruleNameService.saveRuleName(ruleName);
            model.addAttribute("ruleNames", ruleNameService.getAllRuleName());
            return "redirect:/ruleName/list";
        }
        return "ruleName/add";
    }

    /**
     * The controller method which find the rulename object needs to be updated
     * @param id of the rulename object needs to be updated
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        RuleName ruleName = ruleNameService.getById(id);
        model.addAttribute("ruleName", ruleName);
        return "ruleName/update";
    }

    /**
     * The controller method which checks for error in the rulename object and if not found update the entry in the DB
     * @param id of the rulename object needs to be updated
     * @param ruleName this contains the rulename object needs to be updated in DB
     * @param result contains the result of error checking
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "ruleName/update";
        }
        ruleName.setId(id);
        ruleNameService.updateRuleName(ruleName);
        model.addAttribute("ruleNames", ruleNameService.getAllRuleName());
        return "redirect:/ruleName/list";
    }

    /**
     * The controller method which find the rulename object needs to be deleted
     * @param id of the rulename object needs to be deleted
     * @param model this contains the object and attributes which can be passed to the web page
     * @return String name of the web page to be loaded
     */
    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        ruleNameService.deleteRuleName(id);
        model.addAttribute("ruleNames", ruleNameService.getAllRuleName());
        return "redirect:/ruleName/list";
    }

}
