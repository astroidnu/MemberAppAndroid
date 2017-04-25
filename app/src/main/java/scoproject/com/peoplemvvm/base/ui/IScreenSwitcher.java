package scoproject.com.peoplemvvm.base.ui;

import android.content.Intent;

/**
 * Created by ibnumuzzakkir on 4/25/17.
 */

public interface IScreenSwitcher {

    void open(Screen screen);

    void goBack();

    void openAndFinish(Screen screen);

    void closeWithResult(int resultCode, Intent result);

    //public void startForResult(Screen screen);
}
