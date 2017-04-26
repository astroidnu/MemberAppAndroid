package scoproject.com.peoplemvvm;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import scoproject.com.peoplemvvm.view.home.HomeActivity;

/**
 * Created by ibnumuzzakkir on 26/04/2017.
 * Android Developer
 * Garena Indonesia
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomePageTest {
    @Rule
    public ActivityTestRule<HomeActivity> mActivityRule = new ActivityTestRule(HomeActivity.class);

    @Test
    public void addMemberOnClick(){
        
    }

}
