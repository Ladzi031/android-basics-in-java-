package com.example.practicerecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // make connection to the recycleView
        RecyclerView myRecycleView = findViewById(R.id.c_recycle_view);
        myRecycleView.setLayoutManager(new LinearLayoutManager(this));


        // give the RecycleViewAdaptor some data
        List<ItemData> listData = generateListItemData();
        CustomRecycleViewAdaptor customRecycleViewAdaptor = new CustomRecycleViewAdaptor(listData);
        myRecycleView.setAdapter(customRecycleViewAdaptor);
        customRecycleViewAdaptor.notifyDataSetChanged();
    }

    private List<ItemData> generateListItemData() {
        List<ItemData> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            String currentTime = new SimpleDateFormat("hh:mm a").format(new Date()).toString();
            ItemData temp = new ItemData("mike", "hey there mike been a long time man, how are you?", currentTime);
            int sameImage =R.drawable.my_pic;
            temp.setImageView(sameImage);
            temp.setDivider("--------------------------------------------");
            list.add(temp);
        }
        return list;
    }
}