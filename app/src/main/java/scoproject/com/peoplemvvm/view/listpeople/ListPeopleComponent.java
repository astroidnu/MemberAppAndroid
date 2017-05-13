package scoproject.com.peoplemvvm.view.listpeople;

import dagger.Component;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.networking.listpeople.ListPeopleAPIService;
import scoproject.com.peoplemvvm.viewmodel.listpeople.ListPeopleVM;
import scoproject.com.peoplemvvm.viewmodel.listpeople.PeopleRowVM;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

@ListPeopleScope
@Component(dependencies = {AppComponent.class})
public interface ListPeopleComponent {
    void inject(ListPeopleActivity addMemberActivity);
    void inject(ListPeopleVM listPeopleVM);
    void inject(PeopleRowVM peopleRowVM);
}
