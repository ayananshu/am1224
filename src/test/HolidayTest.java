package test;
import main.Holiday;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

class HolidayTest {
    @Test
    void testIndependenceDay() {
        LocalDate date = LocalDate.of(2024, 7, 4);
        assertTrue(Holiday.isHoliday(date));  // Independence Day is on July 4th
        assertFalse(Holiday.isHoliday(date.minusDays(1)));  // Day before
        assertFalse(Holiday.isHoliday(date.plusDays(1)));  // Day after

        // Independence Day on a weekend
        LocalDate satDate = LocalDate.of(2024, 7, 6);
        assertFalse(Holiday.isHoliday(satDate.minusDays(1)));  // Observed on Friday
        LocalDate sunDate = LocalDate.of(2024, 7, 5);
        assertFalse(Holiday.isHoliday(sunDate.plusDays(1)));  // Observed on Monday
    }

    @Test
    void testLaborDay() {
        LocalDate date = LocalDate.of(2024, 9, 2);  // First Monday in September
        assertTrue(Holiday.isHoliday(date));  // Labor Day
        assertFalse(Holiday.isHoliday(date.minusDays(1)));  // Day before
        assertFalse(Holiday.isHoliday(date.plusDays(1)));  // Day after
    }
}