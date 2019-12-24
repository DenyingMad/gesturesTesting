package com.example.gesturetesting;

import android.inputmethodservice.KeyboardView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public abstract class OnSwipeListener implements GestureDetector.OnGestureListener {

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
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
        dX = e2.getX() - e1.getX();
        dY = e2.getY() - e1.getY();
        if (Math.abs(dX) > Math.abs(dY)) {
            if (dX > threshold) {
                OnSlideRight();
            } else if (dX < (-threshold)) {
                OnSlideLeft();
            }
        } else if (Math.abs(dX) < Math.abs(dY)) {
            if (dY > threshold) {
                OnSlideDown();
            } else if (dY < -(threshold)) {
                OnSlideUp();
            }
        }
        return true;
    }
    public abstract void OnSlideRight();
    public abstract void OnSlideLeft();
    public abstract void OnSlideUp();
    public abstract void OnSlideDown();
}
