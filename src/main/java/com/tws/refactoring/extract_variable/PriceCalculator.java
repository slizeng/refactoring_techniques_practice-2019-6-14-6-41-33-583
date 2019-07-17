package com.tws.refactoring.extract_variable;

public class PriceCalculator {

    private static final double MAX_SHOPPING_COST = 100.0;
    private static final double SHOPPING_COST_RATE = 0.1;
    private static final int QUANTITY_THRESHOLD = 500;
    private static final double DISCOUNT_RATE = 0.05;

    double getPrice(int quantity, int itemPrice) {
        double basePrice = calculateBasePrice(quantity, itemPrice);
        double discount = calculateDiscount(quantity, itemPrice);
        double shoppingCost = calculateShoppingCost(basePrice);

        return basePrice - discount + shoppingCost;
    }

    private double calculateBasePrice(int quantity, int itemPrice) {
        return (double) quantity * itemPrice;
    }

    private double calculateShoppingCost(double basePrice) {
        return Math.min(basePrice * SHOPPING_COST_RATE, MAX_SHOPPING_COST);
    }

    private double calculateDiscount(int quantity, int itemPrice) {
        return Math.max(0, quantity - QUANTITY_THRESHOLD) * itemPrice * DISCOUNT_RATE;
    }
}
