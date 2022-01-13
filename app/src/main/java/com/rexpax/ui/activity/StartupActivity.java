package com.rexpax.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.rexpax.R;

public class StartupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        launchRegistrationActivity();
    }

    private void launchRegistrationActivity() {
        Intent intent = new Intent(this, LoginBaseActivity.class /*NavigationActivity.class*/);
        startActivity(intent);
        finish();
    }
}
