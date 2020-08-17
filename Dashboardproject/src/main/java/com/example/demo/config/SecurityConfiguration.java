package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.services.UserService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private CustomeLoginSuccessHandler successHandler;

	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests().antMatchers("/").permitAll().antMatchers("/Landingpage").hasAnyRole("ROLE_USER","ADMIN")
            .antMatchers("/Registration").hasAnyRole("ROLE_USER","ADMIN")
            .antMatchers(
                "/registration**",
                "/Landingpage",
                "/js/**",
                "/css/**",
                "/img/**",
                "/webjars/**").permitAll()
            .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
            .antMatchers("/home/**").hasAnyAuthority("ROLE_USER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            //.failureUrl("/login?error=true")
            .successHandler(successHandler)
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login?logout")
            .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}
