package scoproject.com.peoplemvvm.adapter.listpeople;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.databinding.ItemPeopleBinding;
import scoproject.com.peoplemvvm.model.PeopleData;
import scoproject.com.peoplemvvm.model.PeopleResult;
import scoproject.com.peoplemvvm.view.listpeople.ListPeopleComponent;
import scoproject.com.peoplemvvm.viewmodel.listpeople.PeopleRowVM;

/**
 * Created by ibnumuzzakkir on 12/05/2017.
 * Android Developer
 * Garena Indonesia
 */

public class ListPeopleAdapter extends RecyclerView.Adapter<ListPeopleAdapter.ViewHolder> {
    private PeopleData mPeopleDatas;
    private Context mContext;

    public ListPeopleAdapter(PeopleData peopleData, Context context){
        mPeopleDatas = peopleData;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),viewType, parent, false);
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case R.layout.item_people:
                PeopleRowVM peopleRowVM = new PeopleRowVM(mPeopleDatas.getResults().get(position),  ((ItemPeopleBinding) holder.getDataBinding()));
                peopleRowVM.takeContext(mContext);
                ((ItemPeopleBinding) holder.getDataBinding()).setVm(peopleRowVM);
                break;
            case R.layout.item_divider:
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return R.layout.item_divider;
        }else if(position % 2 == 0){
            return R.layout.item_divider;
        }else{
            return R.layout.item_people;
        }
    }


    @Override
    public int getItemCount() {
        return mPeopleDatas.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding mViewDataBinding;

        public ViewHolder(ViewDataBinding viewDataBinding){
            super(viewDataBinding.getRoot());
            mViewDataBinding = viewDataBinding;
            mViewDataBinding.executePendingBindings();
        }

        public ViewDataBinding getDataBinding(){
            return mViewDataBinding;
        }
    }

    public Context getContext(){
        return mContext;
    }


}
