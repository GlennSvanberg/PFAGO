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

public class FragmentOne extends Fragment {

    private static final String NEW_CONTROL = "new_control";

    private EditText placeEditText;

    private EditText vehicleLicensePlateEditText;
    private EditText vehicleCountryEditText;

    private EditText trailerLicensePlateEditText;
    private EditText trailerCountryEditText;
    private RadioGroup trailerTypeRadioGroup;

    private RadioGroup controlPlaceTypeRadioGroup;

    private Vehicle vehicle;
    private Vehicle trailer;

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

        vehicle = new Vehicle();
        trailer = new Vehicle();
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
                    case R.id.companyVisitRadioButton:
                        control.setLocationType(Control.LocationType.CompanyVisit);
                    case R.id.roadRadioButton:
                        control.setLocationType(Control.LocationType.Road);
                    case R.id.harbourTerminalRadioButton:
                        control.setLocationType(Control.LocationType.PortTerminal);
                    case R.id.systemRadioButton:
                        control.setLocationType(Control.LocationType.System);
                }
            }
        });
        trailerTypeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.trailerRadioButton:
                        trailer.setVehicleType(Vehicle.VehicleType.Trailer);
                    case R.id.semiTrailerRadioButton:
                        trailer.setVehicleType(Vehicle.VehicleType.SemiTrailer);
                    case R.id.containerRadioButton:
                        trailer.setVehicleType(Vehicle.VehicleType.Container);
                }
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
                if(s.length() > 0) {

                    vehicle.setRegNr(s.toString());
                    control.setTruck(vehicle);

                } else if (s.length() == 0 && vehicle.getNationality() == null) {

                    control.setTruck(null);

                } else {
                    // säg att fältet måste fyllas i.
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        vehicleCountryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {

                    vehicle.setNationality(s.toString());
                    control.setTruck(vehicle);

                } else if (s.length() == 0 && vehicle.getRegNr() != null){

                    control.setTruck(null);
                } else {
                    // säga att fältet måste fyllas i.
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        trailerLicensePlateEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {

                    trailer.setRegNr(s.toString());
                    control.setTrailer(trailer);

                } else if (s.length() == 0 && trailer.getNationality() == null && trailer.getVehicleType() == null) {

                    control.setTrailer(null);

                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        trailerCountryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {

                    trailer.setNationality(s.toString());
                    control.setTrailer(vehicle);

                } else if(s.length() == 0 && trailer.getRegNr() == null && trailer.getVehicleType() == null) {

                    control.setTrailer(null);

                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }
}