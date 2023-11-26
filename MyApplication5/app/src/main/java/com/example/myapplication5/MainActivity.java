package com.example.myapplication5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import androidx.core.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private TextView myTextView;
    private GestureDetectorCompat gestureDetectorComp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.myTextView = (TextView) findViewById(R.id.myTextId);



        // only two lines of code to activate gestures Detection
        gestureDetectorComp = new GestureDetectorCompat(this, this);
        gestureDetectorComp.setOnDoubleTapListener(this);
    }

    // this code right here, pretty important!
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorComp.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    // gesture beginning
    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent motionEvent) {
        myTextView.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent motionEvent) {
        myTextView.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent motionEvent) {
        myTextView.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(@NonNull MotionEvent motionEvent) {
        myTextView.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent motionEvent) {
        myTextView.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
        myTextView.setText("onSingleTapUP");
        return true;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        myTextView.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {
        myTextView.setText("onLongPress");
    }

    @Override
    public boolean onFling(@Nullable MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        myTextView.setText("onFling");
        return true;
    }
}