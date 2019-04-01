package com.example.saiprashanth.mybooklistingapp;

/**
 * Created by saiprashanth on 16/10/16.
 */
public class Book {
    private String mTitle;
    private String mAuthor;

    //Constructor
    Book(String title, String author){
        mTitle = title;
        mAuthor = author;
    }

    //Get Title of the book
    public String getmTitle() {
        return mTitle;
    }

    //Get Author name

    public String getmAuthor() {
        return mAuthor;
    }
}
