package org.example.listener;

import cn.langpy.kotime.annotation.KoListener;
import cn.langpy.kotime.handler.InvokedHandler;
import cn.langpy.kotime.model.ExceptionNode;
import cn.langpy.kotime.model.MethodNode;

import java.lang.reflect.Parameter;

/**
 * @author walker.dou
 */
@KoListener
public class KoErrorListener implements InvokedHandler {
    @Override
    public void onInvoked(MethodNode current, MethodNode parent, Parameter[] names, Object[] values) {

    }

    @Override
    public void onException(MethodNode current, MethodNode parent, ExceptionNode exception, Parameter[] names, Object[] values) {
        System.out.println("异常：" + exception);
    }
}