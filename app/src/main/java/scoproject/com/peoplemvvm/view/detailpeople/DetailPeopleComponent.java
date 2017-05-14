package scoproject.com.peoplemvvm.view.detailpeople;

import dagger.Component;
import scoproject.com.peoplemvvm.di.component.AppComponent;
import scoproject.com.peoplemvvm.viewmodel.detailpeople.DetailPeopleVM;

/**
 * Created by ibnumuzzakkir on 5/13/17.
 */
@DetailPeopleScope
@Component(dependencies = {AppComponent.class})
public interface DetailPeopleComponent {
    void inject(DetailPeopleActivity detailPeopleActivity);
    void inject(DetailPeopleVM detailPeopleVM);
}
