package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
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
public class RuleNameServiceImplTest {

    @InjectMocks
    RuleNameServiceImpl ruleNameService;

    @Mock
    RuleNameRepository ruleNameRepository;

    @Test
    public void getById() {
        RuleName rule = new RuleName();
        rule.setName("Rule Name");
        rule.setDescription("Description");
        rule.setJson("Json");
        rule.setTemplate("Template");
        rule.setSqlStr("SQL");
        rule.setSqlPart("SQL Part");
        rule.setId(1);
        Mockito.when(ruleNameRepository.findById(1)).thenReturn(java.util.Optional.of(rule));
        RuleName rule1 = ruleNameService.getById(1);
        Assert.assertTrue(rule1.getId() == 1);
    }

    @Test
    public void getAllRuleName() {
        ruleNameService.getAllRuleName();
        Mockito.verify(ruleNameRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void saveRuleName() {
        ruleNameService.saveRuleName(new RuleName());
        Mockito.verify(ruleNameRepository, Mockito.times(1)).save(Mockito.any(RuleName.class));
    }

    @Test
    public void updateRuleName() {
        ruleNameService.updateRuleName(new RuleName());
        Mockito.verify(ruleNameRepository, Mockito.times(1)).save(Mockito.any(RuleName.class));
    }

    @Test
    public void deleteRuleName() {
        RuleName rule = new RuleName();
        rule.setName("Rule Name");
        rule.setDescription("Description");
        rule.setJson("Json");
        rule.setTemplate("Template");
        rule.setSqlStr("SQL");
        rule.setSqlPart("SQL Part");
        rule.setId(1);
        Mockito.when(ruleNameRepository.findById(1)).thenReturn(java.util.Optional.of(rule));
        ruleNameService.deleteRuleName(1);
        Mockito.verify(ruleNameRepository, Mockito.times(1)).delete(Mockito.any(RuleName.class));
    }

}