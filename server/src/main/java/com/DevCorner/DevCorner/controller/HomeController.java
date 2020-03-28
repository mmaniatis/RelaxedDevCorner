package com.DevCorner.DevCorner.controller;

        import com.DevCorner.DevCorner.models.Post;
        import com.DevCorner.DevCorner.repository.IPostRepository;
        import com.DevCorner.DevCorner.repository.PostRepository;
        import com.nimbusds.oauth2.sdk.http.HTTPResponse;
        import com.sun.deploy.net.HttpResponse;
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
    @GetMapping("/CreatePost")
    public boolean CreatePost(Post post)
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
    @RequestMapping("/")
    public String index() {
        return "Relaxed Dev Corner API.";
    }
}