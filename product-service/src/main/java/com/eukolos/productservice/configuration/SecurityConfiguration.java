package com.eukolos.productservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/**")
                .access(AuthorityAuthorizationManager.hasAuthority("SCOPE_message.read"))
                .and()
                .oauth2ResourceServer()
                .jwt();

        return http.build();

//                mvcMatcher("/**")
//                .authorizeRequests()
//                .mvcMatchers("/**")
//                .access("hasAuthority('SCOPE_message.read')")
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
    }
}