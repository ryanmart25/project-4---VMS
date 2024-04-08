package com.group4.vms;

import java.util.Optional;
import java.util.TimeZone;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class TimeDuration { // Represents the period of time an event lasts for.

    private TimeZone timezone;
    private int starthours;
    private int startminutes;
    private int startseconds;
    private int endhours;
    private int endminutes;
    private int endseconds;
    private Optional<String> format; // 24-hour 12-hour


    public TimeDuration(TimeZone timeZone, int starthours, int startminutes, int startseconds, int endhours,
            int endminutes, int endseconds) {
        this.endhours = endhours;
        this.starthours = starthours;
        this.startminutes = startminutes;
        this.startseconds = startseconds;

        this.endminutes = endminutes;
        this.endseconds = endseconds;
    }
}
