package com.carpark.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {

    public static String convertToSGTTime(LocalDateTime time){

        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
        ZonedDateTime asiaZonedDateTime = time.atZone(singaporeZoneId);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return format.format(asiaZonedDateTime);
    }

    public static LocalDateTime convertStringToTime(String time){
        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
        return LocalDateTime.parse(time).atZone(singaporeZoneId).toLocalDateTime();
    }

}
