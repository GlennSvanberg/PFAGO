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


    private enum Transport {
        handling,
        loading,
        securing,
        leakage,
        damages,
        gods,
        truck,
        transport,
        banned,
    }


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

    public FragmentFive() {
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
        handleRadioButtonInput();
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

    private void setVisibilityFor(Transport transport, int visibility) {
        switch (transport) {
            case handling:
                handlingRiskCategoryEditText.setVisibility(visibility);
                handlingRadioGroup.setVisibility(visibility);
                handlingNotesEditText.setVisibility(visibility);
                break;
            case loading:
                loadingRiskCategoryEditText.setVisibility(visibility);
                loadingRadioGroup.setVisibility(visibility);
                loadingNotesEditText.setVisibility(visibility);
                break;
            case securing:
                securingCargoRiskCategoryEditText.setVisibility(visibility);
                securingCargoNotesEditText.setVisibility(visibility);
                securingCargoRadioGroup.setVisibility(visibility);
                break;
            case leakage:
                leakageRiskCategotyEditText.setVisibility(visibility);
                leakageRadioGroup.setVisibility(visibility);
                leakageNotesEditText.setVisibility(visibility);
                break;
            case damages:
                damagesRiskCategotyEditText.setVisibility(visibility);
                damagesRadioGroup.setVisibility(visibility);
                damagesNotesEditText.setVisibility(visibility);
                break;
            case gods:
                godsApprovedRiskCategoryEditText.setVisibility(visibility);
                godsApprovedRadioGroup.setVisibility(visibility);
                godsApprovedNotesEditText.setVisibility(visibility);
                break;
            case truck:
                truckApprovedRiskCategoryEditText.setVisibility(visibility);
                truckApprovedNotesEditText.setVisibility(visibility);
                truckApprovedRadioGroup.setVisibility(visibility);
                break;
            case transport:
                wayOfTransportRiskCategoryEditText.setVisibility(visibility);
                wayOfTransportRadioGroup.setVisibility(visibility);
                wayOfTransportNotesEditText.setVisibility(visibility);
                break;
            case banned:
                bannedMixedCargoRiskCategoryEditText.setVisibility(visibility);
                bannedMixedCargoRadioGroup.setVisibility(visibility);
                bannedMixedCargoNotesEditText.setVisibility(visibility);
                break;

        }
    }

    private void handleRadioButtonInput() {
        handlingABCRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.handlingControlledRadioButton:
                        setVisibilityFor(Transport.handling, View.GONE);
                        break;
                    case R.id.handlingNotApprovedRadioButton:
                        setVisibilityFor(Transport.handling, View.VISIBLE);
                        break;
                    case R.id.handlingNotApplicableRadioButton:
                        setVisibilityFor(Transport.handling, View.GONE);
                        break;
                }
            }
        });
        loadingABCRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.loadingControlledRadioButton:
                        setVisibilityFor(Transport.loading, View.GONE);
                        break;
                    case R.id.loadingNotApprovedRadioButton:
                        setVisibilityFor(Transport.loading, View.VISIBLE);
                        break;
                    case R.id.loadingNotApplicableRadioButton:
                        setVisibilityFor(Transport.loading, View.GONE);
                        break;
                }
            }
        });
        securingCargoABCRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.securingCargoControlledRadioButton:
                        setVisibilityFor(Transport.securing, View.GONE);
                        break;
                    case R.id.securingCargoNotApprovedRadioButton:
                        setVisibilityFor(Transport.securing, View.VISIBLE);
                        break;
                    case R.id.securingCargoNotApplicableRadioButton:
                        setVisibilityFor(Transport.securing, View.GONE);
                        break;
                }
            }
        });
        leakageABCRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.leakageControlledRadioButton:
                        setVisibilityFor(Transport.leakage, View.GONE);
                        break;
                    case R.id.leakageNotApprovedRadioButton:
                        setVisibilityFor(Transport.leakage, View.VISIBLE);
                        break;
                    case R.id.leakageNotApplicableRadioButton:
                        setVisibilityFor(Transport.leakage, View.GONE);
                        break;
                }
            }
        });
        damagesABCRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.damagesControlledRadioButton:
                        setVisibilityFor(Transport.damages, View.GONE);
                        break;
                    case R.id.damagesNotApprovedRadioButton:
                        setVisibilityFor(Transport.damages, View.VISIBLE);
                        break;
                    case R.id.damagesNotApplicableRadioButton:
                        setVisibilityFor(Transport.damages, View.GONE);
                        break;
                }
            }
        });
        godsApprovedABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.godsApproveControlledRadioButton:
                        setVisibilityFor(Transport.gods, View.GONE);
                        break;
                    case R.id.godsApprovedNotApprovedRadioButton:
                        setVisibilityFor(Transport.gods, View.VISIBLE);
                        break;
                    case R.id.godsApproveNotApplicableRadioButton:
                        setVisibilityFor(Transport.gods, View.GONE);
                        break;
                }
            }
        });
        truckApprovedABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.truckApprovedControlledRadioButton:
                        setVisibilityFor(Transport.truck, View.GONE);
                        break;
                    case R.id.truckApprovedNotApprovedRadioButton:
                        setVisibilityFor(Transport.truck, View.VISIBLE);
                        break;
                    case R.id.truckApprovedNotApplicableRadioButton:
                        setVisibilityFor(Transport.truck, View.GONE);
                        break;
                }
            }
        });
        wayOfTransportABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.wayOfTransportControlledRadioButton:
                        setVisibilityFor(Transport.transport, View.GONE);
                        break;
                    case R.id.wayOfTransportNotApprovedRadioButton:
                        setVisibilityFor(Transport.transport, View.VISIBLE);
                        break;
                    case R.id.wayOfTransportNotApplicableRadioButton:
                        setVisibilityFor(Transport.transport, View.GONE);
                        break;
                }
            }
        });
        bannedMixedCargoABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bannedMixedCargoControlledRadioButton:
                        setVisibilityFor(Transport.banned, View.GONE);
                        break;
                    case R.id.bannedMixedCargoNotApprovedRadioButton:
                        setVisibilityFor(Transport.banned, View.VISIBLE);
                        break;
                    case R.id.bannedMixedCargoNotApplicableRadioButton:
                        setVisibilityFor(Transport.banned, View.GONE);
                        break;
                }
            }
        });
    }

}