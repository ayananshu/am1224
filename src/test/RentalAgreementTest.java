package test;

import main.RentalAgreement;
import main.Tool;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class RentalAgreementTest {
    @Test
    void testRentalAgreementCalculation() {
        LocalDate checkoutDate = LocalDate.parse("09/03/24", DateTimeFormatter.ofPattern("MM/dd/yy"));
        Tool tool = new Tool("LADW", Tool.ToolType.LADDER, "Werner");
        RentalAgreement agreement = new RentalAgreement(tool, 4, 0, checkoutDate);

        assertEquals("LADW", agreement.getTool().getToolCode());
        assertEquals(Tool.ToolType.LADDER, agreement.getTool().getType());
        assertEquals("Werner", agreement.getTool().getBrand());
        assertEquals(4, agreement.getRentalDays());
        assertEquals(checkoutDate, agreement.getCheckoutDate());
        assertEquals(checkoutDate.plusDays(4), agreement.getDueDate());
        assertEquals(1.99, agreement.getDailyRentalCharge(), 0.001);
        assertEquals(4, agreement.getChargeDays());
        assertEquals(7.96, agreement.getPreDiscountCharge(), 0.001);
        assertEquals(0, agreement.getDiscountPercent(), 0.001);
        assertEquals(0, agreement.getDiscountAmount(), 0.001);
        assertEquals(7.96, agreement.getFinalCharge(), 0.001);
    }

    @Test
    void testRentalAgreementWithDiscount() {
        LocalDate checkoutDate = LocalDate.parse("09/03/24", DateTimeFormatter.ofPattern("MM/dd/yy"));
        Tool tool = new Tool("CHNS", Tool.ToolType.CHAINSAW, "Stihl");
        RentalAgreement agreement = new RentalAgreement(tool, 5, 10, checkoutDate);
        //System.out.println(agreement.getTool().+','+agreement.);
        assertEquals(4.47, agreement.getPreDiscountCharge(), 0.001);
        assertEquals(0.447, agreement.getDiscountAmount(), 0.001);
        assertEquals(4.023, agreement.getFinalCharge(), 0.001);
    }
}