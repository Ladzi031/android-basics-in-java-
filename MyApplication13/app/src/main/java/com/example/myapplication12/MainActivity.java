package com.example.myapplication12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private Button addButton;
    private Button deleteButton;
    private TextView displayResult;
    private DbHandler database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.name_edit_text_id);
        addButton = findViewById(R.id.button);
        deleteButton = findViewById(R.id.deletebutton);
        displayResult = findViewById(R.id.display_textview_id);
        database = new DbHandler(this,null,null,1);
        printDatabase();
    }

    private void printDatabase() {
        if(database.databaseToString().isEmpty()){
            displayResult.setText("");
        }
        displayResult.setText(database.databaseToString());
    }
    public void addButtonClicked(View view){
        String productName = userInput.getText().toString();
        if(! productName.isEmpty()){
            Product product = new Product(productName);
            database.addProduct(product);
            clearTextField();
            displayResult.setText(database.databaseToString());
            Toast.makeText(this, "product saved", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "please enter product name", Toast.LENGTH_LONG).show();
        }
    }
    public void deleteButtonClicked(View view){
        String productName = userInput.getText().toString();
        if(! productName.isEmpty()){
            database.deleteProduct(productName);
            clearTextField();
            displayResult.setText(database.databaseToString());
            Toast.makeText(this, "product deleted", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "enter product name to delete", Toast.LENGTH_LONG).show();
        }
    }
    private void clearTextField() {
        userInput.setText("");
    }
}