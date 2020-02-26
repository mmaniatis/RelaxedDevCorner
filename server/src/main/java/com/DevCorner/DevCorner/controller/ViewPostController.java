package com.DevCorner.DevCorner.controller;

import com.DevCorner.DevCorner.models.Post;
import com.DevCorner.DevCorner.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@SpringBootApplication
public class ViewPostController {
    @Autowired
    private PostRepository repository;

    @RequestMapping("/ViewPost")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("ViewPost/index")
                .addObject("post", new Post("1", "TestCategory", "TestTitle", "TestSlug", "Lorem Ipsum. Lorem Ipsum. L" +
                        "orem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. " +
                        "Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. " +
                        "Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. " +
                        "Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. ",
                        "Mmaniatis", new Date().toString()));
        return mav;
    }
}
