package com.example.sunshinetravel.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sunshinetravel.Model.DataModel;
import com.example.sunshinetravel.R;

import java.util.List;

public class DrawerItemCustomAdapter extends ArrayAdapter<DataModel> {

    private static final String TAG = "DrawerItemCustomAdapter";
    Context mContext;
    int layoutResourceId;
    List<DataModel> dataModelList;

    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, List<DataModel> dataList) {

        super(mContext, layoutResourceId, dataList);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.dataModelList = dataList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = listItem.findViewById(R.id.textViewName);
        LinearLayout linearLayout = listItem.findViewById(R.id.linear_layout);

        DataModel folder = dataModelList.get(position);
        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        linearLayout.setOnClickListener(v -> {
            Log.e(TAG, "onClick: " + position);
            if (position == 1) {
                imageViewIcon.setImageTintList(ColorStateList.valueOf(Resources.getSystem().getColor(R.color.steel_blue)));
            }
        });


        return listItem;
    }
}
