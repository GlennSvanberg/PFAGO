package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.TransportRows;
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

    private TransportRows tRows;
    private Control control;

    private ControlRow godsApprovalRow;
    private ControlRow truckApprovalRow;
    private ControlRow wayOfTransportRow;
    private ControlRow bannedMixedCargoRow;
    private ControlRow handlingRow;
    private ControlRow loadingRow;
    private ControlRow securingCargoRow;
    private ControlRow leakageRow;
    private ControlRow damagesRow;


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

        control = (Control) getArguments().getSerializable(NEW_CONTROL);

        tRows = new TransportRows();
        godsApprovalRow = tRows.getRow18();
        truckApprovalRow = tRows.getRow19();
        wayOfTransportRow = tRows.getRow20();
        bannedMixedCargoRow = tRows.getRow21();
        handlingRow = tRows.getRow22_1();
        loadingRow = tRows.getRow22_2();
        securingCargoRow = tRows.getRow22_3();
        leakageRow = tRows.getRow23_1();
        damagesRow = tRows.getRow23_2();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_five, container, false);

        addSubViewToView(view);
        setVisibilityGone(view);
        handleRadioButtonInput();
        handleTextInput();

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
                        handlingRow.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.handling);
                        break;

                    case R.id.handlingNotApprovedRadioButton:
                        setVisibilityFor(Transport.handling, View.VISIBLE);
                        handlingRow.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow22_1(handlingRow);
                        control.setTRows(tRows);

                        break;
                    case R.id.handlingNotApplicableRadioButton:
                        setVisibilityFor(Transport.handling, View.GONE);
                        handlingRow.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.handling);
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
                        loadingRow.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.loading);
                        break;

                    case R.id.loadingNotApprovedRadioButton:
                        setVisibilityFor(Transport.loading, View.VISIBLE);
                        loadingRow.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow22_2(loadingRow);
                        control.setTRows(tRows);

                        break;
                    case R.id.loadingNotApplicableRadioButton:
                        setVisibilityFor(Transport.loading, View.GONE);
                        clearFieldsForView(Transport.loading);
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
                        securingCargoRow.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.securing);
                        break;

                    case R.id.securingCargoNotApprovedRadioButton:
                        setVisibilityFor(Transport.securing, View.VISIBLE);
                        securingCargoRow.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow22_3(securingCargoRow);
                        control.setTRows(tRows);
                        break;
                    case R.id.securingCargoNotApplicableRadioButton:
                        setVisibilityFor(Transport.securing, View.GONE);
                        securingCargoRow.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.securing);
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
                        leakageRow.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.leakage);
                        break;

                    case R.id.leakageNotApprovedRadioButton:
                        setVisibilityFor(Transport.leakage, View.VISIBLE);
                        leakageRow.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow23_1(leakageRow);
                        control.setTRows(tRows);
                        break;

                    case R.id.leakageNotApplicableRadioButton:
                        setVisibilityFor(Transport.leakage, View.GONE);
                        leakageRow.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.leakage);
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
                        damagesRow.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.damages);
                        break;

                    case R.id.damagesNotApprovedRadioButton:
                        setVisibilityFor(Transport.damages, View.VISIBLE);
                        damagesRow.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow23_2(damagesRow);
                        control.setTRows(tRows);
                        break;

                    case R.id.damagesNotApplicableRadioButton:
                        setVisibilityFor(Transport.damages, View.GONE);
                        damagesRow.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.damages);
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
                        godsApprovalRow.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.gods);
                        break;

                    case R.id.godsApprovedNotApprovedRadioButton:
                        setVisibilityFor(Transport.gods, View.VISIBLE);
                        godsApprovalRow.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow18(godsApprovalRow);
                        control.setTRows(tRows);
                        break;

                    case R.id.godsApproveNotApplicableRadioButton:
                        setVisibilityFor(Transport.gods, View.GONE);
                        godsApprovalRow.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.gods);
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
                        truckApprovalRow.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.truck);
                        break;

                    case R.id.truckApprovedNotApprovedRadioButton:
                        setVisibilityFor(Transport.truck, View.VISIBLE);
                        truckApprovalRow.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow19(truckApprovalRow);
                        control.setTRows(tRows);
                        break;

                    case R.id.truckApprovedNotApplicableRadioButton:
                        setVisibilityFor(Transport.truck, View.GONE);
                        truckApprovalRow.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.truck);
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
                        wayOfTransportRow.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.transport);
                        break;
                    case R.id.wayOfTransportNotApprovedRadioButton:
                        setVisibilityFor(Transport.transport, View.VISIBLE);
                        wayOfTransportRow.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow20(wayOfTransportRow);
                        control.setTRows(tRows);
                        break;

                    case R.id.wayOfTransportNotApplicableRadioButton:
                        setVisibilityFor(Transport.transport, View.GONE);
                        wayOfTransportRow.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.transport);
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
                        bannedMixedCargoRow.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.banned);
                        break;

                    case R.id.bannedMixedCargoNotApprovedRadioButton:
                        setVisibilityFor(Transport.banned, View.VISIBLE);
                        bannedMixedCargoRow.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow21(bannedMixedCargoRow);
                        control.setTRows(tRows);
                        break;

                    case R.id.bannedMixedCargoNotApplicableRadioButton:
                        setVisibilityFor(Transport.banned, View.GONE);
                        bannedMixedCargoRow.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.banned);
                        break;
                }
            }
        });
    }

    private void handleTextInput() {
        godsApprovedRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    godsApprovalRow.setRiskCategory(s.toString());
                    tRows.setRow18(godsApprovalRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    godsApprovalRow.setRiskCategory(null);
                    tRows.setRow18(godsApprovalRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.gods)) {
                    tRows.setRow18(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        godsApprovedNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    godsApprovalRow.setNotes(s.toString());
                    tRows.setRow18(godsApprovalRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    godsApprovalRow.setNotes(null);
                    tRows.setRow18(godsApprovalRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.gods)) {
                    tRows.setRow18(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        truckApprovedRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    truckApprovalRow.setRiskCategory(s.toString());
                    tRows.setRow19(godsApprovalRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    truckApprovalRow.setRiskCategory(null);
                    tRows.setRow19(truckApprovalRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.truck)) {
                    tRows.setRow19(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        truckApprovedNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    truckApprovalRow.setNotes(s.toString());
                    tRows.setRow19(truckApprovalRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    truckApprovalRow.setNotes(null);
                    tRows.setRow19(truckApprovalRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.truck)) {
                    tRows.setRow19(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        wayOfTransportRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    wayOfTransportRow.setRiskCategory(s.toString());
                    tRows.setRow20(wayOfTransportRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    wayOfTransportRow.setRiskCategory(null);
                    tRows.setRow20(wayOfTransportRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.transport)) {
                    tRows.setRow20(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        wayOfTransportNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    wayOfTransportRow.setNotes(s.toString());
                    tRows.setRow20(wayOfTransportRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    wayOfTransportRow.setNotes(null);
                    tRows.setRow20(wayOfTransportRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.transport)) {
                    tRows.setRow20(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        bannedMixedCargoRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    bannedMixedCargoRow.setRiskCategory(s.toString());
                    tRows.setRow21(bannedMixedCargoRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    bannedMixedCargoRow.setRiskCategory(null);
                    tRows.setRow21(bannedMixedCargoRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.banned)) {
                    tRows.setRow21(bannedMixedCargoRow);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        bannedMixedCargoNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    bannedMixedCargoRow.setNotes(s.toString());
                    tRows.setRow21(bannedMixedCargoRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    bannedMixedCargoRow.setNotes(null);
                    tRows.setRow21(bannedMixedCargoRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.banned)) {
                    tRows.setRow21(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        handlingRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    handlingRow.setRiskCategory(s.toString());
                    tRows.setRow22_1(handlingRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    handlingRow.setRiskCategory(null);
                    tRows.setRow22_1(handlingRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.handling)) {
                    tRows.setRow22_1(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        handlingNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    handlingRow.setNotes(s.toString());
                    tRows.setRow22_1(handlingRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    handlingRow.setNotes(null);
                    tRows.setRow22_1(handlingRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.handling)) {
                    tRows.setRow22_1(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        loadingRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    loadingRow.setRiskCategory(s.toString());
                    tRows.setRow22_2(loadingRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    loadingRow.setRiskCategory(null);
                    tRows.setRow22_2(loadingRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.loading)) {
                    tRows.setRow22_2(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        loadingNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    loadingRow.setNotes(s.toString());
                    tRows.setRow22_2(loadingRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    loadingRow.setNotes(null);
                    tRows.setRow22_2(loadingRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.loading)) {
                    tRows.setRow22_2(null);
                    control.setTRows(tRows);
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        securingCargoRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    securingCargoRow.setRiskCategory(s.toString());
                    tRows.setRow22_3(securingCargoRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    securingCargoRow.setRiskCategory(null);
                    tRows.setRow22_3(securingCargoRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.securing)) {
                    tRows.setRow22_3(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        securingCargoNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    securingCargoRow.setNotes(s.toString());
                    tRows.setRow22_3(securingCargoRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    securingCargoRow.setNotes(null);
                    tRows.setRow22_3(securingCargoRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.securing)) {
                    tRows.setRow22_3(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        leakageRiskCategotyEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    leakageRow.setRiskCategory(s.toString());
                    tRows.setRow23_1(leakageRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    leakageRow.setRiskCategory(null);
                    tRows.setRow23_1(leakageRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.leakage)) {
                    tRows.setRow23_1(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        leakageNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0 ) {
                    leakageRow.setNotes(s.toString());
                    tRows.setRow23_1(leakageRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    leakageRow.setNotes(null);
                    tRows.setRow23_1(leakageRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.leakage)) {
                    tRows.setRow23_1(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        damagesRiskCategotyEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    damagesRow.setRiskCategory(s.toString());
                    tRows.setRow23_2(damagesRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    damagesRow.setRiskCategory(null);
                    tRows.setRow23_2(damagesRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.damages)) {
                    tRows.setRow23_2(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        damagesNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    damagesRow.setNotes(s.toString());
                    tRows.setRow23_2(damagesRow);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    damagesRow.setNotes(null);
                    tRows.setRow23_2(damagesRow);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.damages)) {
                    tRows.setRow23_2(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void clearFieldsForView(Transport transport) {
        switch (transport) {
            case handling:
                handlingRow.setNotes("");
                handlingRow.setRiskCategory("");
                handlingRow.setImposed(false);
                handlingRow.setBanned(false);
                tRows.setRow22_1(godsApprovalRow);
                control.setTRows(tRows);
                break;

            case loading:
                loadingRow.setNotes("");
                loadingRow.setRiskCategory("");
                loadingRow.setImposed(false);
                loadingRow.setBanned(false);
                tRows.setRow22_2(loadingRow);
                control.setTRows(tRows);
                break;

            case securing:
                securingCargoRow.setNotes("");
                securingCargoRow.setRiskCategory("");
                securingCargoRow.setImposed(false);
                securingCargoRow.setBanned(false);
                tRows.setRow22_3(securingCargoRow);
                control.setTRows(tRows);
                break;

            case leakage:
                leakageRow.setNotes("");
                leakageRow.setRiskCategory("");
                leakageRow.setBanned(false);
                leakageRow.setImposed(false);
                tRows.setRow23_1(leakageRow);
                control.setTRows(tRows);
                break;

            case damages:
                damagesRow.setRiskCategory("");
                damagesRow.setNotes("");
                damagesRow.setImposed(false);
                damagesRow.setBanned(false);
                tRows.setRow23_2(damagesRow);
                control.setTRows(tRows);
                break;

            case gods:
                godsApprovalRow.setRiskCategory("");
                godsApprovalRow.setNotes("");
                godsApprovalRow.setImposed(false);
                godsApprovalRow.setBanned(false);
                tRows.setRow18(godsApprovalRow);
                control.setTRows(tRows);
                break;

            case truck:
                truckApprovalRow.setRiskCategory("");
                truckApprovalRow.setNotes("");
                truckApprovalRow.setImposed(false);
                truckApprovalRow.setBanned(false);
                tRows.setRow19(truckApprovalRow);
                control.setTRows(tRows);
                break;

            case transport:
                wayOfTransportRow.setRiskCategory("");
                wayOfTransportRow.setNotes("");
                wayOfTransportRow.setImposed(false);
                wayOfTransportRow.setBanned(false);
                tRows.setRow20(wayOfTransportRow);
                control.setTRows(tRows);
                break;

            case banned:
                bannedMixedCargoRow.setRiskCategory("");
                bannedMixedCargoRow.setNotes("");
                bannedMixedCargoRow.setImposed(false);
                bannedMixedCargoRow.setBanned(false);
                tRows.setRow21(bannedMixedCargoRow);
                control.setTRows(tRows);
        }

    }

    private boolean viewEmptyFor(Transport transport) {
        switch (transport) {
            case gods:
                if (godsApprovedRiskCategoryEditText.getText().length() > 0
                        || godsApprovedNotesEditText.getText().length() > 0
                        || godsApprovedRadioGroup.getCheckedRadioButtonId() != -1
                        || godsApprovedABCRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case truck:
                if (truckApprovedRiskCategoryEditText.getText().length() > 0
                        || truckApprovedNotesEditText.getText().length() > 0
                        || truckApprovedRadioGroup.getCheckedRadioButtonId() != -1
                        || truckApprovedABCRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case transport:
                if (wayOfTransportRiskCategoryEditText.getText().length() > 0
                        || wayOfTransportNotesEditText.getText().length() > 0
                        || wayOfTransportRadioGroup.getCheckedRadioButtonId() != -1
                        || wayOfTransportABCRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case banned:
                if (bannedMixedCargoRiskCategoryEditText.getText().length() > 0
                        || bannedMixedCargoNotesEditText.getText().length() > 0
                        || bannedMixedCargoRadioGroup.getCheckedRadioButtonId() != -1
                        || bannedMixedCargoABCRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case handling:
                if (handlingRiskCategoryEditText.getText().length() > 0
                        || handlingNotesEditText.getText().length() > 0
                        || handlingRadioGroup.getCheckedRadioButtonId() != -1
                        || handlingABCRadioButton.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case loading:
                if (loadingRiskCategoryEditText.getText().length() > 0
                        || loadingNotesEditText.getText().length() > 0
                        || loadingRadioGroup.getCheckedRadioButtonId() != -1
                        || loadingABCRadioButton.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case securing:
                if (securingCargoNotesEditText.getText().length() > 0
                        || securingCargoNotesEditText.getText().length() > 0
                        || securingCargoRadioGroup.getCheckedRadioButtonId() != -1
                        || securingCargoABCRadioButton.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case damages:
                if (damagesRiskCategotyEditText.getText().length() > 0
                        || damagesNotesEditText.getText().length() > 0
                        || damagesRadioGroup.getCheckedRadioButtonId() != -1
                        || damagesABCRadioButton.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case leakage:
                if (leakageRiskCategotyEditText.getText().length() > 0
                        || leakageNotesEditText.getText().length() > 0
                        || leakageRadioGroup.getCheckedRadioButtonId() != -1
                        || leakageABCRadioButton.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
        }
        return true;
    }
}