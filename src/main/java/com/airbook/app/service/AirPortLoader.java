//package com.airbook.app.service;
//
//import java.io.FileReader;
//import java.sql.DriverManager;
//import org.postgresql.copy.CopyManager;
//import org.postgresql.core.BaseConnection;

//public class AirPortLoader {
    //we cannot insert csv file to supabase after creating a table
    //and we cannot change the primary key from NULL to AUTO-GENERATE!!!!
//    public void loadCsv() throws Exception {
//        DriverManager.getConnection(
//                'jdbc:postgresql://db.mfjcjiuueyfaervwbctb.supabase.co:5432/postgres', 'postgres', 'Airbook304575')
//                .withCloseable(conn -> new CopyManager((BaseConnection) conn)
//            .copyIn('COPY t FROM STDIN', new FileReader('${sqlfile}'))
//    }

//}
