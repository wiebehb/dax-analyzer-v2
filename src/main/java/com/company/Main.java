package com.company;

import com.company.analysis.*;
import java.time.LocalDate;


public class Main {
    public static void main(String args[]) throws Exception{


        /* enter desired dates */

        LocalDate date1 = LocalDate.of(2020, 1, 14); // start date
        LocalDate date2 = LocalDate.of(2020, 1, 19); // end date

        Analysis a = new Analysis(date1, date2);
        a.GetDates();
    }
}
