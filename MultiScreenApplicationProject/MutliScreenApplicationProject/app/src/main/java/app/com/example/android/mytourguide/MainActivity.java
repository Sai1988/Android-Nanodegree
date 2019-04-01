package app.com.example.android.mytourguide;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Creating a intent when Numbers is clicked
        TextView numbers = (TextView) findViewById(R.id.hospital);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNum = new Intent(MainActivity.this, HospitalActivity.class);
                startActivity(intentNum);
            }
        });

        // Creating a intent when Family Members is clicked
        TextView family = (TextView) findViewById(R.id.restaurant);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFamily = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(intentFamily);
            }
        });

        // Creating a intent when Colors is clicked
        TextView colors = (TextView) findViewById(R.id.school);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentColors = new Intent(MainActivity.this, SchoolActivity.class);
                startActivity(intentColors);
            }
        });

        // Creating a intent when Numbers is clicked
        TextView phrases = (TextView) findViewById(R.id.sports);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPhrases = new Intent(MainActivity.this, SportsActivity.class);
                startActivity(intentPhrases);
            }
        });

    }
}
