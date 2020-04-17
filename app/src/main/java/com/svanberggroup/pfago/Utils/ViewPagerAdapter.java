package com.svanberggroup.pfago.Utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.svanberggroup.pfago.Fragments.*;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull @Override public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return FragmentOne.newInstance();
            case 1:
                return FragmentTwo.newInstance();
            case 2:
                return FragmentThree.newInstance();
            case 3:
                return FragmentFour.newInstance();
            case 4:
                return FragmentFive.newInstance();
            case 5:
                return FragmentSix.newInstance();
        }
        return null;
    }

    @Override public int getItemCount() {
        return 6;
    }
}