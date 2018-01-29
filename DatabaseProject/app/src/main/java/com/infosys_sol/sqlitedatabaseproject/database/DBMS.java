package com.infosys_sol.sqlitedatabaseproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mac on 29/01/2018.
 */

public class DBMS extends SQLiteOpenHelper {

    public Context mContext;
    public static String DATABASE_NAME = "UserDatabase.db";
    public static int DATABASE_VERSION = 1;

    public String createTableQeuery =
            "CREATE TABLE user_detail_tbl( `user_r_num` INT ,  `user_name` TEXT ,  `user_fname` TEXT  ,  `user_phone` TEXT ,  `user_address` TEXT);";

    public DBMS(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(createTableQeuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       // forget about it for now!
    }
}
