package com.android.estudykit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/22/2017.
 */

public class TasksActivity extends TasksFragmentActivity {

    private static final String EXTRA_TASK_ID = "com.android.estudykit.task_id";

    public static Intent newIntent (Context packageContext, UUID taskId) {
        Intent intent = new Intent(packageContext, TasksActivity.class);
        intent.putExtra(EXTRA_TASK_ID, taskId);
        return intent;

    }


    @Override
    protected Fragment createFragment() {
        UUID taskId = (UUID) getIntent().getSerializableExtra(EXTRA_TASK_ID);
        return TasksFragment.newInstance(taskId);
    }

}

