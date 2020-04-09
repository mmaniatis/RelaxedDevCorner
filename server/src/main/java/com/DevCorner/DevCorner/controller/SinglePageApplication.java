package com.DevCorner.DevCorner.controller;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@SpringBootApplication
@RequestMapping("/")
public class SinglePageApplication {

        @RequestMapping(value = "/")
        public String index() {
                return "index.html";
        }
}
