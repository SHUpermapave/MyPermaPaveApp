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

public class requestSamplePage2 extends AppCompatActivity {
    private Uri uri;
    private ImageView colourImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_sample_page2);

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        Intent intent = getIntent();
        if (intent != null) {
            uri = intent.getData();
            TextView colourName = (TextView) findViewById(R.id.textView);
            colourImage = (ImageView) findViewById(R.id.selectedColour);
            colourName.setText(uri.toString());
            setImage();
        }
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

        backButton.setTypeface(buttonFont);
        requestButton.setTypeface(buttonFont);
        bottomView.setTypeface(textFont);
    }
    public void back(View view) {
        Intent intent = new Intent(this, requestSample.class);
        startActivity(intent);
    }

    public void setImage()
    {

        switch(uri.toString())
        {
            case "Amber Gold":
                colourImage.setImageResource(R.drawable.ambergold);
                break;
            case "Autumn Gold":
                colourImage.setImageResource(R.drawable.autumngold);
                break;
            case "Autumn Quartz":
                colourImage.setImageResource(R.drawable.autumnquartz);
                break;
            case "Beige":
                colourImage.setImageResource(R.drawable.beige);
                break;
            case "Black":
                colourImage.setImageResource(R.drawable.black);
                break;
            case "Brittany Bronze":
                colourImage.setImageResource(R.drawable.brittanybronze);
                break;
            case "Chinese Bauxite":
                colourImage.setImageResource(R.drawable.chinesebauxite);
                break;
            case "Classic":
                colourImage.setImageResource(R.drawable.classic);
                break;
            case "Dorset Gold":
                colourImage.setImageResource(R.drawable.dorsetgold);
                break;
            case "Golden Pea":
                colourImage.setImageResource(R.drawable.goldenpea);
                break;
            case "Golden Quartz":
                colourImage.setImageResource(R.drawable.goldenquartz);
                break;
            case "Green":
                colourImage.setImageResource(R.drawable.green);
                break;
            case "Pearl Quartz":
                colourImage.setImageResource(R.drawable.pearlquartz);
                break;
            case "Red":
                colourImage.setImageResource(R.drawable.red);
                break;
            case "Salmon Pink":
                colourImage.setImageResource(R.drawable.salmonpink);
                break;
            case "Silver":
                colourImage.setImageResource(R.drawable.silver);
                break;
            case "Staffordshire Pink":
                colourImage.setImageResource(R.drawable.staffordshirepink);
                break;
            case "Trugrip":
                colourImage.setImageResource(R.drawable.trugrip);
                break;
            case "White Flint":
                colourImage.setImageResource(R.drawable.whiteflint);
                break;
            case "Yellow":
                colourImage.setImageResource(R.drawable.yellow);
                break;

            default:
                colourImage.setImageResource(R.drawable.ambergold);
                break;
        }
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