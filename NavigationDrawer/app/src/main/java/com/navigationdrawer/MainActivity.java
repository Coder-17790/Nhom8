package com.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;

import kotlin.OverloadResolutionByLambdaReturnType;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_Navigation,
                R.string.close_Navigation);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }



    @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
           switch (item.getItemId())
           {
               case R.id.nav_home:
                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                   break;
               case R.id.nav_settings:
                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SettingsFragment()).commit();
                   break;
               case R.id.nav_share:
                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ShareFragment()).commit();
                   break;
               case R.id.nav_about:
                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AboutFragment()).commit();
                   break;
               case R.id.nav_exit:
                   Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
                   break;
           }
           drawerLayout.closeDrawer(GravityCompat.START);
           return true;
        }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}