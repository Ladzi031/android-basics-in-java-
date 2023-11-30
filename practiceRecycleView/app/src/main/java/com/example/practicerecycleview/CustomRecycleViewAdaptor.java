package com.example.practicerecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomRecycleViewAdaptor extends RecyclerView.Adapter<CustomRecycleViewAdaptor.ViewHolder> {

    private List<ItemData> listItems = new ArrayList<>();
    public CustomRecycleViewAdaptor(List<ItemData> listItems) {
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecycleViewAdaptor.ViewHolder holder, int position) {
        int imageResource = listItems.get(position).getImageView();
        String name = listItems.get(position).getName();
        String time = listItems.get(position).getCurrentTime();
        String message = listItems.get(position).getMessage();
        String separator = listItems.get(position).getDivider();

        holder.setData(imageResource, name, time, message, separator);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView dImageResource;
        private TextView dName;
        private TextView dTime;
        private TextView dMessage;
        private TextView dLineSeparator;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dImageResource = itemView.findViewById(R.id.my_image_view);
            dName = itemView.findViewById(R.id.name_textview);
            dMessage = itemView.findViewById(R.id.message_textview);
            dTime = itemView.findViewById(R.id.time_textview);
            dLineSeparator = itemView.findViewById(R.id.divider_line_textview);

        }

        public void setData(int imageResource, String name, String time, String message, String separator) {
            dImageResource.setImageResource(imageResource);
            dName.setText(name);
            dTime.setText(time);
            dMessage.setText(message);
            dLineSeparator.setText(separator);
        }
    }
}
