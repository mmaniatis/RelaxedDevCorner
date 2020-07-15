package com.DevCorner.DevCorner.RepositoryTests;


import com.DevCorner.DevCorner.DatabaseConfig;
import com.DevCorner.DevCorner.models.Post;
import com.DevCorner.DevCorner.repository.PostRepository;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PostRepositoryTests {
    @MockBean
    DatabaseConfig databaseConfig;
    @Mock
    private MongoCollection mockCollection;
    @Mock
    private FindIterable iterable;
    @Mock
    private MongoCursor cursor;
    @Autowired
    PostRepository postRepository;

    @BeforeEach
    public void setUp() {
        iterable = mock(FindIterable.class);
        cursor= mock(MongoCursor.class);
        mockCollection = mock(MongoCollection.class);

        when(databaseConfig.getPostCollection()).thenReturn(mockCollection);
        when(mockCollection.find(any(Bson.class))).thenReturn(iterable);
        when(iterable.iterator()).thenReturn(cursor);
    }

    @Test
    public void GetAllPostsSomeResults() {
        Document doc1 = getPostDocument();
        when(cursor.hasNext())
                .thenReturn(true)
                .thenReturn(false);
        when(cursor.next())
                .thenReturn(doc1);
        ArrayList<Post> expected = postRepository.GetAllPosts();
        assertTrue(expected.size() > 0);
    }

    @Test
    public void GetAllPostsNoResults() {
        when(cursor.hasNext())
                .thenReturn(false);
        ArrayList<Post> expected = postRepository.GetAllPosts();
        assertEquals(expected.size(),0);
    }

    @Test
    public void CreatePostProperInput() {
        Mockito.doNothing()
                .when(mockCollection)
                .insertOne(any(Bson.class));
        Post p = getPostObject();
        postRepository.CreatePost(p);
        verify(mockCollection, times(1)).insertOne(any(Bson.class));
    }
    @Test
    public void CreatePostImproperInput() {
        Mockito.doNothing()
                .when(mockCollection)
                .insertOne(any(Bson.class));
        postRepository.CreatePost(null);
        verify(mockCollection, times(0)).insertOne(any(Bson.class));
    }

    private Document getPostDocument() {
        return new Document("id", new ObjectId())
                .append("category", "testCategory")
                .append("title", "testTitle")
                .append("slug", "testSlug")
                .append("body", "testBody")
                .append("author", "testAuthor")
                .append("cdDate", new Date())
                .append("comments", null);
    }
    private Post getPostObject() {
        Post p = new Post(
                "testCategory",
                "testTitle",
                "testSlug",
                "testBody",
                "testAuthor",
                new Date()
        );
        return p;
    }
}
