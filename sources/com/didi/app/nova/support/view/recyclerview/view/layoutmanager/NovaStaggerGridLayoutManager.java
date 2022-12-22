package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;

public class NovaStaggerGridLayoutManager extends StaggeredGridLayoutManager implements INovaLayoutManager {

    /* renamed from: a */
    private RecyclerView.SmoothScroller f8640a;

    /* renamed from: b */
    private C3794a f8641b = new C3794a();

    public NovaStaggerGridLayoutManager(int i, int i2) {
        super(i, i2);
    }

    public void init(NovaRecyclerAdapter novaRecyclerAdapter) {
        this.f8641b.mo41419a((INovaLayoutManager) this, novaRecyclerAdapter);
    }

    public void release() {
        this.f8641b.mo41415a();
    }

    public void setSmoothScroller(RecyclerView.SmoothScroller smoothScroller) {
        this.f8640a = smoothScroller;
    }

    public int findFirstVisibleItemPosition() {
        int spanCount = getSpanCount();
        if (spanCount <= 0) {
            return 0;
        }
        int[] iArr = new int[spanCount];
        findFirstVisibleItemPositions(iArr);
        int i = iArr[0];
        for (int i2 = 0; i2 < spanCount; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        int spanCount = getSpanCount();
        if (spanCount <= 0) {
            return 0;
        }
        int[] iArr = new int[spanCount];
        findFirstCompletelyVisibleItemPositions(iArr);
        int i = iArr[0];
        for (int i2 = 0; i2 < spanCount; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public int findLastVisibleItemPosition() {
        int spanCount = getSpanCount();
        if (spanCount <= 0) {
            return 0;
        }
        int[] iArr = new int[spanCount];
        findLastVisibleItemPositions(iArr);
        int i = iArr[0];
        for (int i2 = 0; i2 < spanCount; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public void elevateHeaders(boolean z) {
        this.f8641b.mo41420a(z);
    }

    public void elevateHeaders(int i) {
        this.f8641b.mo41416a(i);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        this.f8641b.mo41417a(recycler, state);
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
        if (Math.abs(scrollVerticallyBy) > 0) {
            this.f8641b.mo41421b();
        }
        return scrollVerticallyBy;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
        if (Math.abs(scrollHorizontallyBy) > 0) {
            this.f8641b.mo41421b();
        }
        return scrollHorizontallyBy;
    }

    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        super.removeAndRecycleAllViews(recycler);
        this.f8641b.mo41422c();
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        this.f8641b.mo41418a(recyclerView);
        super.onAttachedToWindow(recyclerView);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        RecyclerView.SmoothScroller smoothScroller = this.f8640a;
        if (smoothScroller == null) {
            super.smoothScrollToPosition(recyclerView, state, i);
            return;
        }
        smoothScroller.setTargetPosition(i);
        startSmoothScroll(this.f8640a);
    }
}
