package com.example.zefiro;

import android.util.Log;

class Typetester {
    private static final String TAG = "MyActivity";

    void printType(byte x) {
        Log.i(TAG, x + " is an byte KS:");
    }
    void printType(int x) {
        Log.i(TAG,x + " is an int KS:");
    }
    void printType(float x) {
        Log.i(TAG,x + " is an float KS:");
    }
    void printType(double x) {
        Log.i(TAG,x + " is an double KS:");
    }
    void printType(char x) {
        Log.i(TAG,x + " is an char KS:");
    }
    void printType(String x) {
        Log.i(TAG,x + " is an char KS:");
    }
}
