package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class visualizerViewProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizer_view_product);

        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();

            ImageView imgView = (ImageView) findViewById(R.id.imageView);
            imgView.setImageURI(uri);
        }

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        TextView bottomView = (TextView)findViewById(R.id.bottomBar);
        bottomView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToWebsiteURL(v);
            }
        });
        Button backButton = (Button)findViewById(R.id.backButton);
        Button requestButton = (Button)findViewById(R.id.requestButton);
        Button editAreaButton = (Button)findViewById(R.id.editAreaButton);
        Button editColourButton = (Button)findViewById(R.id.editColourButton);
        Button imageButton = (Button)findViewById(R.id.imageButton);
        Button largerButton = (Button)findViewById(R.id.fullButton);

        editAreaButton.setTypeface(buttonFont);
        editColourButton.setTypeface(buttonFont);
        imageButton.setTypeface(buttonFont);
        requestButton.setTypeface(buttonFont);
        backButton.setTypeface(buttonFont);
        largerButton.setTypeface(buttonFont);
        bottomView.setTypeface(textFont);
    }

    public void backHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void request(View view) {
        Intent intentData = getIntent();
        Intent intent = new Intent(this, visualizerRequestSample.class);
        intent.setData(intentData.getData());
        startActivity(intent);
    }
    public void editArea(View view) {
        Intent intentData = getIntent();
        Intent intent = new Intent(this, visualizerDrawArea.class);
        intent.setData(intentData.getData());
        startActivity(intent);
    }
    public void editColour(View view) {
        Intent intentData = getIntent();
        Intent intent = new Intent(this, visualizerPickColour.class);
        intent.setData(intentData.getData());
        startActivity(intent);
    }
    public void full(View view) {
        Intent intentData = getIntent();
        Intent intent = new Intent(this, visualizerFullScreen.class);
        intent.setData(intentData.getData());
        startActivity(intent);
    }
    public void image(View view) {
        Intent intent = new Intent(this, visualizerGetImage.class);
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
