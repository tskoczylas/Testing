package pl.devfoundry.testing.meal;

import net.bytebuddy.matcher.ElementMatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class MealTestNe {

    @Test
    void ShuldBeDiscontedPrice()
    {
        //given
    Meal meal=new Meal(20,"Fish and Chips");
    //when
        int discountedPrice = meal.getDiscountedPrice(20);
        int expetedValue=0;
        //then
        assertEquals(discountedPrice,0);
        assertThat(discountedPrice,equalTo(0));

    }

@Test
    void WhenDiscountHigherThanPriceThrownIllegalArgumentException(){
        //given
    Meal meal = new Meal(20,"Fish and Chips");
    //when
    //then
    assertThrows(IllegalArgumentException.class,()->meal.getDiscountedPrice(30));
}

@Test
    void ReferenceToTheSameOcjectsShuldBeTheSame()
{   //given
    Meal meal = new Meal(10,"Fish and Chips");
    //when
    Meal meal1=meal;
    //then
    assertSame(meal,meal1);
    assertThat(meal,sameInstance(meal1));

}
@Test
    void ReferenceToDiffrentObjectsShouldNotBeTheSame(){
        //given
    Meal meal = new Meal(10,"Else");
    Meal meal1 = new Meal(20,"Fish and Chips");
    //when
    //then
    assertNotSame(meal,meal1);
    assertThat(meal,not(sameInstance(meal1)));

}
@Test
    void TwoObjectsShuldBeEqualWhenPriceAndTitleAreTheSame(){
        //given
    Meal meal = new Meal(2,"Chips");
    Meal meal2 = new Meal(2,"Chips");
    //when
    //then
    assertThat(meal,equalTo(meal2));
    assertEquals(meal,meal2);


}

@ParameterizedTest
@ValueSource(ints = {3,6,12,15})
    void mealPriceShuldBeLowertThan20(int price){
        //given
    //then
    assertThat(price,lessThan(20));

}

@ParameterizedTest
@MethodSource("createMealsWithNameAndPrice")
void burgerShouldHaveCorrectNameAndPrice(String name, int price){
        //giving
    //then
    assertThat(name,containsString("burger"));
    assertThat(price,greaterThanOrEqualTo(10));

}

private static Stream<Arguments> createMealsWithNameAndPrice(){
        return Stream.of(Arguments.of("Hamburger",10),Arguments.of("Cheseburger",12));
}

@ParameterizedTest
@MethodSource("createCakeNames")
void CackeNamesShuldEndWItchCake(String name){

        assertThat(name,endsWith("Cake"));
    }

private static Stream<String> createCakeNames(){
        List<String> cakesNames = List.of("PineCake","LimonCake","BlueberryCake");
        return cakesNames.stream();
}
}
