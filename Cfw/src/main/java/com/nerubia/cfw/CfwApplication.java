package com.nerubia.cfw;

import android.app.Application;
import android.content.Context;

/**
 * Created by meldy on 03/07/2015.
 */
public class CfwApplication extends Application {

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }

}