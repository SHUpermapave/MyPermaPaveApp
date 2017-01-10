package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class visualizerPickColour extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner listViewColours;
    private ImageView selectedColour;
    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizer_pick_colour);

        adapter = ArrayAdapter.createFromResource(
                this, R.array.coloursArray,
                android.R.layout.simple_list_item_1);

        listViewColours = (Spinner) findViewById(R.id.listViewColours);
        listViewColours.setAdapter(adapter);

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        listViewColours.setOnItemSelectedListener(this);
        selectedColour = (ImageView) findViewById(R.id.selectedColour);

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
        Button leftButton = (Button)findViewById(R.id.leftArrow);
        Button rightButton = (Button)findViewById(R.id.rightArrow);
        Button selectButton = (Button)findViewById(R.id.selectButton);

        backButton.setTypeface(buttonFont);
        selectButton.setTypeface(buttonFont);
        leftButton.setTypeface(textFont);
        rightButton.setTypeface(textFont);
        bottomView.setTypeface(textFont);
    }

    public void back(View view) {
        Intent intent = new Intent(this, visualizerDrawArea.class);
        startActivity(intent);
    }
    public void left(View view) {
        int position = adapter.getPosition(listViewColours.getSelectedItem().toString());
        if (position >= 1)
        {
            position = position - 1;
        } else
        {
            position = (listViewColours.getAdapter().getCount()-1);
        }
        listViewColours.setSelection(position);
        setImage();
    }
    public void right(View view) {
        int position = adapter.getPosition(listViewColours.getSelectedItem().toString());
        if (position < ((listViewColours.getAdapter().getCount())-1))
        {
            position = position + 1;
        } else
        {
            position = 0;
        }
        listViewColours.setSelection(position);
        setImage();
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id)
    {
        setImage();
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void setImage()
    {
        switch(listViewColours.getSelectedItem().toString())
        {
            case "Amber Gold":
                selectedColour.setImageResource(R.drawable.ambergold);
                break;
            case "Autumn Gold":
                selectedColour.setImageResource(R.drawable.autumngold);
                break;
            case "Autumn Quartz":
                selectedColour.setImageResource(R.drawable.autumnquartz);
                break;
            case "Beige":
                selectedColour.setImageResource(R.drawable.beige);
                break;
            case "Black":
                selectedColour.setImageResource(R.drawable.black);
                break;
            case "Brittany Bronze":
                selectedColour.setImageResource(R.drawable.brittanybronze);
                break;
            case "Chinese Bauxite":
                selectedColour.setImageResource(R.drawable.chinesebauxite);
                break;
            case "Classic":
                selectedColour.setImageResource(R.drawable.classic);
                break;
            case "Dorset Gold":
                selectedColour.setImageResource(R.drawable.dorsetgold);
                break;
            case "Golden Pea":
                selectedColour.setImageResource(R.drawable.goldenpea);
                break;
            case "Golden Quartz":
                selectedColour.setImageResource(R.drawable.goldenquartz);
                break;
            case "Green":
                selectedColour.setImageResource(R.drawable.green);
                break;
            case "Pearl Quartz":
                selectedColour.setImageResource(R.drawable.pearlquartz);
                break;
            case "Red":
                selectedColour.setImageResource(R.drawable.red);
                break;
            case "Salmon Pink":
                selectedColour.setImageResource(R.drawable.salmonpink);
                break;
            case "Silver":
                selectedColour.setImageResource(R.drawable.silver);
                break;
            case "Staffordshire Pink":
                selectedColour.setImageResource(R.drawable.staffordshirepink);
                break;
            case "Trugrip":
                selectedColour.setImageResource(R.drawable.trugrip);
                break;
            case "White Flint":
                selectedColour.setImageResource(R.drawable.whiteflint);
                break;
            case "Yellow":
                selectedColour.setImageResource(R.drawable.yellow);
                break;

            default:
                selectedColour.setImageResource(R.drawable.ambergold);
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
