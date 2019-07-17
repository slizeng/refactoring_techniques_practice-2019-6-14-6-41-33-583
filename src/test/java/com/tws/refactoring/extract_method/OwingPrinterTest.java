package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static org.junit.Assert.assertEquals;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_print_banner_and_zero_as_detail_when_printOwing_given_an_empty_order_list() {
        OwingPrinter owingPrinter = new OwingPrinter();
        String name = "name";

        owingPrinter.printOwing(name, emptyList());

        assertEquals(
                "*****************************\n" +
                        "****** Customer totals ******\n" +
                        "*****************************\n" +
                        "name: name\n" +
                        "amount: 0.0\n", outContent.toString());
    }

    @Test
    public void should_print_banner_and_3_as_amount_when_printOwing_given_orders_with_amount_1_and_2() {
        OwingPrinter owingPrinter = new OwingPrinter();
        String name = "name";

        owingPrinter.printOwing(name, asList(new Order(1.0), new Order(2.0)));

        assertEquals(
                "*****************************\n" +
                        "****** Customer totals ******\n" +
                        "*****************************\n" +
                        "name: name\n" +
                        "amount: 3.0\n", outContent.toString());
    }
}