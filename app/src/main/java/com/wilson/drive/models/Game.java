package com.wilson.drive.models;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;

public class Game {

    public Context context;
    public int width;
    public int height;

    public ArrayList<Track> tracks;
    public CarPlayer player;

    public Game(Context context, int width, int height){
        this.context = context;
        this.width   = width;
        this.height  = height;
        this.tracks  = new ArrayList<Track>();

        this.player = new CarPlayer(context, 150, 5*width/4);

        this.generateTrack();
    }

    public void generateTrack(){
        this.tracks.add(new Track(this.context, this.height, 0));
        this.tracks.add(new Track(this.context, this.height, - this.height));
    }

    public void drawTracks(Canvas canvas){
        for (int i=0; i<this.tracks.size(); i++){
            Track t = tracks.get(i);
            t.draw(canvas);

            if (t.top > height/10000){
                t.top = 300 - (height*i);
                System.out.println("adicionou");
            }else{
                t.changeTrack();
            }

            System.err.println("Track: "+i+" Top"+t.top);

        }
    }

    public void drawCars(Canvas canvas){
        this.player.drawCar(canvas);
    }

}
