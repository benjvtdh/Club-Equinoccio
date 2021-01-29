package com.club.equinoccio.configuracion;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Seguridad extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    // Configurar para unir tablas entre usuarios y roles
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, estado from usuario where username=?")
                .authoritiesByUsernameQuery("select u.username, c.cargo from usuario_rol up "
                        + "inner join usuario u on u.id = up.usuario_id "
                        + "inner join rol c on c.perfil_id = up.rol_id "
                        + "where u.username = ?");
    }
    
    //Configurar para restringir y renderizar vistas
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //Recurso estáticos
                .antMatchers(
                        "/assets/**",
                        "/img/**").permitAll()
                // Vistas públicas
                .antMatchers(
                        "/",
                        "/register/**",
                        "/perfil").permitAll()
                
                //Vistas por roles
                .antMatchers("/salidas/**").hasAnyAuthority("Administrador","Supervisor")
                .antMatchers("/perfil/**").hasAnyAuthority("Administrador","Supervisor")
                .anyRequest().authenticated()
                .and()
                //Vista login
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")  
                .logoutSuccessUrl("/");  
                http.csrf().disable();
                
                
    }
}
