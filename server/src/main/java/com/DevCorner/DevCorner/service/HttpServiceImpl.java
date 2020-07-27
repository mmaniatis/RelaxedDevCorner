package com.DevCorner.DevCorner.service;

import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Service
public class HttpServiceImpl implements HttpService {

    public String sendPost(String postUrl, List<NameValuePair> params, Optional<String> auth) {
        StringBuffer response = new StringBuffer();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(postUrl);
        try {
            //Encode the nameValuePair list in UTF-8 and then set as paramaters
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            //Set the header using the basic http auth encoded value string
            if (auth.isPresent()){
                httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + auth.get());
            }
            //execute the post using our httpClient
            CloseableHttpResponse httpResponse = client.execute(httpPost);
            //retrieve the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpResponse.getEntity().getContent()));
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
            client.close();

        } catch (Exception ex) {
            String exception = ex.getMessage();
            return null;
        }

        return response.toString();
    }
}
