package com.example.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class visualizerFullScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizer_full_screen);


        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();

            ImageView imgView = (ImageView) findViewById(R.id.imageView);
            imgView.setImageURI(uri);
        }

    }
}
