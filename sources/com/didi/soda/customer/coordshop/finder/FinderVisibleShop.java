package com.didi.soda.customer.coordshop.finder;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.coordshop.ShopSaver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/finder/FinderVisibleShop;", "Lcom/didi/soda/customer/coordshop/finder/FinderVisibleItem;", "saver", "Lcom/didi/soda/customer/coordshop/ShopSaver;", "(Lcom/didi/soda/customer/coordshop/ShopSaver;)V", "onScreenVisibleChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "visibleFirst", "", "visibleLast", "onVisibleRangeChanged", "lower", "upper", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FinderVisibleShop.kt */
public final class FinderVisibleShop extends FinderVisibleItem {

    /* renamed from: a */
    private ShopSaver f40874a;

    public FinderVisibleShop(ShopSaver shopSaver) {
        Intrinsics.checkNotNullParameter(shopSaver, "saver");
        this.f40874a = shopSaver;
    }

    public void onVisibleRangeChanged(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onVisibleRangeChanged(recyclerView, i, i2);
        this.f40874a.saveVisibleRange(i, i2);
    }

    public void onScreenVisibleChanged(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScreenVisibleChanged(recyclerView, i, i2);
        this.f40874a.saveScreenVisibleChanged(i, i2);
    }
}
