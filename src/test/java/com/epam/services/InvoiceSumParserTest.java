package com.epam.services;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvoiceSumParserTest {


    private InvoiceSumParser testedInstance = new InvoiceSumParser();

    private List<Double> getExpectedList() {
        List<Double> expected = new ArrayList<>();
        expected.add(12.0);
        expected.add(12.24);
        expected.add(12.25);
        expected.add(12.23);
        expected.add(12.15);
        expected.add(12.14);
        expected.add(12.16);
        return expected;
    }

    @Test
    public void shouldValidateParsedSumFromPriceCurrencyFormatToListDouble() {
        List<Double> actual = testedInstance.parseSumFromPriceCurrencyFormatToListDouble();
        Assert.assertEquals(getExpectedList(), actual);
    }


    @Test
    public void shouldValidateParsedSumFromJsonFormatToListDouble() {
        List<Double> actual = testedInstance.parseSumFromJsonFormatToListDouble();
        Assert.assertEquals(getExpectedList(), actual);
    }
}