package com.example.cz2006kachingx;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler_profile extends SQLiteOpenHelper {
    //DB info
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "appdata.db";
    public static final String TABLE_NAME_prof = "Userdata";
    public static final String Fav_Code = "Favorite_code";
    public static final String Fav_1 = "Favorite_1";
    public static final String Fav_2 = "Favorite_2";
    public static final String Fav_3 = "Favorite_3";
    public DBHandler_profile(Context context, String Name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME_prof + "(" + Fav_Code + " INTEGER PRIMARY KEY, " + Fav_1 + " TEXT, " + Fav_2 + " TEXT, " + Fav_3 + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){}

    public void addcolumn(int favoritecode, String fav_1, String fav_2, String fav_3){
        ContentValues values = new ContentValues();
        values.put(Fav_Code, favoritecode);
        values.put(Fav_1, fav_1);
        values.put(Fav_2, fav_2);
        values.put(Fav_3, fav_3);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME_prof, null, values);
        db.close();
    }

    public userdata findcolumn(int favoritecode) {
        String query = "Select * FROM " + TABLE_NAME_prof + " WHERE " + Fav_Code + " = " + String.valueOf(favoritecode);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        userdata temp = new userdata();
        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            temp.setfav1(cursor.getString(0));
            temp.setfav2(cursor.getString(1));
            temp.setfav2(cursor.getString(2));
        }
        db.close();
        return temp;
    }

    public boolean deletecol(int favoritecode) {
        boolean result = false;
        String query = "Select * FROM " + TABLE_NAME_prof + " WHERE " + Fav_Code + " = " + String.valueOf(favoritecode);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            db.delete(TABLE_NAME_prof, Fav_Code + "=?", new String[] {
                    String.valueOf(favoritecode)
            });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
}
    }
