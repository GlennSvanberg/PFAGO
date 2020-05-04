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

public class FragmentEight extends Fragment {



    private static final String NEW_CONTROL = "new_control";

    ArrayList<ControlRow> otherList = new ArrayList<>();
    private View child;

    private Control control;
    private TransportRows tRows;
    private ArrayList<View> views = new ArrayList<>();
    private LinearLayout otherLinerLayout;

    public FragmentEight() {
    }

    public static FragmentEight newInstance(Control control) {
        FragmentEight fragment = new FragmentEight();
        Bundle args = new Bundle();
        args.putSerializable(NEW_CONTROL, (Serializable) control);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        control = (Control) getArguments().getSerializable(NEW_CONTROL);

        if (control.getTRows() != null) {
            tRows = control.getTRows();
        } else {
            tRows = new TransportRows();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eight, container, false);

        otherLinerLayout = (LinearLayout) view.findViewById(R.id.otherLinearLayout);
        child = inflater.inflate(R.layout.control_layout, null);
        View child1 = inflater.inflate(R.layout.control_layout, null);
        View child2 = inflater.inflate(R.layout.control_layout, null);
        views.add(child);
        views.add(child1);
        views.add(child2);

        displayViews();
        addRadioButtonCheckedListner();
        return  view;
    }



    private void displayViews() {
        for (View v: views) {
            otherLinerLayout.addView(v);
        }
    }

    private void addRadioButtonCheckedListner() {
        tRows = control.getTRows();

        for (View v: views) {

            RadioGroup group = v.findViewById(R.id.radioGroupABC);
            ControlRow cRow = new ControlRow("janne");
            group.setOnCheckedChangeListener((group1, checkedId) -> {
                    switch (checkedId) {
                        case R.id.radioButtonControlled:
                            cRow.setField(ControlRow.Field.Controlled);
                            tRows.addRow40(cRow);
                        case R.id.radioButtonNotApproved:
                            cRow.setField(ControlRow.Field.BreakingTheLaw);
                            tRows.addRow40(cRow);
                        case R.id.radioButtonNotApplicible:
                            cRow.setField(ControlRow.Field.NotApplicable);
                            tRows.addRow40(cRow);
                    }
            });
        }
    }


    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}