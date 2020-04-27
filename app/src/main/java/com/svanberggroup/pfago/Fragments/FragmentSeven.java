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
import com.svanberggroup.pfago.Models.TransportRows;
import com.svanberggroup.pfago.R;

import java.io.Serializable;

public class FragmentSeven extends Fragment {

    private enum Transport {
        approved24,
        marking25,
        labeling252,
        bigLabel26,
        signage27
    }

    private static final String NEW_CONTROL = "new_control";

    private RadioGroup approved24ABCRadioGroup;
    private EditText approved24RiskCategoryEditText;
    private RadioGroup approved24RadioGroup;
    private EditText approved24NotesEditText;
    private ControlRow approved24Row;

    private RadioGroup marking25ABCRadioGroup;
    private EditText marking25RiskCategoryEditText;
    private RadioGroup marking25RadioGroup;
    private EditText marking25NotesEditText;
    private ControlRow marking25Row;


    private RadioGroup labeling252ABCRadioGroup;
    private EditText labeling252RiskCategoryEditText;
    private RadioGroup labeling252RadioGroup;
    private EditText labeling252NotesEditText;
    private ControlRow labeling252Row;

    private RadioGroup bigLabel26ABCRadioGroup;
    private EditText bigLabel26RiskCategoryEditText;
    private RadioGroup bigLabel26RadioGroup;
    private EditText bigLabel26NotesEditText;
    private ControlRow bigLabel26Row;

    private RadioGroup signage27ABCRadioGroup;
    private EditText signage27RiskCategoryEditText;
    private RadioGroup signage27RadioGroup;
    private EditText signage27NotesEditText;
    private ControlRow signage27Row;

    private Control control;
    private TransportRows tRows;

    public FragmentSeven() {
    }

    public static FragmentSeven newInstance(Control control) {
        FragmentSeven fragment = new FragmentSeven();
        Bundle args = new Bundle();
        args.putSerializable(NEW_CONTROL, (Serializable) control);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        control = (Control) getArguments().getSerializable(NEW_CONTROL);

        if (control.getTRows() != null) {
            tRows = control.getTRows();
        } else {
            tRows = new TransportRows();
        }

        approved24Row = tRows.getRow24();
        marking25Row = tRows.getRow25_1();
        labeling252Row = tRows.getRow25_2();
        bigLabel26Row = tRows.getRow26();
        signage27Row = tRows.getRow27();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seven, container, false);

        addSubViewToView(view);
        setVisibilityGone();
        handleRadioButtonInput();
        handleTextInput();

        return  view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    private void addSubViewToView(View view) {
        approved24ABCRadioGroup= view.findViewById(R.id.approved24ABCRadioGroup);
        approved24RiskCategoryEditText = view.findViewById(R.id.approved24RiskCategoryEditText);
        approved24RadioGroup = view.findViewById(R.id.approved24RadioGroup);
        approved24NotesEditText = view.findViewById(R.id.approved24NotesRadioButton);

        marking25ABCRadioGroup = view.findViewById(R.id.marking25ABCRadioGroup);
        marking25RiskCategoryEditText = view.findViewById(R.id.marking25RiskCategoryEditText);
        marking25RadioGroup = view.findViewById(R.id.marking25RadioGroup);
        marking25NotesEditText = view.findViewById(R.id.marking25NotesRadioButton);

        labeling252ABCRadioGroup = view.findViewById(R.id.labeling252ABCRadioGroup);
        labeling252RiskCategoryEditText = view.findViewById(R.id.labeling252RiskCategoryEditText);
        labeling252RadioGroup = view.findViewById(R.id.labeling252RadioGroup);
        labeling252NotesEditText = view.findViewById(R.id.labeling252NotesRadioButton);

        bigLabel26ABCRadioGroup = view.findViewById(R.id.bigLabel26ABCRadioGroup);
        bigLabel26RiskCategoryEditText = view.findViewById(R.id.bigLabel26RiskCategoryEditText);
        bigLabel26RadioGroup = view.findViewById(R.id.bigLabel26RadioGroup);
        bigLabel26NotesEditText = view.findViewById(R.id.bigLabel26NotesRadioButton);

        signage27ABCRadioGroup = view.findViewById(R.id.signage27ABCRadioGroup);
        signage27RiskCategoryEditText = view.findViewById(R.id.signage27RiskCategoryEditText);
        signage27RadioGroup = view.findViewById(R.id.signage27RadioGroup);
        signage27NotesEditText = view.findViewById(R.id.signage27NotesRadioButton);
    }

    private void setVisibilityGone() {
        approved24RiskCategoryEditText.setVisibility(View.GONE);
        approved24RadioGroup.setVisibility(View.GONE);
        approved24NotesEditText.setVisibility(View.GONE);

        marking25RiskCategoryEditText.setVisibility(View.GONE);
        marking25RadioGroup.setVisibility(View.GONE);
        marking25NotesEditText.setVisibility(View.GONE);

        labeling252RiskCategoryEditText.setVisibility(View.GONE);
        labeling252RadioGroup.setVisibility(View.GONE);
        labeling252NotesEditText.setVisibility(View.GONE);

        bigLabel26RiskCategoryEditText.setVisibility(View.GONE);
        bigLabel26RadioGroup.setVisibility(View.GONE);
        bigLabel26NotesEditText.setVisibility(View.GONE);

        signage27RiskCategoryEditText.setVisibility(View.GONE);
        signage27RadioGroup.setVisibility(View.GONE);
        signage27NotesEditText.setVisibility(View.GONE);

    }

    private void setVisibilityFor(Transport transport, int visibility) {
        switch (transport) {
            case approved24:
                approved24RiskCategoryEditText.setVisibility(visibility);
                approved24NotesEditText.setVisibility(visibility);
                approved24RadioGroup.setVisibility(visibility);
                break;
            case marking25:
                marking25RiskCategoryEditText.setVisibility(visibility);
                marking25NotesEditText.setVisibility(visibility);
                marking25RadioGroup.setVisibility(visibility);
                break;
            case labeling252:
                labeling252RiskCategoryEditText.setVisibility(visibility);
                labeling252NotesEditText.setVisibility(visibility);
                labeling252RadioGroup.setVisibility(visibility);
                break;
            case bigLabel26:
                bigLabel26RiskCategoryEditText.setVisibility(visibility);
                bigLabel26NotesEditText.setVisibility(visibility);
                bigLabel26RadioGroup.setVisibility(visibility);
                break;
            case signage27:
                signage27RiskCategoryEditText.setVisibility(visibility);
                signage27NotesEditText.setVisibility(visibility);
                signage27RadioGroup.setVisibility(visibility);
                break;
        }
    }

    private void handleRadioButtonInput() {
        approved24ABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.approved24ControlledRadioButton:
                        setVisibilityFor(Transport.approved24, View.GONE);
                        approved24Row.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.approved24);
                        break;

                    case R.id.handlingNotApprovedRadioButton:
                        setVisibilityFor(Transport.approved24, View.VISIBLE);
                        approved24Row.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow24(approved24Row);
                        control.setTRows(tRows);
                        break;

                    case R.id.handlingNotApplicableRadioButton:
                        setVisibilityFor(Transport.approved24, View.GONE);
                        approved24Row.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.approved24);
                        break;
                }
            }
        });
        marking25ABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.loadingControlledRadioButton:
                        setVisibilityFor(Transport.marking25, View.GONE);
                        marking25Row.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.marking25);
                        break;

                    case R.id.loadingNotApprovedRadioButton:
                        setVisibilityFor(Transport.marking25, View.VISIBLE);
                        marking25Row.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow25_1(marking25Row);
                        control.setTRows(tRows);
                        break;

                    case R.id.loadingNotApplicableRadioButton:
                        setVisibilityFor(Transport.marking25, View.GONE);
                        marking25Row.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.marking25);
                        break;
                }
            }
        });
        labeling252ABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.securingCargoControlledRadioButton:
                        setVisibilityFor(Transport.labeling252, View.GONE);
                        labeling252Row.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.labeling252);
                        break;

                    case R.id.securingCargoNotApprovedRadioButton:
                        setVisibilityFor(Transport.labeling252, View.VISIBLE);
                        labeling252Row.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow25_2(labeling252Row);
                        control.setTRows(tRows);
                        break;

                    case R.id.securingCargoNotApplicableRadioButton:
                        setVisibilityFor(Transport.labeling252, View.GONE);
                        labeling252Row.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.labeling252);
                        break;
                }
            }
        });
        bigLabel26ABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.leakageControlledRadioButton:
                        setVisibilityFor(Transport.bigLabel26, View.GONE);
                        bigLabel26Row.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.bigLabel26);
                        break;

                    case R.id.leakageNotApprovedRadioButton:
                        setVisibilityFor(Transport.bigLabel26, View.VISIBLE);
                        bigLabel26Row.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow26(bigLabel26Row);
                        control.setTRows(tRows);
                        break;

                    case R.id.leakageNotApplicableRadioButton:
                        setVisibilityFor(Transport.bigLabel26, View.GONE);
                        bigLabel26Row.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.bigLabel26);
                        break;
                }
            }
        });
        signage27ABCRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.damagesControlledRadioButton:
                        setVisibilityFor(Transport.signage27, View.GONE);
                        signage27Row.setField(ControlRow.Field.Controlled);
                        clearFieldsForView(Transport.signage27);
                        break;

                    case R.id.damagesNotApprovedRadioButton:
                        setVisibilityFor(Transport.signage27, View.VISIBLE);
                        signage27Row.setField(ControlRow.Field.BreakingTheLaw);
                        tRows.setRow27(signage27Row);
                        control.setTRows(tRows);
                        break;

                    case R.id.damagesNotApplicableRadioButton:
                        setVisibilityFor(Transport.signage27, View.GONE);
                        signage27Row.setField(ControlRow.Field.NotApplicable);
                        clearFieldsForView(Transport.signage27);
                        break;
                }
            }
        });

    }

    private void handleTextInput() {
        approved24RiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    approved24Row.setRiskCategory(s.toString());
                    tRows.setRow24(approved24Row);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    approved24Row.setRiskCategory(null);
                    tRows.setRow24(approved24Row);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.approved24)) {
                    tRows.setRow24(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        approved24NotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    approved24Row.setNotes(s.toString());
                    tRows.setRow24(approved24Row);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    approved24Row.setNotes(null);
                    tRows.setRow24(approved24Row);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.approved24)) {
                    tRows.setRow18(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        marking25RiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    marking25Row.setRiskCategory(s.toString());
                    tRows.setRow25_1(marking25Row);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    marking25Row.setRiskCategory(null);
                    tRows.setRow25_1(marking25Row);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.marking25)) {
                    tRows.setRow25_1(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        marking25NotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    marking25Row.setNotes(s.toString());
                    tRows.setRow25_1(marking25Row);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    marking25Row.setNotes(null);
                    tRows.setRow25_1(marking25Row);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.marking25)) {
                    tRows.setRow25_1(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        labeling252RiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    labeling252Row.setRiskCategory(s.toString());
                    tRows.setRow25_2(labeling252Row);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    labeling252Row.setRiskCategory(null);
                    tRows.setRow25_2(labeling252Row);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.labeling252)) {
                    tRows.setRow25_2(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        labeling252NotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    labeling252Row.setNotes(s.toString());
                    tRows.setRow25_2(labeling252Row);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    labeling252Row.setNotes(null);
                    tRows.setRow25_2(labeling252Row);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.labeling252)) {
                    tRows.setRow25_2(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        bigLabel26RiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    bigLabel26Row.setRiskCategory(s.toString());
                    tRows.setRow26(bigLabel26Row);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    bigLabel26Row.setRiskCategory(null);
                    tRows.setRow26(bigLabel26Row);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.bigLabel26)) {
                    tRows.setRow26(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        bigLabel26NotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    bigLabel26Row.setNotes(s.toString());
                    tRows.setRow26(bigLabel26Row);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    bigLabel26Row.setNotes(null);
                    tRows.setRow26(bigLabel26Row);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.bigLabel26)) {
                    tRows.setRow26(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        signage27RiskCategoryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    signage27Row.setRiskCategory(s.toString());
                    tRows.setRow27(signage27Row);
                    control.setTRows(tRows);
                } else if (s.length() == 0) {
                    signage27Row.setRiskCategory(null);
                    tRows.setRow27(signage27Row);
                    control.setTRows(tRows);
                }
                if (viewEmptyFor(Transport.signage27)) {
                    tRows.setRow27(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        signage27NotesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    signage27Row.setNotes(s.toString());
                    tRows.setRow27(signage27Row);
                    control.setTRows(tRows);

                } else if (s.length() == 0) {
                    signage27Row.setNotes(null);
                    tRows.setRow27(signage27Row);
                    control.setTRows(tRows);

                }
                if (viewEmptyFor(Transport.signage27)) {
                    tRows.setRow22_1(null);
                    control.setTRows(tRows);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void clearFieldsForView(Transport transport) {
        switch (transport) {
            case approved24:
                approved24Row.setNotes("");
                approved24Row.setRiskCategory("");
                approved24Row.setImposed(false);
                approved24Row.setBanned(false);
                tRows.setRow24(approved24Row);
                control.setTRows(tRows);
                break;

            case marking25:
                marking25Row.setNotes("");
                marking25Row.setRiskCategory("");
                marking25Row.setImposed(false);
                marking25Row.setBanned(false);
                tRows.setRow25_1(marking25Row);
                control.setTRows(tRows);
                break;

            case labeling252:
                labeling252Row.setNotes("");
                labeling252Row.setRiskCategory("");
                labeling252Row.setImposed(false);
                labeling252Row.setBanned(false);
                tRows.setRow25_2(labeling252Row);
                control.setTRows(tRows);
                break;

            case bigLabel26:
                bigLabel26Row.setNotes("");
                bigLabel26Row.setRiskCategory("");
                bigLabel26Row.setBanned(false);
                bigLabel26Row.setImposed(false);
                tRows.setRow26(bigLabel26Row);
                control.setTRows(tRows);
                break;

            case signage27:
                signage27Row.setRiskCategory("");
                signage27Row.setNotes("");
                signage27Row.setImposed(false);
                signage27Row.setBanned(false);
                tRows.setRow27(signage27Row);
                control.setTRows(tRows);
                break;
        }

    }

    private boolean viewEmptyFor(Transport transport) {
        switch (transport) {
            case approved24:
                if (approved24RiskCategoryEditText.getText().length() > 0
                        || approved24NotesEditText.getText().length() > 0
                        || approved24ABCRadioGroup.getCheckedRadioButtonId() != -1
                        || approved24RadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case marking25:
                if (marking25RiskCategoryEditText.getText().length() > 0
                        || marking25NotesEditText.getText().length() > 0
                        || marking25ABCRadioGroup.getCheckedRadioButtonId() != -1
                        || marking25RadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case labeling252:
                if (labeling252RiskCategoryEditText.getText().length() > 0
                        || labeling252NotesEditText.getText().length() > 0
                        || labeling252ABCRadioGroup.getCheckedRadioButtonId() != -1
                        || labeling252RadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case bigLabel26:
                if (bigLabel26RiskCategoryEditText.getText().length() > 0
                        || bigLabel26NotesEditText.getText().length() > 0
                        || bigLabel26ABCRadioGroup.getCheckedRadioButtonId() != -1
                        || bigLabel26RadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
            case signage27:
                if (signage27RiskCategoryEditText.getText().length() > 0
                        || signage27NotesEditText.getText().length() > 0
                        || signage27ABCRadioGroup.getCheckedRadioButtonId() != -1
                        || signage27RadioGroup.getCheckedRadioButtonId() != -1) {
                    return false;
                }
                break;
        }
        return true;
    }
}