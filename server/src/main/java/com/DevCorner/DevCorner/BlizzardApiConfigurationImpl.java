package com.DevCorner.DevCorner;

import com.DevCorner.DevCorner.configs.ApiConfiguration;
import com.DevCorner.DevCorner.models.BlizzardBearerToken;
import com.DevCorner.DevCorner.service.HttpService;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Configuration
public class BlizzardApiConfigurationImpl implements ApiConfiguration {
    private final String clientIdProperty = "app.BlizzardClientId";
    private final String clientSecretProperty = "app.BlizzardClientSecret";
    private final String blizzardOauthUri = "app.BlizzardOauthUri";
    private Gson g = new Gson();
    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    HttpService httpServiceImpl;

    public String getClientId() {
        return applicationProperties.getProperty(clientIdProperty);
    }

    public String getClientSecret() {
        return applicationProperties.getProperty(clientSecretProperty);
    }

    public String GetBlizzardApiToken() {

        String uri = applicationProperties.getProperty(blizzardOauthUri);
        List<NameValuePair> params = new ArrayList<NameValuePair>(1);
        params.add(new BasicNameValuePair("grant_type", "client_credentials"));
        String encoding = Base64.getEncoder().encodeToString((getClientId() + ":" + getClientSecret()).getBytes());

        String response = httpServiceImpl.sendPost(uri, params, Optional.ofNullable(encoding));
        BlizzardBearerToken bearerToken = g.fromJson(String.valueOf(response), BlizzardBearerToken.class);
        return bearerToken.getAccess_token();
    }

}
