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
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class LivingActivity extends AppCompatActivity {
    ImageButton bt_light;
    ImageButton bt_window;
    ImageButton bt_con;
    ImageView imgv;

    //배열
    // cur_status
    // kitchen - 0,1 light/con
    // room - 3,4 light/con
    // bath - 6,7 light/con
    // living - 8~10 light/con/window
    // room - 11 window
    // kitchen - 12 valve

    //action bar
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living);

        imgv = (ImageView) findViewById(R.id.mode_img);
        if(MapActivity.mode == 0)
            imgv.setImageResource(R.drawable.in_mode);
        else  if(MapActivity.mode == 1)
            imgv.setImageResource(R.drawable.out_mode);

        bt_light = (ImageButton)findViewById(R.id.bt_light);
        bt_window = (ImageButton)findViewById(R.id.bt_win);
        bt_con = (ImageButton)findViewById(R.id.bt_con);

        if(MapActivity.cur_status[8] == 1) {
            bt_light.setSelected(true);
            bt_light.setPressed(true);
        }
        if(MapActivity.cur_status[9] == 1) {
            bt_con.setSelected(true);
            bt_con.setPressed(true);
        }
        if(MapActivity.cur_status[10] == 1) {
            bt_window.setSelected(true);
            bt_window.setPressed(true);
        }

        bt_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MapActivity.cur_status[8] == 0) {
                    bt_light.setSelected(true);
                    MainActivity.fragment.sendMessage("a");
                    MapActivity.cur_status[8] = 1;
                }
                else
                {
                    bt_light.setSelected(false);
                    MainActivity.fragment.sendMessage("b");
                    MapActivity.cur_status[8] = 0;
                }
            }
        });

        bt_window.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭했을경우
                if(MapActivity.cur_status[10] == 0) {
                    bt_window.setSelected(true);
                    MainActivity.fragment.sendMessage("q");
                    MapActivity.cur_status[10] = 1;
                }
                else
                {
                    bt_window.setSelected(false);
                    MainActivity.fragment.sendMessage("r");
                    MapActivity.cur_status[10] = 0;
                }
            }
        });

        bt_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭했을경우
                if(MapActivity.cur_status[9] == 0) {
                    bt_con.setSelected(true);
                    MainActivity.fragment.sendMessage("i");
                    MapActivity.cur_status[9] = 1;
                }
                else
                {
                    bt_con.setSelected(false);
                    MainActivity.fragment.sendMessage("j");
                    MapActivity.cur_status[9] = 0;
                }
            }
        });


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
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
        startActivity(intent);
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
