package scoproject.com.peoplemvvm.view.addmember;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.Observable;

import butterknife.ButterKnife;
import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.base.  BaseActivity;
import scoproject.com.peoplemvvm.base.ui.ActivityScreen;
import scoproject.com.peoplemvvm.databinding.ActivityAddMemberBinding;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.viewmodel.addmember.AddMemberVM;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class AddMemberActivity extends BaseActivity<AddMemberVM> {
    private AddMemberComponent mComponent;
    private AddMemberVM mViewModel;
    private ActivityAddMemberBinding activityAddMemberBinding;

    @Override
    protected void initDataBinding() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activityAddMemberBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_member);
        mViewModel = new AddMemberVM(this);
        mComponent.inject(mViewModel);
        mViewModel.takeContext(this);
        activityAddMemberBinding.setVm(mViewModel);

    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_add_member;
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerAddMemberComponent.builder().appComponent(appComponent).build();
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
            return AddMemberActivity.class;
        }
    }
}
