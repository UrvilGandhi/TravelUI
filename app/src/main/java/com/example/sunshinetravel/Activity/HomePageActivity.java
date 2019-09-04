//package com.example.sunshinetravel.Activity;
//
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.constraintlayout.widget.ConstraintLayout;
//
//import android.content.Intent;
//import android.content.pm.ActivityInfo;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.AdapterView;
//import android.widget.ImageView;
//import android.widget.ListView;
//
//import com.example.sunshinetravel.CustomWidgets.CustomDrawerLayout;
//import com.example.sunshinetravel.Model.DataModel;
//import com.example.sunshinetravel.Adapter.DrawerItemCustomAdapter;
//import com.example.sunshinetravel.Activity.PlacesListActivity;
//import com.example.sunshinetravel.R;
//
//public class HomePageActivity extends AppCompatActivity {
//
//    ImageView imgMenu;
//    Toolbar toolbar;
//    ActionBarDrawerToggle mDrawerToggle;
//    private String[] mNavigationDrawerItemTitles;
//    private CustomDrawerLayout mDrawerLayout;
//    private ListView mDrawerList;
//    private CharSequence mDrawerTitle;
//    private CharSequence mTitle;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.fragment_home);
//
//        ConstraintLayout constCanada, constItaly, constPrague, constUsa;
//
//        constCanada = findViewById(R.id.canada_constraint);
//        constItaly = findViewById(R.id.italy_constraint);
//        constPrague = findViewById(R.id.prague_constraint);
//        constUsa = findViewById(R.id.usa_constraint);
//        mTitle = mDrawerTitle = getTitle();
//        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
//        mDrawerLayout = findViewById(R.id.drawer_layout);
//        mDrawerList = findViewById(R.id.left_drawer);
//
//        setupToolbar();
//
//        DataModel[] drawerItem = new DataModel[6];
//
//        drawerItem[0] = new DataModel(R.drawable.home, "Home");
//        drawerItem[1] = new DataModel(R.drawable.pinpoint, "Location");
//        drawerItem[2] = new DataModel(R.drawable.favourites, "Favourites");
//        drawerItem[3] = new DataModel(R.drawable.wishlist, "WishList");
//        drawerItem[4] = new DataModel(R.drawable.profile, "Profile");
//        drawerItem[5] = new DataModel(R.drawable.settings, "Settings");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//        getSupportActionBar().setHomeButtonEnabled(true);
//
//        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_row_menu, drawerItem);
//        mDrawerList.setAdapter(adapter);
//        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
//        mDrawerLayout = findViewById(R.id.drawer_layout);
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//        setupDrawerToggle();
//
//        constCanada.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomePageActivity.this, PlacesListActivity.class));
//            }
//        });
//
//        constItaly.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomePageActivity.this, PlacesListActivity.class));
//            }
//        });
//
//        constPrague.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomePageActivity.this, PlacesListActivity.class));
//            }
//        });
//
//        constUsa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomePageActivity.this, PlacesListActivity.class));
//            }
//        });
//    }
//
//    private void selectItem(int position) {
//
//        switch (position) {
//            case 0:
//                startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
//                break;
////            case 1:
////                fragment = new FixturesFragment();
////                break;
////            case 2:
////                fragment = new TableFragment();
////                break;
//
//            default:
//                break;
//        }
//
////        if (fragment != null) {
////            FragmentManager fragmentManager = getSupportFragmentManager();
////            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
//
//        mDrawerList.setItemChecked(position, true);
//        mDrawerList.setSelection(position);
//        setTitle(mNavigationDrawerItemTitles[position]);
//        mDrawerLayout.closeDrawer(mDrawerList);
//
////        } else {
////            Log.e("MainActivity", "Error in creating fragment");
////        }
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if (mDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void setTitle(CharSequence title) {
//        mTitle = title;
//        getSupportActionBar().setTitle(mTitle);
//    }
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        mDrawerToggle.syncState();
//    }
//
//    void setupToolbar() {
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//    }
//
//    void setupDrawerToggle() {
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
//        //This is necessary to change the icon of the Drawer Toggle upon state change.
//        mDrawerToggle.syncState();
//    }
//
//    private class DrawerItemClickListener implements ListView.OnItemClickListener {
//
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            selectItem(position);
//        }
//
//    }
//}
