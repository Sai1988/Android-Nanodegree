package app.com.example.android.mytourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.util.Log;

import java.util.ArrayList;

public class SportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);
        // Create an array of hospital information
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.sports_1_name),
                getString(R.string.sports_1_description), getString(R.string.sports_1_address),
                getString(R.string.sports_1_contact), R.drawable.ekam));
        locations.add(new Location(getString(R.string.sports_2_name),
                getString(R.string.sports_2_description), getString(R.string.sports_2_address),
                getString(R.string.sports_1_contact), R.drawable.gurukul));
        locations.add(new Location(getString(R.string.sports_3_name),
                getString(R.string.sports_3_description), getString(R.string.sports_3_address),
                getString(R.string.sports_3_contact), R.drawable.orchid));
        // Find a reference to the {@link ListView} in the layout
        ListView locationListView = (ListView) findViewById(R.id.list);
        Log.v("SportsActivity.java", "" + locationListView);
        // Create a new {@link ArrayAdapter} of earthquakes
        LocationAdapter adapter = new LocationAdapter(this, locations);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        locationListView.setAdapter(adapter);


    }


}
