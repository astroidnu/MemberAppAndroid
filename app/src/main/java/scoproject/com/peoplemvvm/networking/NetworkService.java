package scoproject.com.peoplemvvm.networking;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import scoproject.com.peoplemvvm.model.Member;
import scoproject.com.peoplemvvm.model.PeopleData;
import scoproject.com.peoplemvvm.networking.addmember.AddMemberResponse;

/**
 * Created by ibnumuzzakkir on 4/29/17.
 */

public interface NetworkService {
    @POST("/member")
    Observable<AddMemberResponse> addMember(@Body Member member);

    //Getting data from API Random User me
    @GET("/api")
    Observable<PeopleData> getPeopleList(@Query("results") String result, @Query("nat") String nat);
}
