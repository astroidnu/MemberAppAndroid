package scoproject.com.peoplemvvm.viewmodel.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Observable;

/**
 * Created by ibnumuzzakkir on 4/21/17.
 */

public class HomeVM extends Observable implements IHomeVM {

    private Context mContext;
    public HomeVM(@NonNull Context context){
        mContext = context;
    }

    @Override
    public void addMemberOnclick() {
        Log.d(getClass().getName(), "addMemberOnclick()");
    }

    @Override
    public void listMemberOnClick() {
        Log.d(getClass().getName(), "listMemberOnClick()");
    }
}
