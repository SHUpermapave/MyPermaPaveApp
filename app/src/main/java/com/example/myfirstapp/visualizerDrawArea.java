package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class visualizerDrawArea extends AppCompatActivity {

    EditText cord;
    EditText area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizer_draw_area);

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        cord = (EditText)findViewById(R.id.textView);
        cord.setText("No Click");
        area = (EditText)findViewById(R.id.textView2);
        area.setText("No Click");
        Button backButton = (Button)findViewById(R.id.backButton);
        Button selectButton = (Button)findViewById(R.id.selectButton);

        backButton.setTypeface(buttonFont);
        selectButton.setTypeface(buttonFont);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP) {
            int x = Math.round((int)event.getX());
            int y = Math.round((int)event.getX());

            String text = "You click at x = " + x + " and y = " + y;
            cord.setText(text);
            if (x > 200){
                text = "below 200";
                area.setText(text);
            }

        }
        return super.onTouchEvent(event);
    }
    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void next(View view) {
        Intent intent = new Intent(this, visualizerPickColour.class);
        startActivity(intent);
    }
}
