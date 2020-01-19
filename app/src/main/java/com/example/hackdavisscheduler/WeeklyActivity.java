package com.example.hackdavisscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeeklyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);

        Button button = findViewById(R.id.daily);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WeeklyActivity.this, TimePicking.class));
                //startActivity(new Intent(WeeklyActivity.this, TreeMapDemo.class));
            }
        });
    }
}
