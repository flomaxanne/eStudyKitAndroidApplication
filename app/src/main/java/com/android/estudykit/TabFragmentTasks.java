package com.android.estudykit;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Florence A. Pereira on 2/19/2017.
 */

public class TabFragmentTasks extends Fragment {

    private RecyclerView tTasksRecyclerView;
    private TaskAdapter tAdapter;
    public FloatingActionButton fab;


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

}

    @Override

    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks_list, container, false);


         tTasksRecyclerView = (RecyclerView)view.findViewById(R.id.tasks_recycler_view);
        tTasksRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        fab = (FloatingActionButton)view.findViewById(R.id.fabtask);
        fab.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Task task = new Task();
                                       TasksInfo.get(getActivity()).addTasks(task);
                                       Intent intent = TasksPagerActivity.newIntent(getActivity(), task.getId());
                                       startActivity(intent);
                                   }
                               });


        updateUI();
        return view;

    }




    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }




    private void updateUI() {
        TasksInfo tasksInfo = TasksInfo.get(getActivity());
        List<Task> tasks = tasksInfo.getTasks();

        if (tAdapter == null) {
            tAdapter = new TaskAdapter(tasks);
            tTasksRecyclerView.setAdapter(tAdapter);
        }
        else {
            tAdapter.setTasks(tasks);
            tAdapter.notifyDataSetChanged();
        }

    }


    private class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Task tTask;
        private TextView tCodeTextView;
        private TextView tTitleTextView;
        private TextView tTypeTextView;
        private TextView tDateTextView;
        private CheckBox tCompletedCheckBox;

        public TaskHolder (View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            tCodeTextView = (TextView) itemView.findViewById(R.id.list_item_tasks_code_textview);
            tTitleTextView = (TextView) itemView.findViewById(R.id.list_item_tasks_title_textview);
            tTypeTextView = (TextView) itemView.findViewById(R.id.list_item_tasks_type_textview);
            tDateTextView = (TextView) itemView.findViewById(R.id.list_item_tasks_date_textview);
            tCompletedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_tasks_completed_checkbox);


        }

        public void bindTask(Task task) {
            tTask = task;
            tCodeTextView.setText(tTask.getCode());
            tTitleTextView.setText(tTask.getTitle());
            tTypeTextView.setText(tTask.getType());
            tDateTextView.setText(tTask.getDate().toString());
            tCompletedCheckBox.setChecked(tTask.isCompleted());

            if (tTask.isCompleted()) {
                tTitleTextView.setPaintFlags(tTitleTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                tTypeTextView.setPaintFlags(tTypeTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                tDateTextView.setPaintFlags(tDateTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);




            }
            else {
                tTitleTextView.setPaintFlags(tTitleTextView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                tTypeTextView.setPaintFlags(tTypeTextView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                tDateTextView.setPaintFlags(tDateTextView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));

            }

        }


        @Override
        public void onClick(View v) {
           Intent intent = TasksPagerActivity.newIntent(getActivity(), tTask.getId());
            startActivity(intent);
        }
    }


    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {

        private List<Task> tTasks;

        public TaskAdapter(List<Task> tasks) {
            tTasks = tasks;
        }


        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            View view = layoutInflater.inflate(R.layout.list_item_tasks, parent, false);
            return new TaskHolder(view);
        }

        @Override
        public void onBindViewHolder(TaskHolder holder, int postion) {
            Task task = tTasks.get(postion);
            holder.bindTask(task);
        }

        @Override
        public int getItemCount() {
            return tTasks.size();
        }

        public void setTasks(List<Task> tasks) {
            tTasks = tasks;
        }
    }







}
