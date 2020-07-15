package com.DevCorner.DevCorner.RepositoryTests;


import com.DevCorner.DevCorner.DatabaseConfig;
import com.DevCorner.DevCorner.repository.PostRepository;
import com.mongodb.DBCollection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PostRepositoryTests {
    @MockBean
    DatabaseConfig databaseConfig;

    @Autowired
    PostRepository postRepository;

    @Before
    public void setUp() {
//        FindIterable<Document> documents = new FindIterable();


        MongoCollection dbCollection = Mockito.mock(MongoCollection.class);
//        when(dbCollection.find(any(Bson.class))).thenReturn();
        when(databaseConfig.getPostCollection()).thenReturn(dbCollection);
    }

    @Test
    public void GetAllPosts() {

    }
}
