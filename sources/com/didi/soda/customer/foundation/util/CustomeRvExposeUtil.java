package com.didi.soda.customer.foundation.util;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomeRvExposeUtil {

    /* renamed from: a */
    private OnItemExposeListener f41137a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f41138b = false;
    protected RecyclerView mRecyclerView;

    public interface OnItemExposeListener {
        void onItemViewVisible(int i);
    }

    public void setRecyclerItemExposeListener(RecyclerView recyclerView, OnItemExposeListener onItemExposeListener) {
        this.f41137a = onItemExposeListener;
        this.mRecyclerView = recyclerView;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    if (i == 0) {
                        CustomeRvExposeUtil.this.handleCurrentVisibleItems();
                    }
                }

                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    if (!CustomeRvExposeUtil.this.f41138b) {
                        CustomeRvExposeUtil.this.handleCurrentVisibleItems();
                        boolean unused = CustomeRvExposeUtil.this.f41138b = true;
                    }
                }
            });
        }
    }

    public void handleCurrentVisibleItems() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            try {
                int[] iArr = new int[2];
                RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    iArr = findRangeLinear((LinearLayoutManager) layoutManager);
                }
                if (iArr == null) {
                    return;
                }
                if (iArr.length >= 2) {
                    for (int i = iArr[0]; i <= iArr[1]; i++) {
                        setCallbackForLogicVisibleView(layoutManager.findViewByPosition(i), i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setCallbackForLogicVisibleView(View view, int i) {
        OnItemExposeListener onItemExposeListener;
        if (view != null && view.getVisibility() == 0 && (onItemExposeListener = this.f41137a) != null) {
            onItemExposeListener.onItemViewVisible(i);
        }
    }

    /* access modifiers changed from: protected */
    public int[] findRangeLinear(LinearLayoutManager linearLayoutManager) {
        return new int[]{linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
    }
}
