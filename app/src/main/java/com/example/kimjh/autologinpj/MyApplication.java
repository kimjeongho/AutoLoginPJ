package com.example.kimjh.autologinpj;

import android.app.Application;
import android.content.Context;

/**
 * Created by kimjh on 2016-02-12.
 */
public class MyApplication extends Application {
    private static Context content;

    @Override
    public void onCreate() {
        super.onCreate();
        content = this;
    }

    public static Context getContent(){
        return content;
    }
}
