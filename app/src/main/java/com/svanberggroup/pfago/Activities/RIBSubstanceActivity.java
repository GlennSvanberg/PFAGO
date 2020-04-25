package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.svanberggroup.pfago.R;

public class RIBSubstanceActivity extends AppCompatActivity {
    private String url;
    private String title;
    private WebView substanceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rib_substance);

        Bundle bundle = getIntent().getExtras();
        url = bundle.getString("url");
        title = bundle.getString("substance");

        getSupportActionBar().hide();

        substanceView = findViewById(R.id.substance_view);
        substanceView.setVisibility(View.GONE);
        substanceView.getSettings().setLoadWithOverviewMode(true);
        substanceView.getSettings().setUseWideViewPort(true);
        substanceView.getSettings().getBuiltInZoomControls();
        substanceView.getSettings().setJavaScriptEnabled(true);
        substanceView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);


        substanceView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url)
            {
                substanceView.loadUrl("javascript:(function() { " +
                        "document.getElementById('flik9').style.display='block';})();" +
                        "javascript:(function() { " +
                        "document.getElementById('viewport').style.left='0px';})();");
                substanceView.setVisibility(View.VISIBLE);
            }

        });


        substanceView.loadUrl(url);
    }
}