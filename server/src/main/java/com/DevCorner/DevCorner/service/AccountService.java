package com.DevCorner.DevCorner.service;

import com.DevCorner.DevCorner.ApplicationProperties;
import com.DevCorner.DevCorner.models.Account;
import com.DevCorner.DevCorner.repository.AccountRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ApplicationProperties applicationProperties;

    private final HttpTransport transport;
    private final JacksonFactory jsonFactory;

    public AccountService() {
        transport = new NetHttpTransport();
        jsonFactory = new JacksonFactory();
    }
    public String CreateAccountIfNotExists(Account account) throws Exception {
        return accountRepository.CreateAccountIfNotExists(account);
    }

    public String Authenticate(String idTokenString) throws Exception
    {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(
                        applicationProperties.getProperty("app.prodGoogleClientId")))
                .build();
        try {
            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();

                if(payload.getEmailVerified())
                {
                    return this.CreateAccountIfNotExists(createAccountDetails(payload));
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

    private Account createAccountDetails(GoogleIdToken.Payload payload) {
        String email = payload.getEmail();
        String name = (String) payload.get("name");
        String locale = (String) payload.get("locale");
        String familyName = (String) payload.get("family_name");
        String givenName = (String) payload.get("given_name");

        return new Account(
                email,
                name,
                locale,
                familyName,
                givenName,
                false
        );
    }
}
