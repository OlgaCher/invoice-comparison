package com.epam.services;
//For each payment day we receive from one system sums of invoices in this format:
//        ["12 HRK", "12.235 HRK", "12.25 HRK", "12.231 HRK", "12.15 HRK", "12.14 HRK", "12.16 HRK"]
//        And from other sums of reported payments, in the next format:
//       {
//    "HRK": [12, 12.24, 12.25, 12.23, 12.15, 12.14, 12.16]
//    }
//        We need to check if data from one system is the same as the data from another system.
//        For the given examples, the answer is yes.

import java.util.List;

public class InvoiceComparison {

    public boolean ifInvoicesAreEqual(List<Double> firstSystemParsedInvoice, List<Double> secondSystemParsedInvoice) {

        return firstSystemParsedInvoice.equals(secondSystemParsedInvoice);
    }


}
