package com.example.kimjh.autologinpj;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

public class SplashActivity extends AppCompatActivity {
    Handler mHandler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        String userid = PropertyManager.getInstance().getUserId();

        if(!TextUtils.isEmpty(userid)) {
            String password = PropertyManager.getInstance().getPassword();
            NetworkManager.getInstance().login(this, userid, password, new NetworkManager.OnResultListener<String>() {
                @Override
                public void onSuccess(String result) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }

                @Override
                public void onFailure(int code) {

                }
            });
        } else {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            },2000);
        }
    }
}
