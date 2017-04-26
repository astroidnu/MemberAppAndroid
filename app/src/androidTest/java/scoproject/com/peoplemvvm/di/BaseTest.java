package scoproject.com.peoplemvvm.di;

import android.app.Instrumentation;
import android.databinding.DataBindingUtil;
import android.support.annotation.CallSuper;
import android.support.test.InstrumentationRegistry;
import android.support.v7.app.AppCompatActivity;

import org.junit.Before;

import javax.inject.Inject;

import scoproject.com.peoplemvvm.PeopleMVVM;
import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.databinding.ActivityHomeBinding;
import scoproject.com.peoplemvvm.di.component.DaggerTestComponent;
import scoproject.com.peoplemvvm.di.component.TestComponent;
import scoproject.com.peoplemvvm.di.module.AppModule;
import scoproject.com.peoplemvvm.viewmodel.home.HomeVM;

/**
 * Created by ibnumuzzakkir on 26/04/2017.
 * Android Developer
 * Garena Indonesia
 */

public abstract class BaseTest{
    private HomeVM mHomeVm;

    @Before
    @CallSuper
    public void setUp() throws Exception{
        TestComponent mComponent = DaggerTestComponent.builder().appComponent(PeopleMVVM.getApp().component()).build();
        mComponent.inject(this);
        mHomeVm = new HomeVM(PeopleMVVM.getApp());
    }
}
