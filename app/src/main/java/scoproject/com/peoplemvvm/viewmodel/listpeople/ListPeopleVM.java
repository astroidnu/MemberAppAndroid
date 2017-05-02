package scoproject.com.peoplemvvm.viewmodel.listpeople;

import android.content.Context;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import scoproject.com.peoplemvvm.model.PeopleData;
import scoproject.com.peoplemvvm.networking.listpeople.ListPeopleAPIService;
import scoproject.com.peoplemvvm.view.listpeople.ListPeopleActivity;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class ListPeopleVM extends BaseObservable implements IListPeopleVM {
    private Context mContext;

    @Inject
    Gson gson;

    @Inject
    ListPeopleAPIService listPeopleAPIService;

    public ListPeopleVM(@NonNull Context context) {
        mContext = context;
        gson.toJson("HELLO");
//        listPeopleAPIService.getPeopleList();
    }

    public ListPeopleVM(){

    }

    @Override
    public Observable<PeopleData> getPeopleList() {

        return null;
    }
}
