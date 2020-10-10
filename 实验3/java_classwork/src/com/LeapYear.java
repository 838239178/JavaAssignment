package com;

import java.time.Year;

public class LeapYear {
    public boolean isLeapYear(int year){
        return Year.isLeap(year);
    }
}
