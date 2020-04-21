package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentTwo extends Fragment {


    private static final String NEW_CONTROL = "new_control";

    private EditText transporterEditText;
    private EditText transporterPhoneEditText;
    private EditText transporterAddressEditText;
    private EditText transporterZIPEditText;
    private EditText transporterCityEditText;
    private EditText transporterCountryEditText;

    private EditText transporterEditText;
    private EditText transporterPhoneEditText;
    private EditText transporterAddressEditText;
    private EditText transporterZIPEditText;
    private EditText transporterCityEditText;
    private EditText transporterCountryEditText;
    
    private EditText transporterEditText;
    private EditText transporterPhoneEditText;
    private EditText transporterAddressEditText;
    private EditText transporterZIPEditText;
    private EditText transporterCityEditText;
    private EditText transporterCountryEditText;

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);



        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}