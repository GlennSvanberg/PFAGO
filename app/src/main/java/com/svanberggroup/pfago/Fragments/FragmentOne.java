package com.svanberggroup.pfago.Fragments;

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
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentOne extends Fragment {

    private static final String NEW_CONTROL = "new_control";

    private TextView textView;
    private EditText editText;

    private EditText placeEditText;
    private EditText vehicleLicensePlateEditText;
    private EditText vehicleCountryEditText;
    private EditText trailerLicensePlateEditText;
    private EditText trailerCountryEditText;

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

        placeEditText = view.findViewById(R.id.placeEditText);
        vehicleLicensePlateEditText = view.findViewById(R.id.VehicleLicensePlateEditText);
        vehicleCountryEditText = view.findViewById(R.id.vehicleCountryEditText);
        trailerLicensePlateEditText = view.findViewById(R.id.trailerLicensePlateEditText);
        trailerCountryEditText = view.findViewById(R.id.trailerCountryEditText);

//        button = view.findViewById(R.id.button);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                control.setTruck(new Vehicle(editText.getText().toString(), "SE", Vehicle.VehicleType.Truck));
//                ControlRepository.get().addControl(control);
//                getActivity().finish();
//            }
//        });

        handleTextChanged();

        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void handleTextChanged() {
        placeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(s.length() > 0) {
                    control.setLocation(s.toString());
                    Log.i("JANNE", control.getLocation());
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
                vehicle.setRegNr(s.toString());
                control.setTruck(vehicle);
                Log.i("regNum", control.getTruck().getRegNr());
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
                    Log.i("country", control.getTruck().getNationality());
                } else {

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
                    Log.i("trailerRegNum", control.getTrailer().getRegNr());
                } else {

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
                    Log.i("trailerCountry", control.getTrailer().getNationality());
                } else {

                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }
}