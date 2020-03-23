package com.DevCorner.DevCorner.controller;

        import com.DevCorner.DevCorner.models.Post;
        import com.DevCorner.DevCorner.repository.IPostRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.ModelAndView;

        import java.util.ArrayList;
        import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private IPostRepository repository;

    @GetMapping("/GetPosts/{category}")
    public ArrayList<Post> GetPosts(@PathVariable String category)
    {
        return repository.findPostsByCategory(category);
    }

    @GetMapping("/GetPosts")
    public ArrayList<Post> GetPosts()
    {
        List<Post> PostList = repository.findAll();
        return (ArrayList<Post>) PostList;
    }
    @RequestMapping("/api")
    public String index() {
        return "Relaxed Dev Corner API.";
    }
}