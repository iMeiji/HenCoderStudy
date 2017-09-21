package com.meiji.hencoderstudy;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showFragment(getString(R.string.practice01), MainFragment.newInstance(R.id.practice01));
        navigationView.setCheckedItem(R.id.practice01);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.practice01) {
            showFragment(getString(R.string.practice01), MainFragment.newInstance(R.id.practice01));

        } else if (id == R.id.practice02) {
            showFragment(getString(R.string.practice02), MainFragment.newInstance(R.id.practice02));

        } else if (id == R.id.practice03) {
            showFragment(getString(R.string.practice03), MainFragment.newInstance(R.id.practice03));

        } else if (id == R.id.practice04) {
            showFragment(getString(R.string.practice04), MainFragment.newInstance(R.id.practice04));

        } else if (id == R.id.practice05) {
            showFragment(getString(R.string.practice05), MainFragment.newInstance(R.id.practice05));
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(String title, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
        toolbar.setTitle(title);
    }
}
