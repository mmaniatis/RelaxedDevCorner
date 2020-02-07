package com.DevCorner.DevCorner.controller;


import com.DevCorner.DevCorner.models.Post;
import com.DevCorner.DevCorner.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CreatePostController {
    @Autowired
    private PostRepository repository;

    public void createPost(Post newPost)
    {
        newPost = new Post(".NET", "Working in Java after a career of .NET",
                "Transition", "Example Body", "Michael J. Maniatis", new Date());
        if (newPost != null)
        {
            repository.save(newPost);
        }
    }
}
