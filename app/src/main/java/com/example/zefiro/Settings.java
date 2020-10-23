package com.example.zefiro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Settings extends AppCompatActivity {
    int mDeafultColor;
    Button mButton;
    TextView tv;

    private static HashMap<Button, Integer> buttonList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_settings);

        mDeafultColor = ContextCompat.getColor(Settings.this, R.color.colorPrimary);
        mButton = findViewById(R.id.id_settings_pickColor);
        tv  = findViewById(R.id.id_settings_tv_type_light);

//        findViewById(R.id.id_setttings_location).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GPSTracker g = new GPSTracker(getApplicationContext());
//                Location l = g.getLocation();
//                if(l != null) {
//                    double lat = l.getLatitude();
//                    double lon = l.getLongitude();
//                    Toast.makeText(getApplicationContext(), "lat:" + lat + " lon: " + lon , Toast.LENGTH_LONG).show();
//                    tv.setText("lat:" + lat + " \nlon: " + lon );
//                }
//            }
//        });

        final Button but_1 = findViewById(R.id.id_settings_but_1);
        final Button but_2 = findViewById(R.id.id_settings_but_2);
        final Button but_3 = findViewById(R.id.id_settings_but_3);
        final Button but_4 = findViewById(R.id.id_settings_but_4);
        final Button but_5 = findViewById(R.id.id_settings_but_5);
        final Button but_6 = findViewById(R.id.id_settings_but_6);

        buttonList.put(but_1, 0);
        buttonList.put(but_2, 0);
        buttonList.put(but_3, 0);
        buttonList.put(but_4, 0);
        buttonList.put(but_5, 0);
        buttonList.put(but_6, 0);

        onClickButList(buttonList);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });
    }

    public void onClickButList(final HashMap<Button, Integer> buttonList){
        for(final Button but : buttonList.keySet()) {
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(Button but : buttonList.keySet()){
                        buttonList.replace(but, 0);
                        but.setBackgroundResource(R.color.but_scroll_bg);
                    }
                    buttonList.replace(but, 1);
                    but.setBackgroundResource(R.color.but_scroll_bg_pressed);

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

    public void openColorPicker() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDeafultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDeafultColor = color;
                mButton.setBackgroundColor(color);
            }
        });
        colorPicker.show();
    }
}
