package com.svanberggroup.pfago.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.ControlRow;
import com.svanberggroup.pfago.Models.Fault;
import com.svanberggroup.pfago.Models.Goods;
import com.svanberggroup.pfago.Models.ImageData;
import com.svanberggroup.pfago.Models.Quantity;
import com.svanberggroup.pfago.Models.SafetyAdvisor;
import com.svanberggroup.pfago.Models.TransportDocumentRows;
import com.svanberggroup.pfago.Models.TransportLocation;
import com.svanberggroup.pfago.Models.TransportRows;
import com.svanberggroup.pfago.Models.Transporter;
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;
import com.svanberggroup.pfago.Utils.PictureUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BreakingTheLawActivity extends AppCompatActivity {
    private Control control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        control = (Control) getIntent().getSerializableExtra("control");

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        inflater.inflate(R.layout.activity_breaking_the_law, this);

    }
}
