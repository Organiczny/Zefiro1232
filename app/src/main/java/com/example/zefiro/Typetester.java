package com.example.zefiro;

import android.util.Log;

class Typetester {
    private static final String TAG = "MyActivity";

    void printType(byte x) {
        Log.i(TAG, x + " is an byte");
    }
    void printType(int x) {
        Log.i(TAG,x + " is an int");
    }
    void printType(float x) {
        Log.i(TAG,x + " is an float");
    }
    void printType(double x) {
        Log.i(TAG,x + " is an double");
    }
    void printType(char x) {
        Log.i(TAG,x + " is an char");
    }
    void printType(String x) {
        Log.i(TAG,x + " is an char");
    }
}
