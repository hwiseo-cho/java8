package com.example.java8.date;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAPI {

    public static void main(String[] args) {
        // 기존
        Date date = new Date();
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println(date);
        System.out.println(date.getTime());

        // java8
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 GMT, UTC

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        // 서버 위치의 시간임
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime birthday = LocalDateTime.of(1998, Month.JULY, 16, 0, 0, 0);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        LocalDate localDate = LocalDate.now();
        LocalDate thisYear = LocalDate.of(2024, Month.JULY, 16);

        Period period = Period.between(localDate, thisYear);
        System.out.println(period.getDays());
        System.out.println(period.get(ChronoUnit.DAYS));
        Period until = localDate.until(thisYear);
        System.out.println(until.getDays());

        // 머신용
        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println(between.getSeconds());

        // format
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(dateTime.format(dateTimeFormatter));

        // parse
        LocalDate parse = LocalDate.parse("1998-07-16", dateTimeFormatter);
        System.out.println(parse);
    }
}
