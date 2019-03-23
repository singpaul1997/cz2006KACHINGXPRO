package com.example.cz2006kachingx;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;

public class DBHandler extends SQLiteOpenHelper {
    //DB info
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "exchange.db";
    public static final String TABLE_NAME = "CurrencyExchanges";
    public static final String COLUMN_CODE = "ExchangeUniqueID";
    public static final String COLUMN_NAME = "ExchangeName";
    public static final String COLUMN_ADDRESS = "ExchangeAddr";
    public static final String COLUMN_RATE = "RATE";
    public static final String COLUMN_CONTACT = "Contact";
    public DBHandler(Context context, String Name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_CODE + " INTEGER PRIMARY KEY, " + COLUMN_NAME + " TEXT, " + COLUMN_ADDRESS + " TEXT, " + COLUMN_RATE + " TEXT, " + COLUMN_CONTACT + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){}

    public void addcolumn(int exchange_code, String exchange_name, String exchange_addr, String exchange_rate, String exchange_contact){
        ContentValues values = new ContentValues();
        values.put(COLUMN_CODE, exchange_code);
        values.put(COLUMN_NAME, exchange_name);
        values.put(COLUMN_ADDRESS, exchange_addr);
        values.put(COLUMN_RATE, exchange_rate);
        values.put(COLUMN_CONTACT, exchange_contact);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public CurrencyExchange findcolumn(int exchange_code) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_CODE + " = " + String.valueOf(exchange_code);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        CurrencyExchange Exchange = new CurrencyExchange();
        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            Exchange.setcode(Integer.parseInt(cursor.getString(0)));
            Exchange.setname(cursor.getString(1));
            Exchange.setaddr(cursor.getString(2));
            Exchange.setrate(cursor.getString(3));
            Exchange.setcontact(cursor.getString(4));
        } else {
            Exchange = null;
        }
        db.close();
        return Exchange;
    }

    public boolean deletecol(int exchange_code) {
        boolean result = false;
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_CODE + " = " + String.valueOf(exchange_code);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            db.delete(TABLE_NAME, COLUMN_CODE + "=?", new String[] {
                    String.valueOf(exchange_code)
            });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
}
    }
