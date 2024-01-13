package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import com.example.demo.vo.Greeting;
import com.example.demo.vo.RequestUser;
import com.example.demo.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    private Environment env;
    private UserService userService;

    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @Autowired
    private Greeting greeting;

    @GetMapping("/health_check")
    public String status(){
        return "It's Working in User Service";
    }

    @GetMapping("/welcome_env")
    public String welcomeEnv(){
        return env.getProperty("greeting.message");
    }

    @GetMapping("/welcome_value")
    public String welcomeValue(){
        return greeting.getValue();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user,UserDto.class);
        UserDto responseDto = userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(responseDto,ResponseUser.class);

        //HTTP 201.CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}
