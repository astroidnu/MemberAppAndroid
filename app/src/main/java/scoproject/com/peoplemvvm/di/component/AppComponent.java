package scoproject.com.peoplemvvm.di.component;

import android.app.Application;

import com.google.gson.Gson;

import java.io.File;

import dagger.Component;
import scoproject.com.peoplemvvm.PeopleMVVM;
import scoproject.com.peoplemvvm.di.module.AppModule;
import scoproject.com.peoplemvvm.di.module.NetworkModule;
import scoproject.com.peoplemvvm.di.scope.AppScope;

/**
 * Created by ibnumuzzakkir on 4/21/17.
 */
@AppScope
@Component(
        modules = {AppModule.class, NetworkModule.class}
)
public interface AppComponent extends IAppComponent {
    final static class Initializer {
         public static AppComponent init(PeopleMVVM app){
            File cacheFile = new File(app.getCacheDir(), "responses");
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .networkModule(new NetworkModule(cacheFile))
                    .build();
        }
    }

    Application getApplication();
    Gson getGson();
}