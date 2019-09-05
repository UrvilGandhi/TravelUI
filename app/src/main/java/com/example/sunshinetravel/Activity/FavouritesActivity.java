package com.example.sunshinetravel.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunshinetravel.Adapter.FavouriteAdapter;
import com.example.sunshinetravel.R;

import java.util.Objects;

public class FavouritesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tv_title;
    private RecyclerView rcvFavourites;
    private int[] arrays = {1, 2, 3, 4, 5, 6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_favourites);

        toolbar = findViewById(R.id.toolbar);
        tv_title = toolbar.findViewById(R.id.tv_title);
        rcvFavourites = findViewById(R.id.rcvFavourites);

        setSupportActionBar(toolbar);
        tv_title.setText("Favourites");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(toolbar).setNavigationOnClickListener(v -> {
            finish();
        });

        rcvFavourites.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rcvFavourites.setAdapter(new FavouriteAdapter(getApplicationContext(), arrays));
        rcvFavourites.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
    }
}
