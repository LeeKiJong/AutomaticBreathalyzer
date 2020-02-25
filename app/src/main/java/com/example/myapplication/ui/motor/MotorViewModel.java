package com.example.myapplication.ui.motor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MotorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MotorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is motor fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}