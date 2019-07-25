package com.wilson.drive.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.wilson.drive.R;

public class Track {

    public Context context;
    public int image;
    public int left;
    public int top;
    public int height;

    public Track(Context context, int height, int top){
        this.context = context;
        this.left    = 125;
        this.top     = top;
        this.image   = R.drawable.pista;
        this.height  = height;
    }

    public void draw(Canvas canvas){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), image);
        Bitmap bitScaled = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth()*2, height, true);
        canvas.drawBitmap(bitScaled, left, top, null);
    }

    public void changeTrack(){
        this.top = this.top + 100;
        System.out.println(top);
    }

}
