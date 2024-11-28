import java.time.LocalDate;
import java.util.Scanner;

public class ToolRentalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter tool code: ");
        String toolCode = scanner.nextLine();

        System.out.print("Enter rental days: ");
        int rentalDays = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter discount percent: ");
        double discountPercent = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter checkout date (MM/dd/yyyy): ");
        String checkoutDateStr = scanner.nextLine();
        //LocalDate checkoutDate = LocalDate.parse(checkoutDateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate checkoutDate = RentalAgreement.validateDate(checkoutDateStr, scanner);

        scanner.close();

        // Validate input
        if (rentalDays < 1) {
            throw new IllegalArgumentException("Rental day count must be at least 1.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount percent must be between 0 and 100.");
        }

        Tool tool = validateTool(toolCode);
        RentalAgreement agreement = new RentalAgreement(tool, rentalDays, discountPercent, checkoutDate);
        agreement.print();
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