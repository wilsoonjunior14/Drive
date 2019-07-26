package com.wilson.drive.models;

import android.content.Context;

public class Car {

    public Context context;
    public int image;
    public float left;
    public float top;

    public Car(Context context, int image, float left, float top) {
        this.context = context;
        this.image = image;
        this.left = left;
        this.top = top;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getLeft() {
        return left;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    public float getTop() {
        return top;
    }

    public void setTop(float top) {
        this.top = top;
    }

    public float moveLeftOrRight(float value){
        this.left += value;
        return this.left;
    }
}
