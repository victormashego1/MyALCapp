package com.mashv.myalcapp;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class AboutALC extends AppCompatActivity {
    private static final String URL = "https://andela.com/alc/";
    private WebView mWebViewALC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* Creating a back button, setting it to show
         * Adding behavior allowing the button return back to previous activity
         */

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_white_18dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //back clicked
                onBackPressed();
            }
        });



        mWebViewALC = (WebView) findViewById(R.id.webViewALC);
        WebSettings settings = mWebViewALC.getSettings();

        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        mWebViewALC.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebViewALC.getSettings().setLoadsImagesAutomatically(true);

        mWebViewALC.loadUrl(URL);


        // By using this method together with the overridden method onReceivedSslError()
        // you will avoid the "WebView Blank Page" problem .

        mWebViewALC.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.d("Failure Url :" , failingUrl);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                Log.d("Ssl Error:",handler.toString() + "error:" +  error); //SUPER METHOD has been removed
                handler.proceed(); // Ignore SSL certificate errors
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }



}
