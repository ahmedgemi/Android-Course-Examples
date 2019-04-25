package com.ahmed.roomdatabase2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new FoodFragment();

            case 1:
                return new OrderFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
