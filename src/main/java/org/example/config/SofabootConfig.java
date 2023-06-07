package org.example.config;

import com.alipay.sofa.runtime.api.annotation.SofaAsyncInit;
import org.example.service.impl.SofabootBean;
import org.example.service.impl.SofabootBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author walker.dou
 */
@Configuration
public class SofabootConfig {

    @Bean(value = "sofabootBean", initMethod = "init")
    @SofaAsyncInit
    public SofabootBean sofabootBean() {
        return new SofabootBean();
    }

    @SofaAsyncInit
    @Bean(value = "sofabootBean2", initMethod = "init")
    public SofabootBean2 sofabootBean2() {
        return new SofabootBean2();
    }

}
