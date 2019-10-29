package com.example.booksagregator.ui.userpanel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.booksagregator.R;
import com.example.booksagregator.ResourceActivity;

public class UserPanelFragment extends Fragment {

    private UserPanelViewModel userPanelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

        userPanelViewModel = ViewModelProviders.of(this).get(UserPanelViewModel.class);

        View root = inflater.inflate(R.layout.fragment_user_panel, container, false);

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