package pl.devfoundry.testing.cart;

import org.junit.jupiter.api.Test;
import pl.devfoundry.testing.order.Order;
import pl.devfoundry.testing.order.OrderStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class CartServiceTest {

    @Test
    void processCartShuldBePrepere() {
        //given
        Order order=new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);
        CartHandler cartHandler= mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);
        given(cartHandler.canHandleCart(cart)).willReturn(true);

        //when
        Cart reultCard=cartService.processCart(cart);

        //then
        verify(cartHandler).sendToPrepare(cart);
        assertThat(reultCard.getOrders(),hasSize(1));
        assertThat(reultCard.getOrders().get(0).getOrderStatus(),equalTo(OrderStatus.PREPARING));

    }
    @Test
    void processCartShuldNotBeSendToPrepere() {
        //given
        Order order=new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);
        CartHandler cartHandler= mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);
        given(cartHandler.canHandleCart(cart)).willReturn(false);

        //when
        Cart reultCard=cartService.processCart(cart);

        //then
        verify(cartHandler,never()).sendToPrepare(cart);
        then(cartHandler).should(never()).sendToPrepare(cart);
        assertThat(reultCard.getOrders().get(0).getOrderStatus(),equalTo(OrderStatus.REJECTED));


    }

    @Test
    void processCartShuldNotBeSendToPrepereWitchArhumentsMachers() {
        //given
        Order order=new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler= mock(CartHandler.class);

        given(cartHandler.canHandleCart(any(Cart.class))).willReturn(true,false,true);

        //when
        //then
        assertThat(cartHandler.canHandleCart(cart),equalTo(true));
        assertThat(cartHandler.canHandleCart(cart),equalTo(false));
        assertThat(cartHandler.canHandleCart(cart),equalTo(true));

    }
    @Test
    void processCartShuldBePreperWitchLambdas() {
        //given
        Order order=new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);
        CartHandler cartHandler= mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);
        given(cartHandler.canHandleCart(cart)).willThrow(IllegalStateException.class);

        //when

        //then
        assertThrows(IllegalStateException.class,()->cartHandler.canHandleCart(cart));

    }
}