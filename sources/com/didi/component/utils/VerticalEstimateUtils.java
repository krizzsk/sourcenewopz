package com.didi.component.utils;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalEstimateUtils {
    public static final String TAG = "VerticalEstimateUtils";

    /* renamed from: a */
    static int m11882a(RecyclerView.LayoutManager layoutManager) {
        return layoutManager.getPaddingTop();
    }

    /* renamed from: b */
    static int m11883b(RecyclerView.LayoutManager layoutManager) {
        return layoutManager.getHeight() - layoutManager.getPaddingBottom();
    }

    /* renamed from: a */
    static int m11881a(View view, RecyclerView.LayoutManager layoutManager) {
        return layoutManager.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    public static int getFirstVisibleItemIndex(float f, RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager;
        View childAt;
        if (recyclerView == null || recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || (childAt = linearLayoutManager.getChildAt(0)) == null) {
            return -1;
        }
        int findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        return ((float) m11881a(childAt, linearLayoutManager)) + (((float) childAt.getMeasuredHeight()) * f) >= ((float) m11882a(linearLayoutManager)) ? findFirstVisibleItemPosition : findFirstVisibleItemPosition + 1;
    }

    public static int getLastVisibleItemIndex(float f, RecyclerView recyclerView) {
        if (recyclerView == null || recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return -1;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        View childAt = linearLayoutManager.getChildAt(linearLayoutManager.getChildCount() - 1);
        if (childAt == null) {
            return -1;
        }
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        return ((float) m11881a(childAt, linearLayoutManager)) + (((float) childAt.getMeasuredHeight()) * f) < ((float) m11883b(linearLayoutManager)) ? findLastVisibleItemPosition : findLastVisibleItemPosition - 1;
    }
}
