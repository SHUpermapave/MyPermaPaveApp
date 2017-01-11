package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        Button visualizerButton = (Button)findViewById(R.id.selectButton);
        Button requestButton = (Button)findViewById(R.id.requestButton);
        Button contactButton = (Button)findViewById(R.id.contactButton);
        TextView bottomView = (TextView)findViewById(R.id.bottomBar);

        visualizerButton.setTypeface(buttonFont);
        requestButton.setTypeface(buttonFont);
        contactButton.setTypeface(buttonFont);
        bottomView.setTypeface(textFont);
        bottomView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToWebsiteURL(v);
            }
        });
    }
    public void contact(View view) {
        Intent intent = new Intent(this, contactUs.class);
        startActivity(intent);
    }
    public void request(View view) {
        Intent intent = new Intent(this, requestSample.class);
        startActivity(intent);}

    public void goToWebsiteURL (View view) {
        goToUrl ( "http://www.permapave.co.uk");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void visualizer (View view) {
        Intent intent = new Intent(this, visualizerGetImage.class);
        startActivity(intent);
    }
}
