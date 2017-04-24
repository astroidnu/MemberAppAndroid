package scoproject.com.peoplemvvm.view.addmember;

import dagger.Component;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.viewmodel.addmember.AddMemberVM;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

@AddMemberScope
@Component(dependencies = {AppComponent.class})
public interface AddMemberComponent {
    void inject(AddMemberActivity addMemberActivity);
    void inject(AddMemberVM addMemberVM);
}

