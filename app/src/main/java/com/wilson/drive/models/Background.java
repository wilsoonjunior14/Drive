package com.wilson.drive.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.wilson.drive.R;

public class Background {

    public int image;
    public Context context;
    public int left;
    public int top;


    public Background(Context context, int top){
        this.context = context;
        this.image   = R.drawable.grama;
        this.left    = 0;
        this.top     = top;
    }

    public void draw(Canvas canvas){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), image);
        Bitmap bit = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), top, false);
        canvas.drawBitmap(bit, 0, 0, null);
    }

}
