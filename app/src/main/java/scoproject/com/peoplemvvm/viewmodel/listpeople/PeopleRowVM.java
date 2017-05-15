package scoproject.com.peoplemvvm.viewmodel.listpeople;

import android.databinding.ObservableField;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import javax.inject.Inject;

import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.base.BaseRowViewModel;
import scoproject.com.peoplemvvm.base.ui.ActivityScreenSwitcher;
import scoproject.com.peoplemvvm.databinding.ItemPeopleBinding;
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
    public final ObservableField<String> mLocation = new ObservableField<>();
    public final ObservableField<String> mPhoneNumber = new ObservableField<>();

    private PeopleResult mPeopleResult;
    private ItemPeopleBinding mItemPeopleBinding;

    public  PeopleRowVM(PeopleResult peopleResult, ItemPeopleBinding itemPeopleBinding){
        mPeopleResult = peopleResult;
        mItemPeopleBinding = itemPeopleBinding;
    }

    @Override
    public void onLoad(){
        super.onLoad();
        mFullName.set(mPeopleResult.getName().getFirst() + " " + mPeopleResult.getName().getLast());
        mPhoneNumber.set(mPeopleResult.getPhone());
        mLocation.set(mPeopleResult.getLocation().getCity());
        Glide.with(getContext())
                .load(mPeopleResult.getPicture().getMedium())
                .centerCrop()
                .crossFade()
                .into(mItemPeopleBinding.itemPeopleImageview);
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
