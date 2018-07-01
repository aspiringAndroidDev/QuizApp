package com.example.android.quizapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int question1Score = 0;
    int question2Score = 0;
    int question3Score = 0;
    int question4Score = 0;
    int question5Score = 0;
    RadioButton phishing;
    RadioButton worms;
    RadioButton trojan;
    int finalScore;
    CheckBox cbBaiting;
    CheckBox cbRansom;
    CheckBox cbPhishing;
    CheckBox cbTravellingWorms;
    RadioButton question31;
    RadioButton question32;
    RadioButton question33;
    EditText question5Answer;
    final int totalQuizScore = 5;

    private RadioGroup groupCyberAttack;
    private RadioGroup groupEncodingInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phishing = findViewById(R.id.phishing);
        worms = findViewById(R.id.worms);
        trojan = findViewById(R.id.trojan);
        cbBaiting = findViewById(R.id.baiting);
        cbRansom = findViewById(R.id.ransom);
        cbPhishing = findViewById(R.id.fishing);
        cbTravellingWorms = findViewById(R.id.travelling_worms);
        question31 = findViewById(R.id.compression);
        question32 = findViewById(R.id.systematic);
        question33 = findViewById(R.id.encyptiom);
        question5Answer = findViewById(R.id.fieldtext);

        groupCyberAttack = findViewById(R.id.cyberattack);
        groupEncodingInformation= findViewById(R.id.encoding_information);

    }

    public void submitQuizAnswers(View view) {

        int selectedRadioGroupQ1 = groupCyberAttack.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioGroupQ1);
        if (selectedRadioButton != null && "Phishing".equals(selectedRadioButton.getText())) {
            question1Score = 1;

        } else {

            question1Score = 0;
        }
        RadioGroup selectedRadioGroupQ2 = findViewById(R.id.password_group);
        int selected2 = selectedRadioGroupQ2.getCheckedRadioButtonId();
        RadioButton button2 = findViewById(selected2);
        if (button2 != null && "Upper and lower case letters, numbers and symbols".equals(button2.getText())) {
            question2Score = 1;
        } else {
            question2Score = 0;
        }

        if (cbBaiting.isChecked() && cbRansom.isChecked() && cbTravellingWorms.isChecked()) {
            question3Score = 1;

        } else {
            question3Score = 0;

        }
        int selected1 = groupEncodingInformation.getCheckedRadioButtonId();
        RadioButton selectedRadioButtonQ4 = findViewById(selected1);
        if (selectedRadioButtonQ4 != null && "Encryption".equals(selectedRadioButtonQ4.getText())) {
            question4Score = 1;

        } else {
            question4Score = 0;

        }
        String userAnswer = question5Answer.getText().toString();

        if (userAnswer.equalsIgnoreCase("antivirus")) {
            question5Score = 1;
        }
        else {
            question5Score = 0;

        }


        finalScore = question1Score + question2Score + question3Score + question4Score + question5Score;
        if(finalScore == totalQuizScore) {

            String finalScoreMessage = "Your score is " + String.valueOf(finalScore) + "/5 Well done!!!!";
            Toast.makeText(this, finalScoreMessage, Toast.LENGTH_LONG).show();
        }
        else
        {
            String finalScoreMessage = "Your score is " + String.valueOf(finalScore) + "/5 You may take the quiz again to improve your score!!!!";
            Toast.makeText(this, finalScoreMessage, Toast.LENGTH_LONG).show();

        }

    }
}
