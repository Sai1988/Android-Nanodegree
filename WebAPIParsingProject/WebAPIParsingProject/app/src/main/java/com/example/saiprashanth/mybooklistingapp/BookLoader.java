package com.example.saiprashanth.mybooklistingapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by saiprashanth on 16/10/16.
 */
public class BookLoader extends AsyncTaskLoader<List<Book>> {

    private String mUrl;

    public BookLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Book> loadInBackground() {
        if (null == mUrl)
            return null;
        //Call fetchBookData method of QueryUtilsclass to get a list of Book objects
        List<Book> result = QueryUtils.fetchBookData(mUrl);
        return result;
    }
}
