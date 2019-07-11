package org.demo.components;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LocalDateTimeProvider {

    public final static List<String> DAYS_NAMES = Collections.unmodifiableList(new ArrayList<>(
            Arrays.asList(new String[]{"Monday", "Thuesday"})
    ));

    public static void main(String[] args) {

        ZoneId zone;
        LocalDate ld = LocalDate.now();
        LocalDateTime ldt;
        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
        LocalDate ld2 = LocalDate.of(2019, 7, 1);
        ld2 = ld2.plus(10, ChronoUnit.DAYS);
        System.out.println(ld2);
        LocalDate ld3 = LocalDate.of(2019, 10, 1);
        Period per = Period.between(ld2, ld3);
        int days = per.getDays();
        int months = per.getMonths();
        int years = per.getYears();
        System.out.println("Days diff " + days + " months " + months + " years " + years);
        long totalDays = ChronoUnit.DAYS.between(ld2, ld3);
        ChronoUnit.WEEKS.between(ld2, ld3);
        System.out.println("Total days diff " + totalDays);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(ld3.format(df));
        ld.get(ChronoField.DAY_OF_WEEK);
    }
}
