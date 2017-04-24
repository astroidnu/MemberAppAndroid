package scoproject.com.peoplemvvm.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

import scoproject.com.peoplemvvm.PeopleMVVM;
import scoproject.com.peoplemvvm.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 4/21/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements Observer {
    protected abstract void onCreateUI(Bundle bundle);
    protected abstract void initDataBinding();
    public abstract void update(Observable o, Object arg);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateComponent(PeopleMVVM.getApp().component());
        onCreateUI(savedInstanceState);
        initDataBinding();
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
}
