package com.android.estudykit.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.estudykit.db.Database.TaskTable;
import com.android.estudykit.db.Database.SubjectTable;


/**
 * Created by Florence A. Pereira on 2/19/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION =1;
    private static final String DATABASE_NAME = "eStudyKit.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE " + TaskTable.NAME + "(" +
        " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        TaskTable.Cols.UUID + ", " +
        TaskTable.Cols.CODE + "," +
        TaskTable.Cols.TITLE + ", " +
        TaskTable.Cols.TYPE + ", " +
        TaskTable.Cols.DATE + ", " +
        TaskTable.Cols.COMPLETED + ")"
        );


        db.execSQL("CREATE TABLE " + SubjectTable.NAME + "(" +
                " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SubjectTable.SubCols.UUID + ", " +
                SubjectTable.SubCols.CODE + ", " +
                SubjectTable.SubCols.TITLE + ", " +
                SubjectTable.SubCols.DAY1 + ", " +
                SubjectTable.SubCols.DAY2 + ", " +
                SubjectTable.SubCols.DAY3 + ", " +
                SubjectTable.SubCols.TIME1START + ", " +
                SubjectTable.SubCols.TIME1END + ", " +
                SubjectTable.SubCols.TIME2START + ", " +
                SubjectTable.SubCols.TIME2END + ", " +
                SubjectTable.SubCols.TIME3START + ", " +
                SubjectTable.SubCols.TIME3END + ", " +
                SubjectTable.SubCols.LOCATION1 + ", " +
                SubjectTable.SubCols.LOCATION2 + ", " +
                SubjectTable.SubCols.LOCATION3 + ", " +
                SubjectTable.SubCols.LECTURER + ")"
        );



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TaskTable.NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SubjectTable.NAME);
        // create new tables
        onCreate(db);

    }



}

