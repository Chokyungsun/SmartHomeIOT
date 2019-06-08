package com.example.android.bluetoothchat;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;

import java.util.ArrayList;

public class TimerActivity extends AppCompatActivity {
    private Spinner spinner;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    //action bar
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    //배열
    // cur_status
    // kitchen - 0,1 light/con
    // room - 3,4 light/con
    // bath - 6,7 light/con
    // living - 8~10 light/con/window
    // room - 11 window
    // kitchen - 12 valve


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

        //action bar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();

                int id = item.getItemId();
                // 각 메뉴 클릭시 이뤄지는 이벤트
                switch (id){
                    case R.id.mode_bar:
                        Intent intent = new Intent(getApplicationContext(), ModeActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.map_bar:
                        intent = new Intent(getApplicationContext(), MapActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.living_bar:
                        intent = new Intent(getApplicationContext(), LivingActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.kitchen_bar:
                        intent = new Intent(getApplicationContext(), KitchenActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.bath_bar:
                        intent = new Intent(getApplicationContext(), BathActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.room_bar:
                        intent = new Intent(getApplicationContext(), RoomActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.timer_bar:
                        intent = new Intent(getApplicationContext(), TimerActivity.class);
                        startActivity(intent);
                        break;
                }

                return true;
            }
        });
        Log.e("Frag", "Fragment");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

}
