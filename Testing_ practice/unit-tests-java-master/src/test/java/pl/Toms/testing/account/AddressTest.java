package pl.devfoundry.testing.account;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @ParameterizedTest
    @CsvSource({"Fabryczna,10","Armi Krajowej ,20"})
        void GivvenAdressesShuldNotBeEmptyAndHaveProperName(String street, String number){
            assertThat(number,notNullValue());
        assertThat(street,notNullValue());

        }
@ParameterizedTest
    @CsvFileSource(resources = "/adresses.csv")
void GivvenAdressesFromFIleShuldNotBeEmptyAndHaveProperName(String street, String number){
    assertThat(number,notNullValue());
    assertThat(street,notNullValue());

}

}