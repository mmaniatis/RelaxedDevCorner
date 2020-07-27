package com.DevCorner.DevCorner.models;

public class BlizzardBearerToken {
    private final String access_token;
    private final String token_type;
    private final int expires_in;

    public BlizzardBearerToken(String _access_token, String _token_type, int _expires_in) {
        access_token = _access_token;
        token_type = _token_type;
        expires_in = _expires_in;
    }

    public String getAccess_token() {
        return this.access_token;
    }
    public String getToken_type() {
        return this.token_type;
    }
    public int getExpires_in() {
        return this.expires_in;
    }
}
