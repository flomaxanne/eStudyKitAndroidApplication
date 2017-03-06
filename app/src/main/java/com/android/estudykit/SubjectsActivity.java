package com.android.estudykit;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Florence A. Pereira on 2/24/2017.
 */

public class SubjectsActivity extends SubjectsFragmentActivity {

    private static final String EXTRA_SUBJECT_ID = "com.android.estudykit.subject_id";

    public static Intent newIntent (Context packageContext, UUID subjectId) {
        Intent intent = new Intent(packageContext, SubjectsActivity.class);
        intent.putExtra(EXTRA_SUBJECT_ID, subjectId);
        return intent;

    }


    @Override
    protected Fragment createFragment() {
        UUID subjectId = (UUID) getIntent().getSerializableExtra(EXTRA_SUBJECT_ID);
        return SubjectsFragment.newInstance(subjectId);
    }

}

