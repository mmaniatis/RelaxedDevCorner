package com.DevCorner.DevCorner;

import com.DevCorner.DevCorner.models.Post;
import com.DevCorner.DevCorner.repository.IPostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DevCornerApplicationTests {
	@Autowired
	private IPostRepository postRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void getPosts() {
		List<Post> posts = postRepo.GetAllPosts();
		assert(posts.size() > 0 );
	}

}
