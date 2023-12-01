package com.example.myapplication12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "product.db";
    private static String TABLE_NAME = "productTable";
    private static String COLUMN_ID = "_id";
    private static String COLUMN_PRODUCT_NAME = "productName";
    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String query = "CREATE TABLE "+TABLE_NAME+ " ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT "+", "+COLUMN_PRODUCT_NAME+" TEXT);";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
        onCreate(sqLiteDatabase);
    }

    public void addProduct(Product product){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PRODUCT_NAME, product.get_productName());

        SQLiteDatabase sqLiteDatabase = getWritableDatabase(); // make a connection to the database...

        sqLiteDatabase.insert(TABLE_NAME,null, contentValues);
        sqLiteDatabase.close();
    }

    public void deleteProduct(String productName){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.rawQuery("DELETE FROM "+TABLE_NAME+" WHERE "+COLUMN_PRODUCT_NAME+"= '"+productName+"';", null);
        sqLiteDatabase.close();

    }

    public String databaseToString(){
        String query = "SELECT * FROM "+TABLE_NAME+";";
        String result = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor resSet = sqLiteDatabase.rawQuery(query, null);
        while(resSet.moveToNext()){
            if(resSet.getColumnIndex(COLUMN_PRODUCT_NAME) >= 0){
                result += resSet.getString(resSet.getColumnIndexOrThrow(COLUMN_PRODUCT_NAME));
                result += "\n";
            }
        }
        sqLiteDatabase.close();

        return result;
    }
}
