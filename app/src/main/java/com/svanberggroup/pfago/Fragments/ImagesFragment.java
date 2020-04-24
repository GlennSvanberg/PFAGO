package com.svanberggroup.pfago.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;

import java.io.Serializable;


public class ImagesFragment extends Fragment {


    private static final String NEW_CONTROL = "new_control";
    private Control control;

    public ImagesFragment() {
        // Required empty public constructor
    }

    public static ImagesFragment newInstance(Control control) {
        ImagesFragment fragment = new ImagesFragment();
        Bundle args = new Bundle();
        args.putSerializable(NEW_CONTROL, (Serializable) control);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            control = (Control) getArguments().getSerializable(NEW_CONTROL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_images, container, false);
    }

}
