package com.example.saiprashanth.mybooklistingapp;

import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.util.Log;
import android.app.LoaderManager;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {
    //Member variable used for logging
    public static final String LOG_TAG = MainActivity.class.getName();

    private static final int BOOK_LOADER_ID = 1;
    //Member variable to store Google Books Url
    private static final String GOOGLE_BOOKS_URL =
            "https://www.googleapis.com/books/v1/volumes?q=";
    private String mUrl;
    //Member variables to store the views
    private Button mButton;
    private EditText mSearchText;
    private BookAdapter mAdapter;
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.search_button);
        mSearchText = (EditText) findViewById(R.id.book_search);
        mUrl = GOOGLE_BOOKS_URL;
        mButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mUrl = GOOGLE_BOOKS_URL + mSearchText.getText().toString().replace(" ", "+") + "&maxResults=10";
                Log.v(LOG_TAG, mUrl);
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    // fetch data
                    Log.v(LOG_TAG, "getLoaderManagerCalled");
                    LoaderManager loaderManager = getLoaderManager();

                    loaderManager.restartLoader(BOOK_LOADER_ID, null, MainActivity.this);
                } else {
                    // display error in internet connection
                    mEmptyStateTextView.setText(R.string.no_internet);
                }


            }
        });


        // Find a reference to the {@link ListView} in the layout
        ListView bookListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of books
        mAdapter = new BookAdapter(this, new ArrayList<Book>());
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        bookListView.setAdapter(mAdapter);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_text);
        // set emptyview
        bookListView.setEmptyView(mEmptyStateTextView);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // fetch data
            Log.v(LOG_TAG, "getLoaderManagerCalled");
            LoaderManager loaderManager = getLoaderManager();

            loaderManager.initLoader(BOOK_LOADER_ID, null, MainActivity.this);
        } else {
            // display error in internet connection
            mEmptyStateTextView.setText(R.string.no_internet);
        }


    }

    @Override
    public Loader<List<Book>> onCreateLoader(int id, Bundle args) {
        return new BookLoader(this, mUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> data) {
        mAdapter.clear();
        // Set emptyview text
        mEmptyStateTextView.setText(R.string.empty_text);
        if (null != data && !data.isEmpty()) {
            mAdapter.addAll(data);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        mAdapter.clear();
    }
}

