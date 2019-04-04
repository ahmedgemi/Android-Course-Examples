package com.ahmed.tabs;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdadpter extends FragmentPagerAdapter {

    Fragment1 fragment1 = new Fragment1();
    Fragment2 fragment2 = new Fragment2();

    public TabAdadpter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case  0:
                return fragment1;

            case 1:
                return fragment2;

            case 2:
                return new Fragment3();
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
                return "Tab 1";

            case 1:
                return "Tab 2";

            case 2:
                return "Tab 3";
        }
        return null;
    }
}
