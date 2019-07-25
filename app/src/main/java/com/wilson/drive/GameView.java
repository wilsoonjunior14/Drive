package com.wilson.drive;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.wilson.drive.models.Background;
import com.wilson.drive.models.Game;
import com.wilson.drive.models.Track;

public class GameView extends SurfaceView implements SurfaceHolder.Callback, Runnable, View.OnTouchListener {

    public Context context;

    public GameView(Context context) {
        super(context);
        this.context = context;
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void run() {

        Game g = new Game(context, getWidth(), getHeight());

        while (true){
            Canvas canvas = getHolder().lockCanvas();

            Paint p = new Paint();
            p.setColor(Color.RED);

            // draw fundo
            Background fundo = new Background(context, getHeight());
            fundo.draw(canvas);

            // draw pista
            g.drawTracks(canvas);

            // draw cars
            g.drawCars(canvas);

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            getHolder().unlockCanvasAndPost(canvas);
        }

    }
}
