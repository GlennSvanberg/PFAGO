package com.svanberggroup.pfago.Fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.Transporter;
import com.svanberggroup.pfago.R;

import java.io.Serializable;
import java.lang.reflect.Array;

public class FragmentTwo extends Fragment {


    private static final String NEW_CONTROL = "new_control";

    private EditText transporterEditText;
    private EditText transporterPhoneEditText;
    private EditText transporterAddressEditText;
    private EditText transporterZIPEditText;
    private EditText transporterCityEditText;
    private EditText transporterCountryEditText;

    private EditText driverEditText;
    private EditText driverPhoneEditText;
    private EditText driverAddressEditText;
    private EditText driverZIPEditText;
    private EditText driverCityEditText;
    private EditText driverCountryEditText;

    private EditText coDriverEditText;
    private EditText coDriverPhoneEditText;
    private EditText coDriverAddressEditText;
    private EditText coDriverZIPEditText;
    private EditText coDriverCityEditText;
    private EditText coDriverCountryEditText;

    private Transporter carrier;
    private Transporter driver;
    private Transporter coDriver;

    private Control control;

    private FragmentTwo() {
    }

    public static FragmentTwo newInstance(Control control) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putSerializable(NEW_CONTROL, (Serializable) control);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        control = (Control) getArguments().getSerializable(NEW_CONTROL);

        carrier = new Transporter();
        driver = new Transporter();
        coDriver = new Transporter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        addViewById(view);
        handleTextChangedforCarrier();
        handleTextChangedforDriver();
        handleTextChangedforCoDriver();

        return  view;
    }

    private void addViewById(View view) {

        transporterEditText        = view.findViewById(R.id.transporterEditText);
        transporterAddressEditText = view.findViewById(R.id.transporterAddressEditText);
        transporterPhoneEditText   = view.findViewById(R.id.transporterPhoneEditText);
        transporterZIPEditText     = view.findViewById(R.id.transporterZIPEditText);
        transporterCityEditText    = view.findViewById(R.id.transporterCityEditText);
        transporterCountryEditText = view.findViewById(R.id.transporterCountryEditText);

        driverEditText        = view.findViewById(R.id.driverEditText);
        driverAddressEditText = view.findViewById(R.id.driverAddressEditText);
        driverPhoneEditText   = view.findViewById(R.id.driverPhoneEditText);
        driverZIPEditText     = view.findViewById(R.id.driverZIPEditText);
        driverCityEditText    = view.findViewById(R.id.driverCityEditText);
        driverCountryEditText = view.findViewById(R.id.driverCountryEditText);

        coDriverEditText        = view.findViewById(R.id.coDriverEditText);
        coDriverAddressEditText = view.findViewById(R.id.coDriverAddressEditText);
        coDriverPhoneEditText   = view.findViewById(R.id.coDriverPhoneEditText);
        coDriverZIPEditText     = view.findViewById(R.id.coDriverZIPEditText);
        coDriverCityEditText    = view.findViewById(R.id.coDriverCityEditText);
        coDriverCountryEditText = view.findViewById(R.id.coDriverCountryEditText);

    }

    private void handleTextChangedforCarrier(){
        transporterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                carrier.setName(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        transporterAddressEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                carrier.setAddress(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });transporterPhoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                carrier.setPhone(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });transporterZIPEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    carrier.setZipNr(Integer.parseInt(s.toString()));
                    control.setCarrier(carrier);
                } else {
                    carrier.setZipNr(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });transporterCityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                carrier.setCity(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });transporterCountryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                carrier.setNationality(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void handleTextChangedforDriver(){
        driverEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                driver.setName(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        driverAddressEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                driver.setAddress(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        driverPhoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                driver.setPhone(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        driverZIPEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    driver.setZipNr(Integer.parseInt(s.toString()));
                    control.setCarrier(carrier);
                } else {
                    driver.setZipNr(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        driverCityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                driver.setCity(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        driverCountryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                driver.setNationality(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void handleTextChangedforCoDriver(){
        coDriverEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coDriver.setName(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        coDriverAddressEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coDriver.setAddress(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        coDriverPhoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coDriver.setPhone(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        coDriverZIPEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    coDriver.setZipNr(Integer.parseInt(s.toString()));
                    control.setCarrier(carrier);
                } else {
                    coDriver.setZipNr(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        coDriverCityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coDriver.setCity(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        coDriverCountryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coDriver.setNationality(s.toString());
                control.setCarrier(carrier);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}