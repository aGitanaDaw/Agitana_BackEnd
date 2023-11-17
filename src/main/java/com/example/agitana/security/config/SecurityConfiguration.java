package com.example.agitana.security.config;

import com.example.agitana.enums.TipoRol;
import com.example.agitana.security.filter.JwtAuthenticationFilter;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {"/auth/**",
            "/api-docs",
            "/api-docs",
            "/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
            corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
            corsConfiguration.setAllowCredentials(true);
            corsConfiguration.addAllowedHeader("*");

            cors.configurationSource(request -> corsConfiguration);
        })
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL).permitAll()
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/Admin/**").hasAnyAuthority(TipoRol.ADMIN.name())
                                .requestMatchers("/User/**").hasAnyAuthority(TipoRol.USER.name())
                                .requestMatchers(GET, "/Persona/**").hasAnyAuthority(TipoRol.ADMIN.name())
                                .requestMatchers(GET, "/Productos/**").hasAnyAuthority(TipoRol.ADMIN.name())
                                .requestMatchers(GET, "/Usuario/**").hasAnyAuthority(TipoRol.ADMIN.name(), TipoRol.USER.name())
                                .requestMatchers(GET, "/Tipo/**").hasAnyAuthority(TipoRol.ADMIN.name())
                                .requestMatchers(GET, "/Categoria/**").hasAnyAuthority(TipoRol.ADMIN.name(), TipoRol.USER.name())
                                .requestMatchers(GET, "/Stock/**").hasAnyAuthority(TipoRol.ADMIN.name())
                                .requestMatchers(GET, "/Almacen/**").hasAnyAuthority(TipoRol.ADMIN.name())
                                .requestMatchers(GET, "/Solicitudes/**").hasAnyAuthority(TipoRol.ADMIN.name(), TipoRol.USER.name())
                                .requestMatchers(GET, "/Donaciones/**").hasAnyAuthority(TipoRol.ADMIN.name(), TipoRol.USER.name())
                                .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;

        return http.build();

    }

}
