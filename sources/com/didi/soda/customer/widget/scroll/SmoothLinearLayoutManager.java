package com.didi.soda.customer.widget.scroll;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SmoothLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a */
    private RecyclerView.SmoothScroller f42166a;

    public SmoothLinearLayoutManager(Context context) {
        super(context);
    }

    public SmoothLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public SmoothLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setSmoothScroller(RecyclerView.SmoothScroller smoothScroller) {
        this.f42166a = smoothScroller;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        RecyclerView.SmoothScroller smoothScroller = this.f42166a;
        if (smoothScroller == null) {
            super.smoothScrollToPosition(recyclerView, state, i);
            return;
        }
        smoothScroller.setTargetPosition(i);
        startSmoothScroll(this.f42166a);
    }
}
