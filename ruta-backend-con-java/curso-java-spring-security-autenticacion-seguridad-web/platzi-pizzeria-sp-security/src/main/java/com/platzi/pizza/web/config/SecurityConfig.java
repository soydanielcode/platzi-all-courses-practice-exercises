package com.platzi.pizza.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/api/pizzas/**").hasAnyRole("ADMIN","CUSTOMER")
                .requestMatchers("/api/orders/random").hasAuthority("random_order")
                .requestMatchers("/api/orders/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT).hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }

//    @Bean
//    public UserDetailsService memoryUsers() {
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//        UserDetails customer = User.builder()
//                .username("customer")
//                .password(passwordEncoder().encode("customer"))
//                .roles("CUSToMER")
//                .build();
//        return new InMemoryUserDetailsManager(admin, customer);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
