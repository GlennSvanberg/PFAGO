package com.svanberggroup.pfago.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

import java.text.SimpleDateFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Control> controls;

    private EditText queryField;
    private ImageButton searchButton;
    private RecyclerView recyclerView;
    private LinearLayout buttonsLinearLayout;
    private ControlAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controls = ControlRepository.get().getAllControls();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setVisibility(View.GONE);

        buttonsLinearLayout = (LinearLayout) findViewById(R.id.buttons_linear_layout);
        buttonsLinearLayout.setVisibility(View.VISIBLE);

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
                if(charSequence.length() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    buttonsLinearLayout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controls = ControlRepository.get().getControlsByRegNr(queryField.getText().toString());
                recyclerView.setVisibility(View.VISIBLE);
                buttonsLinearLayout.setVisibility(View.GONE);
                updateUI();
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
        Log.i("TEST", "onStart");
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
                Intent intent = new Intent(this, RIBActivity.class);
                startActivity(intent);
                return true;
            case R.id.addControl:
                intent = new Intent(this, AddControlActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class ControlHolder extends RecyclerView.ViewHolder {

        private Control control;
        private TextView title;
        private TextView description;
        public ControlHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_control_list,parent, false));
             title = itemView.findViewById(R.id.name);
             description = itemView.findViewById(R.id.description);
        }
        public void bind(Control control) {
            this.control = control;
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
            String date = formatter.format(control.getDate());
            title.setText(control.getTruck().getRegNr() + " Datum: " +  date);
            String text  = "";
            if(control.getCarrier()!= null) {
                text = text + "Företag: " + control.getCarrier().getName() + "\n";
            }
            if(control.getDriver() != null) {
                text = text + "Förare: " + control.getDriver().getName() + "\n";
            }
            if(control.getTruck() != null) {
                text = text + "Lastbil: " +control.getTruck().getRegNr() + " " + control.getTruck().getNationality() + "\n";
            }

            if(control.getTrailer() != null) {
                text = text + "Släp: " + control.getTrailer().getRegNr() + " " + control.getTrailer().getNationality() + " " + getString(control.getTrailer().getVehicleType().label) +"\n";
            }

            description.setText(text);
        }

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
                    intent.putExtra("control_id", controls.get(position).getId());
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
