package com.svanberggroup.pfago.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.svanberggroup.pfago.Models.Transport;
import com.svanberggroup.pfago.Models.Party;
import com.svanberggroup.pfago.Models.Trailer;
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Models.Location;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Transport> transports;

    private EditText mQuery;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDummyData();
        for(Transport transport : transports) {
            Log.i("TEST", transport.getNumber()+ "");
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new TransportAdapter(transports);
        mRecyclerView.setAdapter(mAdapter);

        mQuery = (EditText) findViewById(R.id.query);
        mQuery.requestFocus();


    }
    private class TransportHolder extends RecyclerView.ViewHolder {

        private Transport transport;
        private TextView textView;
        public TransportHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.transport_list_item,parent, false));
             textView = itemView.findViewById(R.id.name);
        }
        public void bind(Transport transport) {
            this.transport = transport;
            textView.setText(transport.getVehicle().getRegNr());
        }
    }
    private class TransportAdapter extends RecyclerView.Adapter<TransportHolder> {
        private List<Transport> transports;

        private TransportAdapter(List<Transport> transports) {
            this.transports = transports;
        }

        @NonNull
        @Override
        public TransportHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            return new TransportHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TransportHolder holder, int position) {
            Transport transport = transports.get(position);
            holder.bind(transport);

        }

        @Override
        public int getItemCount() {
            return transports.size();
        }
    }


    private void createDummyData(){

        transports = new ArrayList<>();

        Location sender = new Location("Malmgatan 34 Halmstad", "LKAB, port 22", "0600-352362");
        Location receiver = new Location("Raketgatan Kiruna", "GKN, södra", "010-0525252");
        Party company = new Party("GLÅAB", "0522-252525", "Norra älvvägen 21B", 45130, "Uddevalla", "Sweden");
        Party driver = new Party("Göran Persson", "070-2525352", "Byälven 11A", 45130, "Borås", "Sweden");
        Trailer container = new Trailer("SE", "TTT111", "Container");
        Trailer semi = new Trailer("SE", "SSS111", "Semi");

        Vehicle truckContainer = new Vehicle("SE", "ABC123", container);
        Vehicle truckSemi = new Vehicle("SE", "ABC456", semi);

        Transport a = new Transport();
        a.setNumber(1);
        a.setPlace("Uddevalla");
        a.setType("väg");
        a.setVehicle(truckContainer);
        a.setCompany(company);
        a.setDriver(driver);
        a.setSender(sender);
        a.setReceiver(receiver);
        transports.add(a);

        Transport b = new Transport();
        b.setNumber(2);
        b.setPlace("Göteborg");
        b.setType("Hamnterminal");
        b.setVehicle(truckSemi);
        b.setCompany(company);
        b.setDriver(driver);
        b.setSender(sender);
        b.setReceiver(receiver);
        transports.add(b);

    }
}
