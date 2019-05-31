package com.example.android.bluetoothchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BathActivity extends AppCompatActivity {
    ImageButton bt_light;
    ImageButton bt_valve;
    ImageButton bt_con;
    int light_check = 0;
    int valve_check = 0;
    int con_check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bath);


        bt_light = (ImageButton)findViewById(R.id.bt_light);
        bt_valve = (ImageButton)findViewById(R.id.bt_valve);
        bt_con = (ImageButton)findViewById(R.id.bt_con);

        bt_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭했을경우
                if(light_check == 0) {//CHECK_NUM 이0 일경우 setSelected를 true로 줘서 초록스위치가 나오게 한다
                    bt_light.setSelected(true);
                    light_check = 1; // 다음에 누르면 색이 변하도록 값을 변경.
                }
                else //CHECK_NUM 0이 아니면 setSelected를 false로 줘서 빨간 스위치가 나오게 한다.
                {
                    bt_light.setSelected(false);
                    light_check = 0; //다음에 누르면 색이 변하도록 값을 변경
                }
            }
        });

        bt_valve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭했을경우
                if(valve_check == 0) {//CHECK_NUM 이0 일경우 setSelected를 true로 줘서 초록스위치가 나오게 한다
                    bt_valve.setSelected(true);
                    valve_check = 1; // 다음에 누르면 색이 변하도록 값을 변경.
                }
                else //CHECK_NUM 0이 아니면 setSelected를 false로 줘서 빨간 스위치가 나오게 한다.
                {
                    bt_valve.setSelected(false);
                    valve_check = 0; //다음에 누르면 색이 변하도록 값을 변경
                }
            }
        });

        bt_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭했을경우
                if(con_check == 0) {//CHECK_NUM 이0 일경우 setSelected를 true로 줘서 초록스위치가 나오게 한다
                    bt_con.setSelected(true);
                    con_check = 1; // 다음에 누르면 색이 변하도록 값을 변경.
                }
                else //CHECK_NUM 0이 아니면 setSelected를 false로 줘서 빨간 스위치가 나오게 한다.
                {
                    bt_con.setSelected(false);
                    con_check = 0; //다음에 누르면 색이 변하도록 값을 변경
                }
            }
        });
    }
}
