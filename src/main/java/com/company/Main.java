package com.company;

import com.company.filereader.*;
import com.company.analysis.*;


public class Main {
    public static void main(String args[]) throws Exception{

        ReadFile r = new ReadFile();
        r.ReadCsv();

        Analysis a = new Analysis();
        a.GetDates();

    }
}
