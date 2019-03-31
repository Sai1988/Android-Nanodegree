package app.com.example.android.gkquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * handler for submit button
     *
     * @param view
     */
    public void answerSubmit(View view) {
        int rightAnswers = 0;
        RadioButton answer1_2 = (RadioButton) findViewById(R.id.answer_1_2);
        if (answer1_2.isChecked()) { // increment rightAnswers only if second option is selected
            rightAnswers += 1;
        }

        EditText answer2 = (EditText) findViewById(R.id.answer_2);
        String answerTwo = answer2.getText().toString().toUpperCase().trim();
        if (answerTwo.equals("PACIFIC") || answerTwo.equals("PACIFIC OCEAN")) {
            rightAnswers += 1;
        }

        CheckBox answer3_1 = (CheckBox) findViewById(R.id.answer_3_1);
        CheckBox answer3_2 = (CheckBox) findViewById(R.id.answer_3_2);
        CheckBox answer3_3 = (CheckBox) findViewById(R.id.answer_3_3);
        CheckBox answer3_4 = (CheckBox) findViewById(R.id.answer_3_4);
        if (answer3_1.isChecked() && (!answer3_2.isChecked()) && (!answer3_3.isChecked()) && (answer3_4.isChecked())) {
            rightAnswers += 1;
        }

        EditText answer4 = (EditText) findViewById(R.id.answer_4);
        String answerFour = answer4.getText().toString().toUpperCase().trim();

        if (answerFour.equals("ASIA")) {
            rightAnswers += 1;
        }
        EditText answer5 = (EditText) findViewById(R.id.answer_5);
        String answerFive = answer5.getText().toString().toUpperCase().trim();
        if (answerFive.equals("NILE")) {
            rightAnswers += 1;
        }
        String numOfCorrectAnswers = "You have answered " + rightAnswers + " / 5";
        Toast.makeText(this, numOfCorrectAnswers, Toast.LENGTH_SHORT).show();
        sendMessageToActivity(rightAnswers);
        rightAnswers = 0; // Resetting the variable for next display
    }

    /**
     * Sends the message to next activity.
     *
     * @param rightAnswers
     */
    private void sendMessageToActivity(int rightAnswers) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("Message_Activity", "" + rightAnswers);
        startActivity(intent);

    }
}
