package com.example.hackdavisscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        Button button = findViewById(R.id.daily);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MealActivity.this, TimePicking.class));
                //startActivity(new Intent(MealActivity.this, TreeMapDemo.class));

            }
        });

        Button button1 = findViewById(R.id.weekly);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MealActivity.this, WeeklyActivity.class));
            }
        });
    }
}
