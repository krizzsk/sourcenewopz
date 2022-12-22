package com.didi.soda.home.topgun.widget;

import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.home.topgun.model.FilterModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/FilterBtnItemHolder;", "Lcom/didi/soda/home/topgun/widget/FilterListHolder;", "root", "Landroid/view/ViewGroup;", "resId", "", "(Landroid/view/ViewGroup;I)V", "filterItemView", "Lcom/didi/soda/home/topgun/widget/HomeFilterItem;", "getFilterItemView", "()Lcom/didi/soda/home/topgun/widget/HomeFilterItem;", "bindData", "", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.home.topgun.widget.a */
/* compiled from: HomeFilterLayout.kt */
final class C14060a extends FilterListHolder {

    /* renamed from: a */
    private final HomeFilterItem f43207a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C14060a(ViewGroup viewGroup, int i) {
        super(viewGroup, i);
        Intrinsics.checkNotNullParameter(viewGroup, "root");
        View findViewById = this.itemView.findViewById(R.id.customer_home_filter_item);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…ustomer_home_filter_item)");
        this.f43207a = (HomeFilterItem) findViewById;
    }

    /* renamed from: a */
    public final HomeFilterItem mo108143a() {
        return this.f43207a;
    }

    public void bindData(FilterModel filterModel) {
        Intrinsics.checkNotNullParameter(filterModel, "filterModel");
        this.f43207a.updateItem(filterModel);
    }
}
