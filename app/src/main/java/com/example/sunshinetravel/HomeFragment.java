package com.example.sunshinetravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.sunshinetravel.Interfaces.MenuClickListener;

import java.util.Objects;

import static com.facebook.FacebookSdk.getApplicationContext;


public class HomeFragment extends Fragment implements MenuClickListener {
    private View view;
    private ConstraintLayout constCanada, constItaly, constPrague, constUsa;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        Utilites.setTitle(Objects.requireNonNull(getContext()), "Destinations", HomeFragment.this);
        constCanada = view.findViewById(R.id.canada_constraint);
        constItaly = view.findViewById(R.id.italy_constraint);
        constPrague = view.findViewById(R.id.prague_constraint);
        constUsa = view.findViewById(R.id.usa_constraint);

        constCanada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PlacesListActivity.class));
            }
        });

        constItaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PlacesListActivity.class));
            }
        });

        constPrague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PlacesListActivity.class));
            }
        });

        constUsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PlacesListActivity.class));
            }
        });
        return view;
    }

    @Override
    public void onMenuClick(int index) {

    }


}
