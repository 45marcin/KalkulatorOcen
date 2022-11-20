package com.rosiekm.kalkulatorocen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.rosiekm.kalkulatorocen.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private SampleViewModel.MyCustomCallback callback;
    SampleViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        viewModel = new SampleViewModel();

        callback = new SampleViewModel.MyCustomCallback(){
            @Override
            public void actionIsSuccessful(){
                //do something when action is successful
            }
            @Override
            public void actionFailed(){
                //do something when action fails
            }
        };
        viewModel.setCallback(callback);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setModel(viewModel);
        activityMainBinding.executePendingBindings();

    }


}