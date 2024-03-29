package com.example.security;

//import com.example.userservice.dto.UserDto;
//import com.example.userservice.service.UserService;
//import com.example.userservice.vo.RequestLogin;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.env.Environment;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
//@Slf4j
//public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private UserService userService;
//    private Environment env;
//
//    public AuthenticationFilter(AuthenticationManager authenticationManager, UserService userService, Environment env) {
//        super.setAuthenticationManager(authenticationManager);
//        this.userService = userService;
//        this.env = env;
//    }
//
//    @Override
//    //로그인 요청 정보 처리
//    public Authentication attemptAuthentication(HttpServletRequest request,
//                                                HttpServletResponse response) throws AuthenticationException {
//        try {
//            RequestLogin requestLogin = new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);
//
//            // Manager가 변환된 Token 이메일 패스워드 검증
//            return getAuthenticationManager().authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            requestLogin.getEmail(),
//                            requestLogin.getPassword(),
//                            new ArrayList<>()));
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//        String userName = ((User)authResult.getPrincipal()).getUsername();
//        UserDto userDetails = userService.getUserDetailsByName(userName);
//        String token =Jwts.builder()
//                .setSubject(userDetails.getUserId())
//                .setExpiration(new Date(System.currentTimeMillis()
//                        + Long.parseLong(env.getProperty("token.expiration_time"))))
//                .signWith(SignatureAlgorithm.HS512,env.getProperty("token.secret"))
//                        .compact();
//        response.addHeader("token",token);
//        response.addHeader("userId",userDetails.getUserId());
//    }
//}