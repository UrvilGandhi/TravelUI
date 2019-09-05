package com.example.sunshinetravel.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunshinetravel.Adapter.CustomExpandableListAdapter;
import com.example.sunshinetravel.Adapter.CustomListAdapter;
import com.example.sunshinetravel.Model.DataModel;
import com.example.sunshinetravel.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private Toolbar toolbar;
    private RecyclerView listView;
    private TextView tv_title;
    private List<DataModel> dataList = new ArrayList<>();
    private ConstraintLayout constCanada, constItaly, constPrague, constUsa;
    private boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        tv_title = toolbar.findViewById(R.id.tv_title);
        NavigationView navigationView = findViewById(R.id.nav_view);
        listView = navigationView.findViewById(R.id.listView);

        // Toolbar :: Transparent
        toolbar.setBackgroundColor(Color.TRANSPARENT);

        setSupportActionBar(toolbar);
        tv_title.setText("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setHomeAsUpIndicator(R.drawable.menu);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.setNavigationIcon(R.drawable.menu);
        setSupportActionBar(toolbar);


        Objects.requireNonNull(toolbar).setNavigationOnClickListener(v -> {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        // Status bar :: Transparent
        Window window = this.getWindow();

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.TRANSPARENT);

        constCanada = findViewById(R.id.canada_constraint);
        constItaly = findViewById(R.id.italy_constraint);
        constPrague = findViewById(R.id.prague_constraint);
        constUsa = findViewById(R.id.usa_constraint);

        constCanada.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), PlacesListActivity.class)));
        constItaly.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), PlacesListActivity.class)));
        constPrague.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), PlacesListActivity.class)));
        constUsa.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), PlacesListActivity.class)));

        dataList.add(new DataModel(R.drawable.home, "Home"));
        dataList.add(new DataModel(R.drawable.location, "Location"));
        dataList.add(new DataModel(R.drawable.favourites, "Favourites"));
        dataList.add(new DataModel(R.drawable.wishlist, "WishList"));
        dataList.add(new DataModel(R.drawable.profile, "Profile"));
        dataList.add(new DataModel(R.drawable.settings, "Settings"));

        listView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        CustomListAdapter listAdapter = new CustomListAdapter(this, dataList,isClicked);
        listView.setAdapter(listAdapter);

        SharedPreferences preferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        isClicked = preferences.getBoolean("isClicked",false);
        if (isClicked){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            drawer.closeDrawer(GravityCompat.START);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        Log.e(TAG, "onNavigationItemSelected: " + item);
        return true;
    }
}
