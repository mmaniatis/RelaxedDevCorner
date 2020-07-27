package com.DevCorner.DevCorner;

import com.DevCorner.DevCorner.configs.ApiConfiguration;
import com.DevCorner.DevCorner.models.BlizzardBearerToken;
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


@Configuration
public class BlizzardApiConfigurationImpl implements ApiConfiguration {
    private final String clientIdProperty = "app.BlizzardClientId";
    private final String clientSecretProperty = "app.BlizzardClientSecret";
    private final String blizzardOauthUri = "app.BlizzardOauthUri";
    @Autowired
    ApplicationProperties applicationProperties;

    public String getClientId() {
        return applicationProperties.getProperty(clientIdProperty);
    }

    public String getClientSecret() {
        return applicationProperties.getProperty(clientSecretProperty);
    }

    public String GetBlizzardApiToken() {
        String clientId = getClientId();
        String clientSecret = getClientSecret();
        String uri = applicationProperties.getProperty(blizzardOauthUri);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);
        try {
            //Form the headers nameValuePair list object
            List<NameValuePair> params = new ArrayList<NameValuePair>(1);
            params.add(new BasicNameValuePair("grant_type", "client_credentials"));
            //Encode the nameValuePair list in UTF-8 and then set as paramaters
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            //Encode the basic http authorizaatoin user:password
            String encoding = Base64.getEncoder().encodeToString((clientId +":"+clientSecret).getBytes());

            //Set the header using the basic http auth encoded value string
            httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);

            //execute the post using our httpClient
            CloseableHttpResponse httpResponse = client.execute(httpPost);

            //retrieve the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpResponse.getEntity().getContent()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
            Gson g = new Gson();
            BlizzardBearerToken bearerToken = g.fromJson(String.valueOf(response), BlizzardBearerToken.class);
            client.close();
            return bearerToken.getAccess_token();
        }
        catch (Exception ex){
            String exception = ex.getMessage();
            return null;
        }
    }

}
