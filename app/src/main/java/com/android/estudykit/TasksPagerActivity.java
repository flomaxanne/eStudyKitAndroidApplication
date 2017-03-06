package com.android.estudykit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/24/2017.
 */

public class TasksPagerActivity extends FragmentActivity {

    private static final String EXTRA_TASK_ID = "com.android.estudykit.crime_id";
    private ViewPager tViewPager;
    private List<Task> tTasks;


    public static Intent newIntent(Context packageContext, UUID taskId) {
        Intent intent = new Intent(packageContext, TasksPagerActivity.class);
        intent.putExtra(EXTRA_TASK_ID,taskId);
        return intent;
    }

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tasks_pager);

    UUID taskId = (UUID) getIntent().getSerializableExtra(EXTRA_TASK_ID);



    tViewPager = (ViewPager) findViewById(R.id.activity_tasks_pager);

    tTasks = TasksInfo.get(this).getTasks();
    FragmentManager fragmentManager = getSupportFragmentManager();
    tViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
        @Override
        public Fragment getItem(int position) {
            Task task = tTasks.get(position);
            return TasksFragment.newInstance(task.getId());
        }

        @Override
        public int getCount() {
            return tTasks.size();
        }
    });

    for (int i=0;i<tTasks.size();i++) {
        if (tTasks.get(i).getId().equals(taskId)) {
            tViewPager.setCurrentItem(i);
            break;
        }
    }

}

}
