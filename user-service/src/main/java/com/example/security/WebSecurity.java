package com.example.security;

//import com.example.userservice.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.servlet.Filter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//    private UserService userService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    private Environment env;
//    @Autowired
//    public WebSecurity(Environment env, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userService = userService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.env = env;
//    }
//
//    @Override
//    // 권한 관련
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        http.authorizeRequests().antMatchers("/actuator/**").permitAll();
//        http.authorizeRequests().antMatchers("/**")
//                .hasIpAddress("192.168.1.188") // TO-BE IP 변경 필요
//                .and()
//                .addFilter(getAuthenticationFilter());
//        http.headers().frameOptions().disable();
//
//
//    }
//
//    private AuthenticationFilter getAuthenticationFilter() throws Exception{
//        AuthenticationFilter authenticationFilter =
//                new AuthenticationFilter(authenticationManager(),userService,env);
//        // Manager를 불러와서 인증
//        authenticationFilter.setAuthenticationManager(authenticationManager());
//
//        return authenticationFilter;
//    }
//
//    @Override
//    // 인증 관련
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //select
//        // db(passEnc) == input(encrypted)
//        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
//    }
//}
