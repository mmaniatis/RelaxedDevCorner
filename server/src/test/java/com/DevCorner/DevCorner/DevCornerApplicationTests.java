package com.DevCorner.DevCorner;

import com.DevCorner.DevCorner.models.Post;
import com.DevCorner.DevCorner.repository.IPostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
class DevCornerApplicationTests {
	@Autowired
	private IPostRepository postRepo;

	@Test
	void getPosts() {
		List<Post> posts = postRepo.GetAllPosts();
		assert(posts.size() > 0 );
	}
	@Test
	void getPostsSorting() {
		List<Post> posts = postRepo.GetAllPosts();
		boolean isSortedDescending = true;
		for(int i = posts.size()-1; i > 0; i--){
			if(posts.get(i - 1).cdDate.compareTo(posts.get(i).cdDate) > 0){
				continue;
			}
			else {
				isSortedDescending = false;
				break;
			}
		}

		assert(isSortedDescending);
	}

	@Test
	void getCategoreis() {
		Set<String> categories = postRepo.getCategories();
		assert(categories.size() > 0);
	}

	@Test
	void getPostByCategory(){
		ArrayList<Post> posts = postRepo.getPostsByCategory("Development");
		assert(posts.size() > 0);
	}
}
