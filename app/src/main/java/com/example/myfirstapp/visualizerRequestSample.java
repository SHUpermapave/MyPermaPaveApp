package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class visualizerRequestSample extends AppCompatActivity {

    private ImageView colourImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_sample_page2);


        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");


        TextView colourName = (TextView) findViewById(R.id.textView);
        colourImage = (ImageView) findViewById(R.id.selectedColour);
        colourName.setText(globalVars.getInstance().getSelectedColour());
        setImage();

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
        Intent intentData = getIntent();
        Intent intent = new Intent(this, visualizerViewProduct.class);
        intent.setData(intentData.getData());
        startActivity(intent);
    }

    public void sendEmail(View view) {
        String addressArray[] = {getString(R.string.companyEmail)};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
//        emailIntent.putExtra(Intent.EXTRA_EMAIL  , getString(R.string.companyEmail));
        emailIntent.putExtra(Intent.EXTRA_EMAIL , addressArray);

        TextView colourName = (TextView) findViewById(R.id.textView);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.sampleRequestEmailSubject) + " " + colourName.getText());

        ArrayList<String> values = new ArrayList<String>();
        int[] ids = new int[]{R.id.nameEditText,R.id.address1EditText,R.id.address2EditText,R.id.address3EditText,R.id.postCodeEditText};//and so on
        String body = "";
        for(int id : ids){
            EditText t = (EditText) findViewById(id);
            body += t.getText().toString();
            body += "\n";
        }
        emailIntent.putExtra(Intent.EXTRA_TEXT   , body);
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(visualizerRequestSample.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
    public void requestSampleEmail(View view){
        EditText postcode = (EditText) findViewById(R.id.postCodeEditText);
        String postcodestr = postcode.getText().toString();
        Pattern p = Pattern.compile("([A-PR-UWYZ0-9][A-HK-Y0-9][AEHMNPRTVXY0-9]?[ABEHMNPRVWXY0-9]? {1,2}[0-9][ABD-HJLN-UW-Z]{2}|GIR 0AA)");
        Matcher m = p.matcher(postcodestr);
        boolean b = m.matches();
        EditText ad1 = (EditText) findViewById(R.id.address1EditText);
        String ad1str = ad1.getText().toString();
        EditText ad2 = (EditText) findViewById(R.id.address2EditText);
        String ad2str = ad1.getText().toString();
        EditText adpc = (EditText) findViewById(R.id.postCodeEditText);
        String adpcstr = ad1.getText().toString();
        EditText adname = (EditText) findViewById(R.id.nameEditText);
        String adnamestr = ad1.getText().toString();

        if (ad1str.isEmpty()| ad2str.isEmpty()|adnamestr.isEmpty() | adpcstr.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill all fields",Toast.LENGTH_SHORT).show();
        }
        else{
            if (b) {
                sendEmail(view);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Please enter a valid postcode",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void setImage()
    {

        switch(globalVars.getInstance().getSelectedColour())
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
