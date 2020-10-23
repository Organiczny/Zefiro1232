package com.example.zefiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Home extends AppCompatActivity {

    private static final String TAG = "KS:Home";
    private long backPressTime;
    private Toast backToast;

    private static HashMap<Button, Integer> buttonList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Intent intent = getIntent();
        String str = intent.getStringExtra("android");

//        TextView tv = findViewById(R.id.textView);
//        tv.setText(str);
        findViewById(R.id.but_home_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Settings.class);
//                intent.putExtra("android", "va11fff");
                startActivity(intent);
            }
        });

        Button but_home_pm1 = findViewById(R.id.id_but_home_pm1);
        Button but_home_pm1_v = findViewById(R.id.id_but_home_pm1_v);
        Button but_home_pm25 = findViewById(R.id.id_but_home_pm25);
        Button but_home_pm25_v = findViewById(R.id.id_but_home_pm25_v);
        Button but_home_pm10 = findViewById(R.id.id_but_home_pm10);
        Button but_home_pm10_v = findViewById(R.id.id_but_home_pm10_v);

        Button but_home_temp = findViewById(R.id.id_but_home_temp);
        Button but_home_temp_v = findViewById(R.id.id_but_home_temp_v);
        Button but_home_hum = findViewById(R.id.id_but_home_hum);
        Button but_home_hum_v = findViewById(R.id.id_but_home_hum_v);
        Button but_home_press = findViewById(R.id.id_but_home_press);
        Button but_home_press_v = findViewById(R.id.id_but_home_press_v);

        buttonList.put(but_home_pm1, R.id.id_but_scroll_pm1);
        buttonList.put(but_home_pm1_v, R.id.id_but_scroll_pm1);
        buttonList.put(but_home_pm25, R.id.id_but_scroll_pm25);
        buttonList.put(but_home_pm25_v, R.id.id_but_scroll_pm25);
        buttonList.put(but_home_pm10, R.id.id_but_scroll_pm10);
        buttonList.put(but_home_pm10_v, R.id.id_but_scroll_pm10);

        buttonList.put(but_home_temp, R.id.id_but_scroll_temp);
        buttonList.put(but_home_temp_v, R.id.id_but_scroll_temp);
        buttonList.put(but_home_hum, R.id.id_but_scroll_hum);
        buttonList.put(but_home_hum_v, R.id.id_but_scroll_hum);
        buttonList.put(but_home_press, R.id.id_but_scroll_press);
        buttonList.put(but_home_press_v, R.id.id_but_scroll_press);

        onClickButList(buttonList);

    }


    public void onClickButList(final HashMap<Button, Integer> buttonList){
        for(final Button but : buttonList.keySet()) {
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this, Details.class);
                    intent.putExtra("type", buttonList.get(but));
                    startActivity(intent);
                }
            });
        }
    }

    public Button getSelectedButton(HashMap<Button, Integer> buttonList) {
        Button returned = (Button)buttonList.keySet().toArray()[0];
        for(Button but : buttonList.keySet()) {
            if(buttonList.get(but) == 1) returned = but;
        }
        return returned;
    }





    @Override
    public void onBackPressed(){
        Log.i(TAG, "press back");
        if(backPressTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            moveTaskToBack(true);
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Naciśnij przycisk jeszcze raz", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressTime = System.currentTimeMillis();
    }

}
