package com.example.booksagregator.ui.home;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.booksagregator.R;
import com.example.booksagregator.ResourceActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button movies, music, books;

    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        setHasOptionsMenu(true);

        movies = root.findViewById(R.id.movies);
        music = root.findViewById(R.id.music);
        books = root.findViewById(R.id.books);

        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout gallery = root.findViewById(R.id.gallery);
        LinearLayout gallery2 = root.findViewById(R.id.gallery2);
        LinearLayout gallery3 = root.findViewById(R.id.gallery3);


        inflater = LayoutInflater.from(getActivity());


        for (int i = 0; i < 6; i++) {

            View view = inflater.inflate(R.layout.item, gallery, false);
            View view2 = inflater.inflate(R.layout.item, gallery2, false);
            View view3 = inflater.inflate(R.layout.item, gallery3, false);

            ImageView imageView = view.findViewById(R.id.image);
            imageView.setImageResource(R.drawable.ic_book_resource_24dp);
            ImageView imageView2 = view2.findViewById(R.id.image);
            imageView2.setImageResource(R.drawable.ic_book_resource_24dp);
            ImageView imageView3 = view3.findViewById(R.id.image);
            imageView3.setImageResource(R.drawable.ic_book_resource_24dp);

            gallery.addView(view);
            gallery2.addView(view2);
            gallery3.addView(view3);
        }

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act2 = new Intent(container.getContext(), ResourceActivity.class);
                startActivity(act2);
            }
        });

        gallery2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act2 = new Intent(container.getContext(), ResourceActivity.class);
                startActivity(act2);
            }
        });

        gallery3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act2 = new Intent(container.getContext(), ResourceActivity.class);
                startActivity(act2);
            }
        });

        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.user_main_panel, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);

        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

            queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextChange(String newText) {

                    return true;
                }
                @Override
                public boolean onQueryTextSubmit(String query) {

                    return true;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }
}