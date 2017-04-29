package scoproject.com.peoplemvvm.networking;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import scoproject.com.peoplemvvm.model.Member;

/**
 * Created by ibnumuzzakkir on 4/29/17.
 */

public interface NetworkService {
    @POST("/member")
    Observable<Member> addMember(@Body Member member);
}
