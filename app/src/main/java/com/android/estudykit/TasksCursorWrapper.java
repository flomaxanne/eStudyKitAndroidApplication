package com.android.estudykit;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.android.estudykit.db.Database;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/24/2017.
 */

public class TasksCursorWrapper extends CursorWrapper {

    public TasksCursorWrapper (Cursor cursor) {
        super(cursor);
    }


    public Task getTask() {
        String uuidString = getString(getColumnIndex(Database.TaskTable.Cols.UUID));
        String code = getString(getColumnIndex(Database.TaskTable.Cols.CODE));
        String title = getString(getColumnIndex(Database.TaskTable.Cols.TITLE));
        String type = getString(getColumnIndex(Database.TaskTable.Cols.TYPE));
        long date = getLong(getColumnIndex(Database.TaskTable.Cols.DATE));
        int isCompleted= getInt(getColumnIndex(Database.TaskTable.Cols.COMPLETED));

        Task task = new Task(UUID.fromString(uuidString));
        task.setCode(code);
        task.setTitle(title);
        task.setType(type);
        task.setDate(new Date(date));
        task.setCompleted(isCompleted != 0);


        return  task;
    }
}
