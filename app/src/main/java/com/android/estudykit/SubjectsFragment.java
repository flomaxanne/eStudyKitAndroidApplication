package com.android.estudykit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/24/2017.
 */

public class SubjectsFragment extends Fragment {

    private static final String ARG_SUBJECT_ID = "subject_id";


    private Subject sSubject;
    private EditText sCodeText;
    private EditText sTitleText;

    private EditText sDay1Text;
    private EditText sDay2Text;
    private EditText sDay3Text;

    private Spinner sDay1spinner;
    private Spinner sDay2spinner;
    private Spinner sDay3spinner;

    private EditText sLocation1Text;
    private EditText sLocation2Text;
    private EditText sLocation3Text;

    private EditText sLecturerText;
    private Button deleteButton;
    private Button saveButton;


    private EditText sTime1StartText;
    private EditText sTime1EndText;

    private EditText sTime2StartText;
    private EditText sTime2EndText;

    private EditText sTime3StartText;
    private EditText sTime3EndText;


    private Spinner sTime1startSpinner;
    private Spinner sTime1endSpinner;

    private Spinner sTime2startSpinner;
    private Spinner sTime2endSpinner;

    private Spinner sTime3startSpinner;
    private Spinner sTime3endSpinner;


    ArrayAdapter<String> DayAdapter;
    ArrayAdapter<String> TimeAdapter;


    String [] days ={"Day", "Mon", "Tues", "Wed" , "Thurs", "Fri"};
    String [] time ={"Time", "0800", "0900", "1000" , "1100", "1200" ,
                      "1300", "1400", "1500", "1600", "1700", "1800", "1900" ,
                      "2000" , "2100" };



    public static SubjectsFragment newInstance (UUID subjectId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SUBJECT_ID,subjectId);

        SubjectsFragment fragment = new SubjectsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID subjectId = (UUID) getArguments().getSerializable(ARG_SUBJECT_ID);
        sSubject = SubjectsInfo.get(getActivity()).getSubject(subjectId);

    }
    

    @Override

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_subjects,container,false);

        deleteButton = (Button)v.findViewById(R.id.subject_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UUID subjectId = (UUID) getArguments().getSerializable(ARG_SUBJECT_ID);
                SubjectsInfo subjectsInfo = SubjectsInfo.get(getActivity());
                sSubject = subjectsInfo.getSubject(subjectId);
                subjectsInfo.deleteSubject(sSubject);
                getActivity().finish();
            }
        });


        saveButton = (Button)v.findViewById(R.id.subject_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubjectsInfo.get(getActivity())
                        .updateSubject(sSubject);

                getActivity().finish();
            }
        });






        sDay1Text = (EditText)v.findViewById(R.id.subjects_day1);
        sDay1Text.setText(sSubject.getDay1());
        sDay1Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setDay1(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        sDay2Text = (EditText)v.findViewById(R.id.subjects_day2);
        sDay2Text.setText(sSubject.getDay2());
        sDay2Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setDay2(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sDay3Text = (EditText)v.findViewById(R.id.subjects_day3);
        sDay3Text.setText(sSubject.getDay3());
        sDay3Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setDay3(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        sDay1spinner = (Spinner)v.findViewById(R.id.subjects_day1_spinner);
        sDay2spinner = (Spinner)v.findViewById(R.id.subjects_day2_spinner);
        sDay3spinner = (Spinner)v.findViewById(R.id.subjects_day3_spinner);


        DayAdapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,days);
        DayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDay1spinner.setAdapter(DayAdapter);
        sDay2spinner.setAdapter(DayAdapter);
        sDay3spinner.setAdapter(DayAdapter);


        sDay1spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {

            if (adapter.getItemAtPosition(position).equals("Day")) {
                //do nothing.
                sDay1Text.setText("");
            }
            else {

                sDay1Text.setText(days[position]);
                sSubject.getDay1();
            }
        }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //TODO Auto-generated method stub
                sDay1Text.setText("");
            }


        });

        sDay2spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {

                if (adapter.getItemAtPosition(position).equals("Day")) {
                    sDay2Text.setText("");
                }
                else {

                    sDay2Text.setText(days[position]);
                    sSubject.getDay2();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //TODO Auto-generated method stub
                sDay2Text.setText("");
            }


        });

        sDay3spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {

                if (adapter.getItemAtPosition(position).equals("Day")) {
                    sDay3Text.setText("");
                }
                else {

                    sDay3Text.setText(days[position]);
                    sSubject.getDay3();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //TODO Auto-generated method stub
                sDay3Text.setText("");
            }

        });




        sDay1Text = (EditText)v.findViewById(R.id.subjects_day1);
        sDay1Text.setText(sSubject.getDay1());
        sDay1Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setDay1(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        sDay2Text = (EditText)v.findViewById(R.id.subjects_day2);
        sDay2Text.setText(sSubject.getDay2());
        sDay2Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setDay2(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sDay3Text = (EditText)v.findViewById(R.id.subjects_day3);
        sDay3Text.setText(sSubject.getDay3());
        sDay3Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setDay3(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





        sTime1startSpinner = (Spinner)v.findViewById(R.id.subjects_time1start_spinner);
        sTime1endSpinner = (Spinner)v.findViewById(R.id.subjects_time1end_spinner);

        sTime2startSpinner = (Spinner)v.findViewById(R.id.subjects_time2start_spinner);
        sTime2endSpinner = (Spinner)v.findViewById(R.id.subjects_time2end_spinner);

        sTime3startSpinner = (Spinner)v.findViewById(R.id.subjects_time3start_spinner);
        sTime3endSpinner = (Spinner)v.findViewById(R.id.subjects_time3end_spinner);


        TimeAdapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,time);
        TimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sTime1startSpinner.setAdapter(TimeAdapter);
        sTime1endSpinner.setAdapter(TimeAdapter);

        sTime2startSpinner.setAdapter(TimeAdapter);
        sTime2endSpinner.setAdapter(TimeAdapter);

        sTime3startSpinner.setAdapter(TimeAdapter);
        sTime3endSpinner.setAdapter(TimeAdapter);


        sTime1startSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {

                if (adapter.getItemAtPosition(position).equals("Time")) {
                    sTime1StartText.setText("");
                }
                else {

                    sTime1StartText.setText(time[position]);
                     sSubject.getTime1start();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //TODO Auto-generated method stub
                sTime1StartText.setText("");
            }


        });

        sTime1endSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {

                if (adapter.getItemAtPosition(position).equals("Time")) {
                    sTime1EndText.setText("");
                }
                else {

                    sTime1EndText.setText(time[position]);
                    sSubject.getTime1end();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //TODO Auto-generated method stub
            }

        });



        sTime2startSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {

                if (adapter.getItemAtPosition(position).equals("Time")) {
                    sTime2StartText.setText("");
                }
                else {

                    sTime2StartText.setText(time[position]);
                    sSubject.getTime2start();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //TODO Auto-generated method stub
            }


        });

        sTime2endSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {

                if (adapter.getItemAtPosition(position).equals("Time")) {
                    sTime2EndText.setText("");
                }
                else {

                    sTime2EndText.setText(time[position]);
                    sSubject.getTime2end();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //TODO Auto-generated method stub

            }

        });


        sTime3startSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {

                if (adapter.getItemAtPosition(position).equals("Time")) {
                    sTime3StartText.setText("");
                }
                else {

                    int position3 = sTime3startSpinner.getSelectedItemPosition();
                    sTime3StartText.setText(time[position3].toString());
                    sSubject.getTime3start();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //TODO Auto-generated method stub

            }


        });

        sTime3endSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {

                if (adapter.getItemAtPosition(position).equals("Time")) {
                    sTime3EndText.setText("");
                }
                else {

                    sTime3EndText.setText(time[position]);
                    sSubject.getTime3end();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //TODO Auto-generated method stub

            }

        });



        sTime1StartText = (EditText)v.findViewById(R.id.subjects_time1start);
        sTime1StartText.setText(sSubject.getTime1start());
        sTime1StartText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setTime1start(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        sTime1EndText = (EditText)v.findViewById(R.id.subjects_time1end);
        sTime1EndText.setText(sSubject.getTime1end());
        sTime1EndText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setTime1end(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        sTime2StartText = (EditText)v.findViewById(R.id.subjects_time2start);
        sTime2StartText.setText(sSubject.getTime2start());
        sTime2StartText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setTime2start(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        sTime2EndText = (EditText)v.findViewById(R.id.subjects_time2end);
        sTime2EndText.setText(sSubject.getTime2end());
        sTime2EndText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setTime2end(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        sTime3StartText = (EditText)v.findViewById(R.id.subjects_time3start);
        sTime3StartText.setText(sSubject.getTime3start());
        sTime3StartText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setTime3start(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sTime3EndText = (EditText)v.findViewById(R.id.subjects_time3end);
        sTime3EndText.setText(sSubject.getTime3end());
        sTime3EndText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setTime3end(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        sCodeText = (EditText)v.findViewById(R.id.subjects_code);
        sCodeText.setText(sSubject.getCode());
        sCodeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setCode(s.toString());

                if(s.toString().trim().length()==0){
                    sCodeText.setError("The Subject Code is required!");
                    saveButton.setEnabled(false);
                } else {
                    saveButton.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        sTitleText = (EditText)v.findViewById(R.id.subjects_title);
        sTitleText.setText(sSubject.getTitle());
        sTitleText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setTitle(s.toString());
                if(s.toString().trim().length()==0){
                    sTitleText.setError("The Subject Title is required!");
                    saveButton.setEnabled(false);
                } else {
                    saveButton.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        sLocation1Text = (EditText)v.findViewById(R.id.subjects_location1);
        sLocation1Text.setText(sSubject.getLocation1());
        sLocation1Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setLocation1(s.toString());
                if(s.toString().trim().length()==0){
                    sLocation1Text.setError("The location is required!");
                    saveButton.setEnabled(false);
                } else {
                    saveButton.setEnabled(true);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        sLocation2Text = (EditText)v.findViewById(R.id.subjects_location2);
        sLocation2Text.setText(sSubject.getLocation2());
        sLocation2Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setLocation2(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        sLocation3Text = (EditText)v.findViewById(R.id.subjects_location3);
        sLocation3Text.setText(sSubject.getLocation3());
        sLocation3Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setLocation3(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        sLecturerText = (EditText)v.findViewById(R.id.subjects_lecturer);
        sLecturerText.setText(sSubject.getLecturer());
        sLecturerText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sSubject.setLecturer(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        return v;

    }



    }





