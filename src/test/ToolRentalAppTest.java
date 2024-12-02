package test;

import main.ToolRentalApp;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class ToolRentalAppTest {
    @Test
    void testToolRentalApp() {
        String toolCode = "LADW";
        int rentalDays = 3;
        double discountPercent = 10;
        String checkoutDateStr = "09/03/2024";
        String outContent = ToolRentalApp.checkout(toolCode, rentalDays, discountPercent, checkoutDateStr).toString();

        String expectedOutput = "Tool code: LADW\n" +
                "Tool type: LADDER\n" +
                "Tool brand: Werner\n" +
                "Rental days: 3\n" +
                "Check out date: 09/03/2024\n" +
                "Due date: 09/06/2024\n" +
                "Daily rental charge: $1.99\n" +
                "Charge days: 3\n" +
                "Pre-discount charge: $5.97\n" +
                "Discount percent: 10%\n" +
                "Discount amount: $0.60\n" +
                "Final charge: $5.37\n";

        assertEquals(expectedOutput, outContent);
    }
}