package scoproject.com.peoplemvvm.view.detailpeople;

import android.support.v7.app.AppCompatActivity;

import java.util.Observable;

import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.base.BaseActivity;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.viewmodel.detailpeople.DetailPeopleVM;
import scoproject.com.peoplemvvm.viewmodel.listpeople.PeopleRowVM;

/**
 * Created by ibnumuzzakkir on 5/13/17.
 */

public class DetailPeopleActivity extends BaseActivity<DetailPeopleVM> {
    private DetailPeopleComponent mComponent;
    private DetailPeopleVM mViewModel;

    @Override
    protected void initDataBinding() {

    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_detail_people;
    }

    @Override
    protected void onCreateComponent(AppComponent appComponent) {

    }
}
