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
import java.util.Arrays;
import java.util.Collections;

import static tech.tablesaw.api.ColumnType.*;
import static tech.tablesaw.aggregate.AggregateFunctions.*;


public class Analysis {

    private LocalDate beginDate;
    private LocalDate endDate;


    public Analysis(LocalDate date1, LocalDate date2) {
        this.beginDate = date1; // start date
        this.endDate = date2; // end date
    }


    public void GetDates() throws Exception {

        /* read in csv */
        ReadFile r = new ReadFile();
        r.ReadCsv();


        /* select dax data within selected time frame */
        Table daxTimeFiltered = r.getTableDax().where(
                r.getTableDax().dateColumn("C0").isBetweenIncluding(this.beginDate, this.endDate));


        /* select columns: Open, High, Low, Close */
        Table tableDaxHighLow = daxTimeFiltered.summarize("C3", "C4", min, max)
                .by(daxTimeFiltered.dateColumn("C0"));

        //System.out.println(summary);


        /* new Table with date, min and max */
        Table tableDaxDayMinMax = Table.create("tableDaxMinMax");


        for (Row row : tableDaxHighLow) {
            Double daxDayMin = row.getDouble("Min [C4]");
            Double daxDayMax = row.getDouble("Max [C3]");

            System.out.println(row.getDate("C0") + " min " + daxDayMin
                    + " max " + daxDayMax);
        }




        // add min and max to new column table

        // save to csv

        //tableDaxMinMax.write().csv("filename.csv");








        //System.out.println(summary);


    }
}
