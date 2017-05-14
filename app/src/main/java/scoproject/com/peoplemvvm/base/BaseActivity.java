package scoproject.com.peoplemvvm.base;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

import javax.inject.Inject;

import scoproject.com.peoplemvvm.PeopleMVVM;
import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.base.ui.ActivityScreenSwitcher;
import scoproject.com.peoplemvvm.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 4/21/17.
 */

public abstract class BaseActivity<T extends BaseViewModel>  extends AppCompatActivity implements Observer {
    protected abstract void initDataBinding();
    public abstract void update(Observable o, Object arg);
    public abstract int getLayout();

    @Inject
    ActivityScreenSwitcher activityScreenSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateComponent(PeopleMVVM.getApp().component());
        onInitDataBinding();
        initDataBinding();
        if (activityScreenSwitcher == null) {
            throw new IllegalStateException(
                    "No injection happened. Add component.inject(this) in onCreateComponent() implementation.");
        }
        activityScreenSwitcher.attach(this);
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    /**
     * Implement this method to inject the dependency for activity
     *
     * @param appComponent the base app component
     */
    protected abstract void onCreateComponent(AppComponent appComponent);

    public void onBack() {
        finish();
    }

    @Override
    @Deprecated
    public void onBackPressed() {
        onBack();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onStop(){
        super.onStop();
//        viewModel.clearSubscriptions();
    }

    @Override
    public void onResume(){
        super.onResume();
        activityScreenSwitcher.attach(this);
    }

    public void onInitDataBinding() {
        if(getLayout() != 0){
            Log.d(getClass().getName(), "Hello view not null");
            ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, getLayout());
        }else{
            Log.e(getClass().getName(), "View Null");
        }
    }

}
