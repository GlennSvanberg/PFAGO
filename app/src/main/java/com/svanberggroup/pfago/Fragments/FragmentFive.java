package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentFive extends Fragment {


    private static final String NEW_CONTROL = "new_control";

    private RadioGroup godsApprovedABCRadioGroup;
    private EditText godsApprovedRiskCategoryEditText;
    private RadioGroup godsApprovedRadioGroup;
    private EditText godsApprovedNotesEditText;

    private RadioGroup truckApprovedABCRadioGroup;
    private EditText truckApprovedRiskCategoryEditText;
    private RadioGroup truckApprovedRadioGroup;
    private EditText truckApprovedNotesEditText;

    private RadioGroup wayOfTransportABCRadioGroup;
    private EditText wayOfTransportRiskCategoryEditText;
    private RadioGroup wayOfTransportRadioGroup;
    private EditText wayOfTransportNotesEditText;

    private RadioGroup bannedMixedCargoABCRadioGroup;
    private EditText bannedMixedCargoRiskCategoryEditText;
    private RadioGroup bannedMixedCargoRadioGroup;
    private EditText bannedMixedCargoNotesEditText;

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

    private Control control;

    private FragmentFive() {
    }

    public static FragmentFive newInstance(Control control) {
        FragmentFive fragment = new FragmentFive();
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
        View view = inflater.inflate(R.layout.fragment_five, container, false);

        addSubViewToView(view);
        setVisibilityGone(view);
        handleVisibility();
        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void addSubViewToView(View view) {
        godsApprovedABCRadioGroup           = view.findViewById(R.id.godsApprovedABCRadioGroup);
        godsApprovedRiskCategoryEditText    = view.findViewById(R.id.godsApprovedRiskCategoryEditText);
        godsApprovedRadioGroup              = view.findViewById(R.id.godsApprovedRadioGroup);
        godsApprovedNotesEditText           = view.findViewById(R.id.godsApprovedNotesEditText);

        truckApprovedABCRadioGroup           = view.findViewById(R.id.truckApprovedABCRadioGroup);
        truckApprovedRiskCategoryEditText    = view.findViewById(R.id.truckApprovedRiskCategoryEditText);
        truckApprovedRadioGroup              = view.findViewById(R.id.truckApprovedRadioGroup);
        truckApprovedNotesEditText           = view.findViewById(R.id.truckApprovedNotesEditText);

        wayOfTransportABCRadioGroup          = view.findViewById(R.id.wayOfTransportABCRadioGroup);
        wayOfTransportRiskCategoryEditText   = view.findViewById(R.id.wayOfTransportRiskCategoryEditText);
        wayOfTransportRadioGroup             = view.findViewById(R.id.wayOfTransportRadioGroup);
        wayOfTransportNotesEditText          = view.findViewById(R.id.wayOfTransportNotesEditText);

        bannedMixedCargoABCRadioGroup        = view.findViewById(R.id.bannedMixedCargoABCRadioGroup);
        bannedMixedCargoRiskCategoryEditText = view.findViewById(R.id.bannedMixedCargoRiskCategoryEditText);
        bannedMixedCargoRadioGroup           = view.findViewById(R.id.bannedMixedCargoRadioGroup);
        bannedMixedCargoNotesEditText        = view.findViewById(R.id.bannedMixedCargoNotesEditText);

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

    private void setVisibilityGone(View view){
        godsApprovedRiskCategoryEditText.setVisibility(view.GONE);
        godsApprovedRadioGroup.setVisibility(view.GONE);
        godsApprovedNotesEditText.setVisibility(view.GONE);

        truckApprovedRiskCategoryEditText.setVisibility(view.GONE);
        truckApprovedRadioGroup.setVisibility(view.GONE);
        truckApprovedNotesEditText.setVisibility(view.GONE);

        wayOfTransportRiskCategoryEditText.setVisibility(view.GONE);
        wayOfTransportRadioGroup.setVisibility(view.GONE);
        wayOfTransportNotesEditText.setVisibility(view.GONE);

        bannedMixedCargoRiskCategoryEditText.setVisibility(view.GONE);
        bannedMixedCargoRadioGroup.setVisibility(view.GONE);
        bannedMixedCargoNotesEditText.setVisibility(view.GONE);

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
        godsApprovedABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.godsApprovedNotApprovedRadioButton) {
                    godsApprovedRiskCategoryEditText.setVisibility(View.VISIBLE);
                    godsApprovedRadioGroup.setVisibility(View.VISIBLE);
                    godsApprovedNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    godsApprovedRiskCategoryEditText.setVisibility(View.GONE);
                    godsApprovedRadioGroup.setVisibility(View.GONE);
                    godsApprovedNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        truckApprovedABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.truckApprovedNotApprovedRadioButton) {
                    truckApprovedRiskCategoryEditText.setVisibility(View.VISIBLE);
                    truckApprovedRadioGroup.setVisibility(View.VISIBLE);
                    truckApprovedNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    truckApprovedRiskCategoryEditText.setVisibility(View.GONE);
                    truckApprovedRadioGroup.setVisibility(View.GONE);
                    truckApprovedNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        wayOfTransportABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.wayOfTransportNotApprovedRadioButton) {
                    wayOfTransportRiskCategoryEditText.setVisibility(View.VISIBLE);
                    wayOfTransportRadioGroup.setVisibility(View.VISIBLE);
                    wayOfTransportNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    wayOfTransportRiskCategoryEditText.setVisibility(View.GONE);
                    wayOfTransportRadioGroup.setVisibility(View.GONE);
                    wayOfTransportNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        bannedMixedCargoABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.bannedMixedCargoNotApprovedRadioButton) {
                    bannedMixedCargoRiskCategoryEditText.setVisibility(View.VISIBLE);
                    bannedMixedCargoRadioGroup.setVisibility(View.VISIBLE);
                    bannedMixedCargoNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    bannedMixedCargoRiskCategoryEditText.setVisibility(View.GONE);
                    bannedMixedCargoRadioGroup.setVisibility(View.GONE);
                    bannedMixedCargoNotesEditText.setVisibility(View.GONE);
                }
            }
        });
    }

}