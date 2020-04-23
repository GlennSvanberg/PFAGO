package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentFour extends Fragment {


    private static final String NEW_CONTROL = "new_control";

    private RadioGroup typeOfDocumentABCRadioGroup;
    private EditText typeOfDocumentRiskCategoryEditText;
    private RadioGroup typeOfDocumentRadioGroup;
    private EditText typeOfDocumentNotesEditText;

    private RadioGroup writenInstruktionABCRadioGroup;
    private EditText writenInstruktionRiskCategoryEditText;
    private RadioGroup writenInstruktionRadioGroup;
    private EditText writenInstruktionNotesEditText;

    private RadioGroup typeOfApprovalABCRadioGroup;
    private EditText typeOfApprovalRiskCategoryEditText;
    private RadioGroup typeOfApprovalRadioGroup;
    private EditText typeOfApprovalNotesEditText;

    private RadioGroup truckApprovalCertificateABCRadioGroup;
    private EditText truckApprovalCertificateRiskCategoryEditText;
    private RadioGroup truckApprovalCertificateRadioGroup;
    private EditText truckApprovalCertificateNotesEditText;

    private RadioGroup driverApprovalCertificateABCRadioGroup;
    private EditText driverApprovalCertificateRiskCategoryEditText;
    private RadioGroup driverApprovalCertificateRadioGroup;
    private EditText driverApprovalCertificateNotesEditText;

    private RadioGroup otherApprovalCertificateABCRadioGroup;
    private EditText otherApprovalCertificateRiskCategoryEditText;
    private RadioGroup otherApprovalCertificateRadioGroup;
    private EditText otherApprovalCertificateNotesEditText;

    private Control control;

    private FragmentFour() {
    }

    public static FragmentFour newInstance(Control control) {
        FragmentFour fragment = new FragmentFour();
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
        View view = inflater.inflate(R.layout.fragment_four, container, false);

        addSubViewToView(view);
        setVisibilityGone(view);

        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void addSubViewToView(View view) {
        typeOfDocumentABCRadioGroup = view.findViewById(R.id.typeOfDocumentABCRadioGroup);
        typeOfDocumentRiskCategoryEditText = view.findViewById(R.id.typeOfDocumentRiskCategoryEditText);
        typeOfDocumentRadioGroup = view.findViewById(R.id.typeOfDocumentRadioGroup);
        typeOfDocumentNotesEditText = view.findViewById(R.id.typeOfDocumentNotesEditText);

        writenInstruktionABCRadioGroup = view.findViewById(R.id.writenInstruktionABCRadioGroup);
        writenInstruktionRiskCategoryEditText = view.findViewById(R.id.writenInstruktionRiskCategoryEditText);
        writenInstruktionRadioGroup = view.findViewById(R.id.writenInstruktionRadioGroup);
        writenInstruktionNotesEditText = view.findViewById(R.id.writenInstruktionNotesEditText);

        typeOfApprovalABCRadioGroup = view.findViewById(R.id.typeOfApprovalABCRadioGroup);
        typeOfApprovalRiskCategoryEditText = view.findViewById(R.id.typeOfApprovalRiskCategoryEditText);
        typeOfApprovalRadioGroup = view.findViewById(R.id.typeOfApprovalRadioGroup);
        typeOfApprovalNotesEditText = view.findViewById(R.id.typeOfApprovalNotesEditText);

        truckApprovalCertificateABCRadioGroup = view.findViewById(R.id.truckApprovalCertificateABCRadioGroup);
        truckApprovalCertificateRiskCategoryEditText = view.findViewById(R.id.truckApprovalCertificateRiskCategoryEditText);
        truckApprovalCertificateRadioGroup = view.findViewById(R.id.truckApprovalCertificateRadioGroup);
        truckApprovalCertificateNotesEditText = view.findViewById(R.id.truckApprovalCertificateNotesEditText);

        driverApprovalCertificateABCRadioGroup = view.findViewById(R.id.driverApprovalCertificateABCRadioGroup);
        driverApprovalCertificateRiskCategoryEditText = view.findViewById(R.id.driverApprovalCertificateRiskCategoryEditText);
        driverApprovalCertificateRadioGroup = view.findViewById(R.id.driverApprovalCertificateRadioGroup);
        driverApprovalCertificateNotesEditText = view.findViewById(R.id.driverApprovalCertificateNotesEditText);

        otherApprovalCertificateABCRadioGroup = view.findViewById(R.id.otherApprovalCertificateABCRadioGroup);
        otherApprovalCertificateRiskCategoryEditText = view.findViewById(R.id.otherApprovalCertificateRiskCategoryEditText);
        otherApprovalCertificateRadioGroup = view.findViewById(R.id.otherApprovalCertificateRadioGroup);
        otherApprovalCertificateNotesEditText = view.findViewById(R.id.otherApprovalCertificateNotesEditText);
    }

    private void setVisibilityGone(View view){
        typeOfDocumentRiskCategoryEditText.setVisibility(view.GONE);
        typeOfDocumentRadioGroup.setVisibility(view.GONE);
        typeOfDocumentNotesEditText.setVisibility(view.GONE);

        writenInstruktionRiskCategoryEditText.setVisibility(view.GONE);
        writenInstruktionRadioGroup.setVisibility(view.GONE);
        writenInstruktionNotesEditText.setVisibility(view.GONE);

        typeOfApprovalRiskCategoryEditText.setVisibility(view.GONE);
        typeOfApprovalRadioGroup.setVisibility(view.GONE);
        typeOfApprovalNotesEditText.setVisibility(view.GONE);
//
        truckApprovalCertificateRiskCategoryEditText.setVisibility(view.GONE);
        truckApprovalCertificateRadioGroup.setVisibility(view.GONE);
        truckApprovalCertificateNotesEditText.setVisibility(view.GONE);
//
        driverApprovalCertificateRiskCategoryEditText.setVisibility(view.GONE);
        driverApprovalCertificateRadioGroup.setVisibility(view.GONE);
        driverApprovalCertificateNotesEditText.setVisibility(view.GONE);

        otherApprovalCertificateRiskCategoryEditText.setVisibility(view.GONE);
        otherApprovalCertificateRadioGroup.setVisibility(view.GONE);
        otherApprovalCertificateNotesEditText.setVisibility(view.GONE);
    }

}