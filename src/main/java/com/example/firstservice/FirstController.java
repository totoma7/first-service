package com.example.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
@Slf4j
public class FirstController {

    Environment env;

    @Autowired
    public FirstController(Environment env){
        this.env = env;

    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome first-service";
    }

    @GetMapping("/users")
    public String users(){
        return "welcome first-service";
    }


    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){
        System.out.println(header);
        return "Hello World in First Service";
    }
    @GetMapping("/check")
    public String check(HttpServletRequest request){
        log.info("Server port={}",request.getServerPort());

        return String.format("Hi there. This is a message from First Service %s"
        ,env.getProperty("local.server.port"));
    }
     @GetMapping("/health_check")
        public String health_check(HttpServletRequest request){
        log.info("Server port={}",request.getServerPort());

        return String.format("Hi there. This is a message from First Service %s"
        ,env.getProperty("local.server.port"));
    }

}
