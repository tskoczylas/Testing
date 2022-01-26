package pl.devfoundry.testing.order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderStatusTest {

    @ParameterizedTest
    @EnumSource(OrderStatus.class)
    void OrderStatusShuldBeShorterThan15Characters(OrderStatus orderStatus) {
        //given
        //when
        //then
        assertThat(orderStatus.name().length(),lessThan(15));
    }

    @Test
    void valueOf() {
    }
}