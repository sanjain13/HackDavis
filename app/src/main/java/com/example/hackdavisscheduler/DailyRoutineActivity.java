package com.example.hackdavisscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DailyRoutineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_routine);

        Button button = findViewById(R.id.daily4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DailyRoutineActivity.this, TimePicking.class));
                //startActivity(new Intent(DailyRoutineActivity.this, TreeMapDemo.class));
            }
        });

        Button button1 = findViewById(R.id.weekly4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DailyRoutineActivity.this, WeeklyActivity.class));
            }
        });
    }
}
