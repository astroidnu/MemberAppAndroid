package scoproject.com.peoplemvvm.viewmodel.listpeople;

import android.databinding.BaseObservable;

import scoproject.com.peoplemvvm.view.listpeople.ListPeopleActivity;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class ListPeopleVM extends BaseObservable implements IListPeopleVM {
    private ListPeopleActivity mActivity;

    public ListPeopleVM(ListPeopleActivity listPeopleActivity) {
        mActivity = listPeopleActivity;

    }

    @Override
    public void getPeopleList() {

    }
}
