package scoproject.com.peoplemvvm.view.home;

import dagger.Component;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.viewmodel.home.HomeVM;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */
@HomeScope
@Component(dependencies = {AppComponent.class})
public interface HomeComponent {
    void inject(HomeActivity homeActivity);
    void inject(HomeVM homeViewModel);
}
