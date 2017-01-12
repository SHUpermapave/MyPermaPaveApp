package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class visualizerGetImage extends AppCompatActivity
{
    private static int RESULT_LOAD_IMG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizer_get_image);

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        Button backButton = (Button)findViewById(R.id.backButton);
        Button chooseButton = (Button)findViewById(R.id.chooseButton);
        TextView bottomView = (TextView)findViewById(R.id.bottomBar);


        TextView para1 = (TextView) findViewById(R.id.textView4);
        TextView para2 = (TextView) findViewById(R.id.textView5);

        para1.setTypeface(textFont);
        para2.setTypeface(textFont);

        bottomView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToWebsiteURL(v);
            }
        });


        backButton.setTypeface(buttonFont);
        chooseButton.setTypeface(buttonFont);
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

    public void loadImagefromGallery(View view)
    {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {

                Uri selectedImage = data.getData();

                Intent intent = new Intent(this, visualizerDrawArea.class);
                intent.setData(selectedImage);
                startActivity(intent);

            } else
            {
                Toast.makeText(this, "You haven't picked an image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e)
        {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToWebsiteURL(View view) {
        Uri uriUrl = Uri.parse("http://www.permapave.co.uk");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}