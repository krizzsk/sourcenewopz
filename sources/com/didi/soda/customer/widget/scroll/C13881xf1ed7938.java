package com.didi.soda.customer.widget.scroll;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/customer/widget/scroll/CustomerNavScrollListener$listenRecycleViewScrollEvent$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.widget.scroll.CustomerNavScrollListener$listenRecycleViewScrollEvent$scrollListener$1 */
/* compiled from: CustomerNavScrollListener.kt */
public final class C13881xf1ed7938 extends RecyclerView.OnScrollListener {
    final /* synthetic */ CustomerNavScrollListener this$0;

    C13881xf1ed7938(CustomerNavScrollListener customerNavScrollListener) {
        this.this$0 = customerNavScrollListener;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            LogUtil.m29100d("setUpNavBar", "不是 LinearLayoutManager");
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            float f = 1.0f;
            if (linearLayoutManager.findFirstVisibleItemPosition() == 0) {
                int maxOffset = this.this$0.getMaxOffset();
                View childAt = linearLayoutManager.getChildAt(0);
                if (childAt != null) {
                    maxOffset = childAt.getHeight();
                }
                f = Math.min(Math.max((((float) recyclerView.computeVerticalScrollOffset()) * 1.0f) / ((float) (maxOffset - this.this$0.getOverlapHeight())), 0.0f), 1.0f);
            }
            this.this$0.m29720a(recyclerView, f);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }
}
