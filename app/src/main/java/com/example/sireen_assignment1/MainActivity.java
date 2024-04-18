package com.example.sireen_assignment1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.Button;



import android.content.SharedPreferences;


public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Button to launch CategoryDetailsActivity for Mammals
        Button btn = findViewById(R.id.btn_mammals);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategory("تركيب الجهاز البولي");
            }
        });

        // Button to launch CategoryDetailsActivity for Birds
        Button btnB = findViewById(R.id.btn_birds);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategory("تركيب الوحدة الأنبوبية الكلوية");
            }
        });

        // Button to launch CategoryDetailsActivity for Fish
        Button btnFish = findViewById(R.id.btn_fish);
        btnFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategory("خطوات تكوين البول");
            }
        });

        // Button to launch Quiz
        Button btnQuiz = findViewById(R.id.btn_quiz);
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Quiz Activity
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openCategory(String category) {
        Intent intent = new Intent(MainActivity.this, CategoryDetailsActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);

        // Save selected category value in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("selectedCategory", category);
        editor.apply();
    }
}
