package scoproject.com.peoplemvvm.networking.addmember;

import android.util.Log;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import scoproject.com.peoplemvvm.model.Member;
import scoproject.com.peoplemvvm.networking.NetworkService;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class AddMemberAPIService {
    private Member mMember;
    private NetworkService mNetworkService;

    private boolean isRequestingAddMemberService;

    public boolean isRequestingAddMemberService() {
        return isRequestingAddMemberService;
    }

    public void init(Member member){
        mMember= member;
    }

    public AddMemberAPIService(NetworkService networkService){
        mNetworkService = networkService;
    }

    public Flowable<AddMemberResponse> addMember(Member member) {

        return mNetworkService.addMember(member)
                .doOnSubscribe(disposable -> isRequestingAddMemberService = true)
                .doOnTerminate(() -> isRequestingAddMemberService = false)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(this::handleAccountError)
                .toFlowable(BackpressureStrategy.BUFFER);
    }

    private void handleAccountError(Throwable throwable) {
        Log.e(getClass().getName(), throwable.getMessage());
    }

}
