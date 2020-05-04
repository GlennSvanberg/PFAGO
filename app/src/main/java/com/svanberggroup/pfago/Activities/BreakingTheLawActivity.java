package com.svanberggroup.pfago.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.Fault;
import com.svanberggroup.pfago.Models.Goods;
import com.svanberggroup.pfago.Models.SafetyAdvisor;
import com.svanberggroup.pfago.R;

import java.util.ArrayList;
import java.util.List;

public class BreakingTheLawActivity extends AppCompatActivity {
    private Control control;
    private LinearLayout godsLinearLayout;
    private LinearLayout flawLinearLayout;
    private LinearLayout ofLinearLayout;
    private Button godsAddButton;
    private Button flawsAddButton;
    private List<View> godsViews;
    private List<View> flawsViews;
    private List<EditText> ofEdits;
    private EditText safteyAdvisorTransporterName;
    private EditText safteyAdvisorSenderName;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.breaking_the_law_menu, menu);
        return true;
    }

    private List<Goods> createListofGoods() {
        List<Goods> goods = new ArrayList<>();
        for (View v: godsViews) {
            EditText un = v.findViewById(R.id.godsNrEditText);
            EditText decription = v.findViewById(R.id.godsDescriptionEditText);
            EditText classs = v.findViewById(R.id.classEditText);
            EditText gods = v.findViewById(R.id.godsAmountEditText);
            EditText paper = v.findViewById(R.id.paperEditText);
            EditText LQ = v.findViewById(R.id.LQeditText);
            EditText PG = v.findViewById(R.id.PGeditText);
            Goods good = new Goods("A",
                    un.getText().toString(),
                    decription.getText().toString(), classs.getText().toString(),
                    PG.getText().toString(),
                    gods.getText().toString(),paper.getText().toString(),
                    true);
            goods.add(good);
        }
        return goods;
    }

    private List<Fault> createListOfFlaws() {
        List<Fault> faults = new ArrayList<>();
        for (View v: flawsViews) {
            EditText field = v.findViewById(R.id.fieldNrEditText);
            EditText flawsGodsPos = v.findViewById(R.id.flawGodsPosDescriptionEditText);
            EditText flaw = v.findViewById(R.id.flawEditText);
            EditText mNumber = v.findViewById(R.id.mNumberEditText);
            Fault fault = new Fault(Integer.parseInt(field.getText().toString()), flawsGodsPos.getText().toString(),
                                    flaw.getText().toString(), mNumber.getText().toString());
            faults.add(fault);
        }
        return faults;
    }

    private void addOFs() {
        for (EditText e: ofEdits) {
           control.addPenalty(e.getText().toString());
        }
    }


    private void setFieldsInControl() {
        control.setGoodsList(createListofGoods());
        control.setFaultList(createListOfFlaws());
        addOFs();
        control.getSafetyAdvisorSender().setName(safteyAdvisorSenderName.getText().toString());
        control.getSafetyAdvisorCarrier().setName(safteyAdvisorTransporterName.getText().toString());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setFieldsInControl();

        Intent intent = new Intent(this, ViewControlActivity.class);
        intent.putExtra("control", control);
        intent.putExtra("approvalMode", true);
        startActivity(intent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breaking_the_law);
        safteyAdvisorSenderName = findViewById(R.id.safteyAdvisorSenderNameEditText);
        safteyAdvisorTransporterName = findViewById(R.id.safteyAdvisorTransporterNameEditText);

        flawLinearLayout = (LinearLayout) findViewById(R.id.flawLinearLayout);
        godsLinearLayout = (LinearLayout) findViewById(R.id.godsLinearLayout);
        ofLinearLayout = (LinearLayout) findViewById(R.id.OFlinearLayout);

        View childGods = getLayoutInflater().inflate(R.layout.gods_input_layout, null);
        View childFlaw = getLayoutInflater().inflate(R.layout.flaws_input_layout, null);
        EditText text = new EditText(getApplicationContext());
        text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        text.setHint(R.string.of);
        ofLinearLayout.addView(text);




        godsLinearLayout.addView(childGods);
        flawLinearLayout.addView(childFlaw);

        godsViews = new ArrayList<>();
        flawsViews = new ArrayList<>();
        ofEdits = new ArrayList<>();

        ofEdits.add(text);
        godsViews.add(childGods);
        flawsViews.add(childFlaw);

        addButtonListners();
        toggleViewButton();
    }

    private void addButtonListners() {
        godsAddButton = findViewById(R.id.addGodsBreakingTheLawButton);
        flawsAddButton = findViewById(R.id.flawAddBreakingTheLawButton);
        Button ofAddButton = findViewById(R.id.addOfButton);
        RadioGroup safteyAdvisorTranporterRadioGroup = findViewById(R.id.safetyAdvisorTransporterRadioGroup);
        RadioGroup safetyAdvisorSenderRadioGroup = findViewById(R.id.safetySenderRadioGroup);
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RadioGroup consentRadioGroup = findViewById(R.id.consentRadioGroup);
        RadioGroup isAllowedToContinueTrip = findViewById(R.id.shortestWayRadioGroup);
        RadioGroup reportedRadioGroup = findViewById(R.id.entityReportedRadioGroup);

        godsAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View addView = layoutInflater.inflate(R.layout.gods_input_layout, null);
                godsLinearLayout.addView(addView);
                godsViews.add(addView);
            }
        });
        flawsAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View addView = layoutInflater.inflate(R.layout.flaws_input_layout, null);
                flawLinearLayout.addView(addView);
                flawsViews.add(addView);
            }
        });
        ofAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text = new EditText(getApplicationContext());
                text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                text.setHint(R.string.of);
                ofLinearLayout.addView(text);
                ofEdits.add(text);
            }
        });
        safteyAdvisorTranporterRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.dontKnowRadioButton:

                        control.getSafetyAdvisorCarrier().setAnswer(SafetyAdvisor.Answer.Unknown);
                        break;
                    case R.id.yesRadioButton:
                        control.getSafetyAdvisorCarrier().setAnswer(SafetyAdvisor.Answer.Yes);
                        break;
                    case R.id.noRadioButton:
                        control.getSafetyAdvisorCarrier().setAnswer(SafetyAdvisor.Answer.No);
                        break;
                }
            }
        });
        safetyAdvisorSenderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.dontKnowSenderRadioButton:
                        control.getSafetyAdvisorSender().setAnswer(SafetyAdvisor.Answer.Unknown);
                        break;
                    case R.id.noSenderRadioButton:
                        control.getSafetyAdvisorSender().setAnswer(SafetyAdvisor.Answer.No);
                        break;
                    case R.id.yesRadioButton:
                        control.getSafetyAdvisorSender().setAnswer(SafetyAdvisor.Answer.Yes);
                        break;
                }
            }
        });
        consentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            ArrayList<Integer> list = new ArrayList<>();
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.YesRadioButton:
                        control.setAdmissionGiven(true);
                        break;
                    case R.id.NoRadioButton:
                        control.setAdmissionGiven(false);
                        break;
                }
            }
        });
        isAllowedToContinueTrip.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.shortestWayYesRadioButton:
                        control.setAllowedToContinueTrip(true);
                        break;
                    case R.id.shortestWayNoRadioButton:
                        control.setAllowedToContinueTrip(false);
                        break;
                }
            }
        });
        reportedRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.driverReportedRadioButton:
                        control.setReportedEntity(Control.ReportedEntity.Driver);
                        break;
                    case R.id.carrierReportedRadioButton:
                        control.setReportedEntity(Control.ReportedEntity.Carrier);
                        break;
                    case R.id.coDriverReportedRadioButton:
                        control.setReportedEntity(Control.ReportedEntity.Passenger);
                        break;
                    case R.id.senderReportedRadioButton:
                        control.setReportedEntity(Control.ReportedEntity.Sender);
                        break;
                    case R.id.reciverReportedRadioButton:
                        control.setReportedEntity(Control.ReportedEntity.Receiver);
                        break;
                    case R.id.otherReportedRadioButton:
                        control.setReportedEntity(Control.ReportedEntity.Other);
                        break;
                }
            }
        });
    }

    private void toggleViewButton() {
        ToggleButton toggle = findViewById(R.id.toggleButton);
        ToggleButton toggle1 = findViewById(R.id.toggleButton1);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    findViewById(R.id.godsLinearLayout).setVisibility(View.GONE);
                    findViewById(R.id.addGodsBreakingTheLawButton).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.godsLinearLayout).setVisibility(View.VISIBLE);
                    findViewById(R.id.addGodsBreakingTheLawButton).setVisibility(View.VISIBLE);
                }
            }
        });
        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    findViewById(R.id.flawLinearLayout).setVisibility(View.GONE);
                    findViewById(R.id.flawAddBreakingTheLawButton).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.flawLinearLayout).setVisibility(View.VISIBLE);
                    findViewById(R.id.flawAddBreakingTheLawButton).setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
