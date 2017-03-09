package com.example.android.booklisting;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    private TextView mEmptyStateTextView;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        mListView = (ListView) findViewById(R.id.list2);
        String input = getIntent().getStringExtra("TextBox");
        String query = buildQuery(input);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            mListView.setEmptyView(mEmptyStateTextView);
            mEmptyStateTextView.setText("No internet connection");
        } else {
            BookAsyncTask task = new BookAsyncTask();
            task.execute(query);
        }
    }

    public String buildQuery(String input){
        String beginning = "https://www.googleapis.com/books/v1/volumes?q=";
        String end = "&maxResults=10";
        String result = beginning + input + end;
        return result;
    }
    public void updateUi(ArrayList<Book> books){
        mListView.setEmptyView(mEmptyStateTextView);
        BookAdapter adapter = new BookAdapter(this, books);
        mListView.setAdapter(adapter);
    }

    private class BookAsyncTask extends AsyncTask<String, Void, ArrayList<Book>>{
        @Override
        protected ArrayList<Book> doInBackground(String... url) {
            if (url.length < 1 || url[0] == null) {
                return null;
            }
            ArrayList<Book> books = Utils.fetchBookData(url[0]);
            return books;
        }

        protected void onPostExecute(ArrayList<Book> books) {
            if (books == null) {
                return;
            }
            updateUi(books);
        }
    }
}
