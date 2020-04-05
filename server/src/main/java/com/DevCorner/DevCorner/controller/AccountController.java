package com.DevCorner.DevCorner.controller;

import com.DevCorner.DevCorner.models.Account;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@RestController
@SpringBootApplication
@RequestMapping("/api/Account")
public class AccountController {

    /*
    * eyJhbGciOiJSUzI1NiIsImtpZCI6IjI1N2Y2YTU4MjhkMWU0YTNhNmEwM2ZjZDFhMjQ2MWRiOTU5M2U2MjQiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiMTcwMDE3NTg2Njc2LTJwMWUyY3BmMGpndDhiMTk0NmNybjIwaXBkdWxpNGc1LmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiMTcwMDE3NTg2Njc2LTJwMWUyY3BmMGpndDhiMTk0NmNybjIwaXBkdWxpNGc1LmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTExMzkxMTU1MzkzNTUzMTkzMzAzIiwiZW1haWwiOiJtaWtlam9obm1hbmlhdGlzQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhdF9oYXNoIjoidGx0ZEZqZnpFZS1zSURuU3hUM0RRQSIsIm5hbWUiOiJNaWtlIE1hbmlhdGlzIiwicGljdHVyZSI6Imh0dHBzOi8vbGg2Lmdvb2dsZXVzZXJjb250ZW50LmNvbS8td2k3SEJkc3lzVE0vQUFBQUFBQUFBQUkvQUFBQUFBQUFBQUEvQUFLV0pKTU11YjV5aE84X1RuQ25MQWdSN09GSm9RVWpXUS9zOTYtYy9waG90by5qcGciLCJnaXZlbl9uYW1lIjoiTWlrZSIsImZhbWlseV9uYW1lIjoiTWFuaWF0aXMiLCJsb2NhbGUiOiJlbiIsImlhdCI6MTU4NjAxOTI5MCwiZXhwIjoxNTg2MDIyODkwLCJqdGkiOiIxNTVkMTM4MmZkODFlZjVlMjY5ZTg3ODE5ZTU2YTBkNjcwN2ZlZmJlIn0.YJaUUfkvL3o84TCgAy7JuYtLxPusEm5eRwmRkxyOV5AfJeX13QKRqTqx6irQmljJcx6ULA42o9uVIFASbSXaucsvnlwf1z_ahIWaq1rOfYiVkehrSpgsX2EPEKputsATCN8aFfJTvpsiKACVaDD1fK7T_3MVH6Mx2NQ73KikYnxcXn4N2z2RlrLJOUsmcy3WJanpgx5PyLLWAkxmHo0D9CZftP8UwQoDRhLiFFIAiScxaaJTwGQsWw1ii4jGWGokEjDlNBih5ru4OmD2vxI1A6EF7-65-sZah0nuSsuh--y_YgILdxb9dZShzBmH82XNiZRkGQ73eIQiF-EwdvvuxA
    * */
    @GetMapping("/Authenticate")
    public String Authenticate(String idTokenString) throws Exception
    {
        HttpTransport transport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList("170017586676-2p1e2cpf0jgt8b1946crn20ipduli4g5.apps.googleusercontent.com"))
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
                    return new Gson().toJson(account);
                }
                else
                    throw new Exception();

            } else {
                throw new Exception();
            }
        }
        catch (GeneralSecurityException | IOException Ex){
            throw new Exception();
        }
    }
}
