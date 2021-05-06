package com.bishe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebAppConfiguration implements WebMvcConfigurer {

    //定制资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //意思是：url中读取到/upload时，就会自动将/upload解析成D:/idea/java_workspace/image/upload
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:E:/upload/");
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:E:/upload/");

        registry.addResourceHandler("/upload/**").addResourceLocations("file:upload/");
        /**
         * Linux系统
         * registry.addResourceHandler("/upload/**").addResourceLocations("file:/home/image/upload/");
         */
    }


    @Bean


    public CorsFilter corsFilter() {


        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();


        CorsConfiguration corsConfiguration = new CorsConfiguration();


        corsConfiguration.addAllowedOrigin("http://localhost:8081");


        corsConfiguration.addAllowedHeader("*");


        corsConfiguration.addAllowedMethod("*");


        source.registerCorsConfiguration("/**", corsConfiguration);


        return new CorsFilter(source);


    }
}
