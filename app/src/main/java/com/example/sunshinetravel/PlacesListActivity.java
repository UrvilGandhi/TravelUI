package com.example.sunshinetravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.sunshinetravel.Adapter.PlaceListAdapter;

public class PlacesListActivity extends AppCompatActivity {

    private RecyclerView rv_places_list;
    private ImageView imgBack;
    private int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        rv_places_list = findViewById(R.id.rv_place_list);
        rv_places_list.setLayoutManager(new LinearLayoutManager(PlacesListActivity.this, RecyclerView.VERTICAL, false));
        rv_places_list.setAdapter(new PlaceListAdapter(PlacesListActivity.this, arrays));

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
