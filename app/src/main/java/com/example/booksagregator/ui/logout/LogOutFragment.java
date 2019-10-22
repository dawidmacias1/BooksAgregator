package com.example.booksagregator.ui.logout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.booksagregator.LoginActivity;

public class LogOutFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Intent intent = new Intent(getActivity(), LoginActivity.class);
        getActivity().startActivity(intent);

        return null;
    }
}