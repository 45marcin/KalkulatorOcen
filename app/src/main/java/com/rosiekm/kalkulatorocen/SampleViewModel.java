package com.rosiekm.kalkulatorocen;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SampleViewModel extends BaseObservable {

    public  MainActivityModel model;

    @Bindable
    public String getAbsolutepoints()
    {
        return String.valueOf(model.absolutepoints);
    }

    public void setAbsolutepoints(String absolutepoints)
    {
        model.setAbsolutepoints(Float.valueOf(absolutepoints));
        notifyPropertyChanged(BR.absolutepoints);
    }
    public SampleViewModel()
    {
        model = new MainActivityModel(9999);
    }

    private MyCustomCallback callback;

    public void doOnClick(MyCustomCallback mCallback){
        boolean isSuccessful = true;
        if (isSuccessful){
            mCallback.actionIsSuccessful();
        } else {
            mCallback.actionFailed();
        }
    }
    public void setCallback(MyCustomCallback callback){
        this.callback = callback;
    }
    public MyCustomCallback getCallback(){
        return this.callback;
    }

    public interface MyCustomCallback{
        void actionIsSuccessful();
        void actionFailed();
    }
}