package com.example.hackdavisscheduler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.TreeMap;

import static com.example.hackdavisscheduler.Notification.CHANNEL_1_ID;

public class TimePicking extends AppCompatActivity implements TimePickerFragment.TimePickerListener {

    public NotificationManagerCompat notificationManager;

    private TextView tvDisplayTime1;

    int h1;
    int m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        notificationManager = NotificationManagerCompat.from(this);

        tvDisplayTime1 = findViewById(R.id.tvDisplayTime1);

        Button btnShowTimePicker1 = findViewById(R.id.btnShowTimePicker1);
        btnShowTimePicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                DialogFragment timePickerFragment1 = new TimePickerFragment();
                timePickerFragment1.setCancelable(true);
                timePickerFragment1.show(getSupportFragmentManager(),"timePicker1");
            }
        });
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        h1 = hour;
        m1 = minute;
        if(h1 < 10 && m1 < 10) {
            tvDisplayTime1.setText("0" + h1 + ":0" + m1);
        }
        else if(m1 < 10) {
            tvDisplayTime1.setText(h1 + ":0" + m1);
        }
        else if(h1 < 10) {
            tvDisplayTime1.setText("0" + h1 + ":" + m1);
        }
        else
            tvDisplayTime1.setText(h1 + ":" + m1);
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
