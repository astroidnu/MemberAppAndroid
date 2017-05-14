package scoproject.com.peoplemvvm.viewmodel.listpeople;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;


import javax.inject.Inject;

import scoproject.com.peoplemvvm.BR;
import scoproject.com.peoplemvvm.adapter.listpeople.ListPeopleAdapter;
import scoproject.com.peoplemvvm.base.BaseViewModel;
import scoproject.com.peoplemvvm.databinding.ActivityListPeopleBinding;
import scoproject.com.peoplemvvm.model.PeopleData;
import scoproject.com.peoplemvvm.model.PeopleResult;
import scoproject.com.peoplemvvm.networking.listpeople.ListPeopleAPIService;
import scoproject.com.peoplemvvm.view.listpeople.ListPeopleActivity;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class ListPeopleVM extends BaseViewModel<ListPeopleActivity> implements IListPeopleVM {
    private Context mContext;

    @Inject
    ListPeopleAPIService listPeopleAPIService;

    @Inject
    Gson gson;

    public ListPeopleAdapter mListPeopleAdapter;
    public LinearLayoutManager mLinearLayoutManager;
    public ActivityListPeopleBinding mActivityListPeopleBinding;

    private boolean isLoading = false;
    private boolean isRefreshing = false;

    public ListPeopleVM(@NonNull Context context, ActivityListPeopleBinding activityListPeopleBinding) {
        mContext = context;
        mActivityListPeopleBinding = activityListPeopleBinding;
    }


    @Override
    public void onLoad() {
        super.onLoad();
        setLoading(true);
        mLinearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        getListPeopleData();
    }

    @Override
    public void onStop() {
        super.onStop();
        clearCompositeDisposable();
    }


    @Override
    public void setAdapter(PeopleData peopleData) {
        mListPeopleAdapter = new ListPeopleAdapter(peopleData, mContext);
        setLoading(false);
        setRefreshing(false);
        mListPeopleAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLoading(boolean loading) {
        isLoading = loading;
        notifyPropertyChanged(BR._all);
    }

    @Override
    public void getListPeopleData(){
        compositeDisposable.add(
                listPeopleAPIService.getPeopleList().subscribe(peopleData -> setAdapter(peopleData),
                        throwable -> Log.d(getClass().getName(), throwable.getMessage())));
    }

    @Bindable
    @Override
    public boolean isLoading() {
        return isLoading;
    }

    @Override
    public boolean isRefreshing() {
        return isRefreshing;
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        isRefreshing = refreshing;
        notifyPropertyChanged(BR._all);
    }

    @Override
    public void onRefresh() {
        setRefreshing(true);
        getListPeopleData();
    }


}


