package com.DevCorner.DevCorner.ServiceTests;

import com.DevCorner.DevCorner.models.Account;
import com.DevCorner.DevCorner.repository.AccountRepository;
import com.DevCorner.DevCorner.service.AccountService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTests {
    @MockBean
    AccountRepository accountRepository;
    @Autowired
    AccountService accountService;
    private Gson g = new Gson();

    @Test
    void CreateAccountIfNotExists() {
        try {
            when(accountRepository.CreateAccountIfNotExists(any(Account.class)))
                    .thenReturn(g.toJson(this.getSampleAccount()));

            Account account = g.fromJson(accountService.CreateAccountIfNotExists(this.getSampleAccount()), Account.class);
            assert(account.equals(this.getSampleAccount()));
        } catch (Exception ex){

        }
    }

    private Account getSampleAccount() {
        Account sampleAccount = new Account(
          "test@test.com",
          "testName",
                "testLocale",
                "testFamilyName",
                "testGivenName",
                false

        );
        return sampleAccount;
    }
}
