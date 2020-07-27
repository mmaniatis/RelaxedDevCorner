package com.DevCorner.DevCorner.service;

import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Optional;

public interface HttpService {
    String sendPost(String postUrl, List<NameValuePair> params, Optional<String> auth);
}
