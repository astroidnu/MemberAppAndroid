package scoproject.com.peoplemvvm.networking.listmember;

import android.util.Log;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import scoproject.com.peoplemvvm.model.PeopleData;
import scoproject.com.peoplemvvm.model.PeopleResult;
import scoproject.com.peoplemvvm.networking.NetworkService;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class ListMemberAPIService {
    private PeopleResult mPeopleResult;
    private NetworkService mNetworkService;

    private boolean isRequestingListPeopleService;

    public boolean isRequestingListPeopleService() {
        return isRequestingListPeopleService;
    }

    public ListMemberAPIService(NetworkService networkService){
        mNetworkService = networkService;
    }

    public Flowable<PeopleData> getPeopleList() {

        return mNetworkService.getPeopleList()
                .doOnSubscribe(disposable -> isRequestingListPeopleService = true)
                .doOnTerminate(() -> isRequestingListPeopleService = false)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(this::handleAccountError)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

    private void handleAccountError(Throwable throwable) {
        Log.e(getClass().getName(), throwable.getMessage());
    }

}
