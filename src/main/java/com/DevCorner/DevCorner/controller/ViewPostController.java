package com.DevCorner.DevCorner.controller;

import com.DevCorner.DevCorner.models.Post;
import com.DevCorner.DevCorner.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class ViewPostController {
    @Autowired
    private PostRepository repository;

    @RequestMapping("/ViewPost")
    public ModelAndView index(String id){
        ModelAndView mav = new ModelAndView("ViewPost/index")
                .addObject("post", repository.findPostById(id));
        return mav;
    }
}
