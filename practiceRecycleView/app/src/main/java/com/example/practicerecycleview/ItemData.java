package com.example.practicerecycleview;

public class ItemData {
    private int imageView;
    private String name;
    private String currentTime;
    private String message;
    private String divider;

    public ItemData( String name, String message ,String currentTime) {
       // this.imageView = imageView;
        this.name = name;
        this.currentTime = currentTime;
        this.message = message;
       // this.divider = divider;
    }

    public ItemData() {
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setDivider(String divider){
        this.divider = divider;
    }
    public String getDivider(){
        return divider;
    }
}
