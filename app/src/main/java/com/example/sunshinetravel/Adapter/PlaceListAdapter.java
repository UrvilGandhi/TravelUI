package com.example.sunshinetravel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunshinetravel.Activity.DetailsActivity;
import com.example.sunshinetravel.Activity.PlacesListActivity;
import com.example.sunshinetravel.R;
import com.squareup.picasso.Picasso;


public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.MyViewHolder> {

    private Context mContext;
    private int[] arrays;


    public PlaceListAdapter(PlacesListActivity placesListActivity, int[] arrays) {

        this.mContext = placesListActivity;
        this.arrays = arrays;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.places_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.placeName.setText("Alcatrez Crusies");
        holder.placeType.setText("History and Culture");
        holder.placeDistance.setText("12.3 K.M.");
        Picasso.get().load(R.drawable.bridge).into(holder.placeImage);
        holder.constLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrays.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView placeImage;
        TextView placeName, placeType, placeDistance;
        ConstraintLayout constLayout;

        MyViewHolder(View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.name);
            placeType = itemView.findViewById(R.id.type);
            placeDistance = itemView.findViewById(R.id.distance);
            constLayout = itemView.findViewById(R.id.layout);

        }
    }
}
