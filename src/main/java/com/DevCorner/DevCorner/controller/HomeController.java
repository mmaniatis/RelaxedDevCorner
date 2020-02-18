package com.DevCorner.DevCorner.controller;

        import com.DevCorner.DevCorner.models.Post;
        import com.DevCorner.DevCorner.repository.PostRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.bind.annotation.RequestMapping;

        import java.util.Date;
        import java.util.List;

@Controller
@SpringBootApplication
public class HomeController {
    @Autowired
    private PostRepository repository;

    @RequestMapping("/")
    public String index() {
        List<Post> postList = GetPosts(".NET");
        return "home/index";
    }

    public List<Post> GetPosts(String Category)
    {
        if (repository.findPostsByCategory(".NET").size() == 0)
        {
            repository.save(new Post(".NET", "Working in Java after a career of .NET",
                    "Transition", "Example Body", "Michael J. Maniatis", new Date()));
        }
        return repository.findPostsByCategory((".NET"));
    }
}