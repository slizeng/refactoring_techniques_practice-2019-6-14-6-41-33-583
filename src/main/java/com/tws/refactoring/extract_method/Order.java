package com.tws.refactoring.extract_method;

class Order {
    private final double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    double getAmount() {
        return amount;
    }
}
