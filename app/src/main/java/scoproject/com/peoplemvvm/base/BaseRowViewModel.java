package scoproject.com.peoplemvvm.base;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.util.Log;

import scoproject.com.peoplemvvm.PeopleMVVM;
import scoproject.com.peoplemvvm.di.component.AppComponent;

/**
 * Created by ibnumuzzakkir on 5/13/17.
 */

public abstract class BaseRowViewModel extends BaseObservable{
    private Context mContext;

    public final void takeContext(Context context){
        onCreateComponent(PeopleMVVM.getApp().component());
        mContext = context;
        if(mContext != null){
            onLoad();
        }else{
            Log.e(getClass().getName(), "Context must be not null");
        }
    }

    public final Context getContext() {
        return mContext;
    }

    protected void onLoad() {
    }

    protected void onStop(){
    }

    protected abstract void onCreateComponent(AppComponent appComponent);

}
