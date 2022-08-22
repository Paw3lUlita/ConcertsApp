package pl.coderslab.concertsapp;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.concertsapp.service.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/dashboard").authenticated()
                .antMatchers("/club").hasRole("CLUBMANAGER")
                .antMatchers("/band").hasRole("BANDMANAGER")
                .and().formLogin()
                .defaultSuccessUrl("/dashboard")
                .and().logout().logoutSuccessUrl("/")
                .deleteCookies("bandId", "bandName", "clubId").invalidateHttpSession(true)
                .and().exceptionHandling().accessDeniedPage("/403");

    }
}