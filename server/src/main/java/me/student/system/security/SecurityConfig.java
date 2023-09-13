package me.student.system.security;

import me.student.system.security.role.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
         // .csrf().disable()
          .authorizeRequests()
          .antMatchers("/", "index", "/css/*", "/public/**").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .defaultSuccessUrl("/courses", true)
          .and()
          .rememberMe()
          .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(14))
          .key("CE745E19C0D523E2873065C4CFC1CF6B3D40C546BF2D17F20A1CC7D52A8F14AE")
          .and()
          .logout()
          .clearAuthentication(true)
          .invalidateHttpSession(true)
          .deleteCookies("JSESSIONID", "remember-me")
          .logoutSuccessUrl("/login");

    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
          .username("student")
          .password(passwordEncoder.encode("student"))
          .authorities(UserRole.STUDENT.getGrantedAuthorities())
          .build();

        UserDetails teacher = User.builder()
          .username("teacher")
          .password(passwordEncoder.encode("teacher"))
          .authorities(UserRole.TEACHER.getGrantedAuthorities())

          .build();

        UserDetails developer = User.builder()
          .username("developer")
          .password(passwordEncoder.encode("developer"))
          .authorities(UserRole.ADMIN.getGrantedAuthorities())
          .build();
        return new InMemoryUserDetailsManager(user, teacher, developer);
    }

}
