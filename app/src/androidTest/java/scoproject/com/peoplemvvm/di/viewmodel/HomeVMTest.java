package scoproject.com.peoplemvvm.di.viewmodel;

import android.support.annotation.CallSuper;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import scoproject.com.peoplemvvm.PeopleMVVM;
import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.di.component.DaggerTestComponent;
import scoproject.com.peoplemvvm.di.component.TestComponent;
import scoproject.com.peoplemvvm.view.home.HomeActivity;
import scoproject.com.peoplemvvm.viewmodel.home.HomeVM;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by ibnumuzzakkir on 26/04/2017.
 * Android Developer
 * Garena Indonesia
 */

public class HomeVMTest{

    private HomeVM mHomeVM;

    @Rule
    public ActivityTestRule<HomeActivity> activityTestRule = new ActivityTestRule<>(HomeActivity.class,true, false);


    @Before
    @CallSuper
    public void setUp() throws Exception{
        TestComponent mComponent = DaggerTestComponent.builder().appComponent(PeopleMVVM.getApp().component()).build();
        mComponent.inject(this);
//        mHomeVM = new HomeVM(PeopleMVVM.getApp());
    }

    @Test
    public void addMemberOnClick() throws Exception{
        activityTestRule.launchActivity(null);
        onView(withId(R.id.activity_home_add_member))
                .perform(click());
    }
}
