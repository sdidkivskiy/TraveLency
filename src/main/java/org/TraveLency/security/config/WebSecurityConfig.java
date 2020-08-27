package org.TraveLency.security.config;

import org.TraveLency.security.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("org.TraveLency")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                    .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                    .antMatchers("/auth/sigh-up", "/auth/sigh-in", "/").not().fullyAuthenticated()
                //Доступ только для пользователей с ролью Администратор
                    .antMatchers("/admin/**", "/edit/**", "/delete/**").hasRole("ADMIN")
                    .antMatchers("/hotels/**").hasRole("USER")
                //Доступ разрешен всем пользователей
                    //.antMatchers("/").permitAll()
                //Все остальные страницы требуют аутентификации
                    .anyRequest().authenticated()
                    .and()
                //Настройка для входа в систему
                        .formLogin()
                        .loginPage("/auth/sign-in")
                        //Перенарпавление на главную страницу после успешного входа
                        .defaultSuccessUrl("/")
                        .permitAll()
                    .and()
                        .logout()
                        .permitAll()
                        .logoutSuccessUrl("/");
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }
}
