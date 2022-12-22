package com.didi.soda.customer.coordshop.finder;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.soda.customer.coordshop.ShopSaver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(mo175977d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/finder/FinderAllItem;", "Lcom/didi/soda/customer/coordshop/finder/IFinder;", "saver", "Lcom/didi/soda/customer/coordshop/ShopSaver;", "(Lcom/didi/soda/customer/coordshop/ShopSaver;)V", "onDataChanged", "com/didi/soda/customer/coordshop/finder/FinderAllItem$onDataChanged$1", "Lcom/didi/soda/customer/coordshop/finder/FinderAllItem$onDataChanged$1;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "clear", "", "findAllItem", "findInRecycleView", "refresh", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FinderAllItem.kt */
public final class FinderAllItem implements IFinder {

    /* renamed from: a */
    private final ShopSaver f40865a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RecyclerView f40866b;

    /* renamed from: c */
    private FinderAllItem$onDataChanged$1 f40867c = new FinderAllItem$onDataChanged$1(this);

    public void refresh(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public FinderAllItem(ShopSaver shopSaver) {
        Intrinsics.checkNotNullParameter(shopSaver, "saver");
        this.f40865a = shopSaver;
    }

    public void findInRecycleView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f40866b = recyclerView;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f40867c);
        }
        recyclerView.post(new Runnable(recyclerView) {
            public final /* synthetic */ RecyclerView f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                FinderAllItem.m29037a(FinderAllItem.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29037a(FinderAllItem finderAllItem, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(finderAllItem, "this$0");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        finderAllItem.m29036a(recyclerView);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29036a(RecyclerView recyclerView) {
        NovaRecyclerAdapter novaRecyclerAdapter = null;
        RecyclerView.Adapter adapter = recyclerView == null ? null : recyclerView.getAdapter();
        if (adapter instanceof NovaRecyclerAdapter) {
            novaRecyclerAdapter = (NovaRecyclerAdapter) adapter;
        }
        if (novaRecyclerAdapter != null) {
            List arrayList = new ArrayList();
            Iterator it = RangesKt.until(0, novaRecyclerAdapter.getItemCount()).iterator();
            while (it.hasNext()) {
                Object item = novaRecyclerAdapter.getItem(((IntIterator) it).nextInt());
                Intrinsics.checkNotNullExpressionValue(item, "model");
                arrayList.add(item);
            }
            this.f40865a.saveCurDisplayedItem(arrayList);
        }
    }

    public void clear() {
        RecyclerView.Adapter adapter;
        RecyclerView recyclerView = this.f40866b;
        if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
            adapter.unregisterAdapterDataObserver(this.f40867c);
        }
        this.f40866b = null;
    }
}
