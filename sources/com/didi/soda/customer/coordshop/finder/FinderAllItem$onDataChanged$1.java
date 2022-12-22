package com.didi.soda.customer.coordshop.finder;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/customer/coordshop/finder/FinderAllItem$onDataChanged$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FinderAllItem.kt */
public final class FinderAllItem$onDataChanged$1 extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ FinderAllItem this$0;

    FinderAllItem$onDataChanged$1(FinderAllItem finderAllItem) {
        this.this$0 = finderAllItem;
    }

    public void onChanged() {
        super.onChanged();
        FinderAllItem finderAllItem = this.this$0;
        finderAllItem.m29036a(finderAllItem.f40866b);
    }

    public void onItemRangeChanged(int i, int i2) {
        super.onItemRangeChanged(i, i2);
        FinderAllItem finderAllItem = this.this$0;
        finderAllItem.m29036a(finderAllItem.f40866b);
    }

    public void onItemRangeInserted(int i, int i2) {
        FinderAllItem finderAllItem = this.this$0;
        finderAllItem.m29036a(finderAllItem.f40866b);
    }
}
