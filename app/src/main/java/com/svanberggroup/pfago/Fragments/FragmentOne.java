package com.svanberggroup.pfago.Fragments;

import android.location.Location;
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
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;

import java.io.Serializable;
import java.lang.reflect.Array;

public class FragmentOne extends Fragment {

    private static final String NEW_CONTROL = "new_control";

    private EditText placeEditText;

    private EditText vehicleLicensePlateEditText;
    private EditText vehicleCountryEditText;

    private EditText trailerLicensePlateEditText;
    private EditText trailerCountryEditText;
    private RadioGroup trailerTypeRadioGroup;

    private RadioGroup controlPlaceTypeRadioGroup;

    private Control control;

    private FragmentOne() {
    }

    public static FragmentOne newInstance(Control control) {
        FragmentOne fragment = new FragmentOne();
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

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        placeEditText               = view.findViewById(R.id.placeEditText);

        vehicleLicensePlateEditText = view.findViewById(R.id.VehicleLicensePlateEditText);
        vehicleCountryEditText      = view.findViewById(R.id.vehicleCountryEditText);

        trailerLicensePlateEditText = view.findViewById(R.id.trailerLicensePlateEditText);
        trailerCountryEditText      = view.findViewById(R.id.trailerCountryEditText);
        trailerTypeRadioGroup       = view.findViewById(R.id.trailerTypeRadioGroup);

        controlPlaceTypeRadioGroup  = view.findViewById(R.id.ControlPlaceTypeRadioGroup);

        handleTextChanged();
        handleRadioButtonInput();

        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void handleRadioButtonInput() {
        controlPlaceTypeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.godsTerminalRadioButton:
                        control.setLocationType(Control.LocationType.CargoTerminal);
                        break;
                    case R.id.companyVisitRadioButton:
                        control.setLocationType(Control.LocationType.CompanyVisit);
                        break;
                    case R.id.roadRadioButton:
                        control.setLocationType(Control.LocationType.Road);
                        break;
                    case R.id.harbourTerminalRadioButton:
                        control.setLocationType(Control.LocationType.PortTerminal);
                        break;
                    case R.id.systemRadioButton:
                        control.setLocationType(Control.LocationType.System);
                        break;
                }
            }
        });
        trailerTypeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                setTruck();
            }
        });
    }


    private void handleTextChanged() {
        placeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(s.length() > 0) {
                    control.setLocation(s.toString());
                } else {
                    control.setLocation(null);
                }

            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        vehicleLicensePlateEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setTruck();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        vehicleCountryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setTruck();
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        trailerLicensePlateEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setTrailer();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        trailerCountryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setTrailer();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void setTruck() {

        Vehicle truck = control.getTruck();

        if (truck == null) { truck = new Vehicle(); }

        if (vehicleCountryEditText.getText().length() > 0) {
            truck.setNationality(vehicleCountryEditText.getText().toString());
        } else if (vehicleCountryEditText.getText().length() == 0) {
            truck.setNationality(null);
        }

        if (vehicleLicensePlateEditText.getText().length() > 0) {
            truck.setRegNr(vehicleLicensePlateEditText.getText().toString());
        } else if (vehicleLicensePlateEditText.getText().length() == 0) {
            truck.setRegNr(null);
        }

        if (vehicleLicensePlateEditText.getText().length() == 0 && vehicleCountryEditText.getText().length() == 0) {
            truck = null;
        }
        control.setTruck(truck);
    }

    private void setTrailer() {
        Vehicle trailer = control.getTrailer();
        int id = 0;

        if (trailer == null) { trailer = new Vehicle(); }

        switch (trailerTypeRadioGroup.getCheckedRadioButtonId()) {
            case R.id.trailerRadioButton:
                trailer.setVehicleType(Vehicle.VehicleType.Trailer);
                id = R.id.trailerRadioButton;
                break;
            case R.id.semiTrailerRadioButton:
                trailer.setVehicleType(Vehicle.VehicleType.SemiTrailer);
                id = R.id.semiTrailerRadioButton;
                break;
            case R.id.containerRadioButton:
                trailer.setVehicleType(Vehicle.VehicleType.Container);
                id = R.id.containerRadioButton;
                break;
        }

        if (trailerCountryEditText.getText().length() > 0) {
            trailer.setNationality(trailerCountryEditText.getText().toString());
        } else if (trailerCountryEditText.getText().length() == 0) {
            trailer.setNationality(null);
        }
        if (trailerLicensePlateEditText.getText().length() > 0) {
            trailer.setRegNr(trailerLicensePlateEditText.getText().toString());
        } else if (trailerLicensePlateEditText.getText().length() == 0) {
            trailer.setRegNr(null);
        }

        if (trailerLicensePlateEditText.getText().length() == 0 && trailerCountryEditText.getText().length() == 0 && id == 0) {
            trailer = null;
        }
        control.setTrailer(trailer);
    }
}