package com.pl.github.client;

import feign.Logger.Level;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    public Level feignLoggerLevel() {
        return Level.FULL;
    }

    @Bean
    public GsonEncoder encoder() {
        return new GsonEncoder();
    }

    @Bean
    public GsonDecoder decoder() {
        return new GsonDecoder();
    }
}
