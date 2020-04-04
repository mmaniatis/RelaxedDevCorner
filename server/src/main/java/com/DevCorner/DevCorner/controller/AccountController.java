package com.DevCorner.DevCorner.controller;

import com.DevCorner.DevCorner.models.*;
import com.DevCorner.DevCorner.repository.IPostRepository;
import com.DevCorner.DevCorner.repository.PostRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@SpringBootApplication
@RequestMapping("/api/Account")
public class AccountController {

    /*
    * eyJhbGciOiJSUzI1NiIsImtpZCI6IjI1N2Y2YTU4MjhkMWU0YTNhNmEwM2ZjZDFhMjQ2MWRiOTU5M2U2MjQiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiMTcwMDE3NTg2Njc2LTJwMWUyY3BmMGpndDhiMTk0NmNybjIwaXBkdWxpNGc1LmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiMTcwMDE3NTg2Njc2LTJwMWUyY3BmMGpndDhiMTk0NmNybjIwaXBkdWxpNGc1LmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTExMzkxMTU1MzkzNTUzMTkzMzAzIiwiZW1haWwiOiJtaWtlam9obm1hbmlhdGlzQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhdF9oYXNoIjoidGx0ZEZqZnpFZS1zSURuU3hUM0RRQSIsIm5hbWUiOiJNaWtlIE1hbmlhdGlzIiwicGljdHVyZSI6Imh0dHBzOi8vbGg2Lmdvb2dsZXVzZXJjb250ZW50LmNvbS8td2k3SEJkc3lzVE0vQUFBQUFBQUFBQUkvQUFBQUFBQUFBQUEvQUFLV0pKTU11YjV5aE84X1RuQ25MQWdSN09GSm9RVWpXUS9zOTYtYy9waG90by5qcGciLCJnaXZlbl9uYW1lIjoiTWlrZSIsImZhbWlseV9uYW1lIjoiTWFuaWF0aXMiLCJsb2NhbGUiOiJlbiIsImlhdCI6MTU4NjAxOTI5MCwiZXhwIjoxNTg2MDIyODkwLCJqdGkiOiIxNTVkMTM4MmZkODFlZjVlMjY5ZTg3ODE5ZTU2YTBkNjcwN2ZlZmJlIn0.YJaUUfkvL3o84TCgAy7JuYtLxPusEm5eRwmRkxyOV5AfJeX13QKRqTqx6irQmljJcx6ULA42o9uVIFASbSXaucsvnlwf1z_ahIWaq1rOfYiVkehrSpgsX2EPEKputsATCN8aFfJTvpsiKACVaDD1fK7T_3MVH6Mx2NQ73KikYnxcXn4N2z2RlrLJOUsmcy3WJanpgx5PyLLWAkxmHo0D9CZftP8UwQoDRhLiFFIAiScxaaJTwGQsWw1ii4jGWGokEjDlNBih5ru4OmD2vxI1A6EF7-65-sZah0nuSsuh--y_YgILdxb9dZShzBmH82XNiZRkGQ73eIQiF-EwdvvuxA
    * */

    @GetMapping("/Authenticate")
    public String Authenticate(String token)
    {
        DecodedJWT jwt = JWT.decode(token);

        String issuer = jwt.getIssuer();
        String email = jwt.getClaim("email").asString();
        String name = jwt.getClaim("name").asString();
        String locale = jwt.getClaim("locale").asString();
        //Boolean isEmailVerified = jwt.getClaim("email_verified")x.asBoolean();
        return "true";
    }

//    private boolean CreateUserIfNotExists(Account account)
//    {
//    }
}
