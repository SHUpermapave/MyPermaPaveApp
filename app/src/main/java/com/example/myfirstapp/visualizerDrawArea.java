package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;

public class visualizerDrawArea extends AppCompatActivity {

    private List<Point> areaPoints = new ArrayList<Point>();
    private Paint paint = new Paint();
    private Canvas canvas;
    private Bitmap bmp;
    private ImageView imgCircle;
    private EditText coor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizer_draw_area);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);

        bmp = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);

        canvas = new Canvas(bmp);

        imgCircle = (ImageView)findViewById(R.id.circle);

        coor = (EditText)findViewById(R.id.textView);

        Typeface buttonFont = Typeface.createFromAsset(getAssets(), "fonts/Cuprum-Regular.ttf");
        Typeface textFont = Typeface.createFromAsset(getAssets(), "fonts/Arial.ttf");

        Button backButton = (Button)findViewById(R.id.backButton);
        Button selectButton = (Button)findViewById(R.id.selectButton);
        TextView bottomView = (TextView)findViewById(R.id.bottomBar);
        bottomView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToWebsiteURL(v);
            }
        });

        backButton.setTypeface(buttonFont);
        selectButton.setTypeface(buttonFont);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP) {
            int x = (int)event.getX();
            int y = (int)event.getY();
            String text = "x:" + x + " y:" + y;
            coor.setText(text);
            if (y >= 445 && y <= 1225){
                canvas.drawCircle(x, y, 50, paint);
                imgCircle.setImageBitmap(bmp);
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
    public void draw(Canvas canvas){
        paint.setColor(Color.GREEN);
        for(Point point: areaPoints){
            canvas.drawCircle(point.x, point.y, 20, paint);
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
