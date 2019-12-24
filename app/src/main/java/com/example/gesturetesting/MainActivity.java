package com.example.gesturetesting;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetector(this, new OnSwipeListener() {
            @Override
            public void OnSlideRight() {
                Toast.makeText(MainActivity.this, "Slide Right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnSlideLeft() {
                Toast.makeText(MainActivity.this, "Slide Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnSlideUp() {
                Toast.makeText(MainActivity.this, "Slide Up", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnSlideDown() {
                Toast.makeText(MainActivity.this, "Slide Down", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(this.gestureDetector.onTouchEvent(event)){
            return true;
        }
        return super.onTouchEvent(event);
    }
}
