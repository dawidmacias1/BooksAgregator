package com.example.booksagregator.ui.userpanel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserPanelViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UserPanelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}