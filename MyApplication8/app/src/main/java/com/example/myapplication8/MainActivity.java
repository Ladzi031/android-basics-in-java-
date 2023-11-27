package com.example.myapplication8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ViewGroup myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = findViewById(R.id.my_layout_id);

        myLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                moveButton();
                return true;
            }
        });
    }

    public void moveButton() {
        View myButton = findViewById(R.id.my_button);

        //  TransitionManager.beginDelayedTransition(myButton);


        // change positions of the button
        //wrap content(button)
        RelativeLayout.LayoutParams newBtnCoordinates = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // state exactly where the button should be
        newBtnCoordinates.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        newBtnCoordinates.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        // take button in the view and give new coordinates
        myButton.setLayoutParams(newBtnCoordinates);


        //change the size of the button
        ViewGroup.LayoutParams sizeRules = myButton.getLayoutParams();

        sizeRules.width = 450;
        sizeRules.height = 300;
        myButton.setLayoutParams(sizeRules);
    }
}