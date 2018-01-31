package com.infosys_sol.sqlitedatabaseproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

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

    // onCreate will only be checked once in the app lifecycle
//    if there is no database structure present already with the name given
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableQeuery);
        Log.e("ONCREATE", "yes table bn geya");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // forget about it for now!
    }

    public void putUserDataInDb(String incomingRNumber,
                                String incomingName,
                                String incomingFName,
                                String incomingPhone,
                                String incomingAddress,
                                SQLiteDatabase db) {
        //content values will help us to put specific data at specific colomn
        ContentValues mcv = new ContentValues();
        mcv.put("user_r_num", incomingRNumber);
        mcv.put("user_name", incomingName);
        mcv.put("user_fname", incomingFName);
        mcv.put("user_phone", incomingPhone);
        mcv.put("user_address", incomingAddress);

        db.insert("user_detail_tbl", null, mcv);
        Log.e("putUserDataInDb", "data is entered");

        //Toast.makeText(mContext, "", Toast.LENGTH_SHORT).show();
    }


    public Cursor getDataFromDatabase(SQLiteDatabase readbAbleDb) {

// way 2nd
    Cursor tobeReturnedCursor = readbAbleDb.rawQuery("Select * From user_detail_tbl ",null);

    return  tobeReturnedCursor;
    }

//way 1st

//    public Cursor getDataFromDatabase(SQLiteDatabase db) {
//
//        String[] selectionArgs  = {
//                "user_r_num",
//                "user_name",
//                "user_fname",
//                "user_phone",
//                "user_address",
//        };
//
//        //"SELECT * FROM user_detail_tbl"
//        Cursor fullDataCursor = db.query("user_detail_tbl",
//                selectionArgs,
//                null,
//                null,
//                null,
//                null,
//                null);
//
//        return fullDataCursor;
//    }
}
