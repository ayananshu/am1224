import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RentalAgreement {
    private Tool tool;
    private int rentalDays;
    private double discountPercent;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private double dailyRentalCharge;
    private int chargeDays;
    private double preDiscountCharge;
    private double discountAmount;
    private double finalCharge;

    public RentalAgreement(Tool tool, int rentalDays, double discountPercent, LocalDate checkoutDate) {
        this.tool = tool;
        this.rentalDays = rentalDays;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
        this.dueDate = checkoutDate.plusDays(rentalDays);

        calculateCharges();
    }

    private void calculateCharges() {
        this.dailyRentalCharge = tool.getType().getDailyCharge();
        this.chargeDays = calculateChargeDays();
        this.preDiscountCharge = dailyRentalCharge * chargeDays;
        this.discountAmount = preDiscountCharge * (discountPercent / 100);
        this.finalCharge = preDiscountCharge - discountAmount;
    }

    private int calculateChargeDays() {
        int days = 0;
        LocalDate currentDate = checkoutDate.plusDays(1);
        while (!currentDate.isAfter(dueDate)) {
            if (tool.getType().isWeekdayCharge() && currentDate.getDayOfWeek().getValue() < 6) {
                days++;
            } else if (tool.getType().isWeekendCharge() && currentDate.getDayOfWeek().getValue() >= 6) {
                days++;
            } else if (tool.getType().isHolidayCharge() && Holiday.isHoliday(currentDate)) {
                days++;
            }
            currentDate = currentDate.plusDays(1);
        }
        return days;
    }

    public void print() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        System.out.println("Tool code: " + tool.getToolCode());
        System.out.println("Tool type: " + tool.getType());
        System.out.println("Tool brand: " + tool.getBrand());
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Check out date: " + checkoutDate.format(formatter));
        System.out.println("Due date: " + dueDate.format(formatter));
        System.out.printf("Daily rental charge: $%.2f%n", dailyRentalCharge);
        System.out.println("Charge days: " + chargeDays);
        System.out.printf("Pre-discount charge: $%.2f%n", preDiscountCharge);
        System.out.printf("Discount percent: %d%%%n", (int) discountPercent);
        System.out.printf("Discount amount: $%.2f%n", discountAmount);
        System.out.printf("Final charge: $%.2f%n", finalCharge);
    }

    static LocalDate validateDate(String dateStr, Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        while (true) {
            try {
                return LocalDate.parse(dateStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format. Please re-enter the checkout date (MM/dd/yyyy): ");
                dateStr = scanner.nextLine();
            }
        }
    }
}