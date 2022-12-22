package com.didi.entrega.customer.widget;

import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.data.BaseDataManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/entrega/customer/widget/SingleChildDataListManager;", "T", "Lcom/didi/app/nova/support/view/recyclerview/data/BaseDataManager;", "adapter", "Lcom/didi/app/nova/support/view/recyclerview/adapter/NovaRecyclerAdapter;", "(Lcom/didi/app/nova/support/view/recyclerview/adapter/NovaRecyclerAdapter;)V", "reset", "", "datas", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SingleChildDataListManager.kt */
public final class SingleChildDataListManager<T> extends BaseDataManager<T> {

    /* renamed from: a */
    private final NovaRecyclerAdapter f20359a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleChildDataListManager(NovaRecyclerAdapter novaRecyclerAdapter) {
        super(novaRecyclerAdapter);
        Intrinsics.checkNotNullParameter(novaRecyclerAdapter, "adapter");
        this.f20359a = novaRecyclerAdapter;
    }

    public final void reset(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "datas");
        this.mDataList.clear();
        this.mDataList.addAll(list);
        this.f20359a.notifyDataSetChanged();
    }
}
