package com.svanberggroup.pfago.Fragments;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.TransportRows;
import com.svanberggroup.pfago.R;

import java.io.Serializable;
import java.util.ArrayList;

public class FragmentEight extends Fragment {



    private static final String NEW_CONTROL = "new_control";

    ArrayList<ControlRow> otherList = new ArrayList<>();
    private View child;

    private Control control;
    private TransportRows tRows;
    private ArrayList<View> views = new ArrayList<>();
    private LinearLayout otherLinerLayout;

    public FragmentEight() {
    }

    public static FragmentEight newInstance(Control control) {
        FragmentEight fragment = new FragmentEight();
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

    private void saveControl() {
        for (View v: views) {
            EditText nameEdit = (EditText) v.findViewById(R.id.nameEditText);
            RadioGroup radioGroupABC = v.findViewById(R.id.radioGroupABC);
            RadioGroup radioGroup = v.findViewById(R.id.janneRadio);
            EditText editText = v.findViewById(R.id.editText);
            EditText notes = v.findViewById(R.id.editText2);

            ControlRow cRow = new ControlRow("janne");

            if(nameEdit.getText().length() > 0) {
                cRow.setTitle(nameEdit.getText().toString());
            }

            if (radioGroupABC.getCheckedRadioButtonId() != -1) {
                switch (radioGroupABC.getCheckedRadioButtonId()) {
                    case R.id.radioButtonControlled:
                        cRow.setField(ControlRow.Field.Controlled);
                        break;
                    case R.id.radioButtonNotApproved:
                        cRow.setField(ControlRow.Field.BreakingTheLaw);
                        break;
                    case R.id.radioButtonNotApplicible:
                        cRow.setField(ControlRow.Field.NotApplicable);
                        break;
                }
            }

            if (editText.getText().length() > 0 && radioGroup.getCheckedRadioButtonId() != -1 && notes.getText().length() > 0) {

                cRow.setRiskCategory(editText.getText().toString());
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton4:
                        cRow.setBanned(false);
                        cRow.setImposed(true);
                        break;
                    case R.id.radioButton5:
                        cRow.setBanned(true);
                        cRow.setImposed(false);
                        break;
                }

            }

            boolean allreadyAdded = false;
            cRow.setNotes(notes.getText().toString());
            if (control.getTRows().getRows40().size() > 0) {
                for (ControlRow r: control.getTRows().getRows40()) {
                    if (r.getRiskCategory().equals(cRow.getRiskCategory()) &&
                            r.getTitle().equals(cRow.getTitle()) &&
                            r.getNotes().equals(cRow.getNotes()) &&
                            r.getField().toString().equals(cRow.getField().toString())) {
                        allreadyAdded = true;
                    }
                }
            }
            if (!allreadyAdded) {
                control.getTRows().addRow40(cRow);
            }

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        saveControl();
    }

    private RadioGroup.OnCheckedChangeListener janne(View[] views) {
        RadioGroup.OnCheckedChangeListener janne = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                        case R.id.radioButtonControlled:
                            for (View v: views) {
                                v.setVisibility(View.GONE);
                            }
                            break;
                        case R.id.radioButtonNotApproved:
                            for (View v: views) {
                                v.setVisibility(View.VISIBLE);
                            }
                            break;
                        case R.id.radioButtonNotApplicible:
                            for (View v: views) {
                                v.setVisibility(View.GONE);
                            }
                            break;
                }
            }
        };
        return janne;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eight, container, false);

        otherLinerLayout = (LinearLayout) view.findViewById(R.id.otherLinearLayout);
        addButtonClickedListner(view, inflater);
        RadioGroup category = view.findViewById(R.id.worstCategoryRadioGroup);
        category.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.highest1RadioButton:
                        control.getTRows().setRiskCategory(TransportRows.RiskCategory.category1);
                        break;
                    case R.id.highest2RadioButton:
                        control.getTRows().setRiskCategory(TransportRows.RiskCategory.category2);
                        break;
                    case R.id.highest3RadioButton:
                        control.getTRows().setRiskCategory(TransportRows.RiskCategory.category3);
                        break;
                }
            }
        });
        return  view;
    }




    private void addButtonClickedListner(View view, LayoutInflater inflater) {
        Button addButton = view.findViewById(R.id.addOtherButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View child = inflater.inflate(R.layout.control_layout, null);
                views.add(child);
                otherLinerLayout.addView(child);
                child.findViewById(R.id.editText).setVisibility(View.GONE);
                child.findViewById(R.id.editText2).setVisibility(View.GONE);
                child.findViewById(R.id.janneRadio).setVisibility(View.GONE);
                RadioGroup janne = child.findViewById(R.id.radioGroupABC);
                janne.setOnCheckedChangeListener(janne(new View[] {
                        child.findViewById(R.id.editText), child.findViewById(R.id.janneRadio), child.findViewById(R.id.editText2)
                }));
            }
        });
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}