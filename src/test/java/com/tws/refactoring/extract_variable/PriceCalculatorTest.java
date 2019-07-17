package com.tws.refactoring.extract_variable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    private PriceCalculator priceCalculator;

    @BeforeEach
    void setUp() {
        priceCalculator = new PriceCalculator();
    }

    @Test
    void should_return_0_when_get_price_given_quantity_is_0() {
        double price = priceCalculator.getPrice(0, 1);

        assertEquals(0, price);
    }

    @Test
    void should_return_0_when_get_price_given_item_price_is_0() {
        double price = priceCalculator.getPrice(1, 0);

        assertEquals(0, price);
    }
    @Test
    void should_return_1_point_1_when_get_price_given_quantity_is_1_and_item_price_is_1() {
        double price = priceCalculator.getPrice(1, 1);

        assertEquals(1.1, price);
    }

    @Test
    void should_return_1100_when_get_price_given_quantity_is_500_and_item_price_is_2() {
        double price = priceCalculator.getPrice(500, 2);

        assertEquals(1100, price);
    }

    @Test
    void should_return_1101_point_9_when_get_price_given_quantity_is_501_and_item_price_is_2() {
        double price = priceCalculator.getPrice(501, 2);

        assertEquals(1101.9, price);
    }
}