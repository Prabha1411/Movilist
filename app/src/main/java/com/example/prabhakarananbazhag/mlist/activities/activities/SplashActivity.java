package com.example.prabhakarananbazhag.mlist.activities.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.prabhakarananbazhag.mlist.R;
import com.example.prabhakarananbazhag.mlist.activities.Detail;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

import java.util.Arrays;

public class SplashActivity extends AppCompatActivity {

    ShortcutManager shortcutManager;
    ShortcutInfo shortcutInfo1;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent k;
        final  SharedPreferences sharedPreferences=getSharedPreferences(getString(R.string.MovieListFile),0);
        if(sharedPreferences.contains(getString(R.string.isLoggedIn))) {
            if ((sharedPreferences.getBoolean(getString(R.string.isLoggedIn), false))) {
                k = new Intent(SplashActivity.this, MainActivity.class);
            } else {
                k = new Intent(SplashActivity.this, LoginActivity.class);
            }
        }else {
            k=new Intent(SplashActivity.this,LoginActivity.class);
        }

            k.setAction(Intent.ACTION_VIEW);
            shortcutManager=getSystemService(ShortcutManager.class);
            shortcutInfo1=new ShortcutInfo.Builder(SplashActivity.this,"id2").setShortLabel("Main Page").setLongLabel("Move to Main page")
                    .setIntent(k).build();
            shortcutManager.setDynamicShortcuts(Arrays.asList(shortcutInfo1));


            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (sharedPreferences.contains(getString(R.string.isLoggedIn))) {
                        if (sharedPreferences.getBoolean(getString(R.string.isLoggedIn), false)) {


                            Intent o = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(o);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Intent p = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(p);
                        finish();
                    }
                }
            }, 3000);



    }
}
