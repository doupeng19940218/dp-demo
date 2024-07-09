package org.example.groovy



def push(CcmWorkOrder ccmWorkOrder) {
    List<String> reasons = ["紧急产品事故-人身伤害", "紧急产品事故-机器烧了/明火",
                            "紧急产品事故-重大漏水",
                            "产品事故-机器冒烟",
                            "产品事故-机器烧焦",
                            "产品事故-烧焦/冒烟/焦味"]

    if (reasons.contains(ccmWorkOrder.reason)) {
        ccmWorkOrder.push()
    }
}

push(ccmWorkOrder)