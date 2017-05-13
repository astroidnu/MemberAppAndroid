package scoproject.com.peoplemvvm.viewmodel.listpeople;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
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

    private boolean isLoading;


    public ListPeopleVM(@NonNull Context context, ActivityListPeopleBinding activityListPeopleBinding) {
        mContext = context;
        mActivityListPeopleBinding = activityListPeopleBinding;
    }


    @Override
    public void onLoad(){
        super.onLoad();
//        Log.d(getClass().getName(), "onLoad()");
        setLoading(true);
        mLinearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        compositeDisposable.add(
                listPeopleAPIService.getPeopleList().subscribe(peopleData -> setData(peopleData),
                        throwable -> Log.d(getClass().getName(), throwable.getMessage())));
    }

    @Override
    public void onStop(){
        super.onStop();
        clearCompositeDisposable();
    }

    public void setData(PeopleData peopleData){
        setLoading(false);
        mListPeopleAdapter = new ListPeopleAdapter(peopleData, mContext);
        mActivityListPeopleBinding.listPeople.setAdapter(mListPeopleAdapter);
        mListPeopleAdapter.notifyDataSetChanged();
    }

    @Bindable
    public boolean isLoading(){
        return isLoading;
    }

    public void setLoading(boolean loading){
        isLoading = loading;
        notifyPropertyChanged(BR._all);
    }
}
