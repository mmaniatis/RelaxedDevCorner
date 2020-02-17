package com.DevCorner.DevCorner.repository;

import java.util.Date;
import java.util.List;
import com.DevCorner.DevCorner.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String>
{
    public List<Post> findPostsByCategory(String category);
}
