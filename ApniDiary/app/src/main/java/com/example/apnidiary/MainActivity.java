package com.example.apnidiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar myToolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    BottomNavigationView bottom_nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.black));
        myToolbar.setSubtitle("Safar Khubsurat Hai Manzil Se Bhi");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //navigation view , drawerLayout
        bottom_nav = findViewById(R.id.bottom_navigation_view);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        openFragment(new HomeFragment());

        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.home_bottom) {
                   openFragment(new HomeFragment());
                }
                return true;
            }
        });
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d("Navigation", "Item selected: " + item.getItemId());
        if(item.getItemId()==R.id.profile){
            Toast.makeText(this, "about selected", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.about){
            Toast.makeText(this, "about selected", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.setting){
            Toast.makeText(getApplicationContext(), "setting selected", Toast.LENGTH_SHORT).show();
        }
         if(item.getItemId()==R.id.logout){
            Toast.makeText(getApplicationContext(), "logging out", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this, LoginPage.class);
            startActivity(i);
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }





    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.notification) {
            Toast.makeText(getApplicationContext(), "logout selected", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void openFragment(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,fragment);
        ft.commit();
    }
}

