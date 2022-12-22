package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;

public class NovaGridLayoutManager extends GridLayoutManager implements INovaLayoutManager {

    /* renamed from: a */
    private RecyclerView.SmoothScroller f8636a;

    /* renamed from: b */
    private C3794a f8637b;

    public NovaGridLayoutManager(Context context) {
        this(context, 1, false);
    }

    public NovaGridLayoutManager(Context context, int i, boolean z) {
        super(context, 1, i, z);
        this.f8637b = new C3794a();
    }

    public void init(NovaRecyclerAdapter novaRecyclerAdapter) {
        this.f8637b.mo41419a((INovaLayoutManager) this, novaRecyclerAdapter);
        setSpanCount(novaRecyclerAdapter.getSpanCount());
        setSpanSizeLookup(novaRecyclerAdapter.getSpanSizeLookup());
    }

    public void release() {
        this.f8637b.mo41415a();
    }

    public void elevateHeaders(boolean z) {
        this.f8637b.mo41420a(z);
    }

    public void elevateHeaders(int i) {
        this.f8637b.mo41416a(i);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        this.f8637b.mo41417a(recycler, state);
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
        if (Math.abs(scrollVerticallyBy) > 0) {
            this.f8637b.mo41421b();
        }
        return scrollVerticallyBy;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
        if (Math.abs(scrollHorizontallyBy) > 0) {
            this.f8637b.mo41421b();
        }
        return scrollHorizontallyBy;
    }

    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        super.removeAndRecycleAllViews(recycler);
        this.f8637b.mo41422c();
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        this.f8637b.mo41418a(recyclerView);
        super.onAttachedToWindow(recyclerView);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        RecyclerView.SmoothScroller smoothScroller = this.f8636a;
        if (smoothScroller == null) {
            super.smoothScrollToPosition(recyclerView, state, i);
            return;
        }
        smoothScroller.setTargetPosition(i);
        startSmoothScroll(this.f8636a);
    }

    public void setSmoothScroller(RecyclerView.SmoothScroller smoothScroller) {
        this.f8636a = smoothScroller;
    }
}
