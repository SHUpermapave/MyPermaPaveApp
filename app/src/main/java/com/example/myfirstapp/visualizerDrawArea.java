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

public class visualizerDrawArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizer_draw_area);

        TextView bottomView = (TextView)findViewById(R.id.bottomBar);
        bottomView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToWebsiteURL(v);
            }
        });

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);

        bmp = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bmp);


        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();

            ImageView imgView = (ImageView) findViewById(R.id.imageView);
            imgView.setImageURI(uri);
        }

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        Button selectButton = (Button)findViewById(R.id.selectButton);
        TextView bottomView = (TextView)findViewById(R.id.bottomBar);
        TextView prompt = (TextView)findViewById(R.id.prompt);
        Button backButton = (Button)findViewById(R.id.backButton);
        Button resetButton = (Button)findViewById(R.id.resetButton);

        backButton.setTypeface(buttonFont);
        selectButton.setTypeface(buttonFont);
        resetButton.setTypeface(buttonFont);

        prompt.setTypeface(textFont);
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

    public void back(View view) {
        Intent intent = new Intent(this, visualizerGetImage.class);
        startActivity(intent);
    }
    public void next(View view) {
        Intent intentData = getIntent();
        Intent intent = new Intent(this, visualizerPickColour.class);
        intent.setData(intentData.getData());
        startActivity(intent);
    }
    public void reset(View view) {
        Intent intentData = getIntent();
        Intent intent = new Intent(this, visualizerDrawArea.class);
        intent.setData(intentData.getData());
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
