package com.android.estudykit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import com.android.estudykit.db.Database;
import com.android.estudykit.db.DatabaseHelper;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/22/2017.
 */

public class SubjectsInfo extends AppCompatActivity {
    private static SubjectsInfo sSubjectsInfo;

    private Context mContext;
    private SQLiteDatabase mDatabase;


    public static SubjectsInfo get(Context context) {
        if (sSubjectsInfo == null) {
            sSubjectsInfo = new SubjectsInfo(context);
        }
        return sSubjectsInfo;
    }

    private SubjectsInfo(Context context) {
        mContext =  context.getApplicationContext();
        mDatabase = new DatabaseHelper(mContext).getWritableDatabase();
    }

    public void addSubjects(Subject s) {
        ContentValues values = getContentValues(s);
        mDatabase.insert(Database.SubjectTable.NAME,null,values);
    }


    public List<Subject> getSubjects() {
        List<Subject> subjects = new ArrayList<>();


        SubjectsCursorWrapper cursor = querySubjects(null,null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                subjects.add(cursor.getSubject());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        } return subjects;
    }

    public Subject getSubject(UUID id) {
        SubjectsCursorWrapper cursor = querySubjects(
                Database.SubjectTable.SubCols.UUID + " = ?",
                new String[]{
                        id.toString()
                }
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getSubject();
        } finally {
            cursor.close();
        }
    }

    public void updateSubject(Subject subject) {
        String uuidString = subject.getId().toString();
        ContentValues values = getContentValues(subject);
        mDatabase.update(Database.SubjectTable.NAME, values,
                Database.SubjectTable.SubCols.UUID + " = ?",
                new String[] { uuidString });
    }

    public void deleteSubject(Subject subject)
    {
        String uuidString = subject.getId().toString();
        mDatabase.delete(Database.SubjectTable.NAME,
                Database.SubjectTable.SubCols.UUID + " = ?", new String[] {uuidString});
    }


    private static ContentValues getContentValues(Subject subject) {
        ContentValues values = new ContentValues();
        values.put(Database.SubjectTable.SubCols.UUID, subject.getId().toString());
        values.put(Database.SubjectTable.SubCols.CODE, subject.getCode());
        values.put(Database.SubjectTable.SubCols.TITLE, subject.getTitle());

        values.put(Database.SubjectTable.SubCols.DAY1, subject.getDay1());
        values.put(Database.SubjectTable.SubCols.DAY2, subject.getDay2());
        values.put(Database.SubjectTable.SubCols.DAY3, subject.getDay3());

        values.put(Database.SubjectTable.SubCols.TIME1START, subject.getTime1start());
        values.put(Database.SubjectTable.SubCols.TIME1END, subject.getTime1end());

        values.put(Database.SubjectTable.SubCols.TIME2START, subject.getTime2start());
        values.put(Database.SubjectTable.SubCols.TIME2END,   subject.getTime2end());

        values.put(Database.SubjectTable.SubCols.TIME3START, subject.getTime3start());
        values.put(Database.SubjectTable.SubCols.TIME3END, subject.getTime3end());


        values.put(Database.SubjectTable.SubCols.LOCATION1, subject.getLocation1());
        values.put(Database.SubjectTable.SubCols.LOCATION2, subject.getLocation2());
        values.put(Database.SubjectTable.SubCols.LOCATION3, subject.getLocation3());


        values.put(Database.SubjectTable.SubCols.LECTURER, subject.getLecturer());

        return values;
    }



    private SubjectsCursorWrapper querySubjects(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                Database.SubjectTable.NAME,
                null, //columns - null selects all columns
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new SubjectsCursorWrapper(cursor);
    }

}
