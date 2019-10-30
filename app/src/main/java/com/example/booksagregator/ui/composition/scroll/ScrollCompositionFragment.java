package com.example.booksagregator.ui.composition.scroll;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.booksagregator.R;
import com.example.booksagregator.ResourceActivity;
import com.example.booksagregator.ui.composition.add.AddCompositionViewModel;

public class ScrollCompositionFragment extends Fragment {

    private AddCompositionViewModel aboutAppViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        aboutAppViewModel =
                ViewModelProviders.of(this).get(AddCompositionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_scroll_compositions, container, false);

        LinearLayout gallery = root.findViewById(R.id.gallery);

        inflater = LayoutInflater.from(getActivity());


        for (int i = 0; i < 6; i++) {

            View view = inflater.inflate(R.layout.item, gallery, false);

            ImageView imageView = view.findViewById(R.id.image);
            imageView.setImageResource(R.drawable.ic_book_resource_24dp);

            gallery.addView(view);
        }

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act2 = new Intent(container.getContext(), ResourceActivity.class);
                startActivity(act2);
            }
        });

        return root;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        // This does work
        MenuItem someMenuItem = menu.findItem(R.id.action_search);
        someMenuItem.setVisible(false);
    }
}