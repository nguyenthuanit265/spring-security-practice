package com.learn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringSecurityConfig.class);

    // Bean AuthenticationManager, provider, userdetailsService, passwordEncoder

    @Bean
    public AuthenticationManager authenticationManager() {
        LOGGER.info("[SpringSecurityConfig] authenticationManager");
        return new ProviderManager(List.of(authenticationProvider()));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        LOGGER.info("[SpringSecurityConfig] authenticationProvider");
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("[SpringSecurityConfig] passwordEncoder");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        LOGGER.info("[SpringSecurityConfig] userDetailsService");
        UserDetails admin = User.withUsername("admin@gmail.com")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.withUsername("user@gmail.com")
                .password(passwordEncoder().encode("123456"))
                .roles("USER")
                .build();

        UserDetails mod = User.withUsername("mod@gmail.com")
                .password(passwordEncoder().encode("123456"))
                .roles("MOD")
                .build();

        return new InMemoryUserDetailsManager(admin, user, mod);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        LOGGER.info("[SpringSecurityConfig] securityFilterChain");

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/sign-up", "api/v1/auth/login").permitAll()
                        .requestMatchers("/api/v1/admins/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/users/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()
                ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationManager(authenticationManager())
        ;
        return http.build();
    }
}
