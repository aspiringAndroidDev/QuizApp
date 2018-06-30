package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;
    int score5 = 0;
    RadioButton phishing;
    RadioButton worms;
    RadioButton trojan;
    int finalscore;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    CheckBox question41;
    CheckBox question42;
    CheckBox question43;
    EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phishing = findViewById(R.id.phishing);
        worms = findViewById(R.id.worms);
        trojan = findViewById(R.id.trojan);
        cb1 = findViewById(R.id.baiting);
        cb2 = findViewById(R.id.ransom);
        cb3 = findViewById(R.id.fishing);
        cb4 = findViewById(R.id.travellingworms);
        question41 = findViewById(R.id.compression);
        question42 = findViewById(R.id.systematic);
        question43 = findViewById(R.id.encyptiom);
    edittext = findViewById(R.id.fieldtext);

    }

    public void submitQuizAnswers(View v)
    {

        RadioGroup group1 = findViewById(R.id.cyberattack);
        int selected = group1.getCheckedRadioButtonId();
        RadioButton button1 =  findViewById(selected);
        if ("Phishing".equals(button1.getText())) {
            score1 = score1+1;

        } else {

        }
        RadioGroup group2 = findViewById(R.id.password);
        int selected2 = group2.getCheckedRadioButtonId();
        RadioButton button2 =  findViewById(selected2);
        if ("Upper and lower case letters, numbers and symbols".equals(button2.getText())) {
            score2 = score2+1;
        } else {

        }

        if(cb1.isChecked()||cb2.isChecked()||cb4.isChecked())
        {
            score3 = score3+1;

        }
        else
        {
            score3 = score3+0;
        }
        if(question43.isChecked()&&question42.isChecked()&&cb4.isChecked())
        {
            score4 = score4+0;

        }
        else if (question43.isChecked())
        {
            score4 = score4+1;

        }
        else
        {
            score4 = score4+0;

        }
        String toCompare = edittext.getText().toString();

        if (toCompare.equalsIgnoreCase("antivirus")) {
            score5 = score5+1;
        }

        finalscore=score1+score2+score3+score4+score5;
        Toast.makeText(this,String.valueOf(finalscore), Toast.LENGTH_SHORT).show();

    }
}
