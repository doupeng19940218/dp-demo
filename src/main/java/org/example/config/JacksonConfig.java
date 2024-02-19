package org.example.config;

import com.alipay.sofa.common.utils.StringUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author walker.dou
 */
@Configuration
public class JacksonConfig {
    @Autowired
    ObjectMapper objectMapper;

    @Component
    public static class JacksonCustomer implements Jackson2ObjectMapperBuilderCustomizer {
        @Override
        public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
            jacksonObjectMapperBuilder.serializerByType(Enum.class, new GapEnumSerializer());
            jacksonObjectMapperBuilder.failOnUnknownProperties(false);
        }
    }

    @PostConstruct
    public void init() {
        objectMapper.setSerializerFactory(objectMapper.getSerializerFactory().withSerializerModifier(new MyBeanSerializerModifier()));
    }


    static class MyBeanSerializerModifier extends BeanSerializerModifier {

        private final NullEnumJsonSerializer nullEnumJsonSerializer = new NullEnumJsonSerializer();

        @Override
        public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
                                                         List<BeanPropertyWriter> beanProperties) {
            beanProperties.forEach(writer -> {
                if (isEnumType(writer)) {
                    writer.assignNullSerializer(nullEnumJsonSerializer);
                }
            });
            return beanProperties;
        }

        private boolean isEnumType(BeanPropertyWriter writer) {
            Class<?> clazz = writer.getType().getRawClass();
            return Enum.class.isAssignableFrom(clazz);
        }

        static class NullEnumJsonSerializer extends JsonSerializer<Object> {
            @Override
            public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                if (value == null) {
                    gen.writeNull();
                    final JsonStreamContext outputContext = gen.getOutputContext();
                    final String currentName = outputContext.getCurrentName();
                    final String fieldValueName = currentName + "Value";
                    gen.writeStringField(fieldValueName, null);
                }
            }
        }

    }

    static class GapEnumSerializer extends JsonSerializer<Enum<?>> {

        @Override
        public void serialize(Enum<?> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if (value == null) {
                return;
            }
            gen.writeString(value.name());
            final JsonStreamContext outputContext = gen.getOutputContext();
            final Object currentValue = outputContext.getCurrentValue();
            final String currentName = outputContext.getCurrentName();
            final String fieldValueName = currentName + "Value";
            final Field field = ReflectionUtils.findField(currentValue.getClass(), fieldValueName, String.class);
            if (field != null) {
                field.setAccessible(true);
                try {
                    final String enumDisplayValue = (String) field.get(currentValue);
                    if (StringUtil.isNotEmpty(enumDisplayValue)) {
                        return;
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            List<Field> enumClassTargetFields = new ArrayList<>();
            ReflectionUtils.doWithLocalFields(value.getClass(), field1 -> {
                if (field1.getType() == String.class) {
                    enumClassTargetFields.add(field1);
                }
            });
            if (enumClassTargetFields.size() != 1) {
                return;
            }
            try {
                final Field enumDisplayField = enumClassTargetFields.get(0);
                enumDisplayField.setAccessible(true);
                final String enumDisplayValue = (String) enumDisplayField.get(value);
                gen.writeStringField(fieldValueName, enumDisplayValue);

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
    }
}


