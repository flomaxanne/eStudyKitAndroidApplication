package com.android.estudykit;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.android.estudykit.db.Database;

import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/24/2017.
 */

public class SubjectsCursorWrapper extends CursorWrapper {

    public SubjectsCursorWrapper (Cursor cursor) {
        super(cursor);
    }


    public Subject getSubject() {
        String uuidString = getString(getColumnIndex(Database.SubjectTable.SubCols.UUID));
        String code = getString(getColumnIndex(Database.SubjectTable.SubCols.CODE));
        String title = getString(getColumnIndex(Database.SubjectTable.SubCols.TITLE));

        String day1 = getString(getColumnIndex(Database.SubjectTable.SubCols.DAY1));
        String day2 = getString(getColumnIndex(Database.SubjectTable.SubCols.DAY2));
        String day3 = getString(getColumnIndex(Database.SubjectTable.SubCols.DAY3));

        String time1start =getString(getColumnIndex(Database.SubjectTable.SubCols.TIME1START));
        String time1end =getString(getColumnIndex(Database.SubjectTable.SubCols.TIME1END));


        String time2start =getString(getColumnIndex(Database.SubjectTable.SubCols.TIME2START));
        String time2end =getString(getColumnIndex(Database.SubjectTable.SubCols.TIME2END));


        String time3start =getString(getColumnIndex(Database.SubjectTable.SubCols.TIME3START));
        String time3end =getString(getColumnIndex(Database.SubjectTable.SubCols.TIME3END));


        String location1 = getString(getColumnIndex(Database.SubjectTable.SubCols.LOCATION1));
        String location2 = getString(getColumnIndex(Database.SubjectTable.SubCols.LOCATION2));
        String location3 = getString(getColumnIndex(Database.SubjectTable.SubCols.LOCATION3));

        String lecturer = getString(getColumnIndex(Database.SubjectTable.SubCols.LECTURER));

        Subject subject = new Subject(UUID.fromString(uuidString));
        subject.setCode(code);
        subject.setTitle(title);
        subject.setDay1(day1);
        subject.setDay2(day2);
        subject.setDay3(day3);

        subject.setTime1start(time1start);
        subject.setTime1end(time1end);

        subject.setTime2start(time2start);
        subject.setTime2end(time2end);

        subject.setTime3start(time3start);
        subject.setTime3end(time3end);


        subject.setLocation1(location1);
        subject.setLocation2(location2);
        subject.setLocation3(location3);


        subject.setLecturer(lecturer);

        return subject;
    }
}
