package pl.devfoundry.testing.cart;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.devfoundry.testing.meal.Meal;
import pl.devfoundry.testing.order.Order;

import java.time.Duration;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test cases for Cart")
class CartTest {

    @Test
    void CardShuldNotBeEmptyAfterAddingOrder() {
        //given
        Order order =new Order();
        Cart cart = new Cart();
        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(),allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class))))
        );

        assertAll(
                ()->assertThat(cart.getOrders(),hasSize(1)),
        ()->assertThat(cart.getOrders(),notNullValue()),
        ()->{
            List<Order> additionMeal = cart.getOrders();
            assertThat(additionMeal.size(),is(1));




        }
        );

    }

    @Test
    void addOrderToCart() {
    }

    @Test
    void clearCart() {
    }

    @Test
    @DisplayName("Cart is able to process 1000 orders in one order")
    void simulateLargeOrder() {
        //given
        Cart cart = new Cart();
        //then
        assertTimeout(Duration.ofMillis(100),cart::simulateLargeOrder);
    }
}