package scoproject.com.peoplemvvm.viewmodel.addmember;

import android.app.DatePickerDialog;
import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import scoproject.com.peoplemvvm.R;
import scoproject.com.peoplemvvm.base.BaseViewModel;
import scoproject.com.peoplemvvm.model.Member;
import scoproject.com.peoplemvvm.view.addmember.AddMemberActivity;

/**
 * Created by ibnumuzzakkir on 4/22/17.
 */

public class AddMemberVM  extends BaseViewModel<AddMemberActivity> implements IAddMemberVM {
    @Inject
    Gson gson;

    public final ObservableField<String> mFullName = new ObservableField<>();
    public final ObservableField<String> mAddress = new ObservableField<>();
    public final ObservableField<String> mDateOfBirth = new ObservableField<>();
    public final ObservableField<String> mUserID = new ObservableField<>();
    private Member mMember;
    private Context mContext;
    private DatePickerDialog mDatePickerDialog;

    public AddMemberVM(@NonNull Context context){
        mContext = context;
    }

    @Override
    public void submitMember() {
        mMember = new Member(mUserID.get(), mFullName.get(), mDateOfBirth.get(), mAddress.get());
        Log.d(getClass().getName(), gson.toJson(mMember));
    }

    @Override
    public void setDateOfBirth() {
        openDatePicker();
    }

    public void openDatePicker() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        int mYear  = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay   = c.get(Calendar.DAY_OF_MONTH);
        //launch datepicker modal
        mDatePickerDialog = new DatePickerDialog(mContext,
                (view, year, monthOfYear, dayOfMonth) -> {
                    String dateSelected = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                    mDateOfBirth.set(dateSelected);
                }, mYear, mMonth, mDay);
        mDatePickerDialog.show();

    }
}
