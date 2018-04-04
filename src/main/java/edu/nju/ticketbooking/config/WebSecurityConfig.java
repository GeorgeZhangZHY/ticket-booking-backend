package edu.nju.ticketbooking.config;

import edu.nju.ticketbooking.constant.Role;
import edu.nju.ticketbooking.filter.JWTAuthenticationFilter;
import edu.nju.ticketbooking.filter.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(value = "userServ")
    private UserDetailsService userDetailsService;

    @Autowired
    @Qualifier(value = "venueServ")
    private UserDetailsService venueDetailsService;

    @Autowired
    @Qualifier(value = "managerServ")
    private UserDetailsService managerDetailsService;

    // 设置 HTTP 验证规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        DaoAuthenticationProvider userAuthProvider = new DaoAuthenticationProvider(),
                venueAuthProvider = new DaoAuthenticationProvider(),
                managerAuthProvider = new DaoAuthenticationProvider();
        userAuthProvider.setUserDetailsService(userDetailsService);
        venueAuthProvider.setUserDetailsService(venueDetailsService);
        managerAuthProvider.setUserDetailsService(managerDetailsService);

        AuthenticationManager userAuthManager = new ProviderManager(Collections.singletonList(userAuthProvider));
        AuthenticationManager venueAuthManger = new ProviderManager(Collections.singletonList(venueAuthProvider));
        AuthenticationManager mangerAuthManager = new ProviderManager(Collections.singletonList(managerAuthProvider));

        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user", "/venue").permitAll()
                .antMatchers(HttpMethod.GET, "/activate").permitAll()
                .anyRequest().authenticated()  // 其他所有请求需要身份认证
                .and()
                .addFilter(new JWTLoginFilter(userAuthManager, Role.USER))
                .addFilter(new JWTLoginFilter(venueAuthManger, Role.VENUE))
                .addFilter(new JWTLoginFilter(mangerAuthManager, Role.MANAGER))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()));
    }

}
