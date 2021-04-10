package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.RuleNameService;
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
public class RuleNameControllerTest {

    @Mock
    RuleNameService ruleNameService;

    @InjectMocks
    RuleNameController ruleNameController;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void home() {
        String s = ruleNameController.home(model);
        Assert.assertEquals("ruleName/list", s);
    }

    @Test
    public void addRuleForm() {
        RuleName rule = new RuleName();
        rule.setId(1);
        rule.setName("Rule Name");
        rule.setDescription("Description");
        rule.setJson("Json");
        rule.setTemplate("Template");
        rule.setSqlStr("SQL");
        rule.setSqlPart("SQL Part");
        String s = ruleNameController.addRuleForm(rule);
        Assert.assertEquals("ruleName/add", s);
    }

    @Test
    public void validate() {
        RuleName rule = new RuleName();
        rule.setId(1);
        rule.setName("Rule Name");
        rule.setDescription("Description");
        rule.setJson("Json");
        rule.setTemplate("Template");
        rule.setSqlStr("SQL");
        rule.setSqlPart("SQL Part");
        String s = ruleNameController.validate(rule, bindingResult, model);
        Assert.assertEquals("redirect:/ruleName/list", s);
    }

    @Test
    public void showUpdateForm() {
        RuleName rule = new RuleName();
        rule.setId(1);
        rule.setName("Rule Name");
        rule.setDescription("Description");
        rule.setJson("Json");
        rule.setTemplate("Template");
        rule.setSqlStr("SQL");
        rule.setSqlPart("SQL Part");
        Mockito.when(ruleNameService.getById(1)).thenReturn(rule);
        String s = ruleNameController.showUpdateForm(1, model);
        Assert.assertEquals("ruleName/update", s);
    }

    @Test
    public void updateRuleName() {
        RuleName rule = new RuleName();
        rule.setId(1);
        rule.setName("Rule Name");
        rule.setDescription("Description");
        rule.setJson("Json");
        rule.setTemplate("Template");
        rule.setSqlStr("SQL");
        rule.setSqlPart("SQL Part");
        String s = ruleNameController.updateRuleName(1, rule, bindingResult, model);
        Assert.assertEquals("redirect:/ruleName/list", s);
    }

    @Test
    public void deleteRuleName() {
        RuleName rule = new RuleName();
        rule.setId(1);
        rule.setName("Rule Name");
        rule.setDescription("Description");
        rule.setJson("Json");
        rule.setTemplate("Template");
        rule.setSqlStr("SQL");
        rule.setSqlPart("SQL Part");
        Mockito.when(ruleNameService.getById(1)).thenReturn(rule);
        String s = ruleNameController.deleteRuleName(1, model);
        Assert.assertEquals("redirect:/ruleName/list", s);
    }

}