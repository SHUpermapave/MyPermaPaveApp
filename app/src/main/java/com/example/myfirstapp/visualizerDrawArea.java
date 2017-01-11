package com.example.myfirstapp;

import android.content.Intent;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class visualizerDrawArea extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizer_draw_area);

        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();

            ImageView imgView = (ImageView) findViewById(R.id.imageView);
            imgView.setImageURI(uri);
        }

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        TextView connected = (TextView) findViewById(R.id.backButton);
        Button backButton = (Button)findViewById(R.id.backButton);
        Button selectButton = (Button)findViewById(R.id.selectButton);

        connected.setText("Area Not Completed");
        backButton.setTypeface(buttonFont);
        selectButton.setTypeface(buttonFont);
        selectButton.setEnabled(false);
    }

    public void back(View view) {
        Intent intent = new Intent(this, visualizerGetImage.class);
        startActivity(intent);
    }
    public void next(View view) {
        Intent intent = new Intent(this, visualizerPickColour.class);
        startActivity(intent);
    }

    public void goToWebsiteURL (View view) {
        goToUrl ( "http://www.permapave.co.uk");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
