package com.wilson.drive.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.wilson.drive.R;

import java.util.ArrayList;

public class Game {

    public Context context;
    public int width;
    public int height;

    public ArrayList<Track> tracks;

    public CarPlayer player;

    public ArrayList<CarEnemy> enemies;

    public Boolean playing;

    public Game(Context context, int width, int height){
        this.context = context;
        this.width   = width;
        this.height  = height;
        this.tracks  = new ArrayList<Track>();

        this.player  = new CarPlayer(context, 150, 5*width/4);
        this.enemies = new ArrayList<CarEnemy>();

        this.playing = true;

        this.generateTrack();
        this.generateEnemies();
    }

    public void generateTrack(){
        this.tracks.add(new Track(this.context, this.height, 0));
        this.tracks.add(new Track(this.context, this.height, - this.height));
    }

    public void generateEnemies(){
        if (playing) {
            int value = Math.random() > 0.6 ? 1 : 2;
            this.enemies.add(new CarEnemy(context, 1 * 150, 0));
        }
    }

    public void drawTracks(Canvas canvas){
        for (int i=0; i<this.tracks.size(); i++){
            Track t = tracks.get(i);
            t.draw(canvas);

            if (playing) {
                if (t.top > height / 1000000) {
                    t.top = 300 - (height * i);
                } else {
                    t.changeTrack();
                }
            }

            System.err.println("Track: "+i+" Top"+t.top);

        }
    }

    public void drawCars(Canvas canvas){
        player.drawCar(canvas);


            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).drawCar(canvas);
                if (playing) {
                    enemies.get(i).moveEnemy();

                    System.err.println("Enemy " + i + "" + enemies.get(i).top);
                    if (collide(player, enemies.get(i))) {
                        playing = false;
                    }
                    removeEnemies(enemies.get(i));
                }
        }

    }

    public Boolean removeEnemies(CarEnemy car){
        if (car.top > 2*height){
            enemies.remove(car);
            return true;
        }
        return false;
    }

    public double distance(float xi, float yi, float xf, float yf){
        return Math.sqrt(Math.pow(xf-xi, 2) + Math.pow(yf-yi, 2));
    }

    public Boolean collide(Car one, Car two){
        double distance = distance(one.left, one.top, two.left, two.top);
        System.err.println("Distance: "+distance+" xi: "+one.left+" xf: "+two.left+" yi: "+one.top+" yf: "+two.top+"");
        if (distance <= 100){
            return true;
        }else
            return false;
    }

    public void drawGameOver(Canvas canvas){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.game_over);
        Bitmap bitScaled = Bitmap.createScaledBitmap(bitmap, width, 200, true);
        canvas.drawBitmap(bitScaled, 0, height/2-200, null);
    }

}
