package scoproject.com.peoplemvvm.viewmodel.listpeople;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;


import javax.inject.Inject;

import scoproject.com.peoplemvvm.BR;
import scoproject.com.peoplemvvm.adapter.listpeople.ListPeopleAdapter;
import scoproject.com.peoplemvvm.base.BaseViewModel;
import scoproject.com.peoplemvvm.databinding.ActivityListPeopleBinding;
import scoproject.com.peoplemvvm.model.PeopleData;
import scoproject.com.peoplemvvm.model.PeopleResult;
import scoproject.com.peoplemvvm.networking.listpeople.ListPeopleAPIService;
import scoproject.com.peoplemvvm.utils.RVUtils;
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
    private PeopleData mPeopleData;

    public ListPeopleVM(@NonNull Context context, ActivityListPeopleBinding activityListPeopleBinding) {
        mContext = context;
        mActivityListPeopleBinding = activityListPeopleBinding;
    }


    @Override
    public void onLoad() {
        super.onLoad();
        mLinearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        getListPeopleData(20);
        handleOnScrolledRV();
    }

    @Override
    public void onStop() {
        super.onStop();
        clearCompositeDisposable();
    }


    @Override
    public void setAdapter(PeopleData peopleData) {
        mPeopleData = peopleData;
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
    public void getListPeopleData(int limit){
        setLoading(true);
        listPeopleAPIService.init(limit);
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
        getListPeopleData(20);
    }

    public void handleOnScrolledRV(){
        mActivityListPeopleBinding.listPeopleRecycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RVUtils.lastVisibleItemPosition(recyclerView) >= mPeopleData.getResults().size() - 1) {
//                    getListPeopleData(mPeopleData.getResults().size() + 5);
                }
            }
        });
    }
}


