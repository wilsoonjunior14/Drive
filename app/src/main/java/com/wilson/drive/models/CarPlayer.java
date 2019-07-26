package com.wilson.drive.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import com.wilson.drive.R;

public class CarPlayer extends Car{

    public CarPlayer(Context context, float top, float left){
        super(context, R.drawable.car_player, top, left);
    }

    public void drawCar(Canvas canvas){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), this.image);
        Bitmap bitScaled = Bitmap.createScaledBitmap(bitmap, 200, 200, true);

        Matrix m = new Matrix();
        m.postRotate(90);

        bitScaled = Bitmap.createBitmap(bitScaled, 0, 0, bitScaled.getWidth(), bitScaled.getHeight(), m, true);

        canvas.drawBitmap(bitScaled, this.left, this.top, null);
    }

    public void move(float value){
        super.moveLeftOrRight(value);
    }

}
