package com.didi.soda.search.component.result;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/search/component/result/SearchResultView$setupNovaRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultView.kt */
public final class SearchResultView$setupNovaRecyclerView$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ SearchResultView this$0;

    SearchResultView$setupNovaRecyclerView$1(SearchResultView searchResultView) {
        this.this$0 = searchResultView;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (i != 0 || i2 != 0) {
            KeyboardUtils.hideSoftInput(this.this$0.getContext(), (View) null);
        }
    }
}
