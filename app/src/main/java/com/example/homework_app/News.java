package com.example.homework_app;

public class News {
    private String textForTextView8;
    private int imageResourceForImageView7;
    private String textForTextView9;
    private int imageResourceForImageView8;

    // Constructor, getters, and possibly setters
    public News(String textForTextView8, int imageResourceForImageView7, String textForTextView9, int imageResourceForImageView8) {
        this.textForTextView8 = textForTextView8;
        this.imageResourceForImageView7 = imageResourceForImageView7;
        this.textForTextView9 = textForTextView9;
        this.imageResourceForImageView8 = imageResourceForImageView8;
    }

    public String getTextForTextView8() {
        return textForTextView8;
    }

    public int getImageResourceForImageView7() {
        return imageResourceForImageView7;
    }

    public String getTextForTextView9() {
        return textForTextView9;
    }

    public int getImageResourceForImageView8() {
        return imageResourceForImageView8;
    }
}