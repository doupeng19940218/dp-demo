package com.ecovacs.adminmgr.easyrule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngineListener;

/**
 * @author walker.dou
 */
public class CustomRulesEngineListener implements RulesEngineListener {
    @Override
    public void beforeEvaluate(Rules rules, Facts facts) {
        System.out.println("---CustomRulesEngineListener------beforeEvaluate-----");
    }

    @Override
    public void afterExecute(Rules rules, Facts facts) {
        System.out.println("---CustomRulesEngineListener------afterExecute-----");
    }
}
