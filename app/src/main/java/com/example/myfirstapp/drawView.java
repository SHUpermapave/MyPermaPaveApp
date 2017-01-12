package com.example.myfirstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class drawView extends View{
    private Paint paint = new Paint();
    private Path path = globalVars.getInstance().getPath();

    public drawView(Context ctx, AttributeSet attrs){
        super(ctx, attrs);
        paint.setColor(Color.parseColor("#FF9F23"));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(10f);
        paint.setAlpha(180);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawPath(path, paint);
    }
}
