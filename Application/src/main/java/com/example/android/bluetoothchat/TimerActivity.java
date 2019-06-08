package com.example.android.bluetoothchat;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
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

    private int min1, min2, sec1, sec2;
    private String specific_sensor;
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

//    private class myThread extends Thread {
//        private int tt = 0;
//        private String specific_sensor = "";
//        public myThread(int t, String str) {
//            tt = t;
//            specific_sensor = "" + str;
//        }
//        public void run() {
//            try{
//                Thread.sleep(tt); // 1초
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//
//
//        }
//    }

    public void activate(View w){
        specific_sensor = spinner.getSelectedItem().toString();
        min1 = numpick_min1.getValue(); // 십의자리
        min2 = numpick_min2.getValue(); // 일의자리
        sec1 = numpick_sec1.getValue(); // 십의자리
        sec2 = numpick_sec2.getValue(); // 일의자리

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder((this));
        alertDialogBuilder.setMessage(specific_sensor+"을(를) "+min1+min2+"분 "+sec1+sec2+"초 뒤에 제어하시겠습니까?");
        alertDialogBuilder.setPositiveButton("네",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TimerActivity.this ,specific_sensor+"이(가) "+min1+min2+"분 "+sec1+sec2+"초 뒤에 제어 됩니다.", Toast.LENGTH_SHORT).show();
                        int res = sec2+10*sec1+60*min2+600*min1;
                        if(specific_sensor.equals("주방: 조명")){
                            if(MapActivity.cur_status[0]==1){
                                MainActivity.fragment.sendMessage(res + ",h");
                                MapActivity.cur_status[0]=0;
                            }
                            else if(MapActivity.cur_status[0]==0){
                                MainActivity.fragment.sendMessage(res + ",g");
                                MapActivity.cur_status[0]=1;
                            }
                        }
                        else if(specific_sensor.equals("주방: 가스밸브")){
                            if(MapActivity.cur_status[12]==1){
                                MainActivity.fragment.sendMessage(res + ",w");
                                MapActivity.cur_status[12]=0;
                            }
                            else if(MapActivity.cur_status[12]==0){
                                MainActivity.fragment.sendMessage(res + ",v");
                                MapActivity.cur_status[12]=1;
                            }
                        }
                        else if(specific_sensor.equals("주방: 콘센트")){
                            if(MapActivity.cur_status[1]==1){
                                MainActivity.fragment.sendMessage(res + ",p");
                                MapActivity.cur_status[1]=0;
                            }
                            else if(MapActivity.cur_status[1]==0){
                                MainActivity.fragment.sendMessage(res + ",o");
                                MapActivity.cur_status[1]=1;
                            }
                        }
                        else if(specific_sensor.equals("침실: 조명")){
                            if(MapActivity.cur_status[3]==1){
                                MainActivity.fragment.sendMessage(res + ",d");
                                MapActivity.cur_status[3]=0;
                            }
                            else if(MapActivity.cur_status[3]==0){
                                MainActivity.fragment.sendMessage(res + ",c");
                                MapActivity.cur_status[3]=1;
                            }

                        }
                        else if(specific_sensor.equals("침실: 창문")){
                            if(MapActivity.cur_status[11]==1){
                                MainActivity.fragment.sendMessage(res + ",t");
                                MapActivity.cur_status[11]=0;
                            }
                            else if(MapActivity.cur_status[11]==0){
                                MainActivity.fragment.sendMessage(res + ",s");
                                MapActivity.cur_status[11]=1;
                            }

                        }
                        else if(specific_sensor.equals("침실: 콘센트")){
                            if(MapActivity.cur_status[4]==1){
                                MainActivity.fragment.sendMessage(res + ",l");
                                MapActivity.cur_status[4]=0;
                            }
                            else if(MapActivity.cur_status[4]==0){
                                MainActivity.fragment.sendMessage(res + ",k");
                                MapActivity.cur_status[4]=1;
                            }
                        }
                        else if(specific_sensor.equals("거실: 조명")){
                            if(MapActivity.cur_status[8]==1){
                                MainActivity.fragment.sendMessage(res + ",b");
                                MapActivity.cur_status[8]=0;
                            }
                            else if(MapActivity.cur_status[8]==0){
                                MainActivity.fragment.sendMessage(res + ",a");
                                MapActivity.cur_status[8]=1;
                            }
                        }
                        else if(specific_sensor.equals("거실: 창문")){
                            if(MapActivity.cur_status[10]==1){
                                MainActivity.fragment.sendMessage(res + ",r");
                                MapActivity.cur_status[10]=0;
                            }
                            else if(MapActivity.cur_status[10]==0){
                                MainActivity.fragment.sendMessage(res + ",q");
                                MapActivity.cur_status[10]=1;
                            }
                        }
                        else if(specific_sensor.equals("거실: 콘센트")){
                            if(MapActivity.cur_status[9]==1){
                                MainActivity.fragment.sendMessage(res + ",j");
                                MapActivity.cur_status[9]=0;
                            }
                            else if(MapActivity.cur_status[9]==0){
                                MainActivity.fragment.sendMessage(res + ",i");
                                MapActivity.cur_status[9]=1;
                            }
                        }
                        else if(specific_sensor.equals("화장실: 조명")){
                            if(MapActivity.cur_status[6]==1){
                                MainActivity.fragment.sendMessage(res + ",f");
                                MapActivity.cur_status[6]=0;
                            }
                            else if(MapActivity.cur_status[6]==0){
                                MainActivity.fragment.sendMessage(res + ",e");
                                MapActivity.cur_status[6]=1;
                            }
                        }
                        else if(specific_sensor.equals("화장실: 콘센트")){
                            if(MapActivity.cur_status[7]==1){
                                MainActivity.fragment.sendMessage(res + ",n");
                                MapActivity.cur_status[7]=0;
                            }
                            else if(MapActivity.cur_status[7]==0){
                                MainActivity.fragment.sendMessage(res + ",m");
                                MapActivity.cur_status[7]=1;
                            }
                        }

                    }
                });

        alertDialogBuilder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TimerActivity.this, "취소",
                                Toast.LENGTH_LONG).show();
                    }

                });
        AlertDialog ad = alertDialogBuilder.create();
        ad.show();
    }

}
