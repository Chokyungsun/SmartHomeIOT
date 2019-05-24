package com.example.android.bluetoothchat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

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
