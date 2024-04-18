package com.example.sireen_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.SharedPreferences;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import android.widget.TextView;


public class QuizActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        sharedPreferences = getSharedPreferences("QuizPrefs", MODE_PRIVATE);

        // Set questions and answers
        TextView question1 = findViewById(R.id.question1);
        question1.setText("ما هي وظيفة الكلية؟");
        RadioButton answer1a = findViewById(R.id.answer1a);
        answer1a.setText("تنظيم ضغط الدم");
        RadioButton answer1b = findViewById(R.id.answer1b);
        answer1b.setText("تنقية الدم");
        RadioButton answer1c = findViewById(R.id.answer1c);
        answer1c.setText("إفراز الهرمونات");

        TextView question2 = findViewById(R.id.question2);
        question2.setText("ما هي الوحدة الأساسية في الكلية؟");
        RadioButton answer2a = findViewById(R.id.answer2a);
        answer2a.setText("النفرون");
        RadioButton answer2b = findViewById(R.id.answer2b);
        answer2b.setText("الأنابيب الكلوية");
        RadioButton answer2c = findViewById(R.id.answer2c);
        answer2c.setText("المثانة");

        TextView question3 = findViewById(R.id.question3);
        question3.setText("ما هو السائل الذي يتم إفرازه من الكلية؟");
        RadioButton answer3a = findViewById(R.id.answer3a);
        answer3a.setText("الدم");
        RadioButton answer3b = findViewById(R.id.answer3b);
        answer3b.setText("البول");
        RadioButton answer3c = findViewById(R.id.answer3c);
        answer3c.setText("العرق");

        radioGroup = findViewById(R.id.radio_group);
        Button btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    // No radio button checked
                    Toast.makeText(QuizActivity.this, "يرجى اختيار إجابة", Toast.LENGTH_SHORT).show();
                } else {
                    // Radio button checked
                    radioButton = findViewById(selectedId);
                    String selectedAnswer = radioButton.getText().toString();
                    // Save selected answer in SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("selectedAnswer", selectedAnswer);
                    editor.apply();
                    Toast.makeText(QuizActivity.this, "تم حفظ الإجابة بنجاح", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
