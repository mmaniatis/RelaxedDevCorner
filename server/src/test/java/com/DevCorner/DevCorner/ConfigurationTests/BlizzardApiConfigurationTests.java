package com.DevCorner.DevCorner.ConfigurationTests;

import com.DevCorner.DevCorner.ApplicationProperties;
import com.DevCorner.DevCorner.BlizzardApiConfigurationImpl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BlizzardApiConfigurationTests {
    @Autowired
    BlizzardApiConfigurationImpl blizzardApiConfiguration;

    @MockBean
    ApplicationProperties  applicationProperties;

    @BeforeEach
    public void setUp() {
        when(applicationProperties.getProperty("app.BlizzardClientId")).thenReturn("testClientId");
        when(applicationProperties.getProperty("app.BlizzardClientSecret")).thenReturn("testClientSecret");
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
        when(applicationProperties.getProperty("app.BlizzardClientId")).thenReturn("190844a001a44495b47e336acf4d19d1");
        when(applicationProperties.getProperty("app.BlizzardClientSecret")).thenReturn("NyF4iHnm7Dfv4w3qWFG6VJ0H6ExxT0DU");
        when(applicationProperties.getProperty("app.BlizzardOauthUri")).thenReturn("https://us.battle.net/oauth/token");
        String token = blizzardApiConfiguration.GetBlizzardApiToken();
        Assert.assertTrue(token != null);
    }
}
