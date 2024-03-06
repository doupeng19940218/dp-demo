package org.example.other;

import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.BeanDefinition.ROLE_INFRASTRUCTURE;

/**
 * @author walker.dou
 */
@Component
@Role(ROLE_INFRASTRUCTURE)
public class DogIntroductionAdvisor implements IntroductionAdvisor {
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                return Dog.class.isAssignableFrom(clazz);
            }
        };
    }

    @Override
    public void validateInterfaces() throws IllegalArgumentException {

    }

    @Override
    public Advice getAdvice() {
        return new AnimalIntroductionInterceptor();
    }

    @Override
    public boolean isPerInstance() {
        return true;
    }

    @Override
    public Class<?>[] getInterfaces() {
        return new Class[]{Animal.class};
    }

    public interface Dog {
        void run();
    }
    @Service("DogImpl")
    public static class DogImpl implements Dog{
        @Override
        public void run() {
            System.out.println("Dog run");
        }
    }
    public interface Animal {
        void eat();
    }


}
