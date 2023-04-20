package com.yedeveloper.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping( "/" )
    public String helloWorld () {
        return "helloworld@";
    }
}
