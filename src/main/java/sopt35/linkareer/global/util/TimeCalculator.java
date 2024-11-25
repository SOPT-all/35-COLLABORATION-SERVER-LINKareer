package sopt35.linkareer.global.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeCalculator {
    private final static long TIME_OVER_CRITERIA = 0L;

    private final static String BEFORE_FORMAT = " 전";
    private final static String SECOND_FORMAT = "초";
    private final static String MINUTE_FORMAT = "분";
    private final static String HOUR_FORMAT = "시간";
    private final static String DAY_FORMAT = "일";
    private final static String MONTH_FORMAT = "달";
    private final static String YEAR_FORMAT = "년";

    private static boolean isAfterOneSecond(final long second) {
        return second > TIME_OVER_CRITERIA;
    }

    private static boolean isAfterOneMinute(final long minute) {
        return minute > TIME_OVER_CRITERIA;
    }

    private static boolean isAfterOneHour(final long hour) {
        return hour > TIME_OVER_CRITERIA;
    }

    private static boolean isAfterOneDay(final long day) {
        return day > TIME_OVER_CRITERIA;
    }

    private static boolean isAfterOneMonth(final long month) {
        return month > TIME_OVER_CRITERIA;
    }

    private static boolean isAfterOneYear(final long year) {
        return year > TIME_OVER_CRITERIA;
    }

    public static String calculateTimeInterval(final LocalDateTime startDate, final LocalDateTime endDate) {
        StringBuilder sb = new StringBuilder();

        if (isAfterOneYear(ChronoUnit.YEARS.between(startDate, endDate))) {
            // 년도
            sb.append(ChronoUnit.YEARS.between(startDate, endDate)).append(YEAR_FORMAT);
        } else if (isAfterOneMonth(ChronoUnit.MONTHS.between(startDate, endDate))) {
            // 월
            sb.append(ChronoUnit.MONTHS.between(startDate, endDate)).append(MONTH_FORMAT);
        } else if (isAfterOneDay(ChronoUnit.DAYS.between(startDate, endDate))) {
            // 일
            sb.append(ChronoUnit.DAYS.between(startDate, endDate)).append(DAY_FORMAT);
        } else if (isAfterOneHour(ChronoUnit.DAYS.between(startDate, endDate))) {
            // 시간
            sb.append(ChronoUnit.HOURS.between(startDate, endDate)).append(HOUR_FORMAT);
        } else if (isAfterOneMinute(ChronoUnit.DAYS.between(startDate, endDate))) {
            // 분
            sb.append(ChronoUnit.MINUTES.between(startDate, endDate)).append(MINUTE_FORMAT);
        } else if (isAfterOneSecond(ChronoUnit.DAYS.between(startDate, endDate))) {
            // 초
            sb.append(ChronoUnit.SECONDS.between(startDate, endDate)).append(SECOND_FORMAT);
        }

        return sb.append(BEFORE_FORMAT).toString();
    }
}
