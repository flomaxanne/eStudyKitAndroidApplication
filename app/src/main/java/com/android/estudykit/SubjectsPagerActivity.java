package com.android.estudykit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/24/2017.
 */

public class SubjectsPagerActivity extends FragmentActivity {

    private static final String EXTRA_SUBJECT_ID = "com.android.estudykit.subject_id";
    private ViewPager sViewPager;
    private List<Subject> sSubjects;



    public static Intent newIntent(Context packageContext, UUID subjectId) {
        Intent intent = new Intent(packageContext, SubjectsPagerActivity.class);
        intent.putExtra(EXTRA_SUBJECT_ID,subjectId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_pager);


        UUID subjectId = (UUID) getIntent().getSerializableExtra(EXTRA_SUBJECT_ID);

        sViewPager = (ViewPager) findViewById(R.id.activity_subjects_pager);

        sSubjects = SubjectsInfo.get(this).getSubjects();
        FragmentManager fragmentManager = getSupportFragmentManager();
        sViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Subject subject = sSubjects.get(position);
                return SubjectsFragment.newInstance(subject.getId());
            }

            @Override
            public int getCount() {
                return sSubjects.size();
            }
        });

        for (int i=0;i<sSubjects.size();i++) {
            if (sSubjects.get(i).getId().equals(subjectId)) {
                sViewPager.setCurrentItem(i);
                break;
            }
        }

    }





}
