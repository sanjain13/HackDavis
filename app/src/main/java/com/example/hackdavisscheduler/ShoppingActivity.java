package com.example.hackdavisscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        Button button = findViewById(R.id.daily2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShoppingActivity.this, TimePicking.class));
                //startActivity(new Intent(ShoppingActivity.this, TreeMapDemo.class));
            }
        });

        Button button1 = findViewById(R.id.weekly2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShoppingActivity.this, WeeklyActivity.class));
            }
        });
    }
}
