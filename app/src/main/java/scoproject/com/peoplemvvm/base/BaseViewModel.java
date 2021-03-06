package scoproject.com.peoplemvvm.base;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.util.Log;

import java.util.Observable;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ibnumuzzakkir on 02/05/2017.
 * Android Developer
 * Garena Indonesia
 */

public class BaseViewModel<T extends Context> extends BaseObservable {
    private T context = null;
    protected CompositeDisposable compositeDisposable;
    private boolean loaded;

    public BaseViewModel(){
        compositeDisposable = new CompositeDisposable();
    }

    public final void takeContext(T context){
        if(context == null){
            throw new NullPointerException("Context must be not null");
        }

        if (this.context != context) {
            this.context = context;
            if (getContext() != null && !loaded) {
                loaded = true;
                onLoad();
            }
        }
    }

    protected void onLoad() {
    }

    protected void onStop(){
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }

    public final T getContext() {
        return context;
    }


    public void clearCompositeDisposable() {
        compositeDisposable.clear();
    }

}
