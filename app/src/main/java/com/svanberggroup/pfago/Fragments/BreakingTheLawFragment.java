package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.TransportRows;
import com.svanberggroup.pfago.R;

import java.io.Serializable;
import java.util.ArrayList;

public class BreakingTheLawFragment extends Fragment {



    private static final String NEW_CONTROL = "new_control";

    ArrayList<ControlRow> otherList = new ArrayList<>();
    private View child;

    private Control control;
    private TransportRows tRows;
    private ArrayList<View> views = new ArrayList<>();
    private LinearLayout otherLinerLayout;

    public BreakingTheLawFragment() {
    }

    public static BreakingTheLawFragment newInstance(Control control) {
        BreakingTheLawFragment fragment = new BreakingTheLawFragment();
        Bundle args = new Bundle();
        args.putSerializable(NEW_CONTROL, (Serializable) control);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        control = (Control) getArguments().getSerializable(NEW_CONTROL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_breaking_the_law, container, false);

        otherLinerLayout = (LinearLayout) view.findViewById(R.id.otherLinearLayout);

        return  view;
    }



    private void displayViews() {
        for (View v: views) {
            otherLinerLayout.addView(v);
        }
    }




    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}