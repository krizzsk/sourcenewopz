package com.didi.soda.home.topgun.binder;

import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.BindViewHolderCallBack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/home/topgun/binder/FilterBinder$ViewHolder$setData$1", "Lcom/didi/soda/home/topgun/widget/BindViewHolderCallBack;", "onbind", "", "model", "Lcom/didi/soda/home/topgun/model/FilterModel;", "position", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterBinder.kt */
public final class FilterBinder$ViewHolder$setData$1 implements BindViewHolderCallBack {
    final /* synthetic */ FilterBinder this$0;

    FilterBinder$ViewHolder$setData$1(FilterBinder filterBinder) {
        this.this$0 = filterBinder;
    }

    public void onbind(FilterModel filterModel, int i) {
        Intrinsics.checkNotNullParameter(filterModel, "model");
        BindViewHolderCallBack onBindListener = this.this$0.getOnBindListener();
        if (onBindListener != null) {
            onBindListener.onbind(filterModel, i);
        }
    }
}
