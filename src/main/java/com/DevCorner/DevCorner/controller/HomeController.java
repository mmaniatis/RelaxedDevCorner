package com.DevCorner.DevCorner.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "home/index";
    }
}