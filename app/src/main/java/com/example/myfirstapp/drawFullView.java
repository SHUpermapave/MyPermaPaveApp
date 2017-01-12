package com.example.myfirstapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class drawFullView extends View{

    private Bitmap fillBMP;

    private final Paint paint = new Paint();
    private final Path path = globalVars.getInstance().getFullPath();

    public drawFullView(Context ctx, AttributeSet attrs){
        super(ctx, attrs);

        setImage();

        BitmapShader fillBMPshader = new BitmapShader(fillBMP, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        paint.setColor(0xFFFFFFFF);
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(fillBMPshader);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawPath(path, paint);
    }

    private void setImage()
    {
        switch(globalVars.getInstance().getSelectedColour())
        {
            case "Amber Gold":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ambergold), 218, 218, false);
                break;
            case "Autumn Gold":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.autumngold), 218, 218, false);
                break;
            case "Autumn Quartz":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.autumnquartz), 218, 218, false);
                break;
            case "Beige":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.beige), 218, 218, false);
                break;
            case "Black":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.black), 218, 218, false);
                break;
            case "Brittany Bronze":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.brittanybronze), 218, 218, false);
                break;
            case "Chinese Bauxite":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.chinesebauxite), 218, 218, false);
                break;
            case "Classic":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.classic), 218, 218, false);
                break;
            case "Dorset Gold":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.tileddorsetgoldsmall), 375, 375, false);
                break;
            case "Golden Pea":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.goldenpea), 218, 218, false);
                break;
            case "Golden Quartz":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.goldenquartz), 218, 218, false);
                break;
            case "Green":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.green), 218, 218, false);
                break;
            case "Pearl Quartz":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.pearlquartz), 218, 218, false);
                break;
            case "Red":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.red), 218, 218, false);
                break;
            case "Salmon Pink":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.salmonpink), 218, 218, false);
                break;
            case "Silver":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.silver), 218, 218, false);
                break;
            case "Staffordshire Pink":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.staffordshirepink), 218, 218, false);
                break;
            case "Trugrip":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.trugrip), 218, 218, false);
                break;
            case "White Flint":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.whiteflint), 218, 218, false);
                break;
            case "Yellow":
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.yellow), 218, 218, false);
                break;

            default:
                fillBMP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ambergold), 218, 218, false);
                break;
        }
    }
}
