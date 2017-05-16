package scoproject.com.peoplemvvm.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ibnumuzzakkir on 5/16/17.
 */

public class RVUtils {
    public static int lastVisibleItemPosition(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        return layoutManager.findLastVisibleItemPosition();
    }
}
