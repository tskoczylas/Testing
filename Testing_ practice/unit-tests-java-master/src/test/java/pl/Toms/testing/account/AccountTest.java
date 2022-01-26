package pl.devfoundry.testing.account;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newlyCreatedAccountShuldNotBeActivated(){
        //given
        Account account= new Account();
        //when
        //then
        assertNotNull(account.isActive());
        assertThat(account.isActive(),is(not(true)));

    }

    @Test
    void newlyCreatedAccountShuldNotHaveDefaultDeliveryAdrees()
    {//given
        Account account = new Account();
        //when
        Address defaultDeliveryAddress = account.getDefaultDeliveryAddress();
        //then
        assertNull(defaultDeliveryAddress);
        assertThat(defaultDeliveryAddress,is(nullValue()));

    }
    @Test
    void DeliveryAdressShuldNotBeNullAfterAccountCreated(){
        //given
        Account account= new Account(new Address("Won","2"));
        //when
        Address defaultDeliveryAddress = account.getDefaultDeliveryAddress();
        //then
        assertNotNull(defaultDeliveryAddress);
        assertThat(defaultDeliveryAddress,is(notNullValue()));
    }

    @Test
    void newlyCreatedAccountWitchDeuflatAdreesShouldBeActive(){
        //given
        Address address = new Address("d", "d");

        ///when

        Account account = new Account(address);


    }


}