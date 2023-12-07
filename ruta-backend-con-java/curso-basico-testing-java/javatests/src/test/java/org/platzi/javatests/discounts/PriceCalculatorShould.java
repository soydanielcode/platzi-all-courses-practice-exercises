package org.platzi.javatests.discounts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorShould {
    private PriceCalculator calculator;
    @Before
    public void setup(){
        calculator = new PriceCalculator();
    }
    @Test
    public void return_zero_when_there_are_price() {
        assertEquals(0.0, calculator.getTotal(), 0.00001);
    }
    @Test
    public void return_total_is_sum_of_prices(){
        calculator.addPrice(13.2);
        calculator.addPrice(23.8);
        assertEquals(37.00, calculator.getTotal(), 00000.1);
    }
    @Test
    public void apply_discount_to_prices(){
        calculator.addPrice(100);
        calculator.addPrice(100);
        calculator.setDiscount(33.21);
        assertEquals(133.58, calculator.getTotal(), 00000.1);
    }
}