package com.study.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.TypedValue;

@Configuration
public class TestConfig {

    @Bean  // 이러면 빈의 이름은 typedvalue가 되고 BEAN은 new tupedvalkue가 된다
    public TypedValue typedValue() {
        return new TypedValue(null);
    }
}
