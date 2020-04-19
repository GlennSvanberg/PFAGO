package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

import java.io.Serializable;

public class FragmentOne extends Fragment {

    private static final String NEW_CONTROL = "new_control";

    private TextView textView;
    private EditText editText;
    private Button button;


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

        textView = view.findViewById(R.id.title);
        textView.setText(R.string.hello_blank_fragment);
        editText = view.findViewById(R.id.licensePlate);

        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control.setTruck(new Vehicle(editText.getText().toString(), "SE", Vehicle.VehicleType.Truck));
                ControlRepository.get().addControl(control);
                getActivity().finish();
            }
        });

        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}