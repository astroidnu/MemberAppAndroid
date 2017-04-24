package scoproject.com.peoplemvvm.view.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import java.util.Observable;

import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.base.BaseActivity;
import scoproject.com.peoplemvvm.databinding.ActivityHomeBinding;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.viewmodel.home.HomeVM;

public class HomeActivity extends BaseActivity {
    private HomeVM mViewModel;
    private HomeComponent mComponent;
    private ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreateUI(Bundle bundle) {
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void initDataBinding() {
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        mViewModel = new HomeVM(this);
        activityHomeBinding.setVm(mViewModel);
        mComponent.inject(mViewModel);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerHomeComponent.builder().appComponent(appComponent).build();
        mComponent.inject(this);
    }
}
