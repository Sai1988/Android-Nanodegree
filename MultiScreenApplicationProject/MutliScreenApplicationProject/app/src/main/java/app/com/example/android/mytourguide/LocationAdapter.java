package app.com.example.android.mytourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Speed on 14-08-2016.
 */
public class LocationAdapter extends ArrayAdapter<Location> {
    public LocationAdapter(Activity context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Location currentLocation = getItem(position);

        //Find the ImageView in the list_item.xml layout with the ID image
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current Word object and
        // set the image to image Imageview
        image.setImageResource(currentLocation.getImage());

        // Find the TextView in the list_item.xml layout with the ID name
        TextView name = (TextView) listItemView.findViewById(R.id.name);
        // Get the  name from the current Location object and
        // set this text on the  name TextView
        name.setText(currentLocation.getName());

        // Find the TextView in the list_item.xml layout with the ID description.
        TextView description = (TextView) listItemView.findViewById(R.id.description);
        // Get the description from the current Word object and
        // set this text on the description textview
        description.setText(currentLocation.getDescription());

        // Find the TextView in the list_item.xml layout with the ID address.
        TextView address = (TextView) listItemView.findViewById(R.id.address);
        // Get the address from the current Word object and
        // set this text on the address textview
        address.setText(currentLocation.getAddress());

        // Find the TextView in the list_item.xml layout with the ID contact.
        TextView contact = (TextView) listItemView.findViewById(R.id.contact);
        // Get the contact from the current Word object and
        // set this text on the contact textview
        contact.setText(currentLocation.getContact());


        // Return the whole list item layout (containing 4 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}

