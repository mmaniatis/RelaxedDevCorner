package com.DevCorner.DevCorner.controller;

        import com.DevCorner.DevCorner.models.*;
        import com.DevCorner.DevCorner.repository.PostRepository;
        import com.DevCorner.DevCorner.service.PostService;
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
    private PostService postService;

    @GetMapping("/GetPosts")
    public ArrayList<Post> GetPosts()
    {
        return postService.GetAllPosts();
    }

    @PostMapping("/CreatePost")
    public boolean CreatePost(@RequestBody Post post)
    {
        return postService.CreatePost(post);
    }

    @GetMapping("/GetPost")
    public Post GetPost(@RequestParam("category") String category, @RequestParam("slug")  String slug)
    {
        return postService.GetPost(category,  slug);
    }

    @GetMapping("/GetCategories")
    public Set<String> GetCategories() {
        return postService.getCategories();
    }

    @GetMapping("/GetPostsByCategory")
    public ArrayList<Post> GetPostByCategory(String category){
        return postService.getPostsByCategory(category);
    }

    @GetMapping("/AddComment")
    public void AddComment(@RequestParam("body") String body, @RequestParam("author") String author, @RequestParam("slug") String slug, @RequestParam("category") String category) {
        postService.addComment(body, author, slug, category);
    }
    
    @RequestMapping("/")
    public String index() {
        return "Relaxed Dev Corner API.";
    }
}