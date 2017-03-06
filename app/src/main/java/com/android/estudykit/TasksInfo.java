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

public class TasksInfo extends AppCompatActivity {
    private static TasksInfo sTasksInfo;

    private Context tContext;
    private SQLiteDatabase tDatabase;


    public static TasksInfo get(Context context) {
        if (sTasksInfo == null) {
            sTasksInfo = new TasksInfo(context);
        }
        return sTasksInfo;
    }

    private TasksInfo(Context context) {
        tContext =  context.getApplicationContext();
        tDatabase = new DatabaseHelper(tContext).getWritableDatabase();



    }

    public void addTasks(Task t) {
     ContentValues values = getContentValues(t);
        tDatabase.insert(Database.TaskTable.NAME,null,values);
    }

    public List<Task> getTasks() {
     List<Task> tasks = new ArrayList<>();

        TasksCursorWrapper cursor = queryTasks(null,null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                tasks.add(cursor.getTask());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        } return tasks;
    }

    public Task getTask(UUID id) {
        TasksCursorWrapper cursor = queryTasks(
            Database.TaskTable.Cols.UUID + " = ?",
            new String[]{
                    id.toString()
            }
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getTask();
        } finally {
            cursor.close();
        }
    }

    public void updateTask(Task task) {
        String uuidString = task.getId().toString();
        ContentValues values = getContentValues(task);
        tDatabase.update(Database.TaskTable.NAME, values,
                Database.TaskTable.Cols.UUID + " = ?",
                new String[] { uuidString });
    }

    public void deleteTask(Task task)
    {
        String uuidString = task.getId().toString();
        tDatabase.delete(Database.TaskTable.NAME,
                Database.TaskTable.Cols.UUID + " = ?", new String[] {uuidString});
    }



    private static ContentValues getContentValues(Task task) {
        ContentValues values = new ContentValues();
        values.put(Database.TaskTable.Cols.UUID, task.getId().toString());
        values.put(Database.TaskTable.Cols.CODE, task.getCode());
        values.put(Database.TaskTable.Cols.TITLE, task.getTitle());
        values.put(Database.TaskTable.Cols.TYPE, task.getType());
        values.put(Database.TaskTable.Cols.DATE, task.getDate().getTime());
        values.put(Database.TaskTable.Cols.COMPLETED,task.isCompleted() ? 1 : 0);

        return values;
    }



    private TasksCursorWrapper queryTasks(String whereClause, String[] whereArgs) {
        Cursor cursor = tDatabase.query(
                Database.TaskTable.NAME,
                null, //columns - null selects all columns
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new TasksCursorWrapper(cursor);
    }

}
