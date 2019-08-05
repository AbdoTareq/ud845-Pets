package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "shelter.db";

    // Create a String that contains the SQL statement to create the pets table
    public static final String SQL_CREATE_PETS_TABLE = "CREATE TABLE "
            + PetEntry.TABLE_NAME + " ("
            + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
            + PetEntry.COLUMN_PET_BREED + " TEXT, "
            + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
            + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE "
            + " IF EXISTS "
            + PetEntry.TABLE_NAME + ";";


    public PetDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.v(LOG_TAG,SQL_CREATE_PETS_TABLE);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
