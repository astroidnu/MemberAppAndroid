package scoproject.com.peoplemvvm.di.component;

import javax.inject.Singleton;

import dagger.Component;
import scoproject.com.peoplemvvm.di.BaseTest;
import scoproject.com.peoplemvvm.di.scope.AppScope;
import scoproject.com.peoplemvvm.di.scope.TestScope;
import scoproject.com.peoplemvvm.viewmodel.home.HomeVM;

/**
 * Created by ibnumuzzakkir on 26/04/2017.
 * Android Developer
 * Garena Indonesia
 */
@TestScope
@Component(dependencies = {AppComponent.class})
public interface TestComponent {
    void inject(BaseTest baseTest);
    void inject(HomeVM mViewModel);
}
