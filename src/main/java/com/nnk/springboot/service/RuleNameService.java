package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;

import java.util.List;

public interface RuleNameService {

    public RuleName getById(int id);

    public List<RuleName> getAllRuleName();

    public void saveRuleName(RuleName ruleName);

    public void updateRuleName(RuleName ruleName);

    public void deleteRuleName(int id);
}
