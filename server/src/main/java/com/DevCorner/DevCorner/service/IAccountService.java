package com.DevCorner.DevCorner.service;

import com.DevCorner.DevCorner.models.Account;

public interface IAccountService {
    String CreateAccountIfNotExists(Account account) throws Exception;
    String Authenticate(String idTokenString) throws Exception;
}
