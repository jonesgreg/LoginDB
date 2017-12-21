package com.example.gregoryjones.logindb;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gregoryjones on 5/1/17.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

        public static final String DB_NAME = "loginDB.db";
        public static final int DB_VERSION = 1;


        public DBOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqlDB) {

            sqlDB.execSQL(TableItems.SQL_CREATE);
            sqlDB.execSQL(TableItems.SQL_INSERT + "values('Alice' , '123');");
            sqlDB.execSQL(TableItems.SQL_INSERT + "values('Mike' , '434');");
            sqlDB.execSQL(TableItems.SQL_INSERT + "values('Greg' , '323');");
            sqlDB.execSQL(TableItems.SQL_INSERT + "values('null' ,  'null');");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqlDB, int i, int i1) {
            sqlDB.execSQL(TableItems.SQL_DELETE);
            onCreate(sqlDB);
        }
    }



