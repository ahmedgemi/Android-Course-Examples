package com.ahmed.tasktrackingexample;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ProgressBar;

public class TabAdapter extends FragmentPagerAdapter {

    ToDoFragment toDoFragment = new ToDoFragment();
    ProgressFragment progressFragment = new ProgressFragment();
    DoneFragment doneFragment = new DoneFragment();

    public TabAdapter(FragmentManager fm) {
        super(fm);

        toDoFragment.setListener(progressFragment);

        progressFragment.setListener(doneFragment);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0:
                return toDoFragment;

            case 1:
                return progressFragment;

            case 2:
                return doneFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "ToDo";

            case 1:
                return "In Progress";

            case 2:
                return "Done";
        }
        return null;
    }
}
