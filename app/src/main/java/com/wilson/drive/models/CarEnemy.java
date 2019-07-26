package com.wilson.drive.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.wilson.drive.R;

public class CarEnemy extends Car{

    public CarEnemy(Context context, float left, float top) {
        super(context, R.drawable.car_enemy_1, left, top);
    }

    public void drawCar(Canvas canvas){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), this.image);
        Bitmap bitScaled = Bitmap.createScaledBitmap(bitmap, 200, 200, true);

        canvas.drawBitmap(bitScaled, this.left, this.top, null);
    }

    public void moveEnemy(){
        this.top += 50;
    }

}
