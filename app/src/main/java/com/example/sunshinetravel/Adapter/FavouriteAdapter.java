package com.example.sunshinetravel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunshinetravel.R;
import com.squareup.picasso.Picasso;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.MyViewHolder> {

    private Context context;
    private int[] arrays;

    public FavouriteAdapter(Context applicationContext, int[] arrays) {
        this.context = applicationContext;
        this.arrays = arrays;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_favourite, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.placeCountry.setText("USA");
        holder.placeName.setText("San Francisco");
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "iTem Removed", Toast.LENGTH_SHORT).show();
            }
        });
        Picasso.get().load(R.drawable.san_francisco).into(holder.favouritePhoto);

    }

    @Override
    public int getItemCount() {
        return arrays.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView favouritePhoto, remove;
        TextView placeName, placeCountry;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            favouritePhoto = itemView.findViewById(R.id.imgFavouritePhoto);
            remove = itemView.findViewById(R.id.remove);
            placeName = itemView.findViewById(R.id.txtPlaceName);
            placeCountry = itemView.findViewById(R.id.txtPlaceCountry);
        }
    }
}
