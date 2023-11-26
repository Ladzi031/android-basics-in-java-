package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    //setContentView(R.layout.activity_main);
    // we will create the the interface in java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.GRAY);


        //my button
        Button myButton = new Button(this);
        myButton.setText("click me");
        myButton.setBackgroundColor(Color.BLACK);
        myButton.setTextColor(Color.WHITE);
        myButton.setId(2);

        EditText userInput = new EditText(this);
        userInput.setId(1);
        userInput.setWidth(500);

        // creating the button container here, that adapts to the button's height and width
        RelativeLayout.LayoutParams btnDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // creating the EditText container here, that adapts to the button's height and width
        RelativeLayout.LayoutParams userInputDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        // stating exactly where the container should be relative to this-"MainActivity" layout
        btnDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btnDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        // stating exactly where the EditText container should be relative to this-"MainActivity" layout
        userInputDetails.addRule(RelativeLayout.ABOVE, myButton.getId()); // positioned above the button
        userInputDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userInputDetails.setMargins(0,0,0, 55);


        // we are converting Dip to pixels...
        // since number of pixels depends on the dimension of the screen
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,250.0F, r.getDisplayMetrics());

        userInput.setWidth(px);
        //the "main layout" for display...
        myLayout.addView(myButton, btnDetails);
        myLayout.addView(userInput, userInputDetails);

        // displaying... I one want to write complex systems in any jvm language
        this.setContentView(myLayout);
    }
}