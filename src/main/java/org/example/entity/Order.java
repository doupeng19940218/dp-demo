package org.example.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author walker.dou
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    String status;
    String orderNo;

    public void ship(){
        System.out.println(String.format("单号：【%s】已自动发货", orderNo));
    }
}
