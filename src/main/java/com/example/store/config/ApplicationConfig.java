package com.example.store.config;

import com.example.store.domain.Goods;
import com.example.store.domain.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class ApplicationConfig {

    @Bean
    public RowMapper<Store> storeRowMapper(){
        return new BeanPropertyRowMapper<>(Store.class);
    }

    @Bean
    public RowMapper<Goods> goodsRowMapper(){
        return  new BeanPropertyRowMapper<>(Goods.class);
    }

}
