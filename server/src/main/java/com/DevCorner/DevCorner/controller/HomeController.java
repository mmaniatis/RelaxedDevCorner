package com.DevCorner.DevCorner.controller;

        import com.DevCorner.DevCorner.models.*;
        import com.DevCorner.DevCorner.repository.PostRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.web.bind.annotation.*;
        import java.util.ArrayList;
        import java.util.Set;

@RestController
@SpringBootApplication
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private PostRepository repository;

    @GetMapping("/GetPosts")
    public ArrayList<Post> GetPosts()
    {
        return repository.GetAllPosts();
    }
    @PostMapping("/CreatePost")
    @CrossOrigin(origins = "http://localhost:3000")
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
        return repository.GetPost(category,  slug);
    }

    @GetMapping("/GetCategories")
    public Set<String> GetCategories() {
        return repository.getCategories();
    }
    @GetMapping("GetPostsByCategory")
    public ArrayList<Post> GetPostByCategory(String category){
        return repository.getPostsByCategory(category);
    }
    @RequestMapping("/")
    public String index() {
        return "Relaxed Dev Corner API.";
    }
}