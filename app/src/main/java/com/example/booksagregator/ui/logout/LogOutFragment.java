package com.example.booksagregator.ui.logout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.booksagregator.LoginActivity;
import com.example.booksagregator.R;

public class LogOutFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Intent intent = new Intent(getActivity(), LoginActivity.class);
        getActivity().startActivity(intent);

        return null;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        // This does work
        MenuItem someMenuItem = menu.findItem(R.id.action_search);
        someMenuItem.setVisible(false);
    }
}