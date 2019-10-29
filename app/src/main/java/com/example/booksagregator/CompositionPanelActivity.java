package com.example.booksagregator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


public class CompositionPanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composition_panel);

        LinearLayout gallery = findViewById(R.id.gallery);

        for (int i = 0; i < 6; i++) {

            View view = getLayoutInflater().inflate(R.layout.item, gallery, false);

            ImageView imageView = view.findViewById(R.id.image);
            imageView.setImageResource(R.drawable.ic_book_resource_24dp);

            gallery.addView(view);
        }

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act2 = new Intent(getApplicationContext(), ResourceActivity.class);
                startActivity(act2);
            }
        });
    }
}
