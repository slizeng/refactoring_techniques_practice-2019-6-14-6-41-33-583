package com.tws.refactoring.extract_method;

import java.util.List;

public class OwingPrinter {
    void printOwing(String name, List<Order> orders) {
        printBanner();

        double outstanding = calculateOutstanding(orders);

        printDetails(name, outstanding);
    }

    private double calculateOutstanding(List<Order> orders) {
        return orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();
    }

    private void printBanner() {
        System.out.println("*****************************");
        System.out.println("****** Customer totals ******");
        System.out.println("*****************************");
    }

    private void printDetails(String name, double outstanding) {
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }
}