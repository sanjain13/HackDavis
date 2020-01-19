package com.example.hackdavisscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;

import java.util.*;
import java.util.Random;

import static com.example.hackdavisscheduler.Notification.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity {
    static boolean Meal = false;
    static boolean Shopping = false;
    static boolean Travel = false;
    static boolean DailyRoutine = false;

    public NotificationManagerCompat notificationManager;

    TimePicking timePicking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = NotificationManagerCompat.from(this);

        Button button = findViewById(R.id.meals);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meal = true;
                startActivity(new Intent(MainActivity.this, MealActivity.class));
            }
        });

        Button button1 = findViewById(R.id.shopping);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shopping = true;
                startActivity(new Intent(MainActivity.this, ShoppingActivity.class));
            }
        });

        Button button2 = findViewById(R.id.travel);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Travel = true;
                startActivity(new Intent(MainActivity.this, TravelActivity.class));
            }
        });

        Button button3 = findViewById(R.id.dailyRoutine);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DailyRoutine = true;
                startActivity(new Intent(MainActivity.this, DailyRoutineActivity.class));
            }
        });


    }

    public class TreeMapDemo extends MainActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_time_picker);

            TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

            Random random = new Random();
            String printMessage = "";

            if (Meal) {

                int randomInt = random.nextInt(6 + 1);

                //tips 1 through 6 are from the meal category
                tmap.put(1, "Use a reusable straw or skip the straw if possible!");
                tmap.put(2, "Use a reusable cup!");
                tmap.put(3, "Eat a vegan meal! Reduce global emissions!");
                tmap.put(4, "Avoid plastic utensils!");
                tmap.put(5, "Try to use fewer napkins!");
                tmap.put(6, "Don't get more than you can eat!");
                printMessage = tmap.get(randomInt);

                Meal = false;
            }

            else if (Shopping) {

                int randomInt = random.nextInt(6 + 1) + 7;

                tmap.get(randomInt);
                //tips 7 through 12 are from the shopping category
                tmap.put(7, "Bring your own bags!");
                tmap.put(8, "Before making a purchase, consider whether you really need it!");
                tmap.put(9, "Buy local or organic produce! Farmer's markets are great!");
                tmap.put(10, "Buy things with less packaging (especially avoid single use packaging)!");
                tmap.put(11, "Buy used products whenever possible!");
                tmap.put(12, "Eliminate impulse buying by not grocery shopping when you are hungry!");
                printMessage = tmap.get(randomInt);

                Shopping = false;
            }

            else if (Travel) {

                int randomInt = random.nextInt(6 + 1) + 13;

                //tips 13 through 18 are from the travel category
                tmap.put(13, "Turn off the heat and air conditioner before leaving home!");
                tmap.put(14, "Unplug electronics so that they do not consume excess energy!");
                tmap.put(15, "Take the bus or train instead of flying to reduce carbon emissions!");
                tmap.put(16, "Walk, bike, or take public transport!");
                tmap.put(17, "Carpool when possible!");
                tmap.put(18, "Bring a reusable water bottle!");
                printMessage = tmap.get(randomInt);

                Travel = false;
            }

            else if (DailyRoutine) {

                int randomInt = random.nextInt(6 + 1) + 19;

                //tips 19 through 24 are from the routines category
                tmap.put(19, "Turn off the water when brushing your teeth!");
                tmap.put(20, "Unplug electronics so that they do not consume excess energy!");
                tmap.put(21, "Get a water-saving showerhead!");
                tmap.put(22, "Hand wash your clothes if you only have a few items to clean!");
                tmap.put(23, "Start timing your showers! Aim to keep your showers under 5 minutes!");
                tmap.put(24, "Use LED lighting or CFL bulbs instead of incandescent lighting!");
                printMessage = tmap.get(randomInt);

                DailyRoutine = false;
            }
        }
    }

    public void sendOnChannel1(View v) {
        String title = "Shopping: ";
        String message = "Buy used products whenever possible!";

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_spa)
                .setContentTitle(title)
                .setContentText(message)
                .build();

        notificationManager.notify(1, notification);
    }
}

