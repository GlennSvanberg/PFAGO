package com.svanberggroup.pfago.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.Fault;
import com.svanberggroup.pfago.Models.Goods;
import com.svanberggroup.pfago.Models.TransportRows;
import com.svanberggroup.pfago.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BreakingTheLawFragment extends Fragment {

    private static final String NEW_CONTROL = "new_control";

    private Control control;
    private LinearLayout godsLinearLayout;
    private LinearLayout flawLinearLayout;
    private Button godsAddButton;
    private Button flawsAddButton;
    private List<View> godsViews;
    private List<View> flawsViews;

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

        flawLinearLayout = (LinearLayout) view.findViewById(R.id.flawLinearLayout);
        godsLinearLayout = (LinearLayout) view.findViewById(R.id.godsLinearLayout);
        View childGods = getLayoutInflater().inflate(R.layout.gods_input_layout, null);
        View childFlaw = getLayoutInflater().inflate(R.layout.flaws_input_layout, null);

        //godsLinearLayout.addView(childGods);
        //flawLinearLayout.addView(childFlaw);

        godsViews = new ArrayList<>();
        flawsViews= new ArrayList<>();
        godsViews.add(childGods);
        flawsViews.add(childFlaw);

        addButtonListners(view);
        toggleViewButton(view);

        return  view;
    }

    @Override
    public void onPause() {
        super.onPause();
        setFieldsInControl();
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void addButtonListners(View view) {
        godsAddButton = view.findViewById(R.id.addGodsBreakingTheLawButton);
        flawsAddButton = view.findViewById(R.id.flawAddBreakingTheLawButton);
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        godsAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View addView = layoutInflater.inflate(R.layout.gods_input_layout, null);
                godsLinearLayout.addView(addView);
                godsViews.add(addView);
            }
        });
        flawsAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View addView = layoutInflater.inflate(R.layout.flaws_input_layout, null);
                flawLinearLayout.addView(addView);
                flawsViews.add(addView);
            }
        });
    }

    private void toggleViewButton(View view) {
        ToggleButton toggle = view.findViewById(R.id.toggleButton);
        ToggleButton toggle1 = view.findViewById(R.id.toggleButton1);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    view.findViewById(R.id.godsLinearLayout).setVisibility(View.GONE);
                    view.findViewById(R.id.addGodsBreakingTheLawButton).setVisibility(View.GONE);
                    toggle.setBackgroundResource(R.drawable.ic_down_light);
                } else {
                    view.findViewById(R.id.godsLinearLayout).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.addGodsBreakingTheLawButton).setVisibility(View.VISIBLE);
                    toggle.setBackgroundResource(R.drawable.ic_up_light);
                }
            }
        });
        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    view.findViewById(R.id.flawLinearLayout).setVisibility(View.GONE);
                    view.findViewById(R.id.flawAddBreakingTheLawButton).setVisibility(View.GONE);
                    toggle1.setBackgroundResource(R.drawable.ic_down_light);
                } else {
                    view.findViewById(R.id.flawLinearLayout).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.flawAddBreakingTheLawButton).setVisibility(View.VISIBLE);
                    toggle1.setBackgroundResource(R.drawable.ic_up_light);
                }
            }
        });
    }

    private List<Goods> createListofGoods() {
        List<Goods> goods = new ArrayList<>();
        for (View v: godsViews) {
            EditText un = v.findViewById(R.id.godsNrEditText);
            EditText decription = v.findViewById(R.id.godsDescriptionEditText);
            EditText classs = v.findViewById(R.id.classEditText);
            EditText gods = v.findViewById(R.id.godsAmountEditText);
            EditText paper = v.findViewById(R.id.paperEditText);
            EditText LQ = v.findViewById(R.id.LQeditText);
            EditText PG = v.findViewById(R.id.PGeditText);
            Goods good = new Goods("A",
                    un.getText().toString(),
                    decription.getText().toString(), classs.getText().toString(),
                    PG.getText().toString(),
                    gods.getText().toString(),paper.getText().toString(),
                    true);
            goods.add(good);
        }
        return goods;
    }
    private List<Fault> createListOfFlaws() {
        List<Fault> faults = new ArrayList<>();
        for (View v: flawsViews) {
            EditText field = v.findViewById(R.id.fieldNrEditText);
            EditText flawsGodsPos = v.findViewById(R.id.flawGodsPosDescriptionEditText);
            EditText flaw = v.findViewById(R.id.flawEditText);
            EditText mNumber = v.findViewById(R.id.mNumberEditText);
            Fault fault = new Fault(Integer.parseInt(field.getText().toString()), flawsGodsPos.getText().toString(),
                    flaw.getText().toString(), mNumber.getText().toString());
            faults.add(fault);
        }
        return faults;
    }

    private void setFieldsInControl() {
        control.setGoodsList(createListofGoods());
        control.setFaultList(createListOfFlaws());
    }
}