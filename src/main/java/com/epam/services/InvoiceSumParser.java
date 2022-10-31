package com.epam.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceSumParser {
    private static final String[] FIRST_SYSTEM_SUM = {"12 HRK", "12.235 HRK", "12.25 HRK", "12.231 HRK", "12.15 HRK", "12.14 HRK", "12.16 HRK"};
    private static final String SECOND_SYSTEM_SUM = "    {\n" +
            "   \"HRK\": [12, 12.24, 12.25, 12.23, 12.15, 12.14, 12.16]\n" +
            "   }";

    public List<Double> parseSumFromPriceCurrencyFormatToListDouble() {
        List<String> invoiceSum = Arrays.asList(FIRST_SYSTEM_SUM);

        return invoiceSum.stream().map(invoice -> getSumOfInvoiceInDoubleFormat(invoice.replace("HRK", ""))).toList();
    }


    public List<Double> parseSumFromJsonFormatToListDouble() {
        Map<String, List<Object>> invoiceSumMap = getMapFromJson();
        List<Object> list = invoiceSumMap.get("HRK");
        return list.stream().map(invoice -> getSumOfInvoiceInDoubleFormat(invoice.toString())).toList();

    }

    private double getSumOfInvoiceInDoubleFormat(String invoice) {
        return BigDecimal.valueOf(Double.parseDouble(invoice)).
                setScale(2, RoundingMode.HALF_UP).
                doubleValue();
    }

    private Map<String, List<Object>> getMapFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<Object>> mapFromJson;
        try {
            mapFromJson = objectMapper.readValue(SECOND_SYSTEM_SUM, HashMap.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return mapFromJson;
    }

}
