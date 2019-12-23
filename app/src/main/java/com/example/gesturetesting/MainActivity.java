package com.example.gesturetesting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private static final String DEBUG_TAG = "Gestures";
    private ConstraintLayout constraintLayout;
    private GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.constaint);
        detector = new GestureDetector(this, this);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(this.detector.onTouchEvent(event)){
            return true;
        }
        return super.onTouchEvent(event);
    }
    @Override
    public boolean onDown(MotionEvent e) {
        Toast.makeText(MainActivity.this, "Down!", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast.makeText(MainActivity.this, "UP!", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float dX, dY;
        int threshold = 100;
        Log.d(DEBUG_TAG, "onFling: " + e1.toString() + e2.toString());
        dX = e2.getX() - e1.getX();
        dY = e2.getY() - e1.getY();
        if (Math.abs(dX) > Math.abs(dY)) {
            if (dX > threshold) {
                Toast.makeText(MainActivity.this, "Slide RIGHT!", Toast.LENGTH_SHORT).show();
            } else if (dX < (-threshold)) {
                Toast.makeText(MainActivity.this, "Slide LEFT!", Toast.LENGTH_SHORT).show();
            }
        }
        else if (Math.abs(dX) < Math.abs(dY)){
            if (dY > threshold){
                Toast.makeText(MainActivity.this, "Slide DOWN!", Toast.LENGTH_SHORT).show();
            }
            else if (dY < -(threshold)){
                Toast.makeText(MainActivity.this, "Slide UP!", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }


}
