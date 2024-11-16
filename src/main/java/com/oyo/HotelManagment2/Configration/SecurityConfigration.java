package com.oyo.HotelManagment2.Configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfigration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/api/v1/hotel/").permitAll()
                                .requestMatchers("/api/v1/hotel/create").hasRole("ADMIN")
                )
                .httpBasic(withDefaults());
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User.builder().username("ajay").password(getEncoder().encode("ajay123")).roles("USER").build();
        UserDetails user2 = User.builder().username("kartik").password("{noop}kartik123").roles("ADMIN").build();
        UserDetails user3 = User.builder().username("abhijeet").password("{noop}abhijeet123").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1, user2, user3);

    }

    @Bean
    public PasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }
}