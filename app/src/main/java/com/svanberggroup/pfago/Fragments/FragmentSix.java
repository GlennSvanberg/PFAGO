package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentSix extends Fragment {


    private static final String NEW_CONTROL = "new_control";

    private RadioGroup stopBlockABCRadioGroup;
    private EditText stopBlockRiskCategoryEditText;
    private RadioGroup stopBlockRadioGroup;
    private EditText stopBlockNotesEditText;

    private RadioGroup warningDeviceABCRadioGroup;
    private EditText warningDeviceRiskCategoryEditText;
    private RadioGroup warningDeviceRadioGroup;
    private EditText warningDeviceNotesEditText;

    private RadioGroup safetyEquipmentABCRadioGroup;
    private EditText safetyEquipmentRiskCategoryEditText;
    private RadioGroup safetyEquipmentRadioGroup;
    private EditText safetyEquipmentNotesEditText;

    private RadioGroup portableLightSourceABCRadioGroup;
    private EditText portableLightSourceCategoryEditText;
    private RadioGroup portableLightSourceRadioGroup;
    private EditText portableLightSourceNotesEditText;

    private RadioGroup godsSpecificEquipmentABCRadioGroup;
    private EditText godsSpecificEquipmentRiskCategoryEditText;
    private RadioGroup godsSpecificEquipmentRadioGroup;
    private EditText godsSpecificEquipmentNotesEditText;

    private RadioGroup fireExtinguisherABCRadioGroup;
    private EditText fireExtinguisherRiskCategoryEditText;
    private RadioGroup fireExtinguisherRadioGroup;
    private EditText fireExtinguisherNotesEditText;

    private Control control;

    public FragmentSix() {
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

        addSubViewToView(view);
        setVisibilityGone(view);
        handleVisibility();
        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    private void addSubViewToView(View view) {
        stopBlockABCRadioGroup = view.findViewById(R.id.stopBlockABCRadioGroup);
        stopBlockRiskCategoryEditText = view.findViewById(R.id.stopBlockRiskCategoryEditText);
        stopBlockRadioGroup = view.findViewById(R.id.stopBlockRadioGroup);
        stopBlockNotesEditText = view.findViewById(R.id.stopBlockNotesRadioButton);

        warningDeviceABCRadioGroup = view.findViewById(R.id.warningDeviceABCRadioGroup);
        warningDeviceRiskCategoryEditText = view.findViewById(R.id.warningDeviceRiskCategoryEditText);
        warningDeviceRadioGroup = view.findViewById(R.id.warningDeviceRadioGroup);
        warningDeviceNotesEditText = view.findViewById(R.id.warningDeviceNotesRadioButton);

        safetyEquipmentABCRadioGroup = view.findViewById(R.id.safetyEquipmentABCRadioGroup);
        safetyEquipmentRiskCategoryEditText = view.findViewById(R.id.safetyEquipmentRiskCategoryEditText);
        safetyEquipmentRadioGroup = view.findViewById(R.id.safetyEquipmentRadioGroup);
        safetyEquipmentNotesEditText = view.findViewById(R.id.safetyEquipmentNotesRadioButton);

        portableLightSourceABCRadioGroup = view.findViewById(R.id.portableLightSourceABCRadioGroup);
        portableLightSourceCategoryEditText = view.findViewById(R.id.portableLightSourceRiskCategoryEditText);
        portableLightSourceRadioGroup = view.findViewById(R.id.portableLightSourceRadioGroup);
        portableLightSourceNotesEditText = view.findViewById(R.id.portableLightSourceNotesRadioButton);

        godsSpecificEquipmentABCRadioGroup = view.findViewById(R.id.godsSpecificEquipmentABCRadioGroup);
        godsSpecificEquipmentRiskCategoryEditText = view.findViewById(R.id.godsSpecificEquipmentRiskCategoryEditText);
        godsSpecificEquipmentRadioGroup = view.findViewById(R.id.godsSpecificEquipmentRadioGroup);
        godsSpecificEquipmentNotesEditText = view.findViewById(R.id.godsSpecificEquipmentNotesRadioButton);

        fireExtinguisherABCRadioGroup = view.findViewById(R.id.fireExtinguisherABCRadioGroup);
        fireExtinguisherRiskCategoryEditText = view.findViewById(R.id.fireExtinguisherRiskCategoryEditText);
        fireExtinguisherRadioGroup = view.findViewById(R.id.fireExtinguisherRadioGroup);
        fireExtinguisherNotesEditText = view.findViewById(R.id.fireExtinguisherNotesRadioButton);
    }

    private void setVisibilityGone(View view) {
        stopBlockRiskCategoryEditText.setVisibility(view.GONE);
        stopBlockRadioGroup.setVisibility(view.GONE);
        stopBlockNotesEditText.setVisibility(view.GONE);

        warningDeviceRiskCategoryEditText.setVisibility(view.GONE);
        warningDeviceRadioGroup.setVisibility(view.GONE);
        warningDeviceNotesEditText.setVisibility(view.GONE);

        safetyEquipmentRiskCategoryEditText.setVisibility(view.GONE);
        safetyEquipmentRadioGroup.setVisibility(view.GONE);
        safetyEquipmentNotesEditText.setVisibility(view.GONE);

        portableLightSourceCategoryEditText.setVisibility(view.GONE);
        portableLightSourceRadioGroup.setVisibility(view.GONE);
        portableLightSourceNotesEditText.setVisibility(view.GONE);

        godsSpecificEquipmentRiskCategoryEditText.setVisibility(view.GONE);
        godsSpecificEquipmentRadioGroup.setVisibility(view.GONE);
        godsSpecificEquipmentNotesEditText.setVisibility(view.GONE);

        fireExtinguisherRiskCategoryEditText.setVisibility(view.GONE);
        fireExtinguisherRadioGroup .setVisibility(view.GONE);
        fireExtinguisherNotesEditText.setVisibility(view.GONE);
    }

    private void handleVisibility() {
        stopBlockABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.stopBlockNotApprovedRadioButton) {
                    stopBlockRiskCategoryEditText.setVisibility(View.VISIBLE);
                    stopBlockRadioGroup.setVisibility(View.VISIBLE);
                    stopBlockNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    stopBlockRiskCategoryEditText.setVisibility(View.GONE);
                    stopBlockRadioGroup.setVisibility(View.GONE);
                    stopBlockNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        warningDeviceABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.warningDeviceNotApprovedRadioButton) {
                    warningDeviceRiskCategoryEditText.setVisibility(View.VISIBLE);
                    warningDeviceRadioGroup.setVisibility(View.VISIBLE);
                    warningDeviceNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    warningDeviceRiskCategoryEditText.setVisibility(View.GONE);
                    warningDeviceRadioGroup.setVisibility(View.GONE);
                    warningDeviceNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        safetyEquipmentABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.safetyEquipmentNotApprovedRadioButton) {
                    safetyEquipmentRiskCategoryEditText.setVisibility(View.VISIBLE);
                    safetyEquipmentRadioGroup.setVisibility(View.VISIBLE);
                    safetyEquipmentNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    safetyEquipmentRiskCategoryEditText.setVisibility(View.GONE);
                    safetyEquipmentRadioGroup.setVisibility(View.GONE);
                    safetyEquipmentNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        portableLightSourceABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.portableLightSourceNotApprovedRadioButton) {
                    portableLightSourceCategoryEditText.setVisibility(View.VISIBLE);
                    portableLightSourceRadioGroup.setVisibility(View.VISIBLE);
                    portableLightSourceNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    portableLightSourceCategoryEditText.setVisibility(View.GONE);
                    portableLightSourceRadioGroup.setVisibility(View.GONE);
                    portableLightSourceNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        godsSpecificEquipmentABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.godsSpecificEquipmentNotApprovedRadioButton) {
                    godsSpecificEquipmentRiskCategoryEditText.setVisibility(View.VISIBLE);
                    godsSpecificEquipmentRadioGroup.setVisibility(View.VISIBLE);
                    godsSpecificEquipmentNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    godsSpecificEquipmentRiskCategoryEditText.setVisibility(View.GONE);
                    godsSpecificEquipmentRadioGroup.setVisibility(View.GONE);
                    godsSpecificEquipmentNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        fireExtinguisherABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.fireExtinguisherNotApprovedRadioButton) {
                    fireExtinguisherRiskCategoryEditText.setVisibility(View.VISIBLE);
                    fireExtinguisherRadioGroup.setVisibility(View.VISIBLE);
                    fireExtinguisherNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    fireExtinguisherRiskCategoryEditText.setVisibility(View.GONE);
                    fireExtinguisherRadioGroup.setVisibility(View.GONE);
                    fireExtinguisherNotesEditText.setVisibility(View.GONE);
                }
            }
        });
    }
}

