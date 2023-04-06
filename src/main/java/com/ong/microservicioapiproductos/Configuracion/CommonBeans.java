package com.ong.microservicioapiproductos.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeans {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
