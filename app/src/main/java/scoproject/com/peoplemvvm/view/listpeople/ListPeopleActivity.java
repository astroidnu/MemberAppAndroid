package scoproject.com.peoplemvvm.view.listpeople;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.Observable;

import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.base.BaseActivity;
import scoproject.com.peoplemvvm.base.ui.ActivityScreen;
import scoproject.com.peoplemvvm.databinding.ActivityListPeopleBinding;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.viewmodel.listpeople.ListPeopleVM;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class ListPeopleActivity extends BaseActivity {
    private ListPeopleComponent mComponent;
    private ListPeopleVM mViewModel;
    private ActivityListPeopleBinding activityListPeopleBinding;
    @Override
    protected void onCreateUI(Bundle bundle) {
        setContentView(R.layout.activity_list_people);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initDataBinding() {
        activityListPeopleBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_people);
        mViewModel = new ListPeopleVM(this);
        activityListPeopleBinding.setVm(mViewModel);
        mComponent.inject(mViewModel);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerListPeopleComponent.builder().appComponent(appComponent).build();
        mComponent.inject(this);
    }

    public static class Screen extends ActivityScreen {

        public Screen() {

        }

        @Override
        protected void configureIntent(@NonNull Intent intent) {

        }

        @Override
        protected Class<? extends Activity> activityClass() {
            return ListPeopleActivity.class;
        }
    }
}