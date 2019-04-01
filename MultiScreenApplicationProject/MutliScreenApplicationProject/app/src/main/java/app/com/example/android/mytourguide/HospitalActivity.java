package app.com.example.android.mytourguide;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

public class HospitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_list);
        // Create an array of hospital information
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.hospital_1_name),
                getString(R.string.hospital_1_description), getString(R.string.hospital_1_address),
                getString(R.string.hospital_1_contact), R.drawable.jeevika));
        locations.add(new Location(getString(R.string.hospital_2_name),
                getString(R.string.hospital_2_description), getString(R.string.hospital_2_address),
                getString(R.string.hospital_2_contact), R.drawable.yashomati));
        locations.add(new Location(getString(R.string.hospital_3_name),
                getString(R.string.hospital_3_description), getString(R.string.hospital_3_address),
                getString(R.string.hospital_3_contact), R.drawable.sankara));


        // Find a reference to the {@link ListView} in the layout
        ListView locationListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        LocationAdapter adapter = new LocationAdapter(this, locations);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        locationListView.setAdapter(adapter);

    }


}
