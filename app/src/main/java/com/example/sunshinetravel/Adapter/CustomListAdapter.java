package com.example.sunshinetravel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunshinetravel.Activity.FavouritesActivity;
import com.example.sunshinetravel.Activity.MainActivity;
import com.example.sunshinetravel.Activity.ProfileActivity;
import com.example.sunshinetravel.Activity.SettingsActivity;
import com.example.sunshinetravel.Model.DataModel;
import com.example.sunshinetravel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.MyViewHolder> {

    private static final String TAG = "CustomListAdapter";
    Context mContext;
    List<DataModel> dataList;
    private boolean isClicked;

    public CustomListAdapter(MainActivity mainActivity, List<DataModel> dataList, boolean isClicked) {
        this.mContext = mainActivity;
        this.dataList = dataList;
        this.isClicked = isClicked;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_menu, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        DataModel dataModel = dataList.get(position);

        holder.menuName.setText(dataModel.getName());
        Log.e(TAG, "onBindViewHolder: " + dataModel.getName());
        Picasso.get().load(dataModel.getIcon()).into(holder.menuIcon);

        holder.menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: ");
                if (dataModel.getName().equalsIgnoreCase("Profile")) {
                    isClicked = true;
                    SharedPreferences preferences = mContext.getSharedPreferences("MyPref",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("isClicked",isClicked);
                    editor.apply();
                    mContext.startActivity(new Intent(mContext, ProfileActivity.class));
                }else if(dataModel.getName().equalsIgnoreCase("Settings")){
                    isClicked=true;
                    SharedPreferences preferences = mContext.getSharedPreferences("MyPref",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("isClicked",isClicked);
                    editor.apply();
                    mContext.startActivity(new Intent(mContext, SettingsActivity.class));
                }else if(dataModel.getName().equalsIgnoreCase("Favourites")){
                    isClicked=true;
                    SharedPreferences preferences = mContext.getSharedPreferences("MyPref",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("isClicked",isClicked);
                    editor.apply();
                    mContext.startActivity(new Intent(mContext, FavouritesActivity.class));
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView menuName;
        ImageView menuIcon;
        LinearLayout linearLayout;

        MyViewHolder(View itemView) {
            super(itemView);
            menuName = itemView.findViewById(R.id.textViewName);
            menuIcon = itemView.findViewById(R.id.imageViewIcon);
            linearLayout = itemView.findViewById(R.id.linear_layout);
        }
    }
}
