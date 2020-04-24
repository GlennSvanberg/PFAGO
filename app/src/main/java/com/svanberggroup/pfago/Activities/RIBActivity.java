package com.svanberggroup.pfago.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationServices;
import com.svanberggroup.pfago.Models.RibSearchResult;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Utils.Rib.RibSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class RIBActivity extends AppCompatActivity {

    // private List<Control> controls;
    private ArrayList<RibSearchResult> ribSearchResults;

    private EditText queryField;
    private ImageButton searchButton;
    private RecyclerView recyclerView;
    private RIBActivity.ControlAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    // private FusedLocationProviderClient fusedLocationClient;

    private boolean isSearchMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rib);

        //  controls = ControlRepository.get().getAllControls();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //temp change to see recyclerview should be View.GONE
        recyclerView.setVisibility(View.GONE);

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
                if (charSequence.length() == 0) {
                    recyclerView.setVisibility(View.GONE);
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

                if (isSearchMode) {
                    ribSearchResults = startRibQuery(queryField.getText().toString());
                    recyclerView.setVisibility(View.VISIBLE);
                    updateUI();
                    searchButton.setImageResource(R.drawable.ic_clear);
                    isSearchMode = false;
                } else {
                    queryField.setText("");
                    searchButton.setImageResource(R.drawable.ic_search);
                    isSearchMode = true;
                }
            }
        });
    }

    private void updateUI() {
        if (adapter == null) {
            adapter = new RIBActivity.ControlAdapter(ribSearchResults);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setControls(ribSearchResults);
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
        inflater.inflate(R.menu.rib_control_only_menu, menu);
        return true;
    }

    private class ControlHolder extends RecyclerView.ViewHolder {
        private RibSearchResult control;
        private TextView title;
        private TextView description;

        public ControlHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_rib_list, parent, false));
            title = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
        }

        public void bind(RibSearchResult control) {
            this.control = control;
            title.setText(control.getSubstance());
            String text = "";

            if (control.getNote() != null) {
                text = text + control.getNote() + "\n";
            }

            description.setText(text);
        }

    }

    private class ControlAdapter extends RecyclerView.Adapter<RIBActivity.ControlHolder> {
        private List<RibSearchResult> controls;

        private ControlAdapter(List<RibSearchResult> controls) {
            this.controls = controls;
        }

        @NonNull
        @Override
        public RIBActivity.ControlHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new RIBActivity.ControlHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RIBActivity.ControlHolder holder, final int position) {
            RibSearchResult control = controls.get(position);
            holder.bind(control);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(controls.get(position).getLink()));
                    startActivity(browserIntent);
                    //   Toast.makeText(getApplicationContext(), controls.get(position).getLink(), Toast.LENGTH_LONG).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return controls.size();
        }

        public void setControls(ArrayList<RibSearchResult> controls) {
            this.controls = controls;
        }
    }

    public ArrayList<RibSearchResult> startRibQuery(String term) {
        try {
            return new RibSearch(term).makeRequestAsync();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_control) {
            startAddControlActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startAddControlActivity() {
        Intent intent = new Intent(this, AddControlActivity.class);
        startActivity(intent);
    }

}
