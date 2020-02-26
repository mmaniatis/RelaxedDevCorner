package com.DevCorner.DevCorner.controller;

        import com.DevCorner.DevCorner.models.Post;
        import com.DevCorner.DevCorner.repository.PostRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.ModelAndView;

        import javax.validation.Valid;
        import java.util.ArrayList;
        import java.util.List;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class HomeController {
    @Autowired
    private PostRepository repository;
    @GetMapping("/GetPosts/{category}")
    public ArrayList<Post> GetPosts(@PathVariable String category)
    {
        return repository.findPostsByCategory(category);
    }
    @GetMapping("/GetPosts/")
    public ArrayList<Post> GetPosts()
    {
        return (ArrayList<Post>) repository.findAll();
    }

}