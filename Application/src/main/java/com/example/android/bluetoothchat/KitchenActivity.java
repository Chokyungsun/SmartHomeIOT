package com.example.android.bluetoothchat;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class KitchenActivity extends AppCompatActivity {
    ImageButton bt_light;
    ImageButton bt_valve;
    ImageButton bt_con;
    int light_check = 0;
    int valve_check = 0;
    int con_check = 0;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        bt_light = (ImageButton) findViewById(R.id.bt_light);
        bt_valve = (ImageButton) findViewById(R.id.bt_valve);
        bt_con = (ImageButton) findViewById(R.id.bt_con);

        bt_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭했을경우
                if (light_check == 0) {//CHECK_NUM 이0 일경우 setSelected를 true로 줘서 초록스위치가 나오게 한다
                    bt_light.setSelected(true);
                    light_check = 1; // 다음에 누르면 색이 변하도록 값을 변경.
                } else //CHECK_NUM 0이 아니면 setSelected를 false로 줘서 빨간 스위치가 나오게 한다.
                {
                    bt_light.setSelected(false);
                    light_check = 0; //다음에 누르면 색이 변하도록 값을 변경
                }
            }
        });

        bt_valve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭했을경우
                if (valve_check == 0) {//CHECK_NUM 이0 일경우 setSelected를 true로 줘서 초록스위치가 나오게 한다
                    bt_valve.setSelected(true);
                    valve_check = 1; // 다음에 누르면 색이 변하도록 값을 변경.
                } else //CHECK_NUM 0이 아니면 setSelected를 false로 줘서 빨간 스위치가 나오게 한다.
                {
                    bt_valve.setSelected(false);
                    valve_check = 0; //다음에 누르면 색이 변하도록 값을 변경
                }
            }
        });

        bt_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭했을경우
                if (con_check == 0) {//CHECK_NUM 이0 일경우 setSelected를 true로 줘서 초록스위치가 나오게 한다
                    bt_con.setSelected(true);
                    con_check = 1; // 다음에 누르면 색이 변하도록 값을 변경.
                } else //CHECK_NUM 0이 아니면 setSelected를 false로 줘서 빨간 스위치가 나오게 한다.
                {
                    bt_con.setSelected(false);
                    con_check = 0; //다음에 누르면 색이 변하도록 값을 변경
                }
            }
        });

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
                        Toast.makeText(KitchenActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), ModeActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.map_bar:
                        Toast.makeText(KitchenActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), MapActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.living_bar:
                        Toast.makeText(KitchenActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), LivingActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.kitchen_bar:
                        Toast.makeText(KitchenActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), KitchenActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.bath_bar:
                        Toast.makeText(KitchenActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), BathActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.room_bar:
                        Toast.makeText(KitchenActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), RoomActivity.class);
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





