package com.svanberggroup.pfago.Utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.svanberggroup.pfago.Fragments.*;
import com.svanberggroup.pfago.Models.Control;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private Control control;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, Control control) {
        super(fragmentActivity);
        this.control = control;
    }

    @NonNull @Override public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return FragmentOne.newInstance(control);
            case 1:
                return FragmentTwo.newInstance(control);
            case 2:
                return FragmentThree.newInstance(control);
            case 3:
                return FragmentFour.newInstance(control);
            case 4:
                return FragmentFive.newInstance(control);
            case 5:
                return FragmentSeven.newInstance(control);
            case 6:
                return FragmentSix.newInstance(control);
            case 7:
                return FragmentEight.newInstance(control);
            case 8:
                return ImagesFragment.newInstance(control);
        }
        return null;
    }

    @Override public int getItemCount() {
        return 9;
    }
}