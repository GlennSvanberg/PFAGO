package com.svanberggroup.pfago.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.svanberggroup.pfago.Models.RibSearchResult;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Utils.Rib.Constants.RibMain;
import com.svanberggroup.pfago.Utils.WebProvider;

import java.util.ArrayList;
import java.util.List;

public class RIBActivity extends AppCompatActivity {

    private ArrayList<RibSearchResult> ribSearchResults;
    private EditText queryField;
    private FrameLayout welcomeLayout;
    private ImageButton searchButton;
    private RecyclerView recyclerView;
    private RIBActivity.ControlAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView welcomeText;
    private TextView noResults;
    private ProgressBar searchingRib;
    private boolean isSearchMode = true;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rib);
        setTitle(RibMain.TITLE);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        welcomeLayout = findViewById(R.id.ribWelcomeLayout);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        ribSearchResults = new ArrayList<>();

        welcomeText = findViewById(R.id.ribWelcome);
        welcomeText.setAlpha((float) 0.5);

        noResults = findViewById(R.id.noResults);

        searchingRib = findViewById(R.id.ridSearching);


        updateUI();

        queryField = (EditText) findViewById(R.id.query);
        queryField.setHint(RibMain.QUERY_HINT);

        queryField.requestFocus();
        queryField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                isSearchMode = true;
                noResults.setVisibility(View.GONE);

                if (charSequence.length() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    searchingRib.setVisibility(View.GONE);
                    welcomeLayout.setVisibility(View.VISIBLE);
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
                WebProvider webProvider = new WebProvider();
               // welcomeLayout.setVisibility(View.GONE);

                if (isSearchMode) {
                    welcomeLayout.setVisibility(View.GONE);
                    searchingRib.setVisibility(View.VISIBLE);
                    ribSearchResults = webProvider.searchRib(queryField.getText().toString());
                    if (ribSearchResults == null || ribSearchResults.isEmpty()) {
                        noResults.setText("Sökningen på " + queryField.getText().toString() + " gav inga resultat");
                        noResults.setVisibility(View.VISIBLE);
                        searchingRib.setVisibility(View.GONE);
                        welcomeLayout.setVisibility(View.GONE);

                    }
                    searchingRib.setVisibility(View.GONE);
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
        welcomeText.setText(RibMain.WELCOME);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.rib_control_only_menu, menu);
        return true;
    }

    private class ControlHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView descriptionStart;
        private TextView descriptionEnd;

        public ControlHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_rib_list, parent, false));
            findViewById(R.id.description1);
            findViewById(R.id.description1);
            title = itemView.findViewById(R.id.name);
            descriptionStart = itemView.findViewById(R.id.description1);
            descriptionEnd = itemView.findViewById(R.id.description2);
        }

        public void bind(RibSearchResult result) {
            StringBuilder noteStart = new StringBuilder();
            StringBuilder noteEnd = new StringBuilder();
            ArrayList<String> notes = result.getNote();
            title.setText(result.getSubstance());
            if (notes != null) {

                for (int i = 0; i < notes.size(); i++) {
                    if (i % 2 == 0) {
                        if (i == notes.size() - 1) noteStart.append(notes.toArray()[i]);
                        else noteStart.append(notes.toArray()[i]).append("\n");
                    } else {
                        if (i == notes.size() - 1) noteEnd.append(notes.toArray()[i]);
                        else noteEnd.append(notes.toArray()[i]).append("\n");
                    }
                }
            }

            descriptionStart.setText(noteStart.toString());
            descriptionEnd.setText(noteEnd.toString());
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
            RibSearchResult ribSearchResult = controls.get(position);
            holder.bind(ribSearchResult);
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent ribSubstanceIntent = new Intent(RIBActivity.this, RIBSubstanceActivity.class);
                    ribSubstanceIntent.putExtra("url", ribSearchResult.getLink());
                    startActivity(ribSubstanceIntent);
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
