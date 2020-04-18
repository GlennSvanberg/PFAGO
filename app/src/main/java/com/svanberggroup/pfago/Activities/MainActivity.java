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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Control> mControls;

    private EditText mQuery;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mControls = ControlRepository.get().getAllControls();

        for(Control control : mControls) {
            Log.i("TEST", control.getId() + " ");
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ControlAdapter(mControls);
        mRecyclerView.setAdapter(mAdapter);

        mQuery = (EditText) findViewById(R.id.query);
        mQuery.requestFocus();

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

        private Control mControl;
        private TextView textView;
        public ControlHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_control_list,parent, false));
             textView = itemView.findViewById(R.id.name);
        }
        public void bind(Control control) {
            this.mControl = control;
            textView.setText(control.getTruck().getRegNr() + " " +  control.getDriver().getName());
        }

        @Override
        public void onClick(View view) {
            // open view displaying the control
        }
    }
    private class ControlAdapter extends RecyclerView.Adapter<ControlHolder> {
        private List<Control> mControls;

        private ControlAdapter(List<Control> controls) {
            this.mControls = controls;
        }

        @NonNull
        @Override
        public ControlHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new ControlHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ControlHolder holder, int position) {
            Control control = mControls.get(position);
            holder.bind(control);

        }

        @Override
        public int getItemCount() {
            return mControls.size();
        }
    }


}
