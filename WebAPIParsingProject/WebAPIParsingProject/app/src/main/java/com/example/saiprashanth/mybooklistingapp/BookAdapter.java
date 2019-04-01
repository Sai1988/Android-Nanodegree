package com.example.saiprashanth.mybooklistingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by saiprashanth on 16/10/16.
 */
public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the current Book item
        Book currentData = getItem(position);

        //Get the title Text view
        TextView title = (TextView) listItemView.findViewById(R.id.title);
        //Set the title name in the view
        title.setText(currentData.getmTitle());

        //Get the author Text view
        TextView author = (TextView) listItemView.findViewById(R.id.author);
        //Set the author name in the view
        author.setText(currentData.getmAuthor());

        return listItemView;
    }
}
