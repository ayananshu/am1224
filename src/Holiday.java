import java.time.LocalDate;

public class Holiday {
    public static boolean isHoliday(LocalDate date) {
        return isIndependenceDay(date) || isLaborDay(date);
    }

    private static boolean isIndependenceDay(LocalDate date) {
        LocalDate independenceDay = LocalDate.of(date.getYear(), 7, 4);
        if (independenceDay.getDayOfWeek().getValue() >= 6) {
            if (independenceDay.getDayOfWeek().getValue() == 6) {
                independenceDay = independenceDay.minusDays(1);
            } else if (independenceDay.getDayOfWeek().getValue() == 7) {
                independenceDay = independenceDay.plusDays(1);
            }
        }
        return date.isEqual(independenceDay);
    }

    private static boolean isLaborDay(LocalDate date) {
        LocalDate laborDay = LocalDate.of(date.getYear(), 9, 1);
        while (!laborDay.getDayOfWeek().toString().equals("MONDAY")) {
            laborDay = laborDay.plusDays(1);
        }
        return date.isEqual(laborDay);
    }
}