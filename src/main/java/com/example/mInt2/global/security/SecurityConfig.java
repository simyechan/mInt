package com.example.mInt2.global.security;

import com.example.mInt2.global.error.CustomAuthenticationEntryPoint;
import com.example.mInt2.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsUtils;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors()
                .and()
                .csrf().disable()
                .formLogin().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                // users
                .antMatchers(HttpMethod.HEAD, "/users/nickname").permitAll()
                .antMatchers(HttpMethod.HEAD, "/users/email").permitAll()
                .antMatchers(HttpMethod.HEAD, "/users/verification-codes").permitAll()
                .antMatchers(HttpMethod.GET, "/users").authenticated()
                .antMatchers(HttpMethod.GET, "/users/feeds").authenticated()
                .antMatchers(HttpMethod.GET, "/users/bookmarks").authenticated()
                .antMatchers(HttpMethod.GET, "/users/comments").authenticated()
                .antMatchers(HttpMethod.POST, "/users/verification-codes").permitAll()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.POST, "/users/token").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users").authenticated()
                .antMatchers(HttpMethod.PATCH, "/users/token").authenticated()
                .antMatchers(HttpMethod.PATCH, "/users/location").authenticated()
                .antMatchers(HttpMethod.PATCH, "/users/password").authenticated()
                .antMatchers(HttpMethod.DELETE, "/users/logout").authenticated()
                .antMatchers(HttpMethod.DELETE, "/users/leave").authenticated()

                // feeds & like & bookmark
                .antMatchers(HttpMethod.GET, "/feeds/**").authenticated()
                .antMatchers(HttpMethod.POST, "/feeds/**").authenticated()
                .antMatchers(HttpMethod.PATCH, "/feeds/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/feeds/**").authenticated()

                // comments
                .antMatchers(HttpMethod.GET, "/comments/**").authenticated()
                .antMatchers(HttpMethod.POST, "/comments/**").authenticated()
                .antMatchers(HttpMethod.PATCH, "/comments/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/comments/**").authenticated()

                // categories
                .antMatchers(HttpMethod.GET, "/categories/**").permitAll()

                // meetings
                .antMatchers(HttpMethod.POST, "/meetings").authenticated()

                // swagger
                .antMatchers("/swagger*/**", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**").permitAll()

                .anyRequest().denyAll()

                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint(objectMapper))

                .and()
                .apply(new FilterConfig(jwtTokenProvider, objectMapper))

                .and()
                .build();
    }
}
