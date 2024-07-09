package org.example.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import lombok.extern.slf4j.Slf4j;

/**
 * @author walker.dou
 */
@Slf4j
public class CcmTrigger {
    public static void main(String[] args) {
        final CcmWorkOrder ccmWorkOrder = new CcmWorkOrder();
        ccmWorkOrder.setReason("紧急产品事故-人身伤害");
        ccmWorkOrder.setMaterial("116-2338-0000");
        Binding binding = new Binding();
        binding.setProperty("ccmWorkOrder", ccmWorkOrder);

        GroovyShell groovyShell = new GroovyShell(binding);
        Object result = groovyShell.evaluate(
                "    List<String> reasons = [\"紧急产品事故-人身伤害\", \"紧急产品事故-机器烧了/明火\",\n" +
                "                            \"紧急产品事故-重大漏水\",\n" +
                "                            \"产品事故-机器冒烟\",\n" +
                "                            \"产品事故-机器烧焦\",\n" +
                "                            \"产品事故-烧焦/冒烟/焦味\"]\n" +
                "\n" +
                "    if (reasons.crontains(ccmWokOrder.reason)) {\n" +
                "        println \"${ccmWorkOrder.reason} 满足条件，并推送\"\n" +
                "    }");
        log.info(result.toString());
    }
}
