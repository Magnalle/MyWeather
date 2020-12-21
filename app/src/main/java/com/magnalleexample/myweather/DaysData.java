package com.magnalleexample.myweather;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DaysData {
    int temperature;
    long day;

    public DaysData(int temperature, long day) {
        this.temperature = temperature;
        this.day = day;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getWeekday(){
        return new SimpleDateFormat("EEEE", Locale.getDefault()).format(day);
    }
}
