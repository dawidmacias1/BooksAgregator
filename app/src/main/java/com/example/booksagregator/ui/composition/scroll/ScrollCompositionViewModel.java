package com.example.booksagregator.ui.composition.scroll;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScrollCompositionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ScrollCompositionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}