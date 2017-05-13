package scoproject.com.peoplemvvm.view.listpeople;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.Observable;

import javax.inject.Inject;

import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.base.BaseActivity;
import scoproject.com.peoplemvvm.base.ui.ActivityScreen;
import scoproject.com.peoplemvvm.databinding.ActivityListPeopleBinding;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.networking.listpeople.ListPeopleAPIService;
import scoproject.com.peoplemvvm.viewmodel.listpeople.ListPeopleVM;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class ListPeopleActivity extends BaseActivity<ListPeopleVM> {

    private ListPeopleComponent mComponent;
    private ListPeopleVM mViewModel;
    private ActivityListPeopleBinding activityListPeopleBinding;

    @Override
    protected void initDataBinding() {
        activityListPeopleBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_people);
        mViewModel = new ListPeopleVM(this, activityListPeopleBinding.listPeople);
        mComponent.inject(mViewModel);
        mViewModel.takeContext(this);
        activityListPeopleBinding.setVm(mViewModel);
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
