package pl.devfoundry.testing.account;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Test
    void getAllActiveAccounts() {
        //given
        List<Account> accountList=createAccounts();
        AccountRepository accountRepository=mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        when(accountRepository.getAllAccounts()).thenReturn(accountList);
        //when
        List<Account> accounts = accountService.getAllActiveAccounts();
        //then
        assertThat(accounts,hasSize(2));
    }
    @Test
    void getAllNotActiveAccounts() {
        //given
        AccountRepository accountRepository=mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        when(accountRepository.getAllAccounts()).thenReturn(Collections.emptyList());
        //when
        List<Account> accounts = accountService.getAllActiveAccounts();
        //then
        assertThat(accounts,hasSize(0));
    }


    public List<Account> createAccounts() {
        Address address = new Address("Kwiatowa", "1");
        Address address2 = new Address("Midowa", "2");

        Account account = new Account(address);
        Account account1 = new Account();
        Account account2 = new Account(address2);

        return List.of(account,account1,account2);
    }




    @Test
    void findByName() {
    }
}