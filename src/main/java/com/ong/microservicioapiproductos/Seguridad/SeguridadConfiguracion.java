package com.ong.microservicioapiproductos.Seguridad;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeguridadConfiguracion {

    @Value("${service.security.secure-key-username}")
    private String usuario;

    @Value("${service.security.secure-key-password}")
    private String password;

    @Value("${service.security.secure-key-username2}")
    private String usuario2;

    @Value("${service.security.secure-key-password2}")
    private String password2;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(
                AuthenticationManagerBuilder.class);

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(usuario)
                .password(new BCryptPasswordEncoder().encode(password))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
                .and()
                .withUser(usuario2)
                .password(new BCryptPasswordEncoder().encode(password2))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"))
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());

        return http.antMatcher("/**")
                .authorizeHttpRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .cors()
                .and()
                .csrf().disable().httpBasic()
                .and().build();
    }

}
