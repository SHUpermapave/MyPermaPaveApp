package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class visualizerFullScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizer_full_screen);

        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();

            ImageView imgView = (ImageView) findViewById(R.id.imageView);
            imgView.setImageURI(uri);
        }

        TextView colourName = (TextView) findViewById(R.id.colour);
        colourName.setText(globalVars.getInstance().getSelectedColour());
        colourName.setTypeface(textFont);
    }
    public void back(View view) {
        Intent intentData = getIntent();
        Intent intent = new Intent(this, visualizerViewProduct.class);
        intent.setData(intentData.getData());
        startActivity(intent);
    }
}
