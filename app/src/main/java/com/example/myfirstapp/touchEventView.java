package com.example.myfirstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class touchEventView extends View {
    private final Paint paint = new Paint();
    private final Path path = new Path();
    private final Path fullPath = new Path();
    private boolean first = true;
    private int lines = 0;
    private float xStart;
    private float yStart;
    private float xPos;
    private float yPos;

    public touchEventView(Context ctx, AttributeSet attrs){
        super(ctx, attrs);
        paint.setColor(Color.parseColor("#FF9F23"));
        paint.setStyle(Style.FILL_AND_STROKE);
        paint.setStrokeWidth(10f);
        paint.setAlpha(180);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawPath(path, paint);
        canvas.drawCircle(xPos, yPos, 20, paint);
        globalVars.getInstance().setPath(path);
        globalVars.getInstance().setFullPath(fullPath);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        xPos = event.getX();
        yPos = event.getY();
        if (first){
            if (event.getAction() == (MotionEvent.ACTION_UP)){
                path.moveTo(xPos, yPos);
                fullPath.moveTo((float)(xPos * 1.45), (float)(yPos * 1.45));
                xStart = xPos;
                yStart = yPos;
                first = false;
                lines = lines + 1;
            }
        } else {
            if (event.getAction() == (MotionEvent.ACTION_UP)) {
                if (((xPos < (xStart + 20)) && (xPos > (xStart - 20))) &&
                    ((yPos < (yStart + 20)) && (yPos > (yStart - 20)))) {
                    path.lineTo(xStart, yStart);
                    fullPath.lineTo((float)(xStart * 1.45), (float)(yStart * 1.45));
                    path.close();
                    fullPath.close();
                } else {
                    path.lineTo(xPos, yPos);
                    fullPath.lineTo((float)(xPos * 1.45), (float)(yPos * 1.45));
                    lines = lines + 1;
                }
            }
        }
        if (lines > 2)
        {
            globalVars.getInstance().setIsArea(true);
        }
        invalidate();
        return true;
    }

}
