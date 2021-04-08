package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleNameServiceImpl implements RuleNameService {

    private RuleNameRepository ruleNameRepository;

    @Autowired
    public RuleNameServiceImpl(RuleNameRepository ruleNameRepository) {
        this.ruleNameRepository = ruleNameRepository;
    }

    /**
     * find the rulename item by Id
     * @param id this is the id of rulename item to be searched
     * @return rulename object with the same Id
     */
    @Override
    public RuleName getById(int id) {
        return ruleNameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid RuleName Id:" + id));
    }

    /**
     * find all items of rulename
     * @return list of all rulename items
     */
    @Override
    public List<RuleName> getAllRuleName() {
        return ruleNameRepository.findAll();
    }

    /**
     * save the rulename item in the DB
     * @param ruleName this is the item to be saved in the DB
     */
    @Override
    public void saveRuleName(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
    }

    /**
     * update the rulename item in the DB
     * @param ruleName this is the item to be updated in the DB
     */
    @Override
    public void updateRuleName(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
    }

    /**
     * delete the rulename item in the DB
     * @param id this is the id of rulename item to be deleted
     */
    @Override
    public void deleteRuleName(int id) {
        RuleName ruleName = ruleNameRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid RuleName Id:" + id));
        ruleNameRepository.delete(ruleName);
    }

}
