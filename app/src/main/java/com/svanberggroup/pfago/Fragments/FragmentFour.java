package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.Visibility;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.TransportDocumentRows;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentFour extends Fragment {

    private enum TransportRowType {
        Document,
        WritenInstruction,
        Approval,
        Truck,
        Driver,
        Other
    }

    private enum visibilityType {
        Gone,
        Visible
    }

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

    private RadioGroup chooseTypeOfApprovalRadioGroup;
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
    private ControlRow writtenInstructionsRow;
    private ControlRow typeOfApprovalRow;
    private ControlRow truckCertificateRow;
    private ControlRow driverCertificationRow;
    private ControlRow otherADRTrainingRow;

    private FragmentFour() {
    }

    public static FragmentFour newInstance(Control control) {
        FragmentFour fragment = new FragmentFour();
        Bundle args = new Bundle();
        args.putSerializable(NEW_CONTROL,(Serializable) control);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        control = (Control) getArguments().getSerializable(NEW_CONTROL);

        tdRows = new TransportDocumentRows();
        goodsDeclarationRow = new ControlRow();
        writtenInstructionsRow = new ControlRow();
        typeOfApprovalRow = new ControlRow();
        driverCertificationRow = new ControlRow();
        truckCertificateRow = new ControlRow();
        otherADRTrainingRow = new ControlRow();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);

        addSubViewToView(view);

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

        chooseTypeOfApprovalRadioGroup = view.findViewById(R.id.chooseTypeOfApprovalRadioGroup);
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

    private void handleRadioButtonChecked() {

        chooseTypeOfDocumentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.loadPlanRadioButton:
                        tdRows.setDeclaration(TransportDocumentRows.Declaration.LoadingPlane);
                        control.setTdRows(tdRows);
                    case R.id.CPCRadionButton:
                        tdRows.setDeclaration(TransportDocumentRows.Declaration.StowageCertificate);
                        control.setTdRows(tdRows);
                }
            }
        });

        typeOfDocumentABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.documemtControlledRadioButton) {
                    typeOfDocumentRiskCategoryEditText.setVisibility(View.GONE);
                    typeOfDocumentNotesEditText.setVisibility(View.GONE);
                    typeOfDocumentRadioGroup.setVisibility(View.GONE);
                    clearFieldsForView(TransportRowType.Document);
                    setTdRowFor(goodsDeclarationRow, ControlRow.Field.Controlled, TransportRowType.Document);

                } else if (checkedId == R.id.documentNotApprovedRadioButton) {
                    typeOfDocumentRiskCategoryEditText.setVisibility(View.VISIBLE);
                    typeOfDocumentRadioGroup.setVisibility(View.VISIBLE);
                    typeOfDocumentNotesEditText.setVisibility(View.VISIBLE);

                    setTdRowFor(goodsDeclarationRow, ControlRow.Field.BreakingTheLaw, TransportRowType.Document);
                } else if (checkedId == R.id.documentNotApplicableRadioButton) {
                    typeOfDocumentRiskCategoryEditText.setVisibility(View.GONE);
                    typeOfDocumentRadioGroup.setVisibility(View.GONE);
                    typeOfDocumentNotesEditText.setVisibility(View.GONE);

                    clearFieldsForView(TransportRowType.Document);
                    setTdRowFor(goodsDeclarationRow, ControlRow.Field.NotApplicable, TransportRowType.Document);
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
                        tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                        control.setTdRows(tdRows);
                    case R.id.bannedRadioButton:
                        goodsDeclarationRow.setBanned(true);
                        goodsDeclarationRow.setImposed(false);
                        tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                        control.setTdRows(tdRows);
                }
            }
        });
        writenInstruktionABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.controlledRadioButton1:
                     //   setVisibility(writenViews, visibilityType.Gone);

                        clearFieldsForView(TransportRowType.WritenInstruction);
                        setTdRowFor(writtenInstructionsRow, ControlRow.Field.Controlled, TransportRowType.WritenInstruction);

                    case R.id.notApprovedRadioButton1:
                     //   setVisibility(writenViews, visibilityType.Visible);
                        setTdRowFor(writtenInstructionsRow, ControlRow.Field.BreakingTheLaw, TransportRowType.WritenInstruction);

                    case R.id.notApplicableRadioButton1:
                     //   setVisibility(writenViews, visibilityType.Gone);

                        clearFieldsForView(TransportRowType.WritenInstruction);
                        setTdRowFor(writtenInstructionsRow, ControlRow.Field.NotApplicable, TransportRowType.WritenInstruction);
                }

            }
        });
        writenInstruktionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.imposeRadioButton1:
                        writtenInstructionsRow.setImposed(true);
                        writtenInstructionsRow.setBanned(false);
                        tdRows.setWrittenInstructionsRow(writtenInstructionsRow);
                        control.setTdRows(tdRows);
                    case R.id.bannedRadioButton1:
                        writtenInstructionsRow.setImposed(false);
                        writtenInstructionsRow.setBanned(true);
                        tdRows.setWrittenInstructionsRow(writtenInstructionsRow);
                        control.setTdRows(tdRows);
                }
            }
        });
        chooseTypeOfApprovalRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.biRadioButton:
                        tdRows.setApproval(TransportDocumentRows.Approval.Bilateral);
                        control.setTdRows(tdRows);
                    case R.id.multiRadioButton:
                        tdRows.setApproval(TransportDocumentRows.Approval.Multilateral);
                        control.setTdRows(tdRows);
                    case R.id.natRadioButton:
                        tdRows.setApproval(TransportDocumentRows.Approval.NationalApproval);
                        control.setTdRows(tdRows);
                }
            }
        });
        typeOfApprovalABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.janneControlledRadioButton:
                     //   setVisibility(approvalViews, visibilityType.Gone);

                        clearFieldsForView(TransportRowType.Approval);
                        setTdRowFor(typeOfApprovalRow, ControlRow.Field.Controlled, TransportRowType.Approval);

                    case R.id.notApprovedRadioButton2:
                     //   setVisibility(approvalViews, visibilityType.Visible);
                        setTdRowFor(typeOfApprovalRow, ControlRow.Field.BreakingTheLaw, TransportRowType.Approval);

                    case R.id.janneNotApplicableRadioButton:
                     //   setVisibility(approvalViews, visibilityType.Gone);

                        clearFieldsForView(TransportRowType.Approval);
                        setTdRowFor(typeOfApprovalRow, ControlRow.Field.NotApplicable, TransportRowType.Approval);
                }
            }
        });
        typeOfApprovalRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.imposeRadioButton2:
                        typeOfApprovalRow.setImposed(true);
                        typeOfApprovalRow.setBanned(false);
                        tdRows.setApprovalRow(typeOfApprovalRow);
                        control.setTdRows(tdRows);
                    case R.id.bannedRadioButton2:
                        typeOfApprovalRow.setBanned(true);
                        typeOfApprovalRow.setImposed(false);
                        tdRows.setApprovalRow(typeOfApprovalRow);
                        control.setTdRows(tdRows);
                }
            }
        });
        truckApprovalCertificateABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.truckApprovalControlledRadioButton:
                     //   setVisibility(truckViews, visibilityType.Gone);

                        clearFieldsForView(TransportRowType.Truck);
                        setTdRowFor(truckCertificateRow, ControlRow.Field.Controlled, TransportRowType.Truck);

                    case R.id.truckApprovalNotApprovedRadioButton:
                     //   setVisibility(truckViews, visibilityType.Visible);
                        setTdRowFor(truckCertificateRow, ControlRow.Field.BreakingTheLaw, TransportRowType.Truck);

                    case R.id.truckApprovalNotApplicableRadioButton:
                     //   setVisibility(truckViews, visibilityType.Gone);

                        clearFieldsForView(TransportRowType.Truck);
                        setTdRowFor(truckCertificateRow, ControlRow.Field.NotApplicable, TransportRowType.Truck);
                }
            }
        });
        truckApprovalCertificateRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.truckApprovalImposeRadioButton:
                        truckCertificateRow.setImposed(true);
                        truckCertificateRow.setBanned(false);
                        tdRows.setApprovalCertificateRow(truckCertificateRow);
                        control.setTdRows(tdRows);
                    case R.id.truckApprovalBannedRadioButton:
                        truckCertificateRow.setBanned(true);
                        truckCertificateRow.setImposed(false);
                        tdRows.setApprovalCertificateRow(truckCertificateRow);
                        control.setTdRows(tdRows);
                }
            }
        });
        driverApprovalCertificateABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.driverApprovalControlledRadioButton:
                     //   setVisibility(driverViews, visibilityType.Gone);

                        clearFieldsForView(TransportRowType.Driver);
                        setTdRowFor(driverCertificationRow, ControlRow.Field.Controlled, TransportRowType.Driver);
                    case R.id.driverApprovalNotApprovedRadioButton:
                     //   setVisibility(driverViews, visibilityType.Visible);
                        setTdRowFor(driverCertificationRow, ControlRow.Field.BreakingTheLaw, TransportRowType.Driver);
                    case R.id.driverApprovalImposeRadioButton:
                     //   setVisibility(driverViews, visibilityType.Gone);

                        clearFieldsForView(TransportRowType.Driver);
                        setTdRowFor(driverCertificationRow, ControlRow.Field.NotApplicable, TransportRowType.Driver);
                }
            }
        });
        driverApprovalCertificateRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.driverApprovalImposeRadioButton:
                        driverCertificationRow.setImposed(true);
                        driverCertificationRow.setBanned(false);
                        tdRows.setApprovalCertificateRow(driverCertificationRow);
                        control.setTdRows(tdRows);
                    case R.id.driverApprovalBannedRadioButton:
                        driverCertificationRow.setBanned(true);
                        driverCertificationRow.setImposed(false);
                        tdRows.setApprovalCertificateRow(driverCertificationRow);
                        control.setTdRows(tdRows);
                }
            }
        });
        otherApprovalCertificateABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.otherApprovalControlledRadioButton:
                     //   setVisibility(otherViews, visibilityType.Gone);

                        clearFieldsForView(TransportRowType.Other);
                        setTdRowFor(otherADRTrainingRow, ControlRow.Field.Controlled, TransportRowType.Other);
                    case R.id.otherApprovalNotApprovedRadioButton:
                     //   setVisibility(otherViews, visibilityType.Visible);
                        setTdRowFor(otherADRTrainingRow, ControlRow.Field.BreakingTheLaw, TransportRowType.Other);
                    case R.id.otherApprovalNotApplicableRadioButton:
                     //   setVisibility(otherViews, visibilityType.Gone);

                        clearFieldsForView(TransportRowType.Other);
                        setTdRowFor(otherADRTrainingRow, ControlRow.Field.NotApplicable, TransportRowType.Other);
                }
            }
        });
        otherApprovalCertificateRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.otherApprovalImposeRadioButton:
                        otherADRTrainingRow.setImposed(true);
                        otherADRTrainingRow.setBanned(false);
                        tdRows.setOtherADRTrainingRow(otherADRTrainingRow);
                        control.setTdRows(tdRows);
                    case R.id.otherApprovalBannedRadioButton:
                        otherADRTrainingRow.setBanned(true);
                        otherADRTrainingRow.setImposed(false);
                        tdRows.setOtherADRTrainingRow(otherADRTrainingRow);
                        control.setTdRows(tdRows);
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
                    control.setTdRows(tdRows);
                } else if (s.length() == 0 ) {
                    goodsDeclarationRow.setRiskCategory(null);
                    tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.Document)) {
                    tdRows.setGoodsDeclarationRow(null);
                    control.setTdRows(tdRows);
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
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    goodsDeclarationRow.setNotes(null);
                    tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.Document)) {
                    tdRows.setGoodsDeclarationRow(null);
                    control.setTdRows(tdRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        writenInstruktionRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    writtenInstructionsRow.setRiskCategory(s.toString());
                    tdRows.setWrittenInstructionsRow(writtenInstructionsRow);
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    writtenInstructionsRow.setRiskCategory(null);
                    tdRows.setWrittenInstructionsRow(writtenInstructionsRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.WritenInstruction)) {
                    tdRows.setWrittenInstructionsRow(null);
                    control.setTdRows(tdRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        writenInstruktionNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    writtenInstructionsRow.setNotes(s.toString());
                    tdRows.setWrittenInstructionsRow(writtenInstructionsRow);
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    writtenInstructionsRow.setNotes(null);
                    tdRows.setWrittenInstructionsRow(writtenInstructionsRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.WritenInstruction)) {
                    tdRows.setWrittenInstructionsRow(null);
                    control.setTdRows(tdRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        typeOfApprovalRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    typeOfApprovalRow.setRiskCategory(s.toString());
                    tdRows.setApprovalRow(typeOfApprovalRow);
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    typeOfApprovalRow.setRiskCategory(null);
                    tdRows.setApprovalRow(typeOfApprovalRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.Approval)) {
                    tdRows.setApprovalRow(null);
                    control.setTdRows(tdRows);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        typeOfApprovalNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    typeOfApprovalRow.setNotes(s.toString());
                    tdRows.setApprovalRow(typeOfApprovalRow);
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    typeOfApprovalRow.setNotes(null);
                    tdRows.setApprovalRow(typeOfApprovalRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.Approval)) {
                    tdRows.setApprovalRow(null);
                    control.setTdRows(tdRows);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        truckApprovalCertificateRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    truckCertificateRow.setRiskCategory(s.toString());
                    tdRows.setApprovalCertificateRow(truckCertificateRow);
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    truckCertificateRow.setRiskCategory(null);
                    tdRows.setApprovalCertificateRow(truckCertificateRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.Truck)) {
                    tdRows.setApprovalCertificateRow(null);
                    control.setTdRows(tdRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        truckApprovalCertificateNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    truckCertificateRow.setNotes(s.toString());
                    tdRows.setApprovalCertificateRow(truckCertificateRow);
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    truckCertificateRow.setNotes(null);
                    tdRows.setApprovalCertificateRow(truckCertificateRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.Truck)) {
                    tdRows.setApprovalCertificateRow(null);
                    control.setTdRows(tdRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        driverApprovalCertificateRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    driverCertificationRow.setRiskCategory(s.toString());
                    tdRows.setDriverCertificationRow(driverCertificationRow);
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    driverCertificationRow.setRiskCategory(null);
                    tdRows.setDriverCertificationRow(driverCertificationRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.Driver)) {
                    tdRows.setDriverCertificationRow(null);
                    control.setTdRows(tdRows);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        driverApprovalCertificateNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    driverCertificationRow.setNotes(s.toString());
                    tdRows.setDriverCertificationRow(driverCertificationRow);
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    driverCertificationRow.setNotes(null);
                    tdRows.setDriverCertificationRow(driverCertificationRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.Driver)) {
                    tdRows.setDriverCertificationRow(null);
                    control.setTdRows(tdRows);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        otherApprovalCertificateRiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    otherADRTrainingRow.setRiskCategory(s.toString());
                    tdRows.setOtherADRTrainingRow(otherADRTrainingRow);
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    otherADRTrainingRow.setRiskCategory(null);
                    tdRows.setOtherADRTrainingRow(otherADRTrainingRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.Other)) {
                    tdRows.setOtherADRTrainingRow(null);
                    control.setTdRows(tdRows);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        otherApprovalCertificateNotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    otherADRTrainingRow.setNotes(s.toString());
                    tdRows.setOtherADRTrainingRow(otherADRTrainingRow);
                    control.setTdRows(tdRows);
                } else if (s.length() == 0) {
                    otherADRTrainingRow.setNotes(null);
                    tdRows.setOtherADRTrainingRow(otherADRTrainingRow);
                    control.setTdRows(tdRows);
                }
                if (viewsEmptyFor(TransportRowType.Other)) {
                    tdRows.setOtherADRTrainingRow(null);
                    control.setTdRows(tdRows);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void setTdRowFor(ControlRow controlRow, ControlRow.Field field, TransportRowType type) {

        controlRow.setField(field);
        switch (type) {

            case Document:
                tdRows.setGoodsDeclarationRow(controlRow);
            case WritenInstruction:
                tdRows.setWrittenInstructionsRow(controlRow);
            case Approval:
                tdRows.setApprovalRow(controlRow);
            case Truck:
                tdRows.setApprovalCertificateRow(controlRow);
            case Driver:
                tdRows.setDriverCertificationRow(controlRow);
            case Other:
                tdRows.setOtherADRTrainingRow(controlRow);

        }
        control.setTdRows(tdRows);
    }

    private boolean viewsEmptyFor(TransportRowType transportRowType) {

        switch (transportRowType) {

            case Document:
                if (typeOfDocumentRiskCategoryEditText.getText().length() > 0
                        || typeOfDocumentNotesEditText.getText().length() > 0
                        || typeOfDocumentABCRadioGroup.getCheckedRadioButtonId() != -1
                        || typeOfDocumentRadioGroup.getCheckedRadioButtonId() != -1
                        || chooseTypeOfDocumentRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
            case WritenInstruction:
                if (writenInstruktionRiskCategoryEditText.getText().length() > 0
                        || writenInstruktionNotesEditText.getText().length() > 0
                        || writenInstruktionABCRadioGroup.getCheckedRadioButtonId() != -1
                        || writenInstruktionRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
            case Approval:
                if (typeOfApprovalRiskCategoryEditText.getText().length() > 0
                        || typeOfApprovalNotesEditText.getText().length() > 0
                        || typeOfApprovalABCRadioGroup.getCheckedRadioButtonId() != -1
                        || typeOfDocumentRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
            case Truck:
                if (truckApprovalCertificateRiskCategoryEditText.getText().length() > 0
                        || truckApprovalCertificateNotesEditText.getText().length() > 0
                        || truckApprovalCertificateABCRadioGroup.getCheckedRadioButtonId() != -1
                        || truckApprovalCertificateRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
            case Driver:
                if (driverApprovalCertificateRiskCategoryEditText.getText().length() > 0
                        || truckApprovalCertificateNotesEditText.getText().length() > 0
                        || truckApprovalCertificateABCRadioGroup.getCheckedRadioButtonId() != -1
                        || truckApprovalCertificateRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
            case Other:
                if (otherApprovalCertificateRiskCategoryEditText.getText().length() > 0
                        || driverApprovalCertificateNotesEditText.getText().length() > 0
                        || driverApprovalCertificateABCRadioGroup.getCheckedRadioButtonId() != -1
                        || driverApprovalCertificateRadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
        }
        return true;
    }

    private void clearFieldsForView(TransportRowType transportRowType) {
        switch (transportRowType) {
            case Document:
                goodsDeclarationRow.setRiskCategory(null);
                goodsDeclarationRow.setNotes(null);
                goodsDeclarationRow.setImposed(false);
                goodsDeclarationRow.setBanned(false);
                tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                control.setTdRows(tdRows);

            case WritenInstruction:
                writtenInstructionsRow.setRiskCategory(null);
                writtenInstructionsRow.setNotes(null);
                writtenInstructionsRow.setImposed(false);
                writtenInstructionsRow.setBanned(false);
                tdRows.setWrittenInstructionsRow(writtenInstructionsRow);
                control.setTdRows(tdRows);

            case Approval:
               typeOfApprovalRow.setRiskCategory(null);
               typeOfApprovalRow.setNotes(null);
               typeOfApprovalRow.setImposed(false);
               typeOfApprovalRow.setBanned(false);
               tdRows.setApprovalRow(typeOfApprovalRow);
               control.setTdRows(tdRows);

            case Truck:

                truckCertificateRow.setRiskCategory(null);
                truckCertificateRow.setNotes(null);
                truckCertificateRow.setImposed(false);
                truckCertificateRow.setBanned(false);
                tdRows.setApprovalCertificateRow(truckCertificateRow);
                control.setTdRows(tdRows);
            case Driver:

                driverCertificationRow.setRiskCategory(null);
                driverCertificationRow.setNotes(null);
                driverCertificationRow.setImposed(false);
                driverCertificationRow.setBanned(false);
                tdRows.setDriverCertificationRow(driverCertificationRow);
                control.setTdRows(tdRows);

            case Other:

                otherADRTrainingRow.setRiskCategory(null);
                otherADRTrainingRow.setNotes(null);
                otherADRTrainingRow.setImposed(false);
                otherADRTrainingRow.setBanned(false);
                tdRows.setOtherADRTrainingRow(otherADRTrainingRow);
                control.setTdRows(tdRows);

        }
    }
}