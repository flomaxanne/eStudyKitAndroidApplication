package com.android.estudykit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by Florence A. Pereira on 2/19/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumofTabs;


    public PagerAdapter (FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumofTabs = NumOfTabs;
    }




    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragmentSubjects tab1 = new TabFragmentSubjects();
                return tab1;

            case 1:
                TabFragmentTasks tab2 = new TabFragmentTasks();
                return tab2;


            case 2:

                TabFragmentMaterials tab3 = new TabFragmentMaterials();
                return tab3;


            default:
                return null;
        }

    }


    @Override
    public int getCount() {
        return mNumofTabs;
    }
}
