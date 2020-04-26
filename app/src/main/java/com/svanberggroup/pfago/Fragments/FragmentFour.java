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

    private enum TransportRowType {
        Document,
        WritenInstruction,
        Approval,
        Truck,
        Driver,
        Other
    }

    private enum Visibility {
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

    public  FragmentFour() {
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
        goodsDeclarationRow = tdRows.getGoodsDeclarationRow();
        writtenInstructionsRow = tdRows.getWrittenInstructionsRow();
        typeOfApprovalRow = tdRows.getApprovalRow();
        truckCertificateRow = tdRows.getApprovalCertificateRow();
        driverCertificationRow = tdRows.getDriverCertificationRow();
        otherADRTrainingRow = tdRows.getOtherADRTrainingRow();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);

        addSubViewToView(view);
        setVisibilityGone(view);
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

        truckApprovalCertificateRiskCategoryEditText.setVisibility(view.GONE);
        truckApprovalCertificateRadioGroup.setVisibility(view.GONE);
        truckApprovalCertificateNotesEditText.setVisibility(view.GONE);

        driverApprovalCertificateRiskCategoryEditText.setVisibility(view.GONE);
        driverApprovalCertificateRadioGroup.setVisibility(view.GONE);
        driverApprovalCertificateNotesEditText.setVisibility(view.GONE);

        otherApprovalCertificateRiskCategoryEditText.setVisibility(view.GONE);
        otherApprovalCertificateRadioGroup.setVisibility(view.GONE);
        otherApprovalCertificateNotesEditText.setVisibility(view.GONE);
    }

    private void setVisibilityFor(TransportRowType transportRowType, int visibility) {
        switch (transportRowType) {
            case Document:
                typeOfDocumentRiskCategoryEditText.setVisibility(visibility);
                typeOfDocumentNotesEditText.setVisibility(visibility);
                typeOfDocumentRadioGroup.setVisibility(visibility);
                break;
            case WritenInstruction:
                writenInstruktionRiskCategoryEditText.setVisibility(visibility);
                writenInstruktionRadioGroup.setVisibility(visibility);
                writenInstruktionNotesEditText.setVisibility(visibility);
                break;
            case Approval:
                typeOfApprovalRiskCategoryEditText.setVisibility(visibility);
                typeOfApprovalRadioGroup.setVisibility(visibility);
                typeOfApprovalNotesEditText.setVisibility(visibility);
                break;
            case Truck:
                truckApprovalCertificateRiskCategoryEditText.setVisibility(visibility);
                truckApprovalCertificateRadioGroup.setVisibility(visibility);
                truckApprovalCertificateNotesEditText.setVisibility(visibility);
                break;
            case Driver:
                driverApprovalCertificateRiskCategoryEditText.setVisibility(visibility);
                driverApprovalCertificateRadioGroup.setVisibility(visibility);
                driverApprovalCertificateNotesEditText.setVisibility(visibility);
                break;
            case Other:
                otherApprovalCertificateRiskCategoryEditText.setVisibility(visibility);
                otherApprovalCertificateRadioGroup.setVisibility(visibility);
                otherApprovalCertificateNotesEditText.setVisibility(visibility);
                break;
        }
    }

    private void handleRadioButtonChecked() {

        chooseTypeOfDocumentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.loadPlanRadioButton:
                        tdRows.setDeclaration(TransportDocumentRows.Declaration.LoadingPlane);
                        control.setTdRows(tdRows);
                        break;
                    case R.id.CPCRadionButton:
                        tdRows.setDeclaration(TransportDocumentRows.Declaration.StowageCertificate);
                        control.setTdRows(tdRows);
                        break;
                }
            }
        });

        typeOfDocumentABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.documemtControlledRadioButton:
                        setVisibilityFor(TransportRowType.Document, View.GONE);
                        clearFieldsForView(TransportRowType.Document);
                        setTdRowFor(goodsDeclarationRow, ControlRow.Field.Controlled, TransportRowType.Document);
                        break;

                    case R.id.documentNotApprovedRadioButton:
                        setVisibilityFor(TransportRowType.Document, View.VISIBLE);
                        setTdRowFor(goodsDeclarationRow, ControlRow.Field.BreakingTheLaw, TransportRowType.Document);
                        break;

                    case R.id.documentNotApplicableRadioButton:
                        setVisibilityFor(TransportRowType.Document, View.GONE);
                        clearFieldsForView(TransportRowType.Document);
                        setTdRowFor(goodsDeclarationRow, ControlRow.Field.NotApplicable, TransportRowType.Document);
                        break;
                }
            }
        });
        typeOfDocumentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.documentImposeRadioButton:
                        goodsDeclarationRow.setImposed(true);
                        goodsDeclarationRow.setBanned(false);
                        tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                        control.setTdRows(tdRows);
                        break;
                    case R.id.documentBannedRadioButton:
                        goodsDeclarationRow.setBanned(true);
                        goodsDeclarationRow.setImposed(false);
                        tdRows.setGoodsDeclarationRow(goodsDeclarationRow);
                        control.setTdRows(tdRows);
                        break;
                }
            }
        });
        writenInstruktionABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.writtenControlledRadioButton:
                        setVisibilityFor(TransportRowType.WritenInstruction, View.GONE);
                        clearFieldsForView(TransportRowType.WritenInstruction);
                        setTdRowFor(writtenInstructionsRow, ControlRow.Field.Controlled, TransportRowType.WritenInstruction);
                        break;

                    case R.id.writtenNotApprovedRadioButton:
                        setVisibilityFor(TransportRowType.WritenInstruction, View.VISIBLE);
                        setTdRowFor(writtenInstructionsRow, ControlRow.Field.BreakingTheLaw, TransportRowType.WritenInstruction);
                        break;

                    case R.id.writtenNotApplicableRadioButton:
                        setVisibilityFor(TransportRowType.WritenInstruction, View.GONE);
                        clearFieldsForView(TransportRowType.WritenInstruction);
                        setTdRowFor(writtenInstructionsRow, ControlRow.Field.NotApplicable, TransportRowType.WritenInstruction);
                        break;
                }

            }
        });
        writenInstruktionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.writtenImposeRadioButton:
                        writtenInstructionsRow.setImposed(true);
                        writtenInstructionsRow.setBanned(false);
                        tdRows.setWrittenInstructionsRow(writtenInstructionsRow);
                        control.setTdRows(tdRows);
                        break;
                    case R.id.writtenBannedRadioButton:
                        writtenInstructionsRow.setImposed(false);
                        writtenInstructionsRow.setBanned(true);
                        tdRows.setWrittenInstructionsRow(writtenInstructionsRow);
                        control.setTdRows(tdRows);
                        break;
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
                        break;
                    case R.id.multiRadioButton:
                        tdRows.setApproval(TransportDocumentRows.Approval.Multilateral);
                        control.setTdRows(tdRows);
                        break;
                    case R.id.natRadioButton:
                        tdRows.setApproval(TransportDocumentRows.Approval.NationalApproval);
                        control.setTdRows(tdRows);
                        break;
                }
            }
        });
        typeOfApprovalABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.typeOfApprovalControlledRadioButton:
                        setVisibilityFor(TransportRowType.Approval, View.GONE);
                        clearFieldsForView(TransportRowType.Approval);
                        setTdRowFor(typeOfApprovalRow, ControlRow.Field.Controlled, TransportRowType.Approval);
                        break;

                    case R.id.typeOfApprovalNotApprovedRadioButton:
                        setVisibilityFor(TransportRowType.Approval, View.VISIBLE);
                        setTdRowFor(typeOfApprovalRow, ControlRow.Field.BreakingTheLaw, TransportRowType.Approval);
                        break;

                    case R.id.typeOfApprovalNotApplicableRadioButton:
                        setVisibilityFor(TransportRowType.Approval, View.GONE);
                        clearFieldsForView(TransportRowType.Approval);
                        setTdRowFor(typeOfApprovalRow, ControlRow.Field.NotApplicable, TransportRowType.Approval);
                        break;
                }
            }
        });
        typeOfApprovalRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.approvalImposeRadioButton:
                        typeOfApprovalRow.setImposed(true);
                        typeOfApprovalRow.setBanned(false);
                        tdRows.setApprovalRow(typeOfApprovalRow);
                        control.setTdRows(tdRows);
                        break;
                    case R.id.approvalBannedRadioButton:
                        typeOfApprovalRow.setBanned(true);
                        typeOfApprovalRow.setImposed(false);
                        tdRows.setApprovalRow(typeOfApprovalRow);
                        control.setTdRows(tdRows);
                        break;
                }
            }
        });
        truckApprovalCertificateABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.truckApprovalControlledRadioButton:
                        setVisibilityFor(TransportRowType.Truck, View.GONE);
                        clearFieldsForView(TransportRowType.Truck);
                        setTdRowFor(truckCertificateRow, ControlRow.Field.Controlled, TransportRowType.Truck);
                        break;

                    case R.id.truckApprovalNotApprovedRadioButton:
                        setVisibilityFor(TransportRowType.Truck, View.VISIBLE);
                        setTdRowFor(truckCertificateRow, ControlRow.Field.BreakingTheLaw, TransportRowType.Truck);
                        break;

                    case R.id.truckApprovalNotApplicableRadioButton:
                        setVisibilityFor(TransportRowType.Truck, View.GONE);
                        clearFieldsForView(TransportRowType.Truck);
                        setTdRowFor(truckCertificateRow, ControlRow.Field.NotApplicable, TransportRowType.Truck);
                        break;
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
                        break;
                    case R.id.truckApprovalBannedRadioButton:
                        truckCertificateRow.setBanned(true);
                        truckCertificateRow.setImposed(false);
                        tdRows.setApprovalCertificateRow(truckCertificateRow);
                        control.setTdRows(tdRows);
                        break;
                }
            }
        });
        driverApprovalCertificateABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.driverApprovalControlledRadioButton:
                        setVisibilityFor(TransportRowType.Driver, View.GONE);
                        clearFieldsForView(TransportRowType.Driver);
                        setTdRowFor(driverCertificationRow, ControlRow.Field.Controlled, TransportRowType.Driver);
                        break;

                    case R.id.driverApprovalNotApprovedRadioButton:
                        setVisibilityFor(TransportRowType.Driver, View.VISIBLE);
                        setTdRowFor(driverCertificationRow, ControlRow.Field.BreakingTheLaw, TransportRowType.Driver);
                        break;

                    case R.id.driverApprovalImposeRadioButton:
                        setVisibilityFor(TransportRowType.Driver, View.GONE);
                        clearFieldsForView(TransportRowType.Driver);
                        setTdRowFor(driverCertificationRow, ControlRow.Field.NotApplicable, TransportRowType.Driver);
                        break;
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
                        break;
                    case R.id.driverApprovalBannedRadioButton:
                        driverCertificationRow.setBanned(true);
                        driverCertificationRow.setImposed(false);
                        tdRows.setApprovalCertificateRow(driverCertificationRow);
                        control.setTdRows(tdRows);
                        break;
                }
            }
        });
        otherApprovalCertificateABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.otherApprovalControlledRadioButton:
                        setVisibilityFor(TransportRowType.Other, View.GONE);
                        clearFieldsForView(TransportRowType.Other);
                        setTdRowFor(otherADRTrainingRow, ControlRow.Field.Controlled, TransportRowType.Other);
                        break;

                    case R.id.otherApprovalNotApprovedRadioButton:
                        setVisibilityFor(TransportRowType.Other, View.VISIBLE);
                        setTdRowFor(otherADRTrainingRow, ControlRow.Field.BreakingTheLaw, TransportRowType.Other);
                        break;

                    case R.id.otherApprovalNotApplicableRadioButton:
                        setVisibilityFor(TransportRowType.Other, View.GONE);
                        clearFieldsForView(TransportRowType.Other);
                        setTdRowFor(otherADRTrainingRow, ControlRow.Field.NotApplicable, TransportRowType.Other);
                        break;
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
                        break;
                    case R.id.otherApprovalBannedRadioButton:
                        otherADRTrainingRow.setBanned(true);
                        otherADRTrainingRow.setImposed(false);
                        tdRows.setOtherADRTrainingRow(otherADRTrainingRow);
                        control.setTdRows(tdRows);
                        break;
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
                break;
            case WritenInstruction:
                tdRows.setWrittenInstructionsRow(controlRow);
                break;
            case Approval:
                tdRows.setApprovalRow(controlRow);
                break;
            case Truck:
                tdRows.setApprovalCertificateRow(controlRow);
                break;
            case Driver:
                tdRows.setDriverCertificationRow(controlRow);
                break;
            case Other:
                tdRows.setOtherADRTrainingRow(controlRow);
                break;

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
                break;

            case WritenInstruction:
                writtenInstructionsRow.setRiskCategory(null);
                writtenInstructionsRow.setNotes(null);
                writtenInstructionsRow.setImposed(false);
                writtenInstructionsRow.setBanned(false);
                tdRows.setWrittenInstructionsRow(writtenInstructionsRow);
                control.setTdRows(tdRows);
                break;

            case Approval:
               typeOfApprovalRow.setRiskCategory(null);
               typeOfApprovalRow.setNotes(null);
               typeOfApprovalRow.setImposed(false);
               typeOfApprovalRow.setBanned(false);
               tdRows.setApprovalRow(typeOfApprovalRow);
               control.setTdRows(tdRows);
               break;

            case Truck:
                truckCertificateRow.setRiskCategory(null);
                truckCertificateRow.setNotes(null);
                truckCertificateRow.setImposed(false);
                truckCertificateRow.setBanned(false);
                tdRows.setApprovalCertificateRow(truckCertificateRow);
                control.setTdRows(tdRows);
                break;

            case Driver:
                driverCertificationRow.setRiskCategory(null);
                driverCertificationRow.setNotes(null);
                driverCertificationRow.setImposed(false);
                driverCertificationRow.setBanned(false);
                tdRows.setDriverCertificationRow(driverCertificationRow);
                control.setTdRows(tdRows);
                break;

            case Other:

                otherADRTrainingRow.setRiskCategory(null);
                otherADRTrainingRow.setNotes(null);
                otherADRTrainingRow.setImposed(false);
                otherADRTrainingRow.setBanned(false);
                tdRows.setOtherADRTrainingRow(otherADRTrainingRow);
                control.setTdRows(tdRows);
                break;

        }
    }
}