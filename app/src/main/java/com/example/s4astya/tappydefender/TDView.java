package com.example.s4astya.tappydefender;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by S4ASTYA on 23.03.2016.
 */
public class TDView extends SurfaceView implements Runnable {

    volatile boolean playing;
    Thread gameTread = null;
    private PlayerShip player;
    private SurfaceHolder ourHolder;
    private Paint paint;
    private Canvas canvas;

    public TDView(Context context,int x,int y) {
        super(context);
        ourHolder = getHolder();
        paint = new Paint();
        player = new PlayerShip(context,x,y);
    }
    private void update() {
        player.update();
    }

    private void draw()
    {
        if(ourHolder.getSurface().isValid())
        {
            canvas = ourHolder.lockCanvas();

            canvas.drawColor(Color.rgb(255,0,0));
            canvas.drawBitmap(player.getBitmap(), player.getX(), player.getY(), paint);
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }
    private void control()  {
        try {
            gameTread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(playing) {
            update();
            draw();
            control();
        }
    }
    public void pause()
    {
        playing = false;
        try {
            gameTread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void resume()
    {
        playing = true;
        gameTread = new Thread(this);
        gameTread.start();
    }
}
