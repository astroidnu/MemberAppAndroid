package scoproject.com.peoplemvvm.di.viewmodel;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;

import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.di.BaseTest;
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

public class HomeVMTest extends BaseTest{
    @Rule
    public ActivityTestRule<HomeActivity> activityTestRule = new ActivityTestRule<>(HomeActivity.class,true, false);

    @Test
    public void addMemberOnClick() throws Exception{
        activityTestRule.launchActivity(null);
        onView(withId(R.id.activity_home_add_member))
                .perform(click());
    }
}
