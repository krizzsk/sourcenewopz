package com.didi.soda.customer.coordshop.finder;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/customer/coordshop/finder/FinderVisibleItem$onDataChanged$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onItemRangeChanged", "", "positionStart", "", "itemCount", "onItemRangeInserted", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FinderVisibleItem.kt */
public final class FinderVisibleItem$onDataChanged$1 extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ FinderVisibleItem this$0;

    FinderVisibleItem$onDataChanged$1(FinderVisibleItem finderVisibleItem) {
        this.this$0 = finderVisibleItem;
    }

    public void onItemRangeChanged(int i, int i2) {
        super.onItemRangeChanged(i, i2);
        FinderVisibleItem finderVisibleItem = this.this$0;
        try {
            RecyclerView access$getRecyclerView$p = finderVisibleItem.f40871c;
            if (access$getRecyclerView$p != null) {
                finderVisibleItem.m29042c(access$getRecyclerView$p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onItemRangeInserted(int i, int i2) {
        FinderVisibleItem finderVisibleItem = this.this$0;
        try {
            RecyclerView access$getRecyclerView$p = finderVisibleItem.f40871c;
            if (access$getRecyclerView$p != null) {
                finderVisibleItem.m29042c(access$getRecyclerView$p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
