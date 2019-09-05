package com.example.sunshinetravel.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunshinetravel.R;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView setting, photoEdit;
    private SwitchCompat switchFacebook, switchGoogle;
    private TextView tv_title;

    private boolean isFacebookLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);

        toolbar = findViewById(R.id.toolbar);
        tv_title = toolbar.findViewById(R.id.tv_title);
        setting = toolbar.findViewById(R.id.toolbarTool);
        photoEdit = findViewById(R.id.editPhotoIcon);
        switchFacebook = findViewById(R.id.switchFacebook);
        switchGoogle = findViewById(R.id.switchGoogle);

        setSupportActionBar(toolbar);
        tv_title.setText("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(toolbar).setNavigationOnClickListener(v -> {
            finish();
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(SettingsActivity.this, setting);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(SettingsActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();//showing popup menu
            }
        });

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        isFacebookLogin = preferences.getBoolean("isLogin", false);

        if (isFacebookLogin) {
            switchFacebook.setChecked(true);
        } else {
            switchFacebook.setChecked(false);
        }
    }
}
