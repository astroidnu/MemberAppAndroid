package scoproject.com.peoplemvvm;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import scoproject.com.peoplemvvm.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 4/21/17.
 */

public class PeopleMVVM extends MultiDexApplication{

    public static PeopleMVVM mInstance;

    private AppComponent mAppComponent;

    public static PeopleMVVM getApp() { return mInstance;}

    @Override
    public void onCreate(){
        super.onCreate();

        MultiDex.install(this);
        mInstance  = this;
        mAppComponent = AppComponent.Initializer.init(this);
    }

    public AppComponent component(){ return mAppComponent;}

}
