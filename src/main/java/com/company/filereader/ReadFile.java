package com.company.filereader;

import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.*;
import static tech.tablesaw.api.ColumnType.*;
import javax.swing.JTable;


public class ReadFile {

    public Table table_dax;


    public void ReadCsv() throws Exception {

        /* csv in order: date, minutes, Date, Open, High, Low, Close, Volume.  */

        ColumnType[] types = {LOCAL_DATE, SKIP, SKIP, FLOAT, FLOAT, SKIP, SKIP};

        CsvReadOptions.Builder builder =
                CsvReadOptions.builder("/Users/wiebehb/Documents/dax/dax-1m.csv")
                        .separator(';')
                        .header(false)
                        .dateFormat("dd/MM/yyyy")
                        .columnTypes(types);

        CsvReadOptions options = builder.build();



        Table table_dax = Table.read().usingOptions(options);



        //System.out.println(table_dax);
    }


    public Table getTable_dax() {
        return table_dax;
    }


}
