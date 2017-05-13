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
        notifyDataSetChanged();
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
                PeopleRowVM peopleRowVM = new PeopleRowVM(mPeopleDatas.getResults().get(position));
                ((ItemPeopleBinding) holder.getDataBinding()).setVm(peopleRowVM);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_people;
    }


    @Override
    public int getItemCount() {
        return 2;
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

}
