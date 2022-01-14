package com.vladgoncharov.dtr_sb.config;


import com.vladgoncharov.dtr_sb.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Настройка сервиса для поиска пользователя в базе данных и настройка пароля


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

//    @Bean
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .authorizeRequests()
                        .antMatchers("/changeTheDate").access("hasRole('ROLE_USER')")
                        .antMatchers("/changeTheTime").access("hasRole('ROLE_ADMIN')")
                        .antMatchers("/**").permitAll()
                    .and()
                        .exceptionHandling().accessDeniedPage("/403")
                    .and()
                        .formLogin()
                        .loginProcessingUrl("/j_spring_security_check")
                        .loginPage("/login")
                        .defaultSuccessUrl("/",false)
                        .failureUrl("/login?error=true")
                        .usernameParameter("username")
                        .passwordParameter("password")
                    .and()
                        .logout()
                        .logoutSuccessUrl("/")
                    .and()
                        .rememberMe()
                        .tokenRepository(this.persistentTokenRepository())
                        .tokenValiditySeconds(1*24*60*60);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(this.dataSource);
        return db;
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
//
////        auth.inMemoryAuthentication().withUser("q").password(passwordEncoder().encode("1")).roles("USER");
//    }
}
