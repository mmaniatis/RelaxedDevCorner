package com.DevCorner.DevCorner;

import com.DevCorner.DevCorner.configs.ApiConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlizzardApiConfigurationImpl implements ApiConfiguration {
    private final String clientIdProperty = "app.BlizzardClientId";
    private final String clientSecretProperty = "app.BlizzardClientSecret";
    @Autowired
    ApplicationProperties applicationProperties;

    public String getClientId() {
        return applicationProperties.getProperty(clientIdProperty);
    }

    public String getClientSecret() {
        return applicationProperties.getProperty(clientSecretProperty);

    }
}
