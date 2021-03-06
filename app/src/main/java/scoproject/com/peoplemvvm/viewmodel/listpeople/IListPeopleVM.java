package scoproject.com.peoplemvvm.viewmodel.listpeople;

import scoproject.com.peoplemvvm.model.PeopleData;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public interface IListPeopleVM {
    void setAdapter(PeopleData peopleData);
    void setLoading(boolean loading);
    boolean isLoading();
    boolean isRefreshing();
    void setRefreshing(boolean refreshing);
    void onRefresh();
    void getListPeopleData(int limit);
}
