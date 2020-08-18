package com.company.analysis;

import com.company.filereader.ReadFile;


public class Analysis {

    public void GetDates() throws Exception {
        ReadFile r = new ReadFile();
        System.out.println(r.table_dax);
    }
}
