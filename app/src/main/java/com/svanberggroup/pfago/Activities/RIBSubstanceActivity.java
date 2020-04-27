package com.svanberggroup.pfago.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Utils.Rib.Constants.RibWebJSInjection;


public class RIBSubstanceActivity extends AppCompatActivity {
    private String url;
    private WebView substanceView;
    private ProgressBar adrLoading;
    private boolean loading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rib_substance);

        Bundle bundle = getIntent().getExtras();
        url = bundle.getString("url");

        adrLoading = findViewById(R.id.adrLoading);

        getSupportActionBar().hide();

        loadWebView();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void loadWebView() {

        substanceView = findViewById(R.id.substance_view);
        substanceView.setVisibility(View.GONE);
        substanceView.getSettings().setLoadWithOverviewMode(true);
        substanceView.setInitialScale(90);
        substanceView.getSettings().setUseWideViewPort(false);
        substanceView.getSettings().setDisplayZoomControls(true);
        substanceView.getSettings().setJavaScriptEnabled(true);
        substanceView.getSettings().setTextZoom(45);
        substanceView.getSettings().setMinimumFontSize(28);
        substanceView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        substanceView.setBackgroundColor(Color.argb(1, 0, 0, 0));
        substanceView.loadUrl(url);

        substanceView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                substanceView.loadUrl(RibWebJSInjection.REMOVE_SIDE_MENU +
                        RibWebJSInjection.SHOW_TRANSPORT +
                        RibWebJSInjection.REMOVE_RIB_LINK +
                        RibWebJSInjection.REMOVE_HELP_LINK +
                        RibWebJSInjection.ALIGN_VALUES +
                        RibWebJSInjection.PADDING_BOTTOM_TRANSPORT


                );

                substanceView.setVisibility(View.VISIBLE);

            }
        });
    }

}



