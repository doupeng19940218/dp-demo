package com.ecovacs.adminmgr.easyrule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.RuleListener;

/**
 * @author walker.dou
 */
public class CustomRuleListener implements RuleListener {
    @Override
    public boolean beforeEvaluate(Rule rule, Facts facts) {
        System.out.println("---CustomRuleListener------beforeEvaluate-----");
        return true;
    }

    @Override
    public void afterEvaluate(Rule rule, Facts facts, boolean b) {
        System.out.println("---CustomRuleListener------afterEvaluate-----");
    }

    @Override
    public void beforeExecute(Rule rule, Facts facts) {
        System.out.println("---CustomRuleListener------beforeExecute-----");
    }

    @Override
    public void onSuccess(Rule rule, Facts facts) {

        System.out.println("---CustomRuleListener------onSuccess-----");
    }

    @Override
    public void onFailure(Rule rule, Facts facts, Exception e) {
        System.out.println("---CustomRuleListener------onFailure-----");
    }
}
