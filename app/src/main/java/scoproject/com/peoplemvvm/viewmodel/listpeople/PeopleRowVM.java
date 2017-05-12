package scoproject.com.peoplemvvm.viewmodel.listpeople;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import java.util.Observable;

import scoproject.com.peoplemvvm.model.PeopleData;
import scoproject.com.peoplemvvm.model.PeopleResult;

/**
 * Created by ibnumuzzakkir on 12/05/2017.
 * Android Developer
 * Garena Indonesia
 */

public class PeopleRowVM extends BaseObservable{
    public final ObservableField<String> mFullName = new ObservableField<>();

    private PeopleData mPeopleData;
    public  PeopleRowVM(PeopleData peopleData){
        mPeopleData = peopleData;
        mFullName.set(mPeopleData.getInfo().getVersion());
    }

}
