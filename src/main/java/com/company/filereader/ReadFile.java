package com.company.filereader;

import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.*;
import tech.tablesaw.selection.Selection;
import java.time.*;
import static tech.tablesaw.api.ColumnType.*;


public class ReadFile {

    private Table tableDax;


    public void ReadCsv() throws Exception {

        /* csv in order: Date, Minutes, Open, High, Low, Close, Volume.  */

        ColumnType[] types = {LOCAL_DATE, SKIP, SKIP, FLOAT, FLOAT, SKIP, SKIP};

        CsvReadOptions.Builder builder =
                CsvReadOptions.builder("/Users/wiebehb/Documents/dax/dax-1m.csv")
                        .separator(';')
                        .header(false)
                        .dateFormat("dd/MM/yyyy")
                        .columnTypes(types);

        CsvReadOptions options = builder.build();

        this.tableDax = Table.read().usingOptions(options);


        //System.out.println(tableDax);




        LocalDate date1 = LocalDate.of(2020, 1, 14);
        LocalDate date2 = LocalDate.of(2020, 1, 16);

        Table filtered = tableDax.where(
                tableDax.dateColumn("C0").isBetweenIncluding(date1, date2)
                        .and(tableDax.numberColumn("C4").isGreaterThan(13000)));

        //System.out.println(filtered);



    }

    public Table getDaxData() {
        return this.tableDax;
    }
}
