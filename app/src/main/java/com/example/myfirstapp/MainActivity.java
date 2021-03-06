package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        TextView para1 = (TextView)findViewById(R.id.textView2);
        TextView para2 = (TextView)findViewById(R.id.textView3);

        visualizerButton.setTypeface(buttonFont);
        requestButton.setTypeface(buttonFont);
        contactButton.setTypeface(buttonFont);
        para1.setTypeface(textFont);
        para2.setTypeface(textFont);
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

    private void goToWebsiteURL(View view) {
        Uri uriUrl = Uri.parse("http://www.permapave.co.uk");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void visualizer (View view) {
        Intent intent = new Intent(this, visualizerGetImage.class);
        startActivity(intent);
    }
}
