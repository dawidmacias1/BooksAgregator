package com.example.booksagregator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserMainPanel extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_panel);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();

        LinearLayout gallery = findViewById(R.id.gallery);
        LinearLayout gallery2 = findViewById(R.id.gallery2);
        LinearLayout gallery3 = findViewById(R.id.gallery3);


        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0; i < 6; i++) {

            View view = inflater.inflate(R.layout.item, gallery, false);
            View view2 = inflater.inflate(R.layout.item, gallery2, false);
            View view3 = inflater.inflate(R.layout.item, gallery3, false);

            TextView textView = view.findViewById(R.id.text);
            textView.setText("item " + i);
            TextView textView2 = view2.findViewById(R.id.text);
            textView2.setText("item " + i);
            TextView textView3 = view3.findViewById(R.id.text);
            textView3.setText("item " + i);

            ImageView imageView = view.findViewById(R.id.image);
            imageView.setImageResource(R.mipmap.ic_launcher);
            ImageView imageView2 = view2.findViewById(R.id.image);
            imageView2.setImageResource(R.mipmap.ic_launcher);
            ImageView imageView3 = view3.findViewById(R.id.image);
            imageView3.setImageResource(R.mipmap.ic_launcher);

            gallery.addView(view);
            gallery2.addView(view2);
            gallery3.addView(view3);
        }
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_main_panel, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
