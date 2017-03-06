package com.android.estudykit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Florence A. Pereira on 2/24/2017.
 */

public class TabFragmentSubjects extends Fragment {

    private RecyclerView sSubjectsRecyclerView;
    private SubjectAdapter sAdapter;
    public FloatingActionButton fabsubject;




    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subjects_list, container, false);

        sSubjectsRecyclerView = (RecyclerView)view.findViewById(R.id.subjects_recycler_view);
        sSubjectsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        fabsubject = (FloatingActionButton)view.findViewById(R.id.fabsubject);
        fabsubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Subject subject = new Subject();
                SubjectsInfo.get(getActivity()).addSubjects(subject);
                Intent intent = SubjectsPagerActivity.newIntent(getActivity(), subject.getId());
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
        SubjectsInfo subjectsInfo = SubjectsInfo.get(getActivity());
        List<Subject> subjects = subjectsInfo.getSubjects();

        if (sAdapter == null) {
            sAdapter = new TabFragmentSubjects.SubjectAdapter(subjects);
            sSubjectsRecyclerView.setAdapter(sAdapter);
        }
        else {
            sAdapter.setSubjects(subjects);
            sAdapter.notifyDataSetChanged();
        }

    }


    private class SubjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Subject sSubject;
        private TextView sCodeTextView;
        private TextView sTitleTextView;
        private TextView sDay1TextView;
        private TextView sDay2TextView;
        private TextView sDay3TextView;

        private TextView sTime1startTextView;
        private TextView sTime1endTextView;

        private TextView sTime2startTextView;
        private TextView sTime2endTextView;

        private TextView sTime3startTextView;
        private TextView sTime3endTextView;


        private TextView sLocation1TextView;
        private TextView sLocation2TextView;
        private TextView sLocation3TextView;


        private TextView sLecturerTextView;


        public SubjectHolder (View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            sCodeTextView = (TextView) itemView.findViewById(R.id.list_item_subjects_code_textview);
            sTitleTextView = (TextView) itemView.findViewById(R.id.list_item_subjects_title_textview);
            sDay1TextView = (TextView) itemView.findViewById(R.id.list_item_subjects_day1_textview);
            sDay2TextView = (TextView) itemView.findViewById(R.id.list_item_subjects_day2_textview);
            sDay3TextView = (TextView) itemView.findViewById(R.id.list_item_subjects_day3_textview);

            sTime1startTextView = (TextView) itemView.findViewById(R.id.list_item_subjects_time1start_textview);
            sTime1endTextView = (TextView) itemView.findViewById(R.id.list_item_subjects_time1end_textview);

            sTime2startTextView = (TextView) itemView.findViewById(R.id.list_item_subjects_time2start_textview);
            sTime2endTextView = (TextView) itemView.findViewById(R.id.list_item_subjects_time2end_textview);

            sTime3startTextView = (TextView) itemView.findViewById(R.id.list_item_subjects_time3start_textview);
            sTime3endTextView = (TextView) itemView.findViewById(R.id.list_item_subjects_time3end_textview);


            sLocation1TextView = (TextView) itemView.findViewById(R.id.list_item_subjects_location1_textview);
            sLocation2TextView = (TextView) itemView.findViewById(R.id.list_item_subjects_location2_textview);
            sLocation3TextView = (TextView) itemView.findViewById(R.id.list_item_subjects_location3_textview);

            sLecturerTextView = (TextView) itemView.findViewById(R.id.list_item_subjects_lecturer_textview);


        }

        public void bindSubject(Subject subject) {
            sSubject = subject;
            sCodeTextView.setText(sSubject.getCode());
            sTitleTextView.setText(sSubject.getTitle());
            sDay1TextView.setText(sSubject.getDay1());
            sDay2TextView.setText(sSubject.getDay2());
            sDay3TextView.setText(sSubject.getDay3());

            sTime1startTextView.setText(sSubject.getTime1start());
            sTime1endTextView.setText(sSubject.getTime1end());


            sTime2startTextView.setText(sSubject.getTime2start());
            sTime2endTextView.setText(sSubject.getTime2end());

            sTime3startTextView.setText(sSubject.getTime3start());
            sTime3endTextView.setText(sSubject.getTime3end());


            sLocation1TextView.setText(sSubject.getLocation1());
            sLocation2TextView.setText(sSubject.getLocation2());
            sLocation3TextView.setText(sSubject.getLocation3());

            sLecturerTextView.setText(sSubject.getLecturer());


        }


        @Override
        public void onClick(View v) {
            Intent intent = SubjectsPagerActivity.newIntent(getActivity(), sSubject.getId());
            startActivity(intent);
        }
    }


    private class SubjectAdapter extends RecyclerView.Adapter<TabFragmentSubjects.SubjectHolder> {

        private List<Subject> sSubjects;

        public SubjectAdapter(List<Subject> subjects) {
            sSubjects = subjects;
        }


        @Override
        public TabFragmentSubjects.SubjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            View view = layoutInflater.inflate(R.layout.list_item_subjects, parent, false);

            return new TabFragmentSubjects.SubjectHolder(view);


        }

        @Override
        public void onBindViewHolder(TabFragmentSubjects.SubjectHolder holder, int postion) {
            Subject subject = sSubjects.get(postion);
            holder.bindSubject(subject);
        }

        @Override
        public int getItemCount() {
            return sSubjects.size();
        }

        public void setSubjects(List<Subject> subjects) {
            sSubjects = subjects;
        }
    }


}
