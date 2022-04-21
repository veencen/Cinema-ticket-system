package edu.hanu.sqaproject.configuration;

import edu.hanu.sqaproject.service.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http.authorizeRequests()
                .antMatchers("/hello").hasRole("USER")
                .antMatchers("/register").hasRole("ADMIN")
                .antMatchers("/movies/list").hasAnyRole("USER", "ADMIN")
                .antMatchers("/fnds/list").hasAnyRole("USER", "ADMIN")
                .antMatchers("/order/*").hasAnyRole("USER", "ADMIN")
                .antMatchers("/movies/showForm").hasRole("ADMIN")
                .antMatchers("/movies/edit/*").hasRole("ADMIN")
                .antMatchers("/movies/update/*").hasRole("ADMIN")
                .antMatchers("/movies/delete/*").hasRole("ADMIN")
                .antMatchers("/movies/add").hasRole("ADMIN")
                .antMatchers("/movies/admin/*/newRepertoire").hasRole("ADMIN")
                .antMatchers("/console/*").hasRole("ADMIN")
                .antMatchers("/movies/*/reservation").hasAnyRole("USER", "ADMIN")
                .antMatchers("/movies/*/reservation/*").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
}