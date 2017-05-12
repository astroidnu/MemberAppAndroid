package scoproject.com.peoplemvvm.viewmodel.listpeople;

import android.content.Context;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.google.gson.Gson;


import javax.inject.Inject;

import scoproject.com.peoplemvvm.adapter.listpeople.ListPeopleAdapter;
import scoproject.com.peoplemvvm.base.BaseViewModel;
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

    PeopleData mPeopleData;

    public ListPeopleVM(@NonNull Context context) {
        mContext = context;
    }


    @Override
    public void onLoad(){
        super.onLoad();
        Log.d(getClass().getName(), "onLoad()");
        //Getting data from Network Interface
        compositeDisposable.add(
                listPeopleAPIService.getPeopleList().subscribe(peopleData -> setData(peopleData),
                throwable -> Log.d(getClass().getName(), throwable.getMessage())));
    }

    @Override
    public void onStop(){
        super.onStop();
        clearCompositeDisposable();
    }

    private void setData(PeopleData peopleData){
        mListPeopleAdapter = new ListPeopleAdapter(peopleData, mContext);
        mLinearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        mListPeopleAdapter.notifyDataSetChanged();
    }

}
