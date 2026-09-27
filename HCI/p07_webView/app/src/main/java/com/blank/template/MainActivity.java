package com.blank.template;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView view = findViewById(R.id.webview);

        WebSettings settings = view.getSettings();
        settings.setJavaScriptEnabled(true);

        view.setWebViewClient(new WebViewClient());
        view.loadUrl("https://github.com/InozaAki");

    }
}