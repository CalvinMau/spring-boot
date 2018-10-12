package com.auth.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * The type Web security config adapter customize.
 *
 * @ClassName WebSecurityConfigAdapterCustomize
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigAdapterCustomize extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthoritiesPopulatorCustomize customizationAuthoritiesPopulator;

    /**
     * Global web configuration
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // User logout quest config.
        http
                .logout()
                .logoutRequestMatcher(
                        new AntPathRequestMatcher("/logout"));

        // Page access authentication.
        http
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .and()
                .csrf().disable().httpBasic();

    }

    /**
     * User login authentication for test.
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordAttribute("userPassword")
                .and().ldapAuthoritiesPopulator(customizationAuthoritiesPopulator);
    }
}
