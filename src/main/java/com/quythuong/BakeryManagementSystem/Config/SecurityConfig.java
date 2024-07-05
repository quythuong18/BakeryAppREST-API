package com.quythuong.BakeryManagementSystem.Config;

import com.quythuong.BakeryManagementSystem.AppUser.UserDetailServiceImp;
import com.quythuong.BakeryManagementSystem.JwtAuthentication.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final UserDetailServiceImp userDetailImp;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private  final CustomAccessDeniedHandler customAccessDeniedHandler;

    public SecurityConfig(UserDetailServiceImp userDetailImp, JwtAuthenticationFilter jwtAuthenticationFilter, CustomAccessDeniedHandler customAccessDeniedHandler) {
        this.userDetailImp = userDetailImp;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req->req.requestMatchers("/auth/**").permitAll()
                                .requestMatchers("**/orders/**").hasAuthority("ROLE_CUSTOMER")
                                .requestMatchers("**/orders/**").hasAuthority("ROLE_CASHIER")
                                .requestMatchers("**/orders/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.GET,"**/products/**", "**/categories/**").permitAll()
                                .requestMatchers(HttpMethod.POST,"**/products/**", "**/categories/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.PUT,"**/products/**", "**/categories/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"**/products/**", "**/categories/**").hasAuthority("ROLE_ADMIN")
                                .anyRequest().authenticated()
                ).userDetailsService(userDetailImp)
//                .exceptionHandling(e -> e.accessDeniedHandler(customAccessDeniedHandler)
//                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
