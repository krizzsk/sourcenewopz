package com.didi.soda.customer.coordshop.finder;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.coordshop.ShopSaver;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/finder/FinderVisibleDish;", "Lcom/didi/soda/customer/coordshop/finder/FinderVisibleItem;", "saver", "Lcom/didi/soda/customer/coordshop/ShopSaver;", "(Lcom/didi/soda/customer/coordshop/ShopSaver;)V", "onItemVisible", "", "visibleModel", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "position", "", "onVisibleRangeChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "lower", "upper", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FinderVisibleDish.kt */
public final class FinderVisibleDish extends FinderVisibleItem {

    /* renamed from: a */
    private ShopSaver f40868a;

    public FinderVisibleDish(ShopSaver shopSaver) {
        Intrinsics.checkNotNullParameter(shopSaver, "saver");
        this.f40868a = shopSaver;
    }

    public void onVisibleRangeChanged(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onVisibleRangeChanged(recyclerView, i, i2);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        NovaRecyclerAdapter novaRecyclerAdapter = adapter instanceof NovaRecyclerAdapter ? (NovaRecyclerAdapter) adapter : null;
        if (novaRecyclerAdapter != null && i <= i2) {
            while (true) {
                int i3 = i + 1;
                if (i < 0 || i >= novaRecyclerAdapter.getItemCount()) {
                    CustomerExtentionKt.safeThrow("pos 位置不再adapter范围内！！！");
                } else {
                    Object item = novaRecyclerAdapter.getItem(i);
                    if (item instanceof RecyclerModel) {
                        m29038a((RecyclerModel) item, i);
                    }
                }
                if (i != i2) {
                    i = i3;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m29038a(RecyclerModel recyclerModel, int i) {
        this.f40868a.saveVisibleDishWhenEnterShop(i, recyclerModel);
    }
}
