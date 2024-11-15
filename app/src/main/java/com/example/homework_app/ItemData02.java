package com.example.homework_app;

public class ItemData02 {
    private int imageResId;
    private String text1;
    private String text2;

    public ItemData02(int imageResId, String text1, String text2) {
        this.imageResId = imageResId;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}