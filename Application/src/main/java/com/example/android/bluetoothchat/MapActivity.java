package com.example.android.bluetoothchat;

import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MapActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

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
                    case R.id.navigation_item_wordbook:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        break;

                    case R.id.navigation_item_camera:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        break;

                    case R.id.navigation_item_write:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        break;

                    case R.id.navigation_item_settings:
                        Toast.makeText(MapActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
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

        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick1(View v){
        Intent intent = new Intent(getApplicationContext(), LivingActivity.class);
        startActivity(intent);
    }

    public void onClick2(View v){
        Intent intent = new Intent(getApplicationContext(), BathActivity.class);
        startActivity(intent);
    }

    public void onClick3(View v){
        Intent intent = new Intent(getApplicationContext(), RoomActivity.class);
        startActivity(intent);
    }

    public void onClick4(View v){
        Intent intent = new Intent(getApplicationContext(), KitchenActivity.class);
        startActivity(intent);
    }

    public void open(View v){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder((this));
        alertDialogBuilder.setMessage("움직임이 감지되었습니다."+'\n'+"신고하시겠습니까?");
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
