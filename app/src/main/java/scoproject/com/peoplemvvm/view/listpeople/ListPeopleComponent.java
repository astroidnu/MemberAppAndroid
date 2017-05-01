package scoproject.com.peoplemvvm.view.listpeople;

import dagger.Component;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.viewmodel.listpeople.ListPeopleVM;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

@ListPeopleScope
@Component(dependencies = {AppComponent.class})
public interface ListPeopleComponent {
    void inject(ListPeopleActivity addMemberActivity);
    void inject(ListPeopleVM listPeopleVM);
}
