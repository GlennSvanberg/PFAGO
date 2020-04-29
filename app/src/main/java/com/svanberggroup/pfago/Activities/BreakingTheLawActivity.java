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
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.Fault;
import com.svanberggroup.pfago.Models.Goods;
import com.svanberggroup.pfago.R;

import java.util.ArrayList;
import java.util.List;

public class BreakingTheLawActivity extends AppCompatActivity {
    private Control control;
    private LinearLayout godsLinearLayout;
    private LinearLayout flawLinearLayout;
    private Button godsAddButton;
    private Button flawsAddButton;
    private List<View> godsViews;
    private List<View> flawsViews;

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

    private void setFieldsInControl() {
        control.setGoodsList(createListofGoods());
        control.setFaultList(createListOfFlaws());
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

        control = (Control) getIntent().getSerializableExtra("control");
        flawLinearLayout = (LinearLayout) findViewById(R.id.flawLinearLayout);
        godsLinearLayout = (LinearLayout) findViewById(R.id.godsLinearLayout);
        View childGods = getLayoutInflater().inflate(R.layout.gods_input_layout, null);
        View childFlaw = getLayoutInflater().inflate(R.layout.flaws_input_layout, null);

        godsLinearLayout.addView(childGods);
        flawLinearLayout.addView(childFlaw);

        godsViews = new ArrayList<>();
        flawsViews= new ArrayList<>();
        godsViews.add(childGods);
        flawsViews.add(childFlaw);

        addButtonListners();
        toggleViewButton();
    }

    private void addButtonListners() {
        godsAddButton = findViewById(R.id.addGodsBreakingTheLawButton);
        flawsAddButton = findViewById(R.id.flawAddBreakingTheLawButton);
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
