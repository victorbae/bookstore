package br.edu.unoesc.crud;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("baesso")
                .password("{noop}bae")
                .roles("ADMIN")
                .and()
                .withUser("vitor")
                .password("{noop}123")
                .roles("ADMIN")
                .and()
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/**").hasRole("ADMIN")
            .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/dashboard", true)
                .loginProcessingUrl("/login");
    }

}
