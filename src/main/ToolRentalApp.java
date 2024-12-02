package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ToolRentalApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static void main(String[] args) {
        // This is the entry point for running the application from the command line
        String toolCode = getInput("Enter tool code: ");
        int rentalDays = Integer.parseInt(getInput("Enter rental days: "));
        double discountPercent = Double.parseDouble(getInput("Enter discount percent: "));
        String checkoutDateStr = getInput("Enter checkout date (MM/dd/yyyy): ");
        LocalDate checkoutDate = validateDate(checkoutDateStr);

        // Validate input
        validateRentalDays(rentalDays);
        validateDiscountPercent(discountPercent);

        Tool tool = validateTool(toolCode);
        //RentalAgreement agreement = new RentalAgreement(tool, rentalDays, discountPercent, checkoutDate);
        RentalAgreement agreement = checkout(toolCode,rentalDays,discountPercent,checkoutDateStr);
        agreement.print();
    }

    // Method to facilitate unit testing
    public static RentalAgreement checkout(String toolCode, int rentalDays, double discountPercent, String checkoutDateStr) {
        LocalDate checkoutDate = validateDate(checkoutDateStr);
        validateRentalDays(rentalDays);
        validateDiscountPercent(discountPercent);

        Tool tool = validateTool(toolCode);
        return new RentalAgreement(tool, rentalDays, discountPercent, checkoutDate);
    }

    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static LocalDate validateDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format. Please use MM/dd/yyyy");
        }
    }

    private static void validateRentalDays(int rentalDays) {
        if (rentalDays < 1) {
            throw new IllegalArgumentException("Rental day count must be at least 1.");
        }
    }

    private static void validateDiscountPercent(double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount percent must be between 0 and 100.");
        }
    }

    private static Tool validateTool(String toolCode) {
        Tool tool;
        switch (toolCode) {
            case "CHNS":
                tool = new Tool("CHNS", Tool.ToolType.CHAINSAW, "Stihl");
                break;
            case "LADW":
                tool = new Tool("LADW", Tool.ToolType.LADDER, "Werner");
                break;
            case "JAKD":
            case "JAKR":
                tool = new Tool(toolCode, Tool.ToolType.JACKHAMMER, toolCode.equals("JAKD") ? "DeWalt" : "Ridgid");
                break;
            default:
                throw new IllegalArgumentException("Invalid tool code.");
        }
        return tool;
    }
}