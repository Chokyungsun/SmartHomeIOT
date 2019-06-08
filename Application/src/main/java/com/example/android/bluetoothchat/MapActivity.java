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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class MapActivity extends AppCompatActivity implements View.OnClickListener {

    private Animation fab_open, fab_close;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    //배열
    static int[] cur_status = new int[13];
    // kitchen - 0,1 light/con
    // room - 3,4 light/con
    // bath - 6,7 light/con
    // living - 8~10 light/con/window
    // room - 11 window
    // kitchen - 12 valve
    // 2,5 - 사용 x

    static int[] in_mode = new int[13];
    static int[] out_mode = new int[13];
    //mode
    static int mode;

    // image view
    ImageView imgv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        imgv =  (ImageView) findViewById(R.id.mode_img);
        if(MapActivity.mode == 0)
            imgv.setImageResource(R.drawable.in_mode);
        else  if(MapActivity.mode == 1)
            imgv.setImageResource(R.drawable.out_mode);

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

//        TextView idv = navigationView.getHeaderView(0).findViewById(R.id.textView2);
//        Intent i2 = getIntent();
//        String email = i2.getExtras().getString("id'");
//        idv.setText("aa");


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
                imgv.setImageResource(R.drawable.in_mode);
                mode = 0;
                Toast.makeText(this, "실내 모드가 적용되었습니다.",Toast.LENGTH_SHORT).show();
                Log.e("inside","in mode");
                in_set(13);
                //setting in mode
                break;
            case R.id.fab_outside:
                anim();
                mode = 1;
                imgv.setImageResource(R.drawable.out_mode);
                Toast.makeText(this, "외출 모드가 적용되었습니다.",Toast.LENGTH_SHORT).show();
                Log.e("outside","out mode");
                for(int i =  0  ; i <  13 ;  i++) {
                    in_mode[i] = cur_status[i];
                }
                cmpArr(13);
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
    // map button onclick methods
    public void goLiv(View v) {
        Intent intent = new Intent(getApplicationContext(), LivingActivity.class);
        startActivity(intent);
    }

    public void goBath(View v) {
        Intent intent = new Intent(getApplicationContext(), BathActivity.class);
        startActivity(intent);
    }

    public void goRoom(View v){
        Intent intent = new Intent(getApplicationContext(), RoomActivity.class);
        startActivity(intent);
    }

    public void goKit(View v) {
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

    private void in_set(int len){
        for(int j = 0 ; j < len*10000 ; j++){
            if(j%10000 != 0) continue;
            int i =  j/10000;
            Log.e("in",""+in_mode[i]);
            Log.e("cur",""+cur_status[i]);
            Log.e("out",""+MapActivity.out_mode[i]);
            if(in_mode[i] != cur_status[i]) {
                if (in_mode[i] == 0) {
                    //off
                    cur_status[i] = 0;
                    switch (i) {
                        case 0:
                            MainActivity.fragment.sendMessage("h");
                            break;
                        case 1:
                            MainActivity.fragment.sendMessage("p");
                            break;
                        case 2:
                            break; //x
                        case 3:
                            MainActivity.fragment.sendMessage("d");
                            break;
                        case 4:
                            MainActivity.fragment.sendMessage("l");
                            break;
                        case 5:
                            break; //x
                        case 6:
                            MainActivity.fragment.sendMessage("f");
                            break;
                        case 7:
                            MainActivity.fragment.sendMessage("n");
                            break;
                        case 8:
                            MainActivity.fragment.sendMessage("b");
                            break;
                        case 9:
                            MainActivity.fragment.sendMessage("j");
                            break;
                        case 10:
                            MainActivity.fragment.sendMessage("r"); //거실 창
                            break;
                        case 11:
                            MainActivity.fragment.sendMessage("t"); //칭실 창
                            break;
                        case 12:
                            MainActivity.fragment.sendMessage("v"); //주방 가스밸브
                            break;

                    }
                } else if (in_mode[i] == 1) {
                    //on
                    cur_status[i] = 1;
                    switch (i) {
                        case 0:
                            MainActivity.fragment.sendMessage("g");
                            break;
                        case 1:
                            MainActivity.fragment.sendMessage("o");
                            break;
                        case 2:
                            break;
                        case 3:
                            MainActivity.fragment.sendMessage("c");
                            break;
                        case 4:
                            MainActivity.fragment.sendMessage("k");
                            break;
                        case 5:
                            break;
                        case 6:
                            MainActivity.fragment.sendMessage("e");
                            break;
                        case 7:
                            MainActivity.fragment.sendMessage("m");
                            break;
                        case 8:
                            MainActivity.fragment.sendMessage("a");
                            break;
                        case 9:
                            MainActivity.fragment.sendMessage("i");
                            break;
                        case 10:
                            MainActivity.fragment.sendMessage("q");
                            break;
                        case 11:
                            MainActivity.fragment.sendMessage("s");
                            break;
                        case 12:
                            MainActivity.fragment.sendMessage("w"); //주방 가스밸브
                            break;
                    }
                }
            }
        }
    }


    private void cmpArr(int len){
        for(int j = 0 ; j < len*10000 ; j++){
            if(j%10000 != 0) continue;
            int i = j/10000;
            Log.e(".",".");
            Log.e("out",""+out_mode[i]);
            Log.e("cur",""+cur_status[i]);
            Log.e("int",""+MapActivity.in_mode[i]);
            if(cur_status[i] != out_mode[i]){
                if(out_mode[i] == 0){
                    //off
                    cur_status[i] = 0;
                    switch(i){
                        case 0:
                            MainActivity.fragment.sendMessage("h");
                            break;
                        case 1:
                            MainActivity.fragment.sendMessage("p");
                            break;
                        case 2:
//                            MainActivity.fragment.sendMessage("");
                            break;
                        case 3:
                            MainActivity.fragment.sendMessage("d");
                            break;
                        case 4:
                            MainActivity.fragment.sendMessage("l");
                            break;
                        case 5:
                            break;
                        case 6:
                            MainActivity.fragment.sendMessage("f");
                            break;
                        case 7:
                            MainActivity.fragment.sendMessage("n");
                            break;
                        case 8:
                            MainActivity.fragment.sendMessage("b");
                            break;
                        case 9:
                            MainActivity.fragment.sendMessage("j");
                            break;
                        case 10:
                            MainActivity.fragment.sendMessage("r"); //거실 창
                            break;
                        case 11:
                            MainActivity.fragment.sendMessage("t"); //침실 창
                            break;
                        case 12:
                            MainActivity.fragment.sendMessage("v"); //주방 가스밸브
                            break;

                    }
                }
                else if(out_mode[i] == 1){
                    //on
                    cur_status[i] = 1;
                    switch(i){
                        case 0:
                            MainActivity.fragment.sendMessage("g");
                            break;
                        case 1:
                            MainActivity.fragment.sendMessage("o");
                            break;
                        case 2:
//                            MainActivity.fragment.sendMessage("");
                            break;
                        case 3:
                            MainActivity.fragment.sendMessage("c");
                            break;
                        case 4:
                            MainActivity.fragment.sendMessage("k");
                            break;
                        case 5:
                            break;
                        case 6:
                            MainActivity.fragment.sendMessage("e");
                            break;
                        case 7:
                            MainActivity.fragment.sendMessage("m");
                            break;
                        case 8:
                            MainActivity.fragment.sendMessage("a");
                            break;
                        case 9:
                            MainActivity.fragment.sendMessage("i");
                            break;
                        case 10:
                            MainActivity.fragment.sendMessage("q"); //거실 창
                            break;
                        case 11:
                            MainActivity.fragment.sendMessage("s"); //침실 창
                            break;
                        case 12:
                            MainActivity.fragment.sendMessage("w"); //주방 가스밸브
                            break;
                    }
                }
            }
        }
    }

    public void on(View v){
        for(int i = 0 ; i < 13 ; i++){
            Log.e("in",""+MapActivity.in_mode[i]);
        }
        Log.e("","--------------------------------");

        for(int i = 0 ; i < 13 ; i++){
            Log.e("out",""+MapActivity.out_mode[i]);
        }

        Log.e("","--------------------------------");
        for(int i = 0 ; i < 13 ; i++){
            Log.e("cur",""+MapActivity.cur_status[i]);
        }
    }

}
