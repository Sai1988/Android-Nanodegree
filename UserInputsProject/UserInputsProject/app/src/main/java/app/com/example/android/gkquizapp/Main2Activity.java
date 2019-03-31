package app.com.example.android.gkquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("Message_Activity");
        int rightAnswers = Integer.parseInt(message);
        setContentView(R.layout.activity_main2);

        TextView text = (TextView) findViewById(R.id.all_answers);
        ImageView image1 = (ImageView) findViewById(R.id.cookies1);
        ImageView image2 = (ImageView) findViewById(R.id.cookies2);
        ImageView image3 = (ImageView) findViewById(R.id.cookies3);
        ImageView image4 = (ImageView) findViewById(R.id.cookies4);
        ImageView image5 = (ImageView) findViewById(R.id.cookies5);
        text.setText("Congratulations. You have won " + rightAnswers + " cookies");

        if (rightAnswers == 0) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) image1.getLayoutParams();
            lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
            image1.setLayoutParams(lp);
            text.setText("Better luck next time");
            image1.setImageResource(R.drawable.smiley);
        } else if (rightAnswers == 1) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) image1.getLayoutParams();
            lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
            image1.setLayoutParams(lp);
            text.setText("Congratulations. You have won " + rightAnswers + " cookie");
            image1.setImageResource(R.drawable.cookie);
        } else if (rightAnswers == 2) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) image1.getLayoutParams();
            lp.leftMargin = (int) (100f * this.getResources().getDisplayMetrics().density); // for setting layout.marginLeft = 100dp
            image1.setLayoutParams(lp);
            image1.setImageResource(R.drawable.cookie);
            image2.setImageResource(R.drawable.cookie);
        } else if (rightAnswers == 3) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) image1.getLayoutParams();
            lp.leftMargin = (int) (75f * this.getResources().getDisplayMetrics().density); // for setting layout.marginLeft = 75dp
            image1.setLayoutParams(lp);
            image1.setImageResource(R.drawable.cookie);
            image2.setImageResource(R.drawable.cookie);
            image3.setImageResource(R.drawable.cookie);
        } else if (rightAnswers == 4) {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) image1.getLayoutParams();
            lp.leftMargin = (int) (40f * this.getResources().getDisplayMetrics().density); // for setting layout.marginLeft = 40dp
            image1.setLayoutParams(lp);
            image1.setImageResource(R.drawable.cookie);
            image2.setImageResource(R.drawable.cookie);
            image3.setImageResource(R.drawable.cookie);
            image4.setImageResource(R.drawable.cookie);
        } else if (rightAnswers == 5) {
            image1.setImageResource(R.drawable.cookie);
            image2.setImageResource(R.drawable.cookie);
            image3.setImageResource(R.drawable.cookie);
            image4.setImageResource(R.drawable.cookie);
            image5.setImageResource(R.drawable.cookie);
        }

    }

}
