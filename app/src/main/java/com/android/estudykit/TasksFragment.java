package com.android.estudykit;

import android.app.*;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/22/2017.
 */

public class TasksFragment extends Fragment{

    private static final String ARG_TASK_ID = "task_id";
    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE =0;

    private Task tTask;
    private EditText tCodeText;
    private EditText tTitleText;
    private EditText tTypeText;
    private Button tDateButton;
    private CheckBox tCompletedCheckBox;
    private Button tDeleteButton;
    private Button tSaveButton;


    public static TasksFragment newInstance (UUID taskId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK_ID,taskId);

        TasksFragment fragment = new TasksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID taskId = (UUID) getArguments().getSerializable(ARG_TASK_ID);
        tTask = TasksInfo.get(getActivity()).getTask(taskId);

    }


    @Override

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tasks,container,false);

        tDeleteButton = (Button)v.findViewById(R.id.task_delete);
        tDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UUID taskId = (UUID) getArguments().getSerializable(ARG_TASK_ID);
                TasksInfo tasksInfo = TasksInfo.get(getActivity());
                tTask = tasksInfo.getTask(taskId);
                tasksInfo.deleteTask(tTask);
                getActivity().finish();
            }
        });


        tSaveButton = (Button)v.findViewById(R.id.task_save);
        tSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TasksInfo.get(getActivity())
                        .updateTask(tTask);
                getActivity().finish();
            }
        });




        tCodeText = (EditText)v.findViewById(R.id.tasks_code);
        tCodeText.setText(tTask.getCode());
        tCodeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tTask.setCode(s.toString());

                if(s.toString().trim().length()==0){
                    tCodeText.setError("The Code is required!");
                    tSaveButton.setEnabled(false);
                } else {
                    tSaveButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        tTitleText = (EditText)v.findViewById(R.id.tasks_title);
        tTitleText.setText(tTask.getTitle());
        tTitleText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tTask.setTitle(s.toString());
                if(s.toString().trim().length()==0){
                    tTitleText.setError("The Title is required!");
                    tSaveButton.setEnabled(false);
                } else {
                    tSaveButton.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tTypeText = (EditText)v.findViewById(R.id.tasks_type);
        tTypeText.setText(tTask.getType());
        tTypeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tTask.setType(s.toString());

                if(s.toString().trim().length()==0){
                    tTypeText.setError("The Type is required!");
                   tSaveButton.setEnabled(false);
                } else {
                    tSaveButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        tDateButton = (Button) v.findViewById(R.id.tasks_date);
        updateDate();
        tDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(tTask.getDate());
                dialog.setTargetFragment(TasksFragment.this,REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });



        tCompletedCheckBox = (CheckBox)v.findViewById(R.id.tasks_completed);
        tCompletedCheckBox.setChecked(tTask.isCompleted());
        tCompletedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tTask.setCompleted(isChecked); //set the completed property

            }
        });

        return v;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
        tTask.setDate(date);
        updateDate();
    }

    private void updateDate() {
        tDateButton.setText(tTask.getDate().toString());
    }

}
