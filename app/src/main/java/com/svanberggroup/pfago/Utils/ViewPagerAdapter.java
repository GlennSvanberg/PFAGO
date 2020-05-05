package com.svanberggroup.pfago.Utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.svanberggroup.pfago.Fragments.*;
import com.svanberggroup.pfago.Models.Control;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private Control control;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, Control control) {
        super(fragmentActivity);
        this.control = control;
    }
    public void addFragment(Fragment fragment, String title, int position){
        fragmentList.add(position, fragment);
        fragmentTitleList.add(position, title);
    }
    public void removeFragment(int position){
        fragmentList.remove(position);
        fragmentTitleList.remove(position);
    }
    public Fragment getFragment(int position){
        return fragmentList.get(position);
    }
    public String getTitle(int position){
        return fragmentTitleList.get(position);
    }

    @NonNull @Override public Fragment createFragment(int position) {

        return fragmentList.get(position);
    }

    @Override public int getItemCount() {
        return fragmentList.size();
    }
}