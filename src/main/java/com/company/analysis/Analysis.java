package com.company.analysis;

import com.company.filereader.ReadFile;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import tech.tablesaw.aggregate.Summarizer;
import tech.tablesaw.api.Table;
import java.time.LocalDate;
import tech.tablesaw.api.*;
import tech.tablesaw.columns.Column;
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
                r.getTableDax().dateColumn("C0").isBetweenIncluding(this.beginDate, this.endDate));


        Table summary = filtered.summarize("C2", "C3", "C4", "C5", min, max)
                .by(filtered.dateColumn("C0"));


        Column<?> three = summary.column("C2");


        System.out.println(three);


    }
}
