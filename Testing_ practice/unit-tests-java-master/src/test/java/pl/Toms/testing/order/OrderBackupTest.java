package pl.devfoundry.testing.order;

import org.junit.jupiter.api.*;
import pl.devfoundry.testing.meal.Meal;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderBackupTest {

    static private OrderBackup orderBackup;

    @BeforeAll
    static void setUp() throws FileNotFoundException {
        orderBackup=new OrderBackup();
        orderBackup.createFile();
    }



    @Test
    void BackUpOrderWithOneMeal() throws IOException {
        //given
        Meal meal= new Meal(2,"A");
        Order order = new Order();
        order.addMealToOrder(meal);
        //when
        orderBackup.createFile();
        orderBackup.backUpOrder(order);
        //then
        System.out.println("Oorder + " + order.toString() + " back up");

    }

    @Test
    void createFile() {
    }

    @Test
    void backUpOrder() {
    }


    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }
}