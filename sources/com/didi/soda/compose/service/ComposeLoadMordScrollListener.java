package com.didi.soda.compose.service;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/compose/service/ComposeLoadMordScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "loadMoreListener", "Lcom/didi/soda/compose/service/ComposeLoadMordScrollListener$LoadMoreListener;", "preLoadNumber", "", "(Lcom/didi/soda/compose/service/ComposeLoadMordScrollListener$LoadMoreListener;I)V", "mLoadMoreListener", "mPreLoadNumber", "canTriggerLoadMore", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "findLastVisibleItemPosition", "staggeredGridLayoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "findMax", "lastPositions", "", "onLoadMore", "", "onScrollStateChanged", "newState", "LoadMoreListener", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ComposeLoadMordScrollListener.kt */
public class ComposeLoadMordScrollListener extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    private LoadMoreListener f40140a;

    /* renamed from: b */
    private final int f40141b;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/compose/service/ComposeLoadMordScrollListener$LoadMoreListener;", "", "onLoadMore", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ComposeLoadMordScrollListener.kt */
    public interface LoadMoreListener {
        void onLoadMore();
    }

    public ComposeLoadMordScrollListener(LoadMoreListener loadMoreListener, int i) {
        Intrinsics.checkParameterIsNotNull(loadMoreListener, "loadMoreListener");
        this.f40140a = loadMoreListener;
        this.f40141b = i;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager.getChildCount() > 0 && i == 0 && m28555a(recyclerView)) {
                m28554a();
            }
        }
    }

    /* renamed from: a */
    private final boolean m28555a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            return staggeredGridLayoutManager.getItemCount() - this.f40141b <= m28552a(staggeredGridLayoutManager);
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    /* renamed from: a */
    private final int m28552a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
        return m28553a(iArr);
    }

    /* renamed from: a */
    private final int m28553a(int[] iArr) {
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    /* renamed from: a */
    private final void m28554a() {
        this.f40140a.onLoadMore();
    }
}
