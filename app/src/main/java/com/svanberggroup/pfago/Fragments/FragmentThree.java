package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.Quantity;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentThree extends Fragment {


    private static final String NEW_CONTROL = "new_control";

    private EditText amountEditText;
    private RadioGroup amountRadioGroup;

    private RadioGroup packagingStandardRadioGroup;

    private RadioGroup valueQuantityRadioGroup;
    private EditText valueQuantityEditText;

    private RadioGroup transportedWithRadioGroup;

    private RadioGroup transportedAccordingRadioGroup;

    private Control control;
    private Quantity quantity;

    private FragmentThree() {
    }

    public static FragmentThree newInstance(Control control) {
        FragmentThree fragment = new FragmentThree();
        Bundle args = new Bundle();
        args.putSerializable(NEW_CONTROL, (Serializable) control);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        control = (Control) getArguments().getSerializable(NEW_CONTROL);

        quantity = new Quantity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        addViewsToFields(view);
        handleTextChanged();
        handleRadioButtonChecked();

        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    private void addViewsToFields(View view) {
        amountEditText = view.findViewById(R.id.amountEditText);
        amountRadioGroup = view.findViewById(R.id.amountRadioGroup);

        packagingStandardRadioGroup = view.findViewById(R.id.packagingStandardRadioGroup);

        valueQuantityRadioGroup = view.findViewById(R.id.valueQuantityRadioGroup);
        valueQuantityEditText = view.findViewById(R.id.valueQuantityEditText);

        transportedWithRadioGroup = view.findViewById(R.id.transportedWithRadioGroup);
        transportedAccordingRadioGroup = view.findViewById(R.id.transportedAccordingRadioGroup);
    }

    private void handleTextChanged() {
        amountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    quantity.setQuantity(Integer.parseInt(s.toString()));
                    control.setQuantity(quantity);
                } else if (s.length() == 0) {
                    control.setQuantity(null);
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        valueQuantityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    control.setValueQuantity(Integer.parseInt(s.toString()));
                } else if (s.length() == 0) {
                    control.setValueQuantity(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void handleRadioButtonChecked() {
        amountRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.kgRadioButton:
                        quantity.setQuantityType(Quantity.QuantityType.KG);
                        control.setQuantity(quantity);
                    case R.id.literRadioButton:
                        quantity.setQuantityType(Quantity.QuantityType.Liter);
                        control.setQuantity(quantity);
                }
            }
        });
        packagingStandardRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.LQRadioButton:

                        quantity.setPackagingStandard(Quantity.PackagingStandard.LQ);
                        control.setQuantity(quantity);
                    case R.id.EQRadioButton:
                        quantity.setPackagingStandard(Quantity.PackagingStandard.EQ);
                        control.setQuantity(quantity);
                    case R.id.emptyNotCleandRadioButton:
                        quantity.setPackagingStandard(Quantity.PackagingStandard.EmptyNotCleaned);
                        control.setQuantity(quantity);
                }
            }
        });
        valueQuantityRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.valueQuantityTrueRadioButton:
                        control.setValueQuantityExceeded(true);
                    case R.id.valueQuantityFalseRadioButton:
                        control.setValueQuantityExceeded(false);
                }
            }
        });
        transportedWithRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tankRadioButton:
                        control.setTransportType(Control.TransportType.Tank);
                    case R.id.bulkRadioButton:
                        control.setTransportType(Control.TransportType.Bulk);
                    case R.id.mixedCargoRadioButton:
                        control.setTransportType(Control.TransportType.MixedCargo);
                    case R.id.otherRadioButton:
                        control.setTransportType(Control.TransportType.Other);
                }
            }
        });
        transportedAccordingRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.adrRadioButton:
                        control.setTransportStandard(Control.TransportStandard.ADR);
                    case R.id.adrsRadioButton:
                        control.setTransportStandard(Control.TransportStandard.ADRS);
                    case R.id.imdgRadioButton:
                        control.setTransportStandard(Control.TransportStandard.IMDG);
                    case R.id.icoaRadioButton:
                        control.setTransportStandard(Control.TransportStandard.ICAO);
                    case R.id.ridRadioButton:
                        control.setTransportStandard(Control.TransportStandard.RID);
                    case R.id.ridsRadioButton:
                        control.setTransportStandard(Control.TransportStandard.RIDS);
                    case R.id.baltikSeaRadioButton:
                        control.setTransportStandard(Control.TransportStandard.MOU);
                }
            }
        });
    }
}