package com.example.prabhakarananbazhag.mlist.activities.activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.prabhakarananbazhag.mlist.R;
import com.example.prabhakarananbazhag.mlist.activities.Detail;
import com.example.prabhakarananbazhag.mlist.activities.fragments.NowPlayingFragment;
import com.example.prabhakarananbazhag.mlist.activities.fragments.UpcomingFragment;
import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView t1, t2;
    Detail detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        SharedPreferences set = getSharedPreferences(getString(R.string.MovieListFile), 0);
        Gson gson = new Gson();


        String json = set.getString(set.getString(getString(R.string.isLoggedUser), null), null);
        //    Log.i("json", json);
        Detail detail = gson.fromJson(json, Detail.class);

        View header = navigationView.getHeaderView(0);
        t1 = ((TextView) header.findViewById(R.id.headname));
        t2 = ((TextView) header.findViewById(R.id.headsubname));

        t1.setText(detail.name);
        t2.setText(detail.email);
        navigationView.setNavigationItemSelectedListener(this);
        showFragment(NowPlayingFragment.class);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Class fragment = null;
        if (id == R.id.nav_now_playing) {
            fragment = NowPlayingFragment.class;
            showFragment(fragment);
        } else if (id == R.id.nav_upcoming) {
            fragment = UpcomingFragment.class;
            showFragment(fragment);
        } else if (id == R.id.nav_logout) {
            SharedPreferences.Editor sharedPreferences = getSharedPreferences(getString(R.string.MovieListFile), 0).edit();
            sharedPreferences.clear();
            sharedPreferences.commit();
            finish();
            Intent k = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(k);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void updateNavigationViewHeader() {


    }

    private void showFragment(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flcontent, fragment).commit();
    }


}
