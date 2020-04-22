package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentSix extends Fragment {


    private static final String NEW_CONTROL = "new_control";

    private EditText   handlingRiskCategoryEditText;
    private RadioGroup handlingRadioGroup;
    private EditText   handlingNotesEditText;
    private RadioGroup handlingABCRadioButton;

    private EditText   loadingRiskCategoryEditText;
    private RadioGroup loadingRadioGroup;
    private EditText   loadingNotesEditText;
    private RadioGroup loadingABCRadioButton;

    private EditText   securingCargoRiskCategoryEditText;
    private RadioGroup securingCargoRadioGroup;
    private EditText   securingCargoNotesEditText;
    private RadioGroup securingCargoABCRadioButton;

    private EditText   leakageRiskCategotyEditText;
    private RadioGroup leakageRadioGroup;
    private EditText   leakageNotesEditText;
    private RadioGroup leakageABCRadioButton;

    private EditText   damagesRiskCategotyEditText;
    private RadioGroup damagesRadioGroup;
    private EditText   damagesNotesEditText;
    private RadioGroup damagesABCRadioButton;

    private Control    control;

    private FragmentSix() {
    }

    public static FragmentSix newInstance(Control control) {
        FragmentSix fragment = new FragmentSix();
        Bundle args = new Bundle();
        args.putSerializable(NEW_CONTROL, (Serializable) control);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_six, container, false);

        addSubViewsToView(view);
        setVisibilityGone(view);
        handleVisibility();
        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    private void addSubViewsToView(final View view) {
        handlingRiskCategoryEditText = view.findViewById(R.id.handlingRiskCategoryEditText);
        handlingRadioGroup           = view.findViewById(R.id.handlingRadioGroup);
        handlingNotesEditText        = view.findViewById(R.id.handlingNotesEditText);
        handlingABCRadioButton       = view.findViewById(R.id.handlingABCRadioGroup);

        loadingRiskCategoryEditText  = view.findViewById(R.id.loadingRiskCategoryEditText);
        loadingRadioGroup            = view.findViewById(R.id.loadingRadioGroup);
        loadingNotesEditText         = view.findViewById(R.id.loadingNotesEditText);
        loadingABCRadioButton        = view.findViewById(R.id.loadingABCRadioGroup);

        securingCargoRiskCategoryEditText   = view.findViewById(R.id.securingCargoRiskCategoryEditText);
        securingCargoRadioGroup             = view.findViewById(R.id.securingCargoRadioGroup);
        securingCargoNotesEditText          = view.findViewById(R.id.securingCargoNotesEditText);
        securingCargoABCRadioButton         = view.findViewById(R.id.securingCargoABCRadioGroup);

        leakageRiskCategotyEditText  = view.findViewById(R.id.leakageRiskCategoryEditText);
        leakageRadioGroup            = view.findViewById(R.id.leakageRadioGroup);
        leakageNotesEditText         = view.findViewById(R.id.leakageNotesEditText);
        leakageABCRadioButton        = view.findViewById(R.id.leakageABCRadioGroup);

        damagesRiskCategotyEditText  = view.findViewById(R.id.damagesRiskCategoryEditText);
        damagesRadioGroup            = view.findViewById(R.id.damagesRadioGroup);
        damagesNotesEditText         = view.findViewById(R.id.damagesNotesEditText);
        damagesABCRadioButton        = view.findViewById(R.id.damagesABCRadioGroup);
    }

    private void handleVisibility() {
        handlingABCRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.handlingNotApprovedRadioButton) {
                    handlingRiskCategoryEditText.setVisibility(View.VISIBLE);
                    handlingRadioGroup.setVisibility(View.VISIBLE);
                    handlingNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    handlingRiskCategoryEditText.setVisibility(View.GONE);
                    handlingRadioGroup.setVisibility(View.GONE);
                    handlingNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        loadingABCRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.loadingNotApprovedRadioButton) {
                    loadingRiskCategoryEditText.setVisibility(View.VISIBLE);
                    loadingRadioGroup.setVisibility(View.VISIBLE);
                    loadingNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    loadingRiskCategoryEditText.setVisibility(View.GONE);
                    loadingRadioGroup.setVisibility(View.GONE);
                    loadingNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        securingCargoABCRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.securingCargoNotApprovedRadioButton) {
                    securingCargoRiskCategoryEditText.setVisibility(View.VISIBLE);
                    securingCargoRadioGroup.setVisibility(View.VISIBLE);
                    securingCargoNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    securingCargoRiskCategoryEditText.setVisibility(View.GONE);
                    securingCargoNotesEditText.setVisibility(View.GONE);
                    securingCargoRadioGroup.setVisibility(View.GONE);
                }
            }
        });
        leakageABCRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.leakageNotApprovedRadioButton) {
                    leakageRiskCategotyEditText.setVisibility(View.VISIBLE);
                    leakageRadioGroup.setVisibility(View.VISIBLE);
                    leakageNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    leakageRiskCategotyEditText.setVisibility(View.GONE);
                    leakageRadioGroup.setVisibility(View.GONE);
                    leakageNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        damagesABCRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.damagesNotApprovedRadioButton) {
                    damagesRiskCategotyEditText.setVisibility(View.VISIBLE);
                    damagesRadioGroup.setVisibility(View.VISIBLE);
                    damagesNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    damagesRiskCategotyEditText.setVisibility(View.GONE);
                    damagesRadioGroup.setVisibility(View.GONE);
                    damagesNotesEditText.setVisibility(View.GONE);
                }
            }
        });
    }

    private void setVisibilityGone(View view){
        handlingRiskCategoryEditText.setVisibility(view.GONE);
        handlingRadioGroup.setVisibility(view.GONE);
        handlingNotesEditText.setVisibility(view.GONE);

        loadingRiskCategoryEditText.setVisibility(view.GONE);
        loadingRadioGroup.setVisibility(view.GONE);
        loadingNotesEditText.setVisibility(view.GONE);

        securingCargoRiskCategoryEditText.setVisibility(view.GONE);
        securingCargoRadioGroup.setVisibility(view.GONE);
        securingCargoNotesEditText.setVisibility(view.GONE);

        leakageRiskCategotyEditText.setVisibility(view.GONE);
        leakageRadioGroup.setVisibility(view.GONE);
        leakageNotesEditText.setVisibility(view.GONE);

        damagesRiskCategotyEditText.setVisibility(view.GONE);
        damagesRadioGroup.setVisibility(view.GONE);
        damagesNotesEditText.setVisibility(view.GONE);
    }
}