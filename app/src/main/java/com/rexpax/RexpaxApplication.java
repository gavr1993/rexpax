package com.rexpax;

import android.app.Application;

/**
 * Created by Anton on 30.07.2015.
 */
public class RexpaxApplication extends Application {

    private static RexpaxApplication instance = null;

    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static RexpaxApplication getInstance() {
        return instance;
    }
}
