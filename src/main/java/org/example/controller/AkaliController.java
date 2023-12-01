package org.example.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.dromara.akali.annotation.AkaliHot;
import org.dromara.akali.enums.FlowGradeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker.dou
 */

@RestController("akali")
public class AkaliController {

    @AkaliHot(grade = FlowGradeEnum.FLOW_GRADE_QPS, count = 1, duration = 600)
    @GetMapping("getSkuInfo")
    public SkuInfo getSkuInfo(String skuCode) {
        System.out.println(skuCode);
        return SkuInfo.builder().sku(skuCode).name(skuCode + "名称").build();
    }


    @Getter
    @Setter
    @Builder
    public static class SkuInfo {
        private String sku;
        private String name;

    }

}
