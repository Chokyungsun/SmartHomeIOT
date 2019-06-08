package com.example.android.bluetoothchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class ModeActivity extends AppCompatActivity {

    //배열
    // cur_status

    // kitchen - 0,1 light/con
    // room - 3,4 light/con
    // bath - 6,7 light/con
    // living - 8~10 light/con/window
    // room - 11 window
    // kitchen - 12 valve

    // out_mode

    Switch  kit_light;
    Switch  kit_con;
    Switch  kit_valve;

    Switch room_light;
    Switch room_con;
    Switch room_win;

    Switch bath_light;
    Switch bath_con;

    Switch liv_light;
    Switch liv_con;
    Switch liv_win;

    //action bar
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private void tgl(Switch swt , int onoff){
        if(onoff == 0){
            swt.setChecked(false);
        }else if(onoff == 1){
            swt.setChecked(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        //switch //tgl(,MapActivity.out_mode[]);
        kit_light = (Switch)findViewById(R.id.kit_light_switch);
        tgl(kit_light,MapActivity.out_mode[0]);
        kit_con = (Switch)findViewById(R.id.kit_con_switch);
        tgl(kit_con,MapActivity.out_mode[1]);
        kit_valve = (Switch)findViewById(R.id.kit_valve_switch);
        tgl(kit_valve,MapActivity.out_mode[12]);

        room_light = (Switch)findViewById(R.id.room_ligth_switch);
        tgl(room_light,MapActivity.out_mode[3]);
        room_con  = (Switch)findViewById(R.id.room_con_switch);
        tgl(room_con,MapActivity.out_mode[4]);
        room_win = (Switch)findViewById(R.id.room_win_switch);
        tgl(room_win,MapActivity.out_mode[11]);

        bath_light = (Switch)findViewById(R.id.bath_light_switch);
        tgl(bath_light,MapActivity.out_mode[6]);
        bath_con = (Switch)findViewById(R.id.bath_con_switch);
        tgl(bath_con,MapActivity.out_mode[7]);

        liv_light = (Switch)findViewById(R.id.liv_light_switch);
        tgl(liv_light,MapActivity.out_mode[8]);
        liv_con = (Switch)findViewById(R.id.liv_con_switch);
        tgl(liv_con,MapActivity.out_mode[9]);
        liv_win = (Switch)findViewById(R.id.liv_win_switch);
        tgl(liv_win,MapActivity.out_mode[10]);
        //finish setting

        //switch listener 설정
        //스위치의 체크 이벤트를 위한 리스너 등록
        kit_light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {//on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[0] = 1;
                } else {//off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[0] = 0;
                } }});

        kit_con.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) { // on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[1] = 1;
                } else { //off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[1] = 0;
                } }});

        kit_valve.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {//on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[12] = 1;
                } else {//off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[12] = 0;
                } }});

        room_light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {//on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[3] = 1;
                } else {//off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[3] = 0;
                } }});

        room_con.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {//on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[4] = 1;
                } else {//off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[4] = 0;
                } }});

        room_win.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {//on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[11] = 1;
                } else {//off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[11] = 0;
                } }});

        bath_light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {//on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[6] = 1;
                } else {//off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[6] = 0;
                } }});

        bath_con.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {//on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[7] = 1;
                } else {//off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[7] = 0;
                } }});

        liv_light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {//on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[8] = 1;
                } else {//off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[8] = 0;
                } }});

        liv_con.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {//on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[9] = 1;
                } else {//off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[9] = 0;
                } }});

        liv_win.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {//on
                    Log.e("On","OnOnOn");
                    MapActivity.out_mode[10] = 1;
                } else {//off
                    Log.e("Off","OffOffOff");
                    MapActivity.out_mode[10] = 0;
                } }});


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
