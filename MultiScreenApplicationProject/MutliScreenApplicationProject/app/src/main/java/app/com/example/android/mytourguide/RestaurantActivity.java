package app.com.example.android.mytourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);
        // Create an array of hospital information
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.restaurant_1_name),
                getString(R.string.restaurant_1_description), getString(R.string.restaurant_1_address),
                getString(R.string.restaurant_1_contact), R.drawable.maria));
        locations.add(new Location(getString(R.string.restaurant_2_name),
                getString(R.string.restaurant_2_description), getString(R.string.restaurant_2_address),
                getString(R.string.restaurant_2_contact), R.drawable.moriz));
        locations.add(new Location(getString(R.string.restaurant_3_name),
                getString(R.string.restaurant_3_description), getString(R.string.restaurant_3_address),
                getString(R.string.restaurant_3_contact), R.drawable.thalassery));

        // Find a reference to the {@link ListView} in the layout
        ListView locationListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        LocationAdapter adapter = new LocationAdapter(this, locations);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        locationListView.setAdapter(adapter);

    }
}
