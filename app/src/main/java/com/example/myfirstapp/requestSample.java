package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class requestSample extends AppCompatActivity implements OnItemSelectedListener {

    TextView colour;
    Spinner listViewColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_sample);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.coloursArray,
                android.R.layout.simple_list_item_1);

        listViewColours = (Spinner) findViewById(R.id.listViewColours);
        listViewColours.setAdapter(adapter);

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        colour =(EditText)findViewById(R.id.textView);
        listViewColours.setOnItemSelectedListener(this);

        TextView bottomView = (TextView)findViewById(R.id.bottomBar);
        Button backButton = (Button)findViewById(R.id.backButton);
        Button requestButton = (Button)findViewById(R.id.requestButton);

        backButton.setTypeface(buttonFont);
        requestButton.setTypeface(buttonFont);
        bottomView.setTypeface(textFont);
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        colour.setText(listViewColours.getSelectedItem().toString());
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
