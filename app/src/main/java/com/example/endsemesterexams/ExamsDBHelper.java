package com.example.endsemesterexams;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExamsDBHelper extends SQLiteOpenHelper {
    public ExamsDBHelper(Context context) {
        super(context, "Schools.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("Create Table Schools (FirstName TEXT, LastName TEXT, IDNo TEXT primary key, School TEXT, SchoolCode TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int NewVersion) {
        DB.execSQL("drop Table if exists Schools");
    }

    //crud operations
    public Boolean insertSchoolData(String FirstName, String LastName, String IDNo, String School, String SchoolCode ) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first", FirstName);
        contentValues.put("last", LastName);
        contentValues.put("id", IDNo);
        contentValues.put("school", School);
        contentValues.put("SchoolCode", SchoolCode);

        long result = DB.insert("Schools", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Schools", null);
        return cursor;
    }
}
