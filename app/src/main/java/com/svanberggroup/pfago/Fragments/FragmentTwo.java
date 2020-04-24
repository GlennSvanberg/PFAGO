package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.TransportLocation;
import com.svanberggroup.pfago.Models.Transporter;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentTwo extends Fragment {

    private enum TransporterType {
        carrier,
        driver,
        coDriver,
        sender,
        reciver
    }

    private static final String NEW_CONTROL = "new_control";

    private EditText carrierEditText;
    private EditText carrierPhoneEditText;
    private EditText carrierAddressEditText;
    private EditText carrierZIPEditText;
    private EditText carrierCityEditText;
    private EditText carrierCountryEditText;

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

    private EditText senderPlace;
    private EditText senderPhone;
    private EditText senderAdress;

    private EditText reciverPlace;
    private EditText reciverPhone;
    private EditText reciverAdress;

    private TransportLocation sender;
    private TransportLocation reciver;

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
        sender = new TransportLocation();
        reciver = new TransportLocation();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        addViewById(view);
        handleTextChangedforCarrier();
        handleTextChangedforDriver();
        handleTextChangedforCoDriver();
        handleTextChangeForSender();
        handleTextChangeForReciver();

        return view;
    }

    private void addViewById(View view) {

        carrierEditText = view.findViewById(R.id.carrierEditText);
        carrierAddressEditText = view.findViewById(R.id.carrierAddressEditText);
        carrierPhoneEditText = view.findViewById(R.id.carrierPhoneEditText);
        carrierZIPEditText = view.findViewById(R.id.carrierZIPEditText);
        carrierCityEditText = view.findViewById(R.id.carrierCityEditText);
        carrierCountryEditText = view.findViewById(R.id.carrierCountryEditText);

        driverEditText = view.findViewById(R.id.driverEditText);
        driverAddressEditText = view.findViewById(R.id.driverAddressEditText);
        driverPhoneEditText = view.findViewById(R.id.driverPhoneEditText);
        driverZIPEditText = view.findViewById(R.id.driverZIPEditText);
        driverCityEditText = view.findViewById(R.id.driverCityEditText);
        driverCountryEditText = view.findViewById(R.id.driverCountryEditText);

        coDriverEditText = view.findViewById(R.id.coDriverEditText);
        coDriverAddressEditText = view.findViewById(R.id.coDriverAddressEditText);
        coDriverPhoneEditText = view.findViewById(R.id.coDriverPhoneEditText);
        coDriverZIPEditText = view.findViewById(R.id.coDriverZIPEditText);
        coDriverCityEditText = view.findViewById(R.id.coDriverCityEditText);
        coDriverCountryEditText = view.findViewById(R.id.coDriverCountryEditText);

        senderPlace = view.findViewById(R.id.senderLoadPlaceEditText);
        senderPhone = view.findViewById(R.id.senderPhoneEditText);
        senderAdress = view.findViewById(R.id.senderEditText);

        reciverPlace = view.findViewById(R.id.reciverUnloadPlaceEditText);
        reciverPhone = view.findViewById(R.id.reciverPhoneEditText);
        reciverAdress = view.findViewById(R.id.reciverAdressEditText);

    }

    private void handleTextChangedforCarrier() {
        carrierEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    carrier.setName(s.toString());
                    control.setCarrier(carrier);
                } else if (viewsEmptyFor(TransporterType.carrier)) {
                    control.setCarrier(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        carrierAddressEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    carrier.setAddress(s.toString());
                    control.setCarrier(carrier);
                } else if (viewsEmptyFor(TransporterType.carrier)) {
                    control.setCarrier(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        carrierPhoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    carrier.setPhone(s.toString());
                    control.setCarrier(carrier);
                } else if (viewsEmptyFor(TransporterType.carrier)) {
                    control.setCarrier(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        carrierZIPEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    carrier.setZipNr(Integer.parseInt(s.toString()));
                    control.setCarrier(carrier);
                } else if (viewsEmptyFor(TransporterType.carrier)) {
                    carrier.setZipNr(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        carrierCityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    carrier.setCity(s.toString());
                    control.setCarrier(carrier);
                } else if (viewsEmptyFor(TransporterType.carrier)) {
                    control.setCarrier(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        carrierCountryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    carrier.setNationality(s.toString());
                    control.setCarrier(carrier);
                } else if (viewsEmptyFor(TransporterType.carrier)) {
                    control.setCarrier(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void handleTextChangedforDriver() {
        driverEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    driver.setName(s.toString());
                    control.setDriver(driver);
                } else if (viewsEmptyFor(TransporterType.driver)) {
                    control.setDriver(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        driverAddressEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    driver.setAddress(s.toString());
                    control.setDriver(driver);
                } else if (viewsEmptyFor(TransporterType.driver)) {
                    control.setDriver(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        driverPhoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    driver.setPhone(s.toString());
                    control.setDriver(driver);
                } else if (viewsEmptyFor(TransporterType.driver)) {
                    control.setDriver(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        driverZIPEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    driver.setZipNr(Integer.parseInt(s.toString()));
                    control.setDriver(driver);
                } else if (viewsEmptyFor(TransporterType.driver)) {
                    control.setDriver(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        driverCityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    driver.setCity(s.toString());
                    control.setDriver(driver);
                } else if (viewsEmptyFor(TransporterType.driver)) {
                    control.setDriver(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        driverCountryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    driver.setNationality(s.toString());
                    control.setDriver(driver);
                } else if (viewsEmptyFor(TransporterType.driver)) {
                    control.setDriver(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void handleTextChangedforCoDriver() {
        coDriverEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    coDriver.setName(s.toString());
                    control.setPassenger(coDriver);
                } else if (viewsEmptyFor(TransporterType.coDriver)) {
                    control.setPassenger(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        coDriverAddressEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    coDriver.setAddress(s.toString());
                    control.setPassenger(coDriver);
                } else if (viewsEmptyFor(TransporterType.coDriver)) {
                    control.setPassenger(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        coDriverPhoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    coDriver.setPhone(s.toString());
                    control.setPassenger(coDriver);
                } else if (viewsEmptyFor(TransporterType.coDriver)) {
                    control.setPassenger(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        coDriverZIPEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    coDriver.setZipNr(Integer.parseInt(s.toString()));
                    control.setPassenger(coDriver);
                } else if (viewsEmptyFor(TransporterType.coDriver)) {
                    control.setPassenger(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        coDriverCityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    coDriver.setCity(s.toString());
                    control.setPassenger(coDriver);
                } else if (viewsEmptyFor(TransporterType.coDriver)) {
                    control.setPassenger(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        coDriverCountryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    coDriver.setNationality(s.toString());
                    control.setPassenger(coDriver);
                } else if (viewsEmptyFor(TransporterType.coDriver)) {
                    control.setPassenger(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void handleTextChangeForSender() {
        senderPlace.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    reciver.setPlace(s.toString());
                    control.setSender(reciver);
                } else if (viewsEmptyFor(TransporterType.sender)) {
                    control.setSender(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        senderAdress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    sender.setAddress(s.toString());
                    control.setSender(sender);
                } else if (viewsEmptyFor(TransporterType.sender)) {
                    control.setSender(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        senderPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    sender.setPhone(s.toString());
                    control.setSender(sender);
                } else if (viewsEmptyFor(TransporterType.sender)) {
                    control.setSender(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void handleTextChangeForReciver() {
        reciverPlace.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    reciver.setPlace(s.toString());
                    control.setReceiver(reciver);
                } else if (viewsEmptyFor(TransporterType.reciver)) {
                    control.setReceiver(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        reciverAdress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    reciver.setAddress(s.toString());
                    control.setReceiver(reciver);
                } else if (viewsEmptyFor(TransporterType.reciver)) {
                    control.setReceiver(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        reciverPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    reciver.setPhone(s.toString());
                    control.setReceiver(reciver);
                } else if (viewsEmptyFor(TransporterType.reciver)) {
                    control.setReceiver(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private boolean viewsEmptyFor(TransporterType transporterType) {
        switch (transporterType) {
            case carrier:
                EditText[] carrierEdits = {carrierEditText, carrierPhoneEditText, carrierAddressEditText,
                        carrierZIPEditText, carrierCityEditText, carrierCountryEditText};
                for (EditText e: carrierEdits) {
                    if (e.getText().length() > 0) {
                        return false;
                    }
                }
            case driver:
                EditText[] driverEdits = {driverEditText, driverPhoneEditText, driverAddressEditText,
                        driverZIPEditText, driverCityEditText, driverCountryEditText};
                for (EditText e: driverEdits) {
                    if (e.getText().length() > 0) {
                        return false;
                    }
                }
            case coDriver:
                EditText[] coDriverEdits = {coDriverEditText, coDriverPhoneEditText, coDriverAddressEditText,
                        coDriverZIPEditText, coDriverCityEditText, coDriverCountryEditText};
                for (EditText e: coDriverEdits) {
                    if (e.getText().length() > 0) {
                        return false;
                    }
                }
            case sender:
                EditText[] senderEdits = {senderAdress, senderPhone, senderPlace};
                for (EditText e: senderEdits) {
                    if (e.getText().length() > 0) {
                        return false;
                    }
                }
            case reciver:
                EditText[] reciverEdits = {reciverAdress, reciverPhone, reciverPlace};
                for (EditText e: reciverEdits) {
                    if (e.getText().length() > 0) {
                        return false;
                    }
                }
        }
        return true;
    }

}