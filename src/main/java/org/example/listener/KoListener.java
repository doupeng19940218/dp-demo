package org.example.listener;

import cn.langpy.kotime.handler.InvokedHandler;
import cn.langpy.kotime.model.MethodNode;

import java.lang.reflect.Parameter;

/**
 * @author walker.dou
 */
@cn.langpy.kotime.annotation.KoListener
public class KoListener implements InvokedHandler {
    @Override
    public void onInvoked(MethodNode current, MethodNode parent, Parameter[] names, Object[] values) {
        System.out.println("调用的方法：" + current);
        System.out.println("调用当前方法的上一级方法：" + parent);
        System.out.println("调用的方法-参数名称：" + names);
        System.out.println("调用的方法-具体参数：" + values);
    }
}

