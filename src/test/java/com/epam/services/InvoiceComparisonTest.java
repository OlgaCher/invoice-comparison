package com.epam.services;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvoiceComparisonTest {

    private InvoiceComparison testedInstance = new InvoiceComparison();

    private List<Double> getFirstSystemParsedInvoice() {
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

    private List<Double> getSecondSystemParsedInvoice() {
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

    private List<Double> getIncorrectInvoice() {
        List<Double> expected = new ArrayList<>();
        expected.add(12.0);
        expected.add(12.25);
        expected.add(12.24);
        expected.add(12.23);
        expected.add(12.15);
        expected.add(12.14);
        expected.add(12.16);
        return expected;
    }

    @Test
    public void shouldValidateIfInvoicesAreEqual() {
        boolean actual = testedInstance.ifInvoicesAreEqual(getFirstSystemParsedInvoice(), getSecondSystemParsedInvoice());
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldValidateIfInvoicesAreNOTEqual() {
        boolean actual = testedInstance.ifInvoicesAreEqual(getFirstSystemParsedInvoice(), getIncorrectInvoice());
        Assert.assertFalse(actual);
    }

}