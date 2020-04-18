package com.svanberggroup.pfago.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;

import java.text.SimpleDateFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Control> controls;

    private EditText queryField;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controls = ControlRepository.get().getAllControls();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ControlAdapter(controls);
        recyclerView.setAdapter(adapter);

        queryField = (EditText) findViewById(R.id.query);
        queryField.requestFocus();

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
                Log.i("TEST", "Going to RIB");
                Intent intent = new Intent(this, RIBActivity.class);
                startActivity(intent);
                return true;
            case R.id.addControl:
                Log.i("TEST", "Going to addControl");
                intent = new Intent(this, AddControlActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class ControlHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

            String text = "Företag: " + control.getCarrier().getName() + "\n";
            text = text + "Förare: " + control.getDriver().getName() + "\n";
            text = text + "Lastbil: " +control.getTruck().getRegNr() + " " + control.getTruck().getNationality() + "\n";
            if(control.getTrailer() != null) {
                text = text + "Släp: " + control.getTrailer().getRegNr() + " " + control.getTrailer().getNationality() + " " + getString(control.getTrailer().getVehicleType().label) +"\n";
            }

            description.setText(text);
        }

        @Override
        public void onClick(View view) {
            // open view displaying the control
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
    }


}
