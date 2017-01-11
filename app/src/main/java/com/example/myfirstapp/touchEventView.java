package com.example.myfirstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class touchEventView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    private int lines = 0;
    private float xStart;
    private float yStart;
    private float xPos;
    private float yPos;

    public touchEventView(Context ctx, AttributeSet attrs){
        super(ctx, attrs);
        paint.setColor(Color.parseColor("#FF9F23"));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(10f);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawPath(path, paint);
        canvas.drawCircle(xPos, yPos, 20, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        xPos = event.getX();
        yPos = event.getY();
        if (lines == 0){
            if (event.getAction() == (MotionEvent.ACTION_UP)){
                path.moveTo(xPos, yPos);
                xStart = xPos;
                yStart = yPos;
                lines = lines + 1;
            }
        } else {


            if (event.getAction() == (MotionEvent.ACTION_UP)) {
                if (((xPos < (xStart + 20)) && (xPos > (xStart - 20))) &&
                    ((yPos < (yStart + 20)) && (yPos > (yStart - 20)))) {
                    path.lineTo(xStart, yStart);
                    path.close();
                    //selectButton.setEnabled(true);
                    //connected.setText("Area Completed! Please Continue.");
                } else {
                    path.lineTo(xPos, yPos);
                    path.moveTo(xPos, yPos);
                    lines = lines + 1;
                }
            }
        }
        invalidate();
        return true;
    }

}
