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

    @Override
    public RuleName getById(int id) {
        return ruleNameRepository.getOne(id);
    }

    @Override
    public List<RuleName> getAllRuleName() {
        return ruleNameRepository.findAll();
    }

    @Override
    public void saveRuleName(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
    }

    @Override
    public void updateRuleName(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
    }

    @Override
    public void deleteRuleName(int id) {
        ruleNameRepository.deleteById(id);
    }
}
