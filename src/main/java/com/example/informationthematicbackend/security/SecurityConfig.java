package com.example.informationthematicbackend.security;

import com.example.informationthematicbackend.common.enums.UserRole;
import com.example.informationthematicbackend.filter.CustomAuthenticationFilter;
import com.example.informationthematicbackend.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter(authenticationManagerBean(), userDetailsService, passwordEncoder);
        filter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/api/login/**").permitAll();
        http.authorizeRequests().antMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll();
        http.authorizeRequests().antMatchers("/api/users/**").hasAnyAuthority(UserRole.SCHOOL_ROLE.getRole(),
                UserRole.ADMIN_ROLE.getRole(), UserRole.TEACHER_ROLE.getRole(), UserRole.STUDENT_ROLE.getRole());
        http.authorizeRequests().antMatchers("/api/schooladmins/**", "/api/schools/**").hasAuthority(UserRole.ADMIN_ROLE.getRole());
        http.authorizeRequests().antMatchers("/api/teachers/**")
                .hasAuthority(UserRole.SCHOOL_ROLE.getRole());
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/schoolyear").hasAnyAuthority(UserRole.SCHOOL_ROLE.getRole(), UserRole.TEACHER_ROLE.getRole());
        http.authorizeRequests().antMatchers("/api/schoolyear/**").hasAnyAuthority(UserRole.SCHOOL_ROLE.getRole());
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/students/profile").hasAnyAuthority(UserRole.SCHOOL_ROLE.getRole(),
                UserRole.STUDENT_ROLE.getRole());
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/students").hasAnyAuthority(UserRole.SCHOOL_ROLE.getRole(), UserRole.TEACHER_ROLE.getRole());
        http.authorizeRequests().antMatchers("/api/students/**").hasAuthority(UserRole.SCHOOL_ROLE.getRole());
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/classes").hasAnyAuthority(UserRole.SCHOOL_ROLE.getRole(), UserRole.TEACHER_ROLE.getRole());
        http.authorizeRequests().antMatchers("/api/classes/**").hasAuthority(UserRole.SCHOOL_ROLE.getRole());
        http.authorizeRequests().antMatchers("/api/learningresults/**").hasAnyAuthority(UserRole.SCHOOL_ROLE.getRole(), UserRole.STUDENT_ROLE.getRole());
        http.authorizeRequests().antMatchers("/api/examresults/**", "/api/inputscores/**", "/api/calendars/**").hasAnyAuthority(UserRole.SCHOOL_ROLE.getRole(), UserRole.TEACHER_ROLE.getRole());
        http.authorizeRequests().antMatchers("/api/rooms/**").hasAuthority(UserRole.SCHOOL_ROLE.getRole());
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(filter);
        http.addFilterBefore(new CustomAuthorizationFilter(userDetailsService), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
