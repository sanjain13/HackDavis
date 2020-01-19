package com.example.hackdavisscheduler;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment  implements TimePickerDialog.OnTimeSetListener{

    public interface TimePickerListener{
        void onTimeSet(TimePicker timePicker, int hour, int minute);
    }

    TimePickerListener nListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            nListener = (TimePickerListener) context;
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString()+" must implements TimePickerListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getContext()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        nListener.onTimeSet(timePicker,i,i1);
    }
}


/*
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePicking extends AppCompatActivity implements TimePickerFragment.TimePickerListener {

    private TextView tvDisplayTime1;

    int h1;
    int m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

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
}
*/