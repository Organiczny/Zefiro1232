package com.example.zefiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.zefiro.R.layout.ac_login;

public class Login extends AppCompatActivity {

    private static final String TAG = "KS:Login";

    EditText et_login, et_pass;

    String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ac_login);

        et_login = findViewById(R.id.et_login);
        et_pass = findViewById(R.id.et_pass);

        findViewById(R.id.but_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, et_login.getText().toString() + "<=>" + et_pass.getText().toString());
                new Connection().execute();

//                Intent intent = new Intent(Login.this, Home.class);
//                intent.putExtra("android", "va11fff");
//                startActivity(intent);
            }
        });



    }

    public class Connection extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void ... Void) {

            OkHttpClient client = new OkHttpClient();

            RequestBody formBody = new FormBody.Builder()
                    .add("id", et_login.getText().toString())
                    .add("password", et_pass.getText().toString())
//                    .add("email", "eve.holt@reqres.in")
//                    .add("password", "pistol")
                    .build();
            Request request = new Request.Builder()
                    .url("https://zefiro.pl/app/appdata.php")
//                    .url("https://reqres.in/api/register")
                    .post(formBody)
                    .build();

            Response response = null;
            try {
                response = client.newCall(request).execute();
                res = response.body().string();
                Log.i(TAG, '\"' + res + "\" CODE:" + response.code());

//                Typetester t = new Typetester();
//                t.printType(res);

                if(res.toCharArray()[0] =='1') {
                    Log.i(TAG, "Login succes");
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }else {
//                    Toast.makeText(getApplicationContext(), "text", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "Login failed");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    if(res.toCharArray()[0] !='1') Toast.makeText(getApplicationContext(), "Złe hasło", Toast.LENGTH_SHORT).show();
                }
            });

            return null;
        }


    }
}
