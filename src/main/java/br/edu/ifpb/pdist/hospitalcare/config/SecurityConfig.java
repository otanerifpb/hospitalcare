package br.edu.ifpb.pdist.hospitalcare.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;
    
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() 
                .antMatchers("/css/**", "/imagens/**")  
                .permitAll()
                .antMatchers("/medicos/**").hasRole("ADMIN")
                .antMatchers("/login/**").hasRole("ADMIN")
                .antMatchers("/pacientes/**").hasAnyRole("VIS","USER", "ADMIN")
                .anyRequest()  
                .authenticated() 
                .and()
                .formLogin(form -> form 
                    .loginPage("/auth")  
                    .defaultSuccessUrl("/home", true) 
                    .permitAll())  
                .logout(logout -> logout.logoutUrl("/auth/logout"))
                //.and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        auth.jdbcAuthentication()
            .dataSource(dataSource)
            // Criptografia da senha do usuário, lembrar de tirar ";" quando for rodar em um banco novo 
            .passwordEncoder(encoder)//; /*; */
            .withUser(User.builder().username("admin").password(encoder.encode("useradm")).roles("USER","ADMIN").build())
            .withUser(User.builder().username("estudante").password(encoder.encode("userest")).roles("USER").build())
            .withUser(User.builder().username("visitante").password(encoder.encode("uservis")).roles("VIS").build());
    }
}
