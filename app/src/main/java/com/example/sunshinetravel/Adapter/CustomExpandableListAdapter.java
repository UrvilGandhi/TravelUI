package com.example.sunshinetravel.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sunshinetravel.Model.DataModel;
import com.example.sunshinetravel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles

    public CustomExpandableListAdapter(Context context, List<String> listDataHeader) {
        this._context = context;
        this._listDataHeader = listDataHeader;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_row_menu, null);
        }

        String headerTitle = String.valueOf(getGroup(groupPosition));

        TextView title = convertView.findViewById(R.id.textViewName);
        ImageView icon = convertView.findViewById(R.id.imageViewIcon);
        LinearLayout linearLayout = convertView.findViewById(R.id.linear_layout);
        title.setText(headerTitle);

        if (headerTitle.equalsIgnoreCase("Home")) {
            Picasso.get().load(R.drawable.home).into(icon);

        } else if (headerTitle.equalsIgnoreCase("Location")) {
            Picasso.get().load(R.drawable.location).into(icon);
        } else if (headerTitle.equalsIgnoreCase("Favourites")) {
            Picasso.get().load(R.drawable.favourites).into(icon);
        } else if (headerTitle.equalsIgnoreCase("WishList")) {
            Picasso.get().load(R.drawable.wishlist).into(icon);
        } else if (headerTitle.equalsIgnoreCase("Profile")) {
            Picasso.get().load(R.drawable.profile).into(icon);
        } else if (headerTitle.equalsIgnoreCase("Settings")) {
            Picasso.get().load(R.drawable.settings).into(icon);
        }

        linearLayout.setOnClickListener(v -> {
            Log.e("TAG", "getGroupView: clicked" );
        });


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}