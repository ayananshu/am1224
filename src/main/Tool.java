package main;

public class Tool {
    private String toolCode;
    private ToolType type;
    private String brand;

    public enum ToolType {
        LADDER(1.99, true, true, false),
        CHAINSAW(1.49, true, false, true),
        JACKHAMMER(2.99, true, false, false);

        private final double dailyCharge;
        private final boolean weekdayCharge;
        private final boolean weekendCharge;
        private final boolean holidayCharge;

        ToolType(double dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
            this.dailyCharge = dailyCharge;
            this.weekdayCharge = weekdayCharge;
            this.weekendCharge = weekendCharge;
            this.holidayCharge = holidayCharge;
        }

        public double getDailyCharge() {
            return dailyCharge;
        }

        public boolean isWeekdayCharge() {
            return weekdayCharge;
        }

        public boolean isWeekendCharge() {
            return weekendCharge;
        }

        public boolean isHolidayCharge() {
            return holidayCharge;
        }
    }

    public Tool(String toolCode, ToolType type, String brand) {
        this.toolCode = toolCode;
        this.type = type;
        this.brand = brand;
    }

    public String getToolCode() {
        return toolCode;
    }

    public ToolType getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }
}