package pl.devfoundry.testing.order;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import pl.devfoundry.testing.meal.Meal;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;

    @BeforeEach
    void initializeOrder(){
        order=new Order();
    }
    @AfterEach
    void cleanApp(){
        order.cancel();
    }

    @Test
    void AssertArreyEqual(){
        //given
        int[] int1={1,2,3};
        int[] int2={1,2,3};
        //then
        assertArrayEquals(int1,int2);

    }
    @Test
    void MealListShuldBeEmptyAfterCreationOrder(){
        //given
        //then
        assertThat(order.getMeals(),is(empty()));
        assertThat(order.getMeals(),hasSize(0));
        assertThat(order.getMeals(),emptyCollectionOf(Meal.class));
    }

    @Test
    void AddingMealToOrderShuldIncriseOrderListSize(){
        //given
        Meal meal = new Meal(32, "Fish");
        Meal meal1 = new Meal(22, "And Chips");
        //when
        order.addMealToOrder(meal);
        order.addMealToOrder(meal1);
        //then
        assertThat(order.getMeals(),hasSize(2));
        assertThat(order.getMeals(),contains(meal,meal1));
    }
@Test
    void RemovingMealFromOdrerShuldEarseMealFromOrder(){
    //given
    Meal meal = new Meal(32, "Fish");
    Meal meal1 = new Meal(22, "And Chips");
    //when
    order.addMealToOrder(meal);
    order.addMealToOrder(meal1);

    order.removeMealFromOrder(meal);
    order.removeMealFromOrder(meal1);
    //then
    assertThat(order.getMeals(),hasSize(0));
    assertThat(order.getMeals(),emptyCollectionOf(Meal.class));
    assertThat(order.getMeals(),not(contains(meal,meal1)));

}
@Test
void MealsShuldBeInCorrentOrderAfterAddingtoOrders(){
    //given
    Meal meal = new Meal(32, "Fish");
    Meal meal1 = new Meal(22, "And Chips");
    //when
    order.addMealToOrder(meal);
    order.addMealToOrder(meal1);


    //then
    assertThat(order.getMeals(),contains(meal,meal1));
    assertThat(order.getMeals(),containsInAnyOrder(meal1,meal));

}
@Test
    void TestIfTwoMealsAreTheSame(){
    //given
    Meal meal = new Meal(32, "Fish");
    Meal meal1 = new Meal(22, "And Chips");
    Meal meal2 = new Meal(22, "And Chips");
    List<Meal> list = List.of(meal1,meal2);
    List<Meal> list2 = List.of(meal1,meal2);


    //when


    //then
    assertThat(list,(is(list2)));

}



}