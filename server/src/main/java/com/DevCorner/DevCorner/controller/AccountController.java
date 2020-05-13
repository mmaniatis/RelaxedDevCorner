package com.DevCorner.DevCorner.controller;

import com.DevCorner.DevCorner.ApplicationProperties;
import com.DevCorner.DevCorner.models.Account;
import com.DevCorner.DevCorner.repository.AccountRepository;
import com.DevCorner.DevCorner.repository.IAccountRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@RestController
@SpringBootApplication
@RequestMapping("/api/Account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("/Authenticate")
    public String Authenticate(String idTokenString) throws Exception
    {
        HttpTransport transport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(new ApplicationProperties().getProperty("app.prodGoogleClientId")))
                .build();
        try {
            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {
                Payload payload = idToken.getPayload();

                // Get profile information from payload
                if(Boolean.valueOf(payload.getEmailVerified()))
                {
                    String email = payload.getEmail();
                    String name = (String) payload.get("name");
                    String locale = (String) payload.get("locale");
                    String familyName = (String) payload.get("family_name");
                    String givenName = (String) payload.get("given_name");

                    Account account = new Account(
                            email,
                            name,
                            locale,
                            familyName,
                            givenName,
                            false
                    );
                    return accountRepository.CreateAccountIfNotExists(account);
                }
                else
                    throw new Exception("Email not verified.");

            } else {
                throw new Exception("Google verification has failed.");
            }
        }
        catch (GeneralSecurityException | IOException Ex){
            throw new Exception();
        }
    }
}
