package scoproject.com.peoplemvvm.di.module;

import dagger.Module;
import dagger.Provides;
import scoproject.com.peoplemvvm.base.ui.ActivityScreenSwitcher;
import scoproject.com.peoplemvvm.di.scope.AppScope;

/**
 * Created by ibnumuzzakkir on 4/25/17.
 */

@Module
public class AppUIModule {
    @Provides
    @AppScope
    ActivityScreenSwitcher provideActivityScreenSwitcher() {
        return new ActivityScreenSwitcher();
    }

}

