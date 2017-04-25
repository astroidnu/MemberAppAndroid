package scoproject.com.peoplemvvm.di.component;

import scoproject.com.peoplemvvm.PeopleMVVM;
import scoproject.com.peoplemvvm.base.ui.ActivityScreenSwitcher;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public interface IAppComponent {
    void inject (PeopleMVVM app);

    ActivityScreenSwitcher activityScreenSwitcher();
}
