package com.example.bethouse.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.projection.SpelAwareProxyProjectionFactory
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@Configuration
class Config {
    @Bean
    fun projectionFactory(): SpelAwareProxyProjectionFactory? {
        return SpelAwareProxyProjectionFactory()
    }

    @Bean
    fun corsConfigurer(): WebMvcConfigurer? {
        return object : WebMvcConfigurerAdapter() {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", HttpMethod.OPTIONS.name).allowedOrigins("*")
                    .allowedHeaders("*")
            }
        }
    }
}