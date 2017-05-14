package scoproject.com.peoplemvvm.viewmodel.detailpeople;

import android.content.Context;
import android.support.annotation.NonNull;

import scoproject.com.peoplemvvm.base.BaseViewModel;
import scoproject.com.peoplemvvm.view.detailpeople.DetailPeopleActivity;

/**
 * Created by ibnumuzzakkir on 5/13/17.
 */

public class DetailPeopleVM extends BaseViewModel<DetailPeopleActivity> {
    private Context mContext;
    public DetailPeopleVM(@NonNull Context context){
        mContext = context;
    }
}
