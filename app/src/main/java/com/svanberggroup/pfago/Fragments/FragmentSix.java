package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.Editable;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Activities.AddControlActivity;
import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.TransportRows;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentSix extends Fragment {

    private enum Transport {
        stopBlock,
        warningDevice,
        saftey,
        portable,
        gods,
        fire
    }


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
    private TransportRows tRows;
    private ControlRow stopBlockRow281;
    private ControlRow warningDeviceRow282;
    private ControlRow safetyRow283;
    private ControlRow portableRow284;
    private ControlRow godsRow29;
    private ControlRow fireRow31;




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

        control = (Control) getArguments().getSerializable(NEW_CONTROL);

        if (control.getTRows() != null) {
            tRows = control.getTRows();
        } else {
            tRows = new TransportRows();
        }

        stopBlockRow281 = tRows.getRow28_1();
        warningDeviceRow282 = tRows.getRow28_2();
        safetyRow283 = tRows.getRow28_3();
        portableRow284 = tRows.getRow28_4();
        godsRow29 = tRows.getRow29();
        fireRow31 = tRows.getRow31();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_six, container, false);

        addSubViewToView(view);
        setVisibilityGone();
        handleRadioButtonInput();
        handleTextInput();
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

    private void setVisibilityGone() {
        stopBlockRiskCategoryEditText.setVisibility(View.GONE);
        stopBlockRadioGroup.setVisibility(View.GONE);
        stopBlockNotesEditText.setVisibility(View.GONE);

        warningDeviceRiskCategoryEditText.setVisibility(View.GONE);
        warningDeviceRadioGroup.setVisibility(View.GONE);
        warningDeviceNotesEditText.setVisibility(View.GONE);

        safetyEquipmentRiskCategoryEditText.setVisibility(View.GONE);
        safetyEquipmentRadioGroup.setVisibility(View.GONE);
        safetyEquipmentNotesEditText.setVisibility(View.GONE);

        portableLightSourceCategoryEditText.setVisibility(View.GONE);
        portableLightSourceRadioGroup.setVisibility(View.GONE);
        portableLightSourceNotesEditText.setVisibility(View.GONE);

        godsSpecificEquipmentRiskCategoryEditText.setVisibility(View.GONE);
        godsSpecificEquipmentRadioGroup.setVisibility(View.GONE);
        godsSpecificEquipmentNotesEditText.setVisibility(View.GONE);

        fireExtinguisherRiskCategoryEditText.setVisibility(View.GONE);
        fireExtinguisherRadioGroup .setVisibility(View.GONE);
        fireExtinguisherNotesEditText.setVisibility(View.GONE);
    }

    private void setVisibilityFor(Transport transport, int visibility) {
        switch (transport) {
            case stopBlock:
                stopBlockRiskCategoryEditText.setVisibility(visibility);
                stopBlockNotesEditText.setVisibility(visibility);
                stopBlockRadioGroup.setVisibility(visibility);
                break;
            case warningDevice:
                warningDeviceRiskCategoryEditText.setVisibility(visibility);
                warningDeviceNotesEditText.setVisibility(visibility);
                warningDeviceRadioGroup.setVisibility(visibility);
                break;
            case saftey:
                safetyEquipmentRiskCategoryEditText.setVisibility(visibility);
                safetyEquipmentNotesEditText.setVisibility(visibility);
                safetyEquipmentRadioGroup.setVisibility(visibility);
                break;
            case portable:
                portableLightSourceCategoryEditText.setVisibility(visibility);
                portableLightSourceNotesEditText.setVisibility(visibility);
                portableLightSourceRadioGroup.setVisibility(visibility);
                break;
            case gods:
                godsSpecificEquipmentRiskCategoryEditText.setVisibility(visibility);
                godsSpecificEquipmentNotesEditText.setVisibility(visibility);
                godsSpecificEquipmentRadioGroup.setVisibility(visibility);
                break;
            case fire:
                fireExtinguisherRiskCategoryEditText.setVisibility(visibility);
                fireExtinguisherNotesEditText.setVisibility(visibility);
                fireExtinguisherRadioGroup.setVisibility(visibility);
        }
    }

    private void handleRadioButtonInput() {
        stopBlockABCRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.stopBlockControlledRadioButton:
                    setVisibilityFor(Transport.stopBlock, View.GONE);
                    stopBlockRow281.setField(ControlRow.Field.Controlled);
                    clearFieldsForView(Transport.stopBlock);
                    break;

                case R.id.stopBlockNotApprovedRadioButton:
                    ((AddControlActivity) getActivity()).addBreakingTheLawFragment();
                    setVisibilityFor(Transport.stopBlock, View.VISIBLE);
                    stopBlockRow281.setField(ControlRow.Field.BreakingTheLaw);
                    tRows.setRow28_1(stopBlockRow281);
                    control.setTRows(tRows);
                    break;

                case R.id.stopBlockNotApplicableRadioButton:
                    setVisibilityFor(Transport.stopBlock, View.GONE);
                    stopBlockRow281.setField(ControlRow.Field.NotApplicable);
                    clearFieldsForView(Transport.stopBlock);
                    break;
            }
        });
        warningDeviceABCRadioGroup.setOnCheckedChangeListener( (group, checkedId) -> {
            switch (checkedId) {
                case R.id.warningDeviceControlledRadioButton:
                    setVisibilityFor(Transport.warningDevice, View.GONE);
                    warningDeviceRow282.setField(ControlRow.Field.Controlled);
                    clearFieldsForView(Transport.warningDevice);
                    break;

                case R.id.warningDeviceNotApprovedRadioButton:
                    ((AddControlActivity) getActivity()).addBreakingTheLawFragment();
                    setVisibilityFor(Transport.warningDevice, View.VISIBLE);
                    warningDeviceRow282.setField(ControlRow.Field.BreakingTheLaw);
                    tRows.setRow28_2(warningDeviceRow282);
                    control.setTRows(tRows);
                    break;

                case R.id.warningDeviceNotApplicableRadioButton:
                    setVisibilityFor(Transport.warningDevice, View.GONE);
                    warningDeviceRow282.setField(ControlRow.Field.NotApplicable);
                    clearFieldsForView(Transport.warningDevice);
                    break;
            }
        });
        safetyEquipmentABCRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.safetyEquipmentControlledRadioButton:
                    setVisibilityFor(Transport.saftey, View.GONE);
                    safetyRow283.setField(ControlRow.Field.Controlled);
                    clearFieldsForView(Transport.saftey);
                    break;

                case R.id.safetyEquipmentNotApprovedRadioButton:
                    ((AddControlActivity) getActivity()).addBreakingTheLawFragment();
                    setVisibilityFor(Transport.saftey, View.VISIBLE);
                    safetyRow283.setField(ControlRow.Field.BreakingTheLaw);
                    tRows.setRow28_3(safetyRow283);
                    control.setTRows(tRows);
                    break;

                case R.id.safetyEquipmentNotApplicableRadioButton:
                    setVisibilityFor(Transport.saftey, View.GONE);
                    safetyRow283.setField(ControlRow.Field.NotApplicable);
                    clearFieldsForView(Transport.saftey);
                    break;
            }
        });
        portableLightSourceABCRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.portableLightSourceControlledRadioButton:
                    setVisibilityFor(Transport.portable, View.GONE);
                    portableRow284.setField(ControlRow.Field.Controlled);
                    clearFieldsForView(Transport.portable);
                    break;

                case R.id.portableLightSourceNotApprovedRadioButton:
                    ((AddControlActivity) getActivity()).addBreakingTheLawFragment();
                    setVisibilityFor(Transport.portable, View.VISIBLE);
                    portableRow284.setField(ControlRow.Field.BreakingTheLaw);
                    tRows.setRow28_4(portableRow284);
                    control.setTRows(tRows);
                    break;

                case R.id.portableLightSourceNotApplicableRadioButton:
                    setVisibilityFor(Transport.portable, View.GONE);
                    portableRow284.setField(ControlRow.Field.NotApplicable);
                    clearFieldsForView(Transport.portable);
                    break;
            }
        });
        godsSpecificEquipmentABCRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.godsSpecificEquipmentControlledRadioButton:
                    setVisibilityFor(Transport.gods, View.GONE);
                    godsRow29.setField(ControlRow.Field.Controlled);
                    clearFieldsForView(Transport.gods);
                    break;

                case R.id.godsSpecificEquipmentNotApprovedRadioButton:
                    ((AddControlActivity) getActivity()).addBreakingTheLawFragment();
                    setVisibilityFor(Transport.gods, View.VISIBLE);
                    godsRow29.setField(ControlRow.Field.BreakingTheLaw);
                    tRows.setRow29(godsRow29);
                    control.setTRows(tRows);
                    break;

                case R.id.godsSpecificEquipmentNotApplicableRadioButton:
                    setVisibilityFor(Transport.gods, View.GONE);
                    godsRow29.setField(ControlRow.Field.NotApplicable);
                    clearFieldsForView(Transport.gods);
                    break;
            }
        });
        fireExtinguisherABCRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.fireExtinguisherControlledRadioButton:
                    setVisibilityFor(Transport.fire, View.GONE);
                    fireRow31.setField(ControlRow.Field.Controlled);
                    clearFieldsForView(Transport.fire);
                    break;

                case R.id.fireExtinguisherNotApprovedRadioButton:
                    ((AddControlActivity) getActivity()).addBreakingTheLawFragment();
                    setVisibilityFor(Transport.fire, View.VISIBLE);
                    fireRow31.setField(ControlRow.Field.BreakingTheLaw);
                    tRows.setRow31(fireRow31);
                    control.setTRows(tRows);
                    break;

                case R.id.fireExtinguisherNotApplicableRadioButton:
                    setVisibilityFor(Transport.fire, View.GONE);
                    fireRow31.setField(ControlRow.Field.NotApplicable);
                    clearFieldsForView(Transport.gods);
                    break;
            }
        });

    }

    private void handleTextInput() {
        stopBlockRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    stopBlockRow281.setRiskCategory(s.toString());
                    tRows.setRow28_1(stopBlockRow281);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    if(stopBlockRow281 != null){
                        stopBlockRow281.setRiskCategory(null);
                        tRows.setRow28_1(stopBlockRow281);
                    }
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.stopBlock)) {
                    tRows.setRow24(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        stopBlockNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    stopBlockRow281.setNotes(s.toString());
                    tRows.setRow28_1(stopBlockRow281);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    stopBlockRow281.setNotes(null);
                    tRows.setRow28_1(stopBlockRow281);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.stopBlock)) {
                    tRows.setRow28_1(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        warningDeviceRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    warningDeviceRow282.setRiskCategory(s.toString());
                    tRows.setRow28_2(warningDeviceRow282);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    warningDeviceRow282.setRiskCategory(null);
                    tRows.setRow28_2(warningDeviceRow282);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.warningDevice)) {
                    tRows.setRow28_2(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        warningDeviceNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    warningDeviceRow282.setNotes(s.toString());
                    tRows.setRow28_2(warningDeviceRow282);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    warningDeviceRow282.setNotes(null);
                    tRows.setRow28_2(warningDeviceRow282);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.warningDevice)) {
                    tRows.setRow28_2(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        safetyEquipmentRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    safetyRow283.setRiskCategory(s.toString());
                    tRows.setRow28_3(safetyRow283);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    safetyRow283.setRiskCategory(null);
                    tRows.setRow28_3(safetyRow283);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.saftey)) {
                    tRows.setRow28_3(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        safetyEquipmentNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    safetyRow283.setNotes(s.toString());
                    tRows.setRow28_3(safetyRow283);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    safetyRow283.setNotes(null);
                    tRows.setRow28_3(safetyRow283);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.saftey)) {
                    tRows.setRow28_3(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        portableLightSourceCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    portableRow284.setRiskCategory(s.toString());
                    tRows.setRow28_4(portableRow284);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    portableRow284.setRiskCategory(null);
                    tRows.setRow28_4(portableRow284);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.portable)) {
                    tRows.setRow28_4(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        portableLightSourceNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    portableRow284.setNotes(s.toString());
                    tRows.setRow28_4(portableRow284);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    portableRow284.setNotes(null);
                    tRows.setRow28_4(portableRow284);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.portable)) {
                    tRows.setRow28_4(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        godsSpecificEquipmentRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    godsRow29.setRiskCategory(s.toString());
                    tRows.setRow29(godsRow29);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    godsRow29.setRiskCategory(null);
                    tRows.setRow29(godsRow29);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.gods)) {
                    tRows.setRow29(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        godsSpecificEquipmentNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    godsRow29.setNotes(s.toString());
                    tRows.setRow29(godsRow29);
                    control.setTRows(tRows);

                } else if (s.length() == 0) {
                    godsRow29.setNotes(null);
                    tRows.setRow29(godsRow29);
                    control.setTRows(tRows);

                }
                if (viewEmptyFor(Transport.gods)) {
                    tRows.setRow29(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        fireExtinguisherRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    fireRow31.setRiskCategory(s.toString());
                    tRows.setRow31(fireRow31);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    fireRow31.setRiskCategory(null);
                    tRows.setRow31(fireRow31);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.gods)) {
                    tRows.setRow31(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        fireExtinguisherNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    fireRow31.setNotes(s.toString());
                    tRows.setRow31(fireRow31);
                    control.setTRows(tRows);

                } else if (s.length() == 0) {
                    fireRow31.setNotes(null);
                    tRows.setRow31(fireRow31);
                    control.setTRows(tRows);

                }
                if (viewEmptyFor(Transport.gods)) {
                    tRows.setRow31(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void clearFieldsForView(Transport transport) {

        switch (transport) {
            case stopBlock:
                stopBlockRow281.setNotes("");
                stopBlockRow281.setRiskCategory("");
                stopBlockRow281.setImposed(false);
                stopBlockRow281.setBanned(false);
                tRows.setRow28_1(stopBlockRow281);
                control.setTRows(tRows);
                break;

            case warningDevice:
                warningDeviceRow282.setNotes("");
                warningDeviceRow282.setRiskCategory("");
                warningDeviceRow282.setImposed(false);
                warningDeviceRow282.setBanned(false);
                tRows.setRow28_2(warningDeviceRow282);
                control.setTRows(tRows);
                break;

            case saftey:
                safetyRow283.setNotes("");
                safetyRow283.setRiskCategory("");
                safetyRow283.setImposed(false);
                safetyRow283.setBanned(false);
                tRows.setRow28_3(safetyRow283);
                control.setTRows(tRows);
                break;

            case portable:
                portableRow284.setNotes("");
                portableRow284.setRiskCategory("");
                portableRow284.setBanned(false);
                portableRow284.setImposed(false);
                tRows.setRow28_4(portableRow284);
                control.setTRows(tRows);
                break;

            case gods:
                godsRow29.setRiskCategory("");
                godsRow29.setNotes("");
                godsRow29.setImposed(false);
                godsRow29.setBanned(false);
                tRows.setRow29(godsRow29);
                control.setTRows(tRows);
                break;

            case fire:
                fireRow31.setRiskCategory("");
                fireRow31.setNotes("");
                fireRow31.setImposed(false);
                fireRow31.setBanned(false);
                tRows.setRow31(fireRow31);
                control.setTRows(tRows);
                break;
        }
    }

    private boolean viewEmptyFor(Transport transport) {
        switch (transport) {
            case stopBlock:
                if (stopBlockRiskCategoryEditText.getText().length() > 0
                        || stopBlockNotesEditText.getText().length() > 0
                        || stopBlockABCRadioGroup.getCheckedRadioButtonId() != -1
                        || stopBlockRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case warningDevice:
                if (warningDeviceRiskCategoryEditText.getText().length() > 0
                        || warningDeviceNotesEditText.getText().length() > 0
                        || warningDeviceABCRadioGroup.getCheckedRadioButtonId() != -1
                        || warningDeviceRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case saftey:
                if (safetyEquipmentRiskCategoryEditText.getText().length() > 0
                        || safetyEquipmentNotesEditText.getText().length() > 0
                        || safetyEquipmentABCRadioGroup.getCheckedRadioButtonId() != -1
                        || safetyEquipmentRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case portable:
                if (portableLightSourceCategoryEditText.getText().length() > 0
                        || portableLightSourceNotesEditText.getText().length() > 0
                        || portableLightSourceABCRadioGroup.getCheckedRadioButtonId() != -1
                        || portableLightSourceRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case gods:
                if (godsSpecificEquipmentRiskCategoryEditText.getText().length() > 0
                        || godsSpecificEquipmentNotesEditText.getText().length() > 0
                        || godsSpecificEquipmentABCRadioGroup.getCheckedRadioButtonId() != -1
                        || godsSpecificEquipmentRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case fire:
                if (fireExtinguisherRiskCategoryEditText.getText().length() > 0
                        || fireExtinguisherNotesEditText.getText().length() > 0
                        || fireExtinguisherABCRadioGroup.getCheckedRadioButtonId() != -1
                        || fireExtinguisherRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
        }
        return true;
    }
}

