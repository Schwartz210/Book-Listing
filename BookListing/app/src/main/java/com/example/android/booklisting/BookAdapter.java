package com.example.android.booklisting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aschwartz on 1/5/2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {


    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Book currentBook = getItem(position);
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        titleTextView.setText(currentBook.getTitle());
        authorTextView.setText(currentBook.getAuthor());
        dateTextView.setText(currentBook.getDate());

        return listItemView;
    }

}
