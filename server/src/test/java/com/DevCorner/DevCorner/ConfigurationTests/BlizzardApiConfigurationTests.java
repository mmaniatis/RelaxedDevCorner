package com.DevCorner.DevCorner.ConfigurationTests;

import com.DevCorner.DevCorner.ApplicationProperties;
import com.DevCorner.DevCorner.BlizzardApiConfigurationImpl;
import com.DevCorner.DevCorner.models.BlizzardBearerToken;
import com.DevCorner.DevCorner.service.HttpService;
import com.DevCorner.DevCorner.service.HttpServiceImpl;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BlizzardApiConfigurationTests {
    Gson g = new Gson();
    @Autowired
    BlizzardApiConfigurationImpl blizzardApiConfiguration;

    @MockBean
    ApplicationProperties  applicationProperties;

    @MockBean
    HttpServiceImpl httpServiceImpl;


    @BeforeEach
    public void setUp() {
        BlizzardBearerToken mockBearerToken = new BlizzardBearerToken("testToken", "TestType", 123456);

        when(applicationProperties.getProperty("app.BlizzardClientId")).thenReturn("testClientId");
        when(applicationProperties.getProperty("app.BlizzardClientSecret")).thenReturn("testClientSecret");
        when(applicationProperties.getProperty("app.BlizzardOauthUri")).thenReturn("TestUri");

        when(httpServiceImpl.sendPost(any(String.class), any(List.class), any(Optional.class))).thenReturn(g.toJson(mockBearerToken));
    }

    @Test
    public void whenGetClientIdThenRetrieveClientId() {
        String result = blizzardApiConfiguration.getClientId();

        Assert.assertTrue(result.equalsIgnoreCase("testclientid"));
    }

    @Test
    public void whenGetClientSecretThenRetrieveClientSecret() {
        String result = blizzardApiConfiguration.getClientSecret();
        Assert.assertTrue(result.equalsIgnoreCase("testclientsecret"));

    }

    @Test
    public void whenGetBlizzardApiTokenThenRetrieveToken() {
        String token = blizzardApiConfiguration.GetApiToken();
        Assert.assertTrue(token != null);
    }
}
