package com.DevCorner.DevCorner.controller;

        import com.DevCorner.DevCorner.models.Post;
        import com.DevCorner.DevCorner.repository.PostRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.servlet.ModelAndView;

        import java.util.ArrayList;
        import java.util.List;

@Controller
@SpringBootApplication
public class HomeController {
    @Autowired
    private PostRepository repository;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("home/index")
                .addObject("postList", GetPosts("Development"));
        return mav;
    }

    public ArrayList<Post> GetPosts(String Category)
    {
        return repository.findPostsByCategory(Category);
    }
}