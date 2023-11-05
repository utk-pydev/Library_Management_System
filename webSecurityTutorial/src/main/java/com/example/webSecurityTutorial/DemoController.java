package com.example.webSecurityTutorial;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    /*
    * BE will verify the JSESSIONID cookie given by the FE. If
    * the JSESSIONID is of an authenticated user. it will not redirect
    * to /login API else it will redirect to /login and after entering the creds, a new logged in JESSIONID will be given by the BE
    * */

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
    public String accessServer(){        return "Accessing the server....";
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to the home page...";
    }
}
