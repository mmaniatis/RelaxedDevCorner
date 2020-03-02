package com.DevCorner.DevCorner.controller;

        import com.DevCorner.DevCorner.models.Post;
        import com.DevCorner.DevCorner.repository.IPostRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.web.bind.annotation.*;
        import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class HomeController {
    @Autowired
    private IPostRepository repository;
    @GetMapping("/GetPosts/{category}")
    public ArrayList<Post> GetPosts(@PathVariable String category)
    {
        return repository.findPostsByCategory(category);
    }
    @GetMapping("/GetPosts/")
    public ArrayList<Post> GetPosts()
    {
        var PostList = repository.findAll();
        return (ArrayList<Post>) PostList;
    }

}