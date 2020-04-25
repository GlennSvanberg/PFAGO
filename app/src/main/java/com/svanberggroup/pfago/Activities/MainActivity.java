package com.svanberggroup.pfago.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationServices;
import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.Fault;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

import java.text.SimpleDateFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Control> controls;

    private EditText queryField;
    private TextView messageTextView;
    private ImageButton searchButton;
    private Button ribButton, addControlButton;
    private RecyclerView recyclerView;
    private LinearLayout buttonsLinearLayout;
    private ControlAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
   // private FusedLocationProviderClient fusedLocationClient;

    private boolean isSearchMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controls = ControlRepository.get().getAllControls();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //temp change to see recyclerview should be View.GONE - View.VISIBLE
        recyclerView.setVisibility(View.GONE);

        ribButton = findViewById(R.id.rib_search_button);
        ribButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRIBActivity();
            }
        });
        addControlButton = findViewById(R.id.add_control_button);
        addControlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAddControlActivity();
            }
        });
        buttonsLinearLayout = (LinearLayout) findViewById(R.id.buttons_linear_layout);
        buttonsLinearLayout.setVisibility(View.VISIBLE);

        messageTextView = findViewById(R.id.message_text_view);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        updateUI();

        queryField = (EditText) findViewById(R.id.query);
        queryField.requestFocus();
        queryField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                isSearchMode = true;
                if(charSequence.length() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    buttonsLinearLayout.setVisibility(View.VISIBLE);
                    searchButton.setImageResource(R.drawable.ic_search);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isSearchMode) {
                    controls = ControlRepository.get().getControlsByRegNr(queryField.getText().toString());
                    if(controls.size() == 0){
                        messageTextView.setVisibility(View.VISIBLE);
                        messageTextView.setText("Inga kontroller för: " + queryField.getText().toString());
                        buttonsLinearLayout.setVisibility(View.VISIBLE);
                    } else {
                        buttonsLinearLayout.setVisibility(View.GONE);
                        messageTextView.setVisibility(View.GONE);
                        searchButton.setImageResource(R.drawable.ic_clear);
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                    updateUI();
                    isSearchMode = !isSearchMode;

                } else {
                    queryField.setText("");
                    searchButton.setImageResource(R.drawable.ic_search);
                    //messageTextView.setVisibility(View.GONE);
                    isSearchMode = !isSearchMode;
                }
            }
        });
    }

    private void updateUI(){
        if(adapter == null) {
            adapter = new ControlAdapter(controls);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setControls(controls);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //controls = ControlRepository.get().getAllControls();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rib:
                startRIBActivity();
                return true;
            case R.id.add_control:
                startAddControlActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startRIBActivity() {
        Intent intent = new Intent(this, RIBActivity.class);
        startActivity(intent);
    }

    private void startAddControlActivity() {
        Intent intent = new Intent(this, AddControlActivity.class);
        startActivity(intent);
    }

    private class ControlHolder extends RecyclerView.ViewHolder {

        private Control control;
        private TextView left, right, title;
        public ControlHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.view_control_card,parent, false));
             title = itemView.findViewById(R.id.card_title);
             left = itemView.findViewById(R.id.card_body_left);
             right = itemView.findViewById(R.id.card_body_right);
        }

        public void bind(Control control) {
            this.control = control;
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
            String date = formatter.format(control.getStartDate());
            setText(title,"<strong>" + date + "</strong> - " +  control.getTruck().getRegNr());

            setText(left, cardTextLeft(control));
            setText(right, cardTextRight(control));
        }

    }

    private String cardTextLeft(Control control){
        StringBuilder str =new StringBuilder();
        if(control.getCarrier()!= null) {
            str.append(line("Företag:", control.getCarrier().getName()));
        }
        if(control.getDriver() != null) {
            str.append(line("Förare: ", control.getDriver().getName()));
        }
        if(control.getTruck() != null) {
            str.append(line(getString(control.getTruck().getVehicleType().label) + ":", control.getTruck().getRegNr() + " " + control.getTruck().getNationality()));
        }
        if(control.getTrailer() != null) {
            str.append(line(getString(control.getTrailer().getVehicleType().label) + ":", control.getTrailer().getRegNr() + " " + control.getTrailer().getNationality()));
        }
        return str.toString();
    }

    private String cardTextRight(Control control){
        StringBuilder str =new StringBuilder();
        List<Fault> faults = control.getFaultList();

        if(faults.size() > 0){
            for(Fault fault : faults) {
                str.append(line("Brist " + fault.getFieldNr() + ":", fault.getFault()));
            }
        } else {
            str.append(line("", "Inga brister"));
        }
        return str.toString();
    }

    private String line(String title, String data) {
        return title + " <strong>" + data + "</strong>" + "<br>";
    }

    private void setText(TextView textView, String str) {
        textView.setText(Html.fromHtml(str));
    }

    private class ControlAdapter extends RecyclerView.Adapter<ControlHolder> {
        private List<Control> controls;

        private ControlAdapter(List<Control> controls) {
            this.controls = controls;
        }

        @NonNull
        @Override
        public ControlHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new ControlHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ControlHolder holder, final int position) {
            Control control = controls.get(position);
            holder.bind(control);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getApplicationContext(), ViewControlActivity.class);
                    intent.putExtra("control", controls.get(position));
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return controls.size();
        }

        public void setControls(List<Control> controls) {
            this.controls = controls;
        }
    }
}
