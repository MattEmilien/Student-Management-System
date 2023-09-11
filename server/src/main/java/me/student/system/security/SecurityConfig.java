package me.student.system.security;

import me.student.system.security.role.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
          .antMatchers("/", "index", "/css/*", "/public/**").permitAll()
          .antMatchers("/students/**").hasRole(UserRole.STUDENT.name())
          .anyRequest().authenticated()
          .and()
          .formLogin().permitAll()
          .and()
          .httpBasic();
    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
          .username("student")
          .password(passwordEncoder.encode("student"))
          .roles(UserRole.STUDENT.name()) // ROLE_STUDENT
          .build();

        UserDetails teacher = User.builder()
          .username("teacher")
          .password(passwordEncoder.encode("teacher"))
          .roles(UserRole.TEACHER.name()) // ROLE_ADMIN
          .build();

        UserDetails developer = User.builder()
          .username("developer")
          .password(passwordEncoder.encode("developer"))
          .roles(UserRole.ADMIN.name()) // ROLE_ADMIN
          .build();
        return new InMemoryUserDetailsManager(user, developer);
    }

}
