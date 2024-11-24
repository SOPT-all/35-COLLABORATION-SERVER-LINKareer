package sopt35.linkareer.global.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeCalculator {
    public static long BETWEEN(final LocalDateTime startDate, final LocalDateTime endDate) {
        return ChronoUnit.HOURS.between(startDate, endDate);
    }
}
