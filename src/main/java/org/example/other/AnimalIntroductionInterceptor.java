package org.example.other;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * @author walker.dou
 */
@Component
public class AnimalIntroductionInterceptor implements IntroductionInterceptor, DogIntroductionAdvisor.Animal {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (implementsInterface(invocation.getMethod().getDeclaringClass())) {
            return invocation.getMethod().invoke(this, invocation.getArguments());
        }
        return invocation.proceed();
    }

    @Override
    public void eat() {
        System.out.println("Animal eat");
    }

    @Override
    public boolean implementsInterface(Class<?> intf) {
        return intf.isAssignableFrom(this.getClass());
    }
}
