package com.company.analysis;

import com.company.filereader.ReadFile;
import tech.tablesaw.aggregate.Summarizer;
import tech.tablesaw.api.Table;
import java.time.LocalDate;
import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.*;
import tech.tablesaw.selection.Selection;
import java.time.*;
import static tech.tablesaw.api.ColumnType.*;
import static tech.tablesaw.aggregate.AggregateFunctions.*;


public class Analysis {

    private LocalDate beginDate;
    private LocalDate endDate;


    public Analysis(LocalDate date1, LocalDate date2) {
        this.beginDate = date1;
        this.endDate = date2;
    }


    public void GetDates() throws Exception {

        /* read in csv */
        ReadFile r = new ReadFile();
        r.ReadCsv();



        Table filtered = r.getTableDax().where(
                r.getTableDax().dateColumn("C0").isBetweenIncluding(this.beginDate, this.endDate)
                        .and(r.getTableDax().numberColumn("C4").isGreaterThan(13000)));

        System.out.println(filtered);
    }
}
