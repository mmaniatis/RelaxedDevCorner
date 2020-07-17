package com.DevCorner.DevCorner.controller;

import com.DevCorner.DevCorner.ApplicationProperties;
import com.DevCorner.DevCorner.models.Account;
import com.DevCorner.DevCorner.repository.AccountRepository;
import com.DevCorner.DevCorner.repository.IAccountRepository;
import com.DevCorner.DevCorner.service.AccountService;
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
@RequestMapping("/api/Account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/Authenticate")
    public String Authenticate(String idTokenString) throws Exception
    {
        return accountService.Authenticate(idTokenString);
    }

    
}
