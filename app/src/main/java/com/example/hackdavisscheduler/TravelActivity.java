package com.example.hackdavisscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TravelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        Button button = findViewById(R.id.daily3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TravelActivity.this, TimePicking.class));
                //startActivity(new Intent(TravelActivity.this, TreeMapDemo.class));
            }
        });

        Button button1 = findViewById(R.id.weekly3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TravelActivity.this, WeeklyActivity.class));
            }
        });
    }
}
