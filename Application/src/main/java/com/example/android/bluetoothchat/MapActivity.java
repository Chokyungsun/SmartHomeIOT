package com.example.android.bluetoothchat;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;



public class MapActivity extends AppCompatActivity implements View.OnClickListener {

    private Animation fab_open, fab_close;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private static final String TAG = "MapActivity";
    private Context context;
    //배열
    static int[] cur_status = new int[12];
    // kitchen - 0~2 light/con/valve
    // room - 3~5 light/con/window
    // bath - 6,7 light/con
    // living - 8~10 light/con/window


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        context = getApplicationContext();

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab_inside);
        fab2 = (FloatingActionButton) findViewById(R.id.fab_outside);

        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);

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
                switch (id) {
                    case R.id.mode_bar:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), ModeActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.map_bar:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), MapActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.living_bar:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), LivingActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.kitchen_bar:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), KitchenActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.bath_bar:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), BathActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.room_bar:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), RoomActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.timer_bar:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        intent = new Intent(getApplicationContext(), TimerActivity.class);
                        startActivity(intent);
                        break;
                }

                return true;
            }
        });
        Log.e("Frag", "Fragment");
    }
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fab:
                anim();
                break;
            case R.id.fab_inside:
                anim();
                setTitle("실내모드");
                break;
            case R.id.fab_outside:
                anim();
                setTitle("실외모드");
                break;
        }
    }

    public void anim() {

        if (isFabOpen) {
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
        } else {
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
        }
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

    public void onClick1(View v) {
        Intent intent = new Intent(getApplicationContext(), LivingActivity.class);
        startActivity(intent);
    }

    public void onClick2(View v) {
        Intent intent = new Intent(getApplicationContext(), BathActivity.class);
        startActivity(intent);
    }

    public void onClick3(View v) {
        Intent intent = new Intent(getApplicationContext(), RoomActivity.class);
        startActivity(intent);
    }

    public void onClick4(View v) {
        Intent intent = new Intent(getApplicationContext(), KitchenActivity.class);
        startActivity(intent);
    }

    public void open(View v) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder((this));
        alertDialogBuilder.setMessage("움직임이 감지되었습니다." + '\n' + "신고하시겠습니까?");
        alertDialogBuilder.setPositiveButton("네",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MapActivity.this, "신고 완료",
                                Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MapActivity.this, "취소",
                                Toast.LENGTH_LONG).show();
                    }

                });
        AlertDialog ad = alertDialogBuilder.create();
        ad.show();

    }


}
