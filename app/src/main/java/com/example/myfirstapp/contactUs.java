package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class contactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");
        Typeface boldFont = Typeface.createFromAsset(getAssets(), "fonts/Arial Bold.ttf");

        TextView contactView = (TextView)findViewById(R.id.contact);
        TextView address1View = (TextView)findViewById(R.id.address1);
        TextView address2View = (TextView)findViewById(R.id.address2);
        TextView phoneView = (TextView)findViewById(R.id.phone);
        TextView emailView = (TextView)findViewById(R.id.email);
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
        Button sendButton = (Button)findViewById(R.id.sendButton);

        contactView.setTypeface(boldFont);
        address1View.setTypeface(textFont);
        address2View.setTypeface(textFont);
        phoneView.setTypeface(textFont);
        emailView.setTypeface(textFont);
        bottomView.setTypeface(textFont);
        backButton.setTypeface(buttonFont);
        sendButton.setTypeface(buttonFont);
    }
    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToWebsiteURL (View view) {
        goToUrl ( "http://www.permapave.co.uk");
    }

    public void goToMessageURL (View view) {
        goToUrl ( "http://www.permapave.co.uk/contact-us");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
