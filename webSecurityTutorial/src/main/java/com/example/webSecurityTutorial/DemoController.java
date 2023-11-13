package com.example.webSecurityTutorial;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    /*
    * BE will verify the JSESSIONID cookie given by the FE. If
    * the JSESSIONID is of an authenticated user. it will not redirect
    * to /login API else it will redirect to /login and after entering the creds, a new logged in JESSIONID will be given by the BE
    * */

    @Autowired
    MyUserDetailService myUserDetailService;

    @GetMapping("/demo")
    public String greet(){
        return "Hello World!!";
    }
    @GetMapping("/demo2")
    public String greet2(){
        return "Hello World2!!";
    }

    @GetMapping("/testcode")
    public String testCode(){
        return "Testing the code.....";
    }
    @GetMapping("/developcode")
    public String accessServer(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      MyUser myUser = (MyUser) authentication.getPrincipal();

        return myUser.getName() +"Accessing the server....";
    }

    @PostMapping("/storeUser")
    public void createUser(@RequestBody MyUser myUser){
        myUserDetailService.createUser(myUser);
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to the home page...";
    }
}
