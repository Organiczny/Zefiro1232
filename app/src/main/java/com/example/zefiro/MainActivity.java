package com.example.zefiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "KS:MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        Log.i(TAG, "START");

        startActivity(new Intent(MainActivity.this, Login.class));

    }
}
