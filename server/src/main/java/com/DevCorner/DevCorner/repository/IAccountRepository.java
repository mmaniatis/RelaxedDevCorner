package com.DevCorner.DevCorner.repository;

import com.DevCorner.DevCorner.models.Account;
import org.springframework.stereotype.Component;

@Component
public interface IAccountRepository {
    String CreateAccountIfNotExists(Account account) throws Exception;
}