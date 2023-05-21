package com.example.demo.utils;

import com.example.demo.exceptions.BadRequestException;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class DateUtil {
    public static LocalDateTime parseToRequest(String date) {
        try {
            return LocalDateTime.parse(date);
        } catch (DateTimeParseException dtpEx) {
            throw new BadRequestException("Invalid date format, must be like 2007-12-03T10:15:30");
        }
    }
}
