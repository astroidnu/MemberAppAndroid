package scoproject.com.peoplemvvm.viewmodel.home;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.Observable;

import javax.inject.Inject;

import scoproject.com.peoplemvvm.base.ui.ActivityScreenSwitcher;
import scoproject.com.peoplemvvm.view.addmember.AddMemberActivity;
import scoproject.com.peoplemvvm.view.listpeople.ListPeopleActivity;

/**
 * Created by ibnumuzzakkir on 4/21/17.
 */

public class HomeVM extends Observable implements IHomeVM {

    private Context mContext;

    @Inject
    ActivityScreenSwitcher mScreenSwitcher;

    public HomeVM(@NonNull Context context){
        mContext = context;
    }

    @Override
    public void addMemberOnclick() {
        mScreenSwitcher.open(new AddMemberActivity.Screen());
    }

    public Context getmContext(){
        return this.mContext;
    }

    @Override
    public void listMemberOnClick() {
        mScreenSwitcher.open(new ListPeopleActivity.Screen());
    }
}
