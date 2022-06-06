package org.springframework.samples.petclinic.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Value("${server.servlet.context-path}")
//    private String contextPath;

    @Autowired
    private UserDetailsService petUserServiceImpl;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(petUserServiceImpl);
//    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        // allow css, fonts, images
        web.ignoring().antMatchers("/resources/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/loginPage").permitAll()
            .defaultSuccessUrl("/", true)
            .loginProcessingUrl("/login")
            .and()
            .logout();
    }





//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .authorizeRequests()
//            .antMatchers("/admin/**").hasRole("USER")
//            .antMatchers("/loginPage", "/login", "error").permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/loginPage")
//            .usernameParameter("email")
//            .passwordParameter("password");
////            .successHandler(new RefererRedirectionAuthenticationSuccessHandler())
//////            .defaultSuccessUrl("/welcome", true)
////            .loginProcessingUrl("/login")
////            .failureUrl("/error")
//////            .failureHandler(authenticationFailureHandler())
////            .and()
////            .logout()
////            .logoutUrl("/perform_logout")
////            .deleteCookies("JSESSIONID");
//////            .logoutSuccessHandler(logoutSuccessHandler());
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
