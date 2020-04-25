package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.TransportDocumentRows;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentFour extends Fragment {


    private static final String NEW_CONTROL = "new_control";

    private RadioGroup chooseTypeOfDocumentRadioGroup;
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
    private TransportDocumentRows tdRows;
    private ControlRow goodsDeclarationRow;

    public  FragmentFour() {
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
        control = (Control) getArguments().getSerializable(NEW_CONTROL);

        tdRows = new TransportDocumentRows();
        goodsDeclarationRow = tdRows.getGoodsDeclarationRow();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);

        addSubViewToView(view);
        setVisibilityGone(view);
        handleVisibility();
        handleRadioButtonChecked();
        handleTextInput();

        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void addSubViewToView(View view) {
        chooseTypeOfDocumentRadioGroup = view.findViewById(R.id.chooseTypeOfDocumentRadioGroup);
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

    private void handleVisibility() {

        typeOfDocumentABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.notApprovedRadioButton) {
                    typeOfDocumentRiskCategoryEditText.setVisibility(View.VISIBLE);
                    typeOfDocumentRadioGroup.setVisibility(View.VISIBLE);
                    typeOfDocumentNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    typeOfDocumentRiskCategoryEditText.setVisibility(View.GONE);
                    typeOfDocumentRadioGroup.setVisibility(View.GONE);
                    typeOfDocumentNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        writenInstruktionABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.notApprovedRadioButton1) {
                    writenInstruktionRiskCategoryEditText.setVisibility(View.VISIBLE);
                    writenInstruktionRadioGroup.setVisibility(View.VISIBLE);
                    writenInstruktionNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    writenInstruktionRiskCategoryEditText.setVisibility(View.GONE);
                    writenInstruktionRadioGroup.setVisibility(View.GONE);
                    writenInstruktionNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        typeOfApprovalABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.notApprovedRadioButton2) {
                    typeOfApprovalRiskCategoryEditText.setVisibility(View.VISIBLE);
                    typeOfApprovalRadioGroup.setVisibility(View.VISIBLE);
                    typeOfApprovalNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    typeOfApprovalRiskCategoryEditText.setVisibility(View.GONE);
                    typeOfApprovalRadioGroup.setVisibility(View.GONE);
                    typeOfApprovalNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        truckApprovalCertificateABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.truckApprovalNotApprovedRadioButton) {
                    truckApprovalCertificateRiskCategoryEditText.setVisibility(View.VISIBLE);
                    truckApprovalCertificateRadioGroup.setVisibility(View.VISIBLE);
                    truckApprovalCertificateNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    truckApprovalCertificateRiskCategoryEditText.setVisibility(View.GONE);
                    truckApprovalCertificateRadioGroup.setVisibility(View.GONE);
                    truckApprovalCertificateNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        driverApprovalCertificateABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.driverApprovalNotApprovedRadioButton) {
                    driverApprovalCertificateRiskCategoryEditText.setVisibility(View.VISIBLE);
                    driverApprovalCertificateRadioGroup.setVisibility(View.VISIBLE);
                    driverApprovalCertificateNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    driverApprovalCertificateRiskCategoryEditText.setVisibility(View.GONE);
                    driverApprovalCertificateRadioGroup.setVisibility(View.GONE);
                    driverApprovalCertificateNotesEditText.setVisibility(View.GONE);
                }
            }
        });
        otherApprovalCertificateABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.otherApprovalNotApprovedRadioButton) {
                    otherApprovalCertificateRiskCategoryEditText.setVisibility(View.VISIBLE);
                    otherApprovalCertificateRadioGroup.setVisibility(View.VISIBLE);
                    otherApprovalCertificateNotesEditText.setVisibility(View.VISIBLE);
                } else {
                    otherApprovalCertificateRiskCategoryEditText.setVisibility(View.GONE);
                    otherApprovalCertificateRadioGroup.setVisibility(View.GONE);
                    otherApprovalCertificateNotesEditText.setVisibility(View.GONE);
                }
            }
        });
    }

    private void handleRadioButtonChecked() {
        chooseTypeOfDocumentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.loadPlanRadioButton:
                        tdRows.setDeclaration(TransportDocumentRows.Declaration.LoadingPlane);
                    case R.id.CPCRadionButton:
                        tdRows.setDeclaration(TransportDocumentRows.Declaration.StowageCertificate);
                }
            }
        });
        typeOfDocumentABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.controlledRadioButton:
                        goodsDeclarationRow.setField(ControlRow.Field.Controlled);
                        tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                    case R.id.notApprovedRadioButton:
                        goodsDeclarationRow.setField(ControlRow.Field.BreakingTheLaw);
                        tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                    case R.id.notApplicableRadioButton:
                        goodsDeclarationRow.setField(ControlRow.Field.NotApplicable);
                        tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                }
            }
        });
        typeOfDocumentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.imposeRadioButton:
                        goodsDeclarationRow.setImposed(true);
                        goodsDeclarationRow.setBanned(false);
                    case R.id.bannedRadioButton:
                        goodsDeclarationRow.setBanned(true);
                        goodsDeclarationRow.setImposed(false);
                }
            }
        });
        writenInstruktionABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.controlledRadioButton1:

                }
            }
        });
    }
    private void handleTextInput() {
        typeOfDocumentRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    goodsDeclarationRow.setRiskCategory(s.toString());
                    tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        typeOfDocumentNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    goodsDeclarationRow.setNotes(s.toString());
                    tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                } else if (s.length() == 0) {
                    goodsDeclarationRow.setNotes(null);
                    tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

}