package com.example.s4astya.tappydefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by S4ASTYA on 23.03.2016.
 */
public class PlayerShip {

    private Bitmap bitmap;
    private int x,y;
    private int speed = 0;
    private boolean booster;

    private int maxY;
    private int minY;

    private final int GRAVITY = -12;
    private int maxSpeed = 20;
    private int minSpeed = 1;
    PlayerShip(Context context,int screenX,int screenY)
    {
        int x = 50;
        int y = 50;
        maxY = screenY - bitmap.getHeight();
        minY = 0;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.ship);
        booster = false;
    }

    public void update()
    {
        if(booster)
        {
            speed +=2;
        }else
         speed-=5;

        if(speed<minSpeed)
            speed = minSpeed;
        if(speed>maxSpeed)
            speed = maxSpeed;
        y -= speed+GRAVITY;
        if(y<minY)
            y = minY;
        if(y>maxY)
            y = maxY;
        x++;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setBoosting()
    {}
    public void stopBoosting()
    {}
}
