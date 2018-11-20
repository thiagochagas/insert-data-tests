package com.project.example.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExampleVO implements Serializable {

    private static final long serialVersionUID = -223279330582992930L;

    private LocalDate holidayDay;
    private LocalDate nextBusinessDay;

    public ExampleVO(String pattern, String holidayDay, String nextBusinessDay) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        this.holidayDay = LocalDate.parse(holidayDay, dateTimeFormatter);
        this.nextBusinessDay = LocalDate.parse(nextBusinessDay, dateTimeFormatter);
    }

    public LocalDate getHolidayDay() {
        return holidayDay;
    }

    public LocalDate getNextBusinessDay() {
        return nextBusinessDay;
    }
}
