package scoproject.com.peoplemvvm.networking.listpeople;

import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import scoproject.com.peoplemvvm.model.Member;
import scoproject.com.peoplemvvm.model.PeopleData;
import scoproject.com.peoplemvvm.model.PeopleResult;
import scoproject.com.peoplemvvm.networking.NetworkService;
import scoproject.com.peoplemvvm.networking.addmember.AddMemberResponse;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class ListPeopleAPIService {
    private NetworkService mNetworkService;
    private int mLimit;


    public void init(int limit){
        mLimit = limit;
    }

    public ListPeopleAPIService(NetworkService networkService){
        mNetworkService = networkService;
    }

    public Flowable<PeopleData> getPeopleList() {
        return mNetworkService.getPeopleList()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(this::handleAccountError)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

    private void handleAccountError(Throwable throwable) {
        Log.e(getClass().getName(), throwable.getMessage());
    }

}
