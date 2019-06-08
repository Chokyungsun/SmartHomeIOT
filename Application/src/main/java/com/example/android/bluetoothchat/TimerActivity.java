package com.example.android.bluetoothchat;

import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class TimerActivity extends AppCompatActivity {
    private Spinner spinner;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    //action bar
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private NumberPicker numpick_min1;
    private NumberPicker numpick_min2;
    private NumberPicker numpick_sec1;
    private NumberPicker numpick_sec2;

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


        numpick_min1 = findViewById(R.id.min1);
        numpick_min2 = findViewById(R.id.min2);
        numpick_sec1 = findViewById(R.id.sec1);
        numpick_sec2 = findViewById(R.id.sec2);

        numpick_min1.setMinValue(0);
        numpick_min1.setMaxValue(5);

        numpick_min2.setMinValue(0);
        numpick_min2.setMaxValue(9);

        numpick_sec1.setMinValue(0);
        numpick_sec1.setMaxValue(5);

        numpick_sec2.setMinValue(0);
        numpick_sec2.setMaxValue(9);


        arrayList = new ArrayList<>();
        arrayList.add("주방: 조명");
        arrayList.add("주방: 가스밸브");
        arrayList.add("주방: 콘센트");
        arrayList.add("침실: 조명");
        arrayList.add("침실: 창문");
        arrayList.add("침실: 콘센트");
        arrayList.add("거실: 조명");
        arrayList.add("거실: 창문");
        arrayList.add("거실: 콘센트");
        arrayList.add("화장실: 조명");
        arrayList.add("화장실: 콘센트");

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

                    case R.id.police_bar:
                        intent = new Intent(getApplicationContext(), PoliceActivity.class);
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

    private class myThread extends Thread {
        private int tt = 0;
        private String strr = "";
        public myThread(int t, String str) {
            tt = t;
            strr = "" + str;
        }
        public void run() {
            try{
                Thread.sleep(tt); // 1초
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            if(strr.equals("주방: 조명")){

            }
            else if(strr.equals("주방: 가스밸브")){

            }
            else if(strr.equals("주방: 콘센트")){

            }
            else if(strr.equals("침실: 조명")){

            }
            else if(strr.equals("침실: 창문")){

            }
            else if(strr.equals("침실: 콘센트")){

            }
            else if(strr.equals("거실: 조명")){

            }
            else if(strr.equals("거실: 창문")){

            }
            else if(strr.equals("거실: 콘센트")){

            }
            else if(strr.equals("화장실: 조명")){

            }
            else if(strr.equals("화장실: 콘센트")){

            }
        }
    }

    public void activate(View w){
        String specific_sensor = spinner.getSelectedItem().toString();
        int min1 = numpick_min1.getValue(); // 십의자리
        int min2 = numpick_min2.getValue(); // 일의자리
        int sec1 = numpick_sec1.getValue(); // 십의자리
        int sec2 = numpick_sec2.getValue(); // 일의자리
        Toast.makeText(this ,specific_sensor+"이(가) "+min1+min2+"분 "+sec1+sec2+"초 뒤에 제어 됩니다.", Toast.LENGTH_SHORT).show();
        int res = 1000*(sec2+10*sec1+60*min2+600*min1);
        myThread mythread = new myThread(res, specific_sensor);
        mythread.start();
    }

}
