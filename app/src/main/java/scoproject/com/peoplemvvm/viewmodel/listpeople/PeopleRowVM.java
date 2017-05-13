package scoproject.com.peoplemvvm.viewmodel.listpeople;

import android.databinding.ObservableField;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import javax.inject.Inject;

import scoproject.com.peoplemvvm.base.BaseRowViewModel;
import scoproject.com.peoplemvvm.base.ui.ActivityScreenSwitcher;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.model.PeopleResult;
import scoproject.com.peoplemvvm.view.listpeople.*;

/**
 * Created by ibnumuzzakkir on 12/05/2017.
 * Android Developer
 * Garena Indonesia
 */

public class PeopleRowVM extends BaseRowViewModel{
    @Inject
    Gson gson;

    @Inject
    ActivityScreenSwitcher mScreenSwitcher;

    private ListPeopleComponent mComponent;

    public final ObservableField<String> mFullName = new ObservableField<>();

    private PeopleResult mPeopleResult;

    public  PeopleRowVM(PeopleResult peopleResult){
        mPeopleResult = peopleResult;
        mFullName.set(mPeopleResult.getName().getFirst());
    }

    @Override
    public void onLoad(){
        super.onLoad();

    }

    @Override
    public void onStop(){
        super.onStop();
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {
        mComponent = DaggerListPeopleComponent.builder().appComponent(appComponent).build();
        mComponent.inject(this);
    }

    public void onClick() {
        Toast.makeText(getContext(), gson.toJson(mPeopleResult),Toast.LENGTH_LONG).show();
    }

}
