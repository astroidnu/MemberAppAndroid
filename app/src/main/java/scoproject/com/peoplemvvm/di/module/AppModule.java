package scoproject.com.peoplemvvm.di.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import scoproject.com.peoplemvvm.PeopleMVVM;
import scoproject.com.peoplemvvm.base.BaseRowViewModel;
import scoproject.com.peoplemvvm.di.scope.AppScope;

/**
 * Created by ibnumuzzakkir on 4/21/17.
 */
@Module
public class AppModule {

    private final PeopleMVVM mApp;

    public AppModule(PeopleMVVM app) {
        this.mApp = app;
    }

    @Provides
    @AppScope
    Application provideApplicationContext(){ return mApp;}
}
