package com.example.android.bluetoothchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;

import java.util.ArrayList;

public class TimerActivity extends AppCompatActivity {
    private Spinner spinner;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);



        NumberPicker numpick_min1 = findViewById(R.id.min1);
        NumberPicker numpick_min2 = findViewById(R.id.min2);
        NumberPicker numpick_sec1 = findViewById(R.id.sec1);
        NumberPicker numpick_sec2 = findViewById(R.id.sec2);

        numpick_min1.setMinValue(0);
        numpick_min1.setMaxValue(5);

        numpick_min2.setMinValue(0);
        numpick_min2.setMaxValue(9);

        numpick_sec1.setMinValue(0);
        numpick_sec1.setMaxValue(5);

        numpick_sec2.setMinValue(0);
        numpick_sec2.setMaxValue(9);


        arrayList = new ArrayList<>();
        arrayList.add("조명");
        arrayList.add("가스");
        arrayList.add("창문");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);




    }

}
