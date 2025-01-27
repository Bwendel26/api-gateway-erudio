package com.spring.erudio.api_gateway.config;

import com.spring.erudio.api_gateway.serialization.converter.YamlJackson2HttpMesageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMesageConverter());
    }


    // QUERY PARAM:
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//
//        configurer.favorParameter(true).parameterName("MediaType").ignoreAcceptHeader(true)
//                .useRegisteredExtensionsOnly(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                    .mediaType("json", MediaType.APPLICATION_JSON)
//                    .mediaType("xml", MediaType.APPLICATION_XML);
//    }

    // HEADER PARAM:

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer config) {

        config.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                    .mediaType("json", MediaType.APPLICATION_JSON)
                    .mediaType("xml", MediaType.APPLICATION_XML)
                    .mediaType("x-yaml", MediaType.valueOf("application/x-yaml"));
    }

}
