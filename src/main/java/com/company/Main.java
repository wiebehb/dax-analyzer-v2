package com.company;

import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.*;


public class Main {
    public static void main(String args[]) throws Exception{

        CsvReadOptions.Builder builder =
                CsvReadOptions.builder("/Users/wiebehb/Documents/dax/dax-1m.csv")
                        .separator(';')
                        .header(false);

        CsvReadOptions options = builder.build();


        Table t1 = Table.read().usingOptions(options);

        System.out.println(t1.print());

    }
}
