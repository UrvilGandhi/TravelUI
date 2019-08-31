package com.example.sunshinetravel.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.sunshinetravel.PlacesListActivity;
import com.example.sunshinetravel.R;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);

        ConstraintLayout constCanada,constItaly,constPrague,constUsa;

        constCanada = findViewById(R.id.canada_constraint);
        constItaly = findViewById(R.id.italy_constraint);
        constPrague = findViewById(R.id.prague_constraint);
        constUsa = findViewById(R.id.usa_constraint);

        constCanada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, PlacesListActivity.class));
            }
        });

        constItaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, PlacesListActivity.class));
            }
        });

        constPrague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, PlacesListActivity.class));
            }
        });

        constUsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, PlacesListActivity.class));
            }
        });
    }
}
