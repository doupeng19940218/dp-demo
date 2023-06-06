package org.example.other;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 * @author walker.dou
 */
public class YamlPropertySourceLoaderTest {

    /**
     *springboot 2.5.6和2.7.7行为不一致
     * 2.7.7中会把0003000402当成 8进制的数字，会把0003008502当成字符串
     * 2.5.6中会把0003000402当成 8进制的数字，会把0003008502当成10进制的数字
     * 2.7.7中的 把0003000402当成 8进制的正则："^(?:[-+]?0b_*[0-1]+[0-1_]*|[-+]?0_*[0-7]+[0-7_]*|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x_*[0-9a-fA-F]+[0-9a-fA-F_]*|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$";
     */
    @SneakyThrows
    @Test
    public void test() {
        String content = "0003000402: https://qas-intl-api-jp.ecovacs.cn";
        //
        String content2 = "0003008502: https://qas-intl-api-jp.ecovacs.cn";
        Resource resource = new ByteArrayResource(content.getBytes());
        // 再将其转换成 Resource 对象
        final YamlPropertySourceLoader yamlPropertySourceLoader = new YamlPropertySourceLoader();
        final List<PropertySource<?>> load = yamlPropertySourceLoader.load("11", resource);
        System.out.println(load);

        Resource resource2 = new ByteArrayResource(content2.getBytes());
        // 再将其转换成 Resource 对象
        final YamlPropertySourceLoader yamlPropertySourceLoader2 = new YamlPropertySourceLoader();
        final List<PropertySource<?>> load2 = yamlPropertySourceLoader2.load("11", resource2);
        System.out.println(load2);


    }
}
