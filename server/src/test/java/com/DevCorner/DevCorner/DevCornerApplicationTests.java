package com.DevCorner.DevCorner;

import com.DevCorner.DevCorner.controller.HomeController;
import com.DevCorner.DevCorner.models.Comment;
import com.DevCorner.DevCorner.models.Post;
import com.DevCorner.DevCorner.repository.IPostRepository;
import com.DevCorner.DevCorner.repository.PostRepository;
import com.DevCorner.DevCorner.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DevCornerApplicationTests {


	@MockBean
	private PostRepository postRepository;

	@Autowired
	PostService postService;

	@Test
	void getPosts() {
		when(postRepository.GetAllPosts()).thenReturn(getSamplePosts());
		assertEquals(this.getSamplePosts().size(), postService.GetAllPosts().size());
	}

	@Test
	void createPost() {
		when(postRepository.CreatePost(any(Post.class))).thenReturn(true);
		assertTrue(postService.CreatePost(this.getSamplePost()));
	}

	@Test
	void getPostsSorting() {
		when(postRepository.GetAllPosts()).thenReturn(getSamplePosts());
		List<Post> posts = postService.GetAllPosts();
		boolean isSortedDescending = true;
		for (int i = posts.size() - 1; i > 0; i--) {
			if (posts.get(i - 1).cdDate.compareTo(posts.get(i).cdDate) >= 0) {
				continue;
			} else {
				isSortedDescending = false;
				break;
			}
		}
		assert(isSortedDescending);
	}

	@Test
	void getCategories() {
		when(postRepository.getCategories()).thenReturn(new HashSet<String>(
			Arrays.asList("Test", "Test1", "Test2")
		));
		assertEquals(new HashSet<String>(
				Arrays.asList("Test", "Test1", "Test2")
		), postService.getCategories());
	}

	@Test
	void getPostByCategory(){
		when(postRepository.getPostsByCategory(any(String.class))).thenReturn(getSamplePosts());
		assertEquals(postService.getPostsByCategory("Test").size(), getSamplePosts().size());
	}

	private ArrayList<Post> getSamplePosts() {
		Post p = new Post(
				"Test",
				"Test",
				"Test",
				"Test",
				"Test",
				new Date()
		);
		Post p2 = new Post(
				"Test",
				"Test",
				"Test",
				"Test",
				"Test",
				new Date(-3)
		);
		Post p3 = new Post(
				"Test",
				"Test",
				"Test",
				"Test",
				"Test",
				new Date()
		);
		ArrayList<Post> res = new ArrayList<>();
		res.add(p);
		res.add(p2);
		res.add(p3);
		return res;
	}
	private Post getSamplePost() {
		Post p = new Post(
				"Test",
				"Test",
				"Test",
				"Test",
				"Test",
				new Date()
		);
		return p;
	}
}
