package com.DevCorner.DevCorner.repository;

import com.DevCorner.DevCorner.models.Account;

public interface IAccountRepository {
    String CreateAccountIfNotExists(Account account) throws Exception;
}