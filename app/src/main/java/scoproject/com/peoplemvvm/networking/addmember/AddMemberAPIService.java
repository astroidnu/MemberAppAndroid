package scoproject.com.peoplemvvm.networking.addmember;

import scoproject.com.peoplemvvm.model.Member;
import scoproject.com.peoplemvvm.networking.NetworkService;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class AddMemberAPIService {
    private Member mMember;
    private NetworkService mNetworkService;

    public void init(Member member){
        mMember= member;
    }

    public AddMemberAPIService(NetworkService networkService){
        mNetworkService = networkService;
    }

}
