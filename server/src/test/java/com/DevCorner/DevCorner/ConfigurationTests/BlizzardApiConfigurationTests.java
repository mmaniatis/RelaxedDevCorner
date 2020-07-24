package com.DevCorner.DevCorner.ConfigurationTests;

import com.DevCorner.DevCorner.ApplicationProperties;
import com.DevCorner.DevCorner.BlizzardApiConfigurationImpl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
}
