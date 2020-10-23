package com.example.zefiro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class Details extends AppCompatActivity {

    private static final String TAG = "KS:Details";
    TextView tv;

    private static HashMap<Button, Integer> buttonList1 = new HashMap<>();
    private static HashMap<Button, Integer> buttonList2 = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_details);

         final Button but_temp = findViewById(R.id.id_but_scroll_temp);
         final Button but_hum = findViewById(R.id.id_but_scroll_hum);
         final Button but_press = findViewById(R.id.id_but_scroll_press);
         final Button but_pm1 = findViewById(R.id.id_but_scroll_pm1);
         final Button but_pm25 = findViewById(R.id.id_but_scroll_pm25);
         final Button but_pm10 = findViewById(R.id.id_but_scroll_pm10);

         buttonList1.put(but_temp, 0);
         buttonList1.put(but_hum, 0);
         buttonList1.put(but_press, 0);
         buttonList1.put(but_pm1, 0);
         buttonList1.put(but_pm25, 0);
         buttonList1.put(but_pm10, 0);

         Button but_day = findViewById(R.id.id_but_scroll_day);
         Button but_week = findViewById(R.id.id_but_scroll_week);
         Button but_month = findViewById(R.id.id_but_scroll_month);
         Button but_half = findViewById(R.id.id_but_scroll_halfYear);
         Button but_year = findViewById(R.id.id_but_scroll_year);

         buttonList2.put(but_day, 0);
         buttonList2.put(but_week, 0);
         buttonList2.put(but_month, 0);
         buttonList2.put(but_half, 0);
         buttonList2.put(but_year, 0);

        tv = findViewById(R.id.id_tv);

        onClickButList(buttonList1);
        onClickButList(buttonList2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int id_targetButton = (int) getIntent().getSerializableExtra("type");
            findViewById(id_targetButton).performClick();
        }
        but_day.performClick();

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
                    tv.setText(getSelectedButton(buttonList1).getText() + " <=> " + getSelectedButton(buttonList2).getText());

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







}
