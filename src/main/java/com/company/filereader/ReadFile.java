package com.company.filereader;

import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.*;
import static tech.tablesaw.api.ColumnType.*;


public class ReadFile {

    public ReadFile() {
    }

    private Table tableDax;


    /* method to read in csv  */

    public void ReadCsv() throws Exception {

        /* csv in order: Date, Minutes, Open, High, Low, Close, Volume.  */

        ColumnType[] types = {LOCAL_DATE, SKIP, FLOAT, FLOAT, FLOAT, FLOAT, SKIP};

        CsvReadOptions.Builder builder =
                CsvReadOptions.builder("/Users/wiebehb/Documents/dax/dax-1m.csv")
                        .separator(';')
                        .header(false)
                        .dateFormat("dd/MM/yyyy")
                        .columnTypes(types);

        CsvReadOptions options = builder.build();

        tableDax = Table.read().usingOptions(options);


        //System.out.println(tableDax);
    }

    public Table getTableDax() {
        return tableDax;
    }
}
