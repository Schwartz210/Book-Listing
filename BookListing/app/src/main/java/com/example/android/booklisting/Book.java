package com.example.android.booklisting;

/**
 * Created by aschwartz on 1/5/2017.
 */

public class Book {
    private String mTitle;
    private String mAuthor;
    private String mDate;
    public Book(String title, String author, String date){
        mTitle = title;
        mAuthor = author;
        mDate = date;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getAuthor(){
        return mAuthor;
    }

    public String getDate(){
        return mDate;
    }
}
