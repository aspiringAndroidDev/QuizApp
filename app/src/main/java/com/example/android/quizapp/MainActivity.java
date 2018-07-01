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

    //Variable declaration for all views used
    int questionOneScore = 0;
    int questionTwoScore = 0;
    int questionThreeScore = 0;
    int questionFourScore = 0;
    int questionFiveScore = 0;
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

    //submitQuizAnswers methods does checks to determine right and wrong answers
    //The sequence is that of questions 1-5 respectively

    public void submitQuizAnswers(View view) {

        int selectedRadioQ1 = groupCyberAttack.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioQ1);
        if (selectedRadioButton != null && "Phishing".equals(selectedRadioButton.getText())) {
            questionOneScore = 1;

        } else {

            questionOneScore = 0;
        }
        RadioGroup selectedRadioGroupQ2 = findViewById(R.id.password_group);
        int selectedButtonQ2 = selectedRadioGroupQ2.getCheckedRadioButtonId();
        RadioButton buttonId = findViewById(selectedButtonQ2);
        if (buttonId != null && "Upper and lower case letters, numbers and symbols".equals(buttonId.getText())) {
            questionTwoScore = 1;
        } else {
            questionTwoScore = 0;
        }

        if (cbBaiting.isChecked() && cbRansom.isChecked() && cbTravellingWorms.isChecked()) {
            questionThreeScore = 1;

        } else {
            questionThreeScore = 0;

        }
        int selectedRadioQ4 = groupEncodingInformation.getCheckedRadioButtonId();
        RadioButton selectedRadioButtonQ4 = findViewById(selectedRadioQ4);
        if (selectedRadioButtonQ4 != null && "Encryption".equals(selectedRadioButtonQ4.getText())) {
            questionFourScore = 1;

        } else {
            questionFourScore = 0;

        }
        String userAnswer = question5Answer.getText().toString();

        if (userAnswer.equalsIgnoreCase("antivirus")) {
            questionFiveScore = 1;
        }
        else {
            questionFiveScore = 0;

        }


        finalScore = questionOneScore + questionTwoScore + questionThreeScore + questionFourScore + questionFiveScore;
        if(finalScore == totalQuizScore) {

            String finalScoreMessage = "Your score is " + String.valueOf(finalScore) + "/5. Well done!!!!";
            Toast.makeText(this, finalScoreMessage, Toast.LENGTH_LONG).show();
        }
        else
        {
            String finalScoreMessage = "Your score is " + String.valueOf(finalScore) + "/5. You may take the quiz again to improve your score!!!!";
            Toast.makeText(this, finalScoreMessage, Toast.LENGTH_LONG).show();

        }


    }
}
