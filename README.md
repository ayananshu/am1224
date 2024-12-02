# ToolDepot Tool Rental Application

Welcome to the **ToolDepot Tool Rental Application**! This application is a point-of-sale system designed to simulate the checkout process for a store that rents large tools, similar to Home Depot.

## Overview

The tool rental application allows customers to rent tools for a specified number of days, generates a Rental Agreement upon checkout, and calculates the total charge, considering discounts, weekends, and holidays.

## Features

- **Tool Rental System**: Simulates the rental process for tools like ladders, chainsaws, and jackhammers from different brands.
- **Rental Agreement Generation**: Produces a detailed agreement document for the customer, including all calculated charges.
- **Charge Calculation**: Applies daily rental fees based on tool type, considering weekends and holidays, with discount application capabilities.
- **Holidays Handling**: Recognizes Independence Day and Labor Day, adjusting charges accordingly.
- **User Input Validation**: Ensures that the input provided by the customer is valid, throwing exceptions with informative messages for invalid data.

## Requirements

- **Java Development Kit (JDK)**: Version 8 or above to run and compile the Java code provided.

## Getting Started

### Running the Application

1. **Compile**: Use `javac` to compile all Java files:

   ```
   javac Tool.java Holiday.java RentalAgreement.java ToolRentalApp.java
    ```
2. **Run**: Use `java` to run the application:
   ```
   java ToolRentalApp
   ```
### Input
The application prompts for the following user inputs:
- Tool Code: A unique identifier for each tool.
- Rental Days: Number of days for which the customer wants to rent the tool.
- Discount Percent: A whole number between 0 and 100 representing the percentage discount.
- Checkout Date: The date when the customer checks out the tool.

### Output
The application generates and prints a Rental Agreement to the console, which includes:
- Tool Code, Type, and Brand
- Rental Days, Check Out, and Due Date
- Daily Rental Charge, Charge Days, Pre-Discount Charge, Discount Percent, Discount Amount, and Final Charge

### Formatting
- Date: MM/dd/yy
- Currency: $9,999.99
- Percent: 99%

### Testing
- Unit Tests: Ensure that the application handles various scenarios:
  - Invalid Input: Test with invalid tool codes, rental days less than 1, or discount percentages outside of 0-100% range.
  - Holidays: Verify that Independence Day and Labor Day are correctly observed.
  - Weekends: Ensure charges are applied or waived based on tool type and rental dates.

### Code Structure
The application includes the following classes:
- Tool: Represents a tool with its attributes like type, brand, and daily charge rules.
- Holiday: Contains logic for determining if a date is a holiday.
- RentalAgreement: Encapsulates all details of a rental agreement and calculates charges.
- ToolRentalApp: The main application class that orchestrates the checkout process.

### Limitations
- User Interface: This application does not include a graphical user interface.
- Database: No database integration; all data is stored within the application.

### License
This project is for educational purposes. If you have any questions or need further clarification, feel free to reach out.

  
