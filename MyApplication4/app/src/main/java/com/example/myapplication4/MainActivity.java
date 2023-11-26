package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = this.findViewById(R.id.myButtonId);

        // can use a lambda here as well.
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView myText = findViewById(R.id.myTextId);
                String text = (String) myText.getText();

                int addOne = Integer.parseInt(text) + 1;
                myText.setText(String.valueOf(addOne));
            }
        });
    }
}
