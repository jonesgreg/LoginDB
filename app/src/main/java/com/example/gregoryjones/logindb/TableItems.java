package com.example.gregoryjones.logindb;

/**
 * Created by gregoryjones on 4/10/17.
 */

public class TableItems {

    public static final String TABLE_NAME= "login";
    public static final String  COL_ID = "sequence_number";
    public static final String COL_NAME = "USERNAME";
    public static final String COL_PWD = "PASSWORD";

    public static final String DB_NAME_FULL = "loginDB.db";
    public static final String[] ALL_COL ={COL_ID,COL_NAME,COL_PWD};


    public static final String SQL_CREATE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NAME + " TEXT NOT NULL,"
            + COL_PWD +  " TEXT NOT NULL" +");";


    public static final String SQL_DELETE = "DROP TABLE " + DB_NAME_FULL + "."+ TABLE_NAME + ";";

    public static final  String SQL_INSERT = "INSERT INTO " + TABLE_NAME + "("
            + COL_NAME + ", " + COL_PWD + ") ";


}
