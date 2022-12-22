package com.didi.soda.home.topgun.binder;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ScopeContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\t"}, mo175978d2 = {"com/didi/soda/home/topgun/binder/FilterBinder$ViewHolder$recordScrollPosition$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "savePosition", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterBinder.kt */
public final class FilterBinder$ViewHolder$recordScrollPosition$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ FilterBinder this$0;

    FilterBinder$ViewHolder$recordScrollPosition$1(FilterBinder filterBinder) {
        this.this$0 = filterBinder;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            savePosition(recyclerView);
        }
    }

    public final void savePosition(RecyclerView recyclerView) {
        int i;
        View findViewByPosition;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            i = -1;
        } else {
            i = linearLayoutManager.findFirstVisibleItemPosition();
        }
        if (i >= 0) {
            ScopeContext access$getScopeContext$p = this.this$0.scopeContext;
            int i2 = 0;
            if (!(linearLayoutManager == null || (findViewByPosition = linearLayoutManager.findViewByPosition(i)) == null)) {
                i2 = findViewByPosition.getLeft();
            }
            access$getScopeContext$p.attach(FilterBinderKt.keyFilterBinderOffset, Integer.valueOf(i2));
        }
        this.this$0.scopeContext.attach(FilterBinderKt.keyFilterBinderPos, Integer.valueOf(i));
    }
}
