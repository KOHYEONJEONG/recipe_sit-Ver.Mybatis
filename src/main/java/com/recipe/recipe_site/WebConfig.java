package com.recipe.recipe_site;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 메시지 소스를 UTF-8 인코딩으로 설정하는 예제입니다. 이를 통해 메시지 파일에서 한글과 같은
     * 다국어 문자열이 올바르게 읽히도록 할 수 있습니다.
     * */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");//scr/main/resources 디렉토리 아래에 messages.* 파일이 위치함을 의미함.
        messageSource.setDefaultEncoding("UTF-8");//인코딩 설정
        return messageSource;
    }
}
