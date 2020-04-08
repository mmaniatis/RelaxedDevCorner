package com.DevCorner.DevCorner.controller;

        import com.DevCorner.DevCorner.models.*;
        import com.DevCorner.DevCorner.repository.IPostRepository;
        import com.DevCorner.DevCorner.repository.PostRepository;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.web.bind.annotation.*;
        import java.util.ArrayList;

@RestController
@SpringBootApplication
@RequestMapping("/api")
public class HomeController {

    private IPostRepository repository;

    public HomeController()
    {
        repository = new PostRepository();
    }

    @GetMapping("/GetPosts")
    public ArrayList<Post> GetPosts()
    {
        return repository.GetAllPosts();
    }
    @PostMapping("/CreatePost")
    public boolean CreatePost(@RequestBody Post post)
    {
        try
        {
            repository.CreatePost(post);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    @GetMapping("/GetPost")
    public Post GetPost(@RequestParam("category") String category, @RequestParam("slug")  String slug)
    {
        return repository.GetPost(category, slug);
    }

    @RequestMapping("/")
    public String index() {
        return "Relaxed Dev Corner API.";
    }
}