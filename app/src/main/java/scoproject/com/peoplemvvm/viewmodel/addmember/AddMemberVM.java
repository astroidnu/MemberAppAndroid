package scoproject.com.peoplemvvm.viewmodel.addmember;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import scoproject.com.peoplemvvm.model.Member;
import scoproject.com.peoplemvvm.view.addmember.AddMemberActivity;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class AddMemberVM extends Observable implements IAddMemberVM {
    @Inject
    Gson gson;

    public final ObservableField<String> mFullName = new ObservableField<>();
    public final ObservableField<String> mAddress = new ObservableField<>();
    public final ObservableField<String> mDateOfBirth = new ObservableField<>();
    public final ObservableField<String> mUserID = new ObservableField<>();
    private Member mMember;
    private Context mContext;

    public AddMemberVM(@NonNull Context context){
        mContext = context;
    }

    @Override
    public void submitMember() {
        mMember = new Member(mUserID.get(), mFullName.get(), mDateOfBirth.get(), mAddress.get());
        Log.d(getClass().getName(), gson.toJson(mMember));
    }
}
