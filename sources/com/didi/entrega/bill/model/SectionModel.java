package com.didi.entrega.bill.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/SectionModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "components", "", "Lcom/didi/entrega/bill/model/ComponentModel;", "(Ljava/util/List;)V", "getComponents", "()Ljava/util/List;", "setComponents", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SectionModel.kt */
public final class SectionModel implements RecyclerModel {

    /* renamed from: a */
    private List<ComponentModel> f19569a;

    public SectionModel() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public SectionModel(List<ComponentModel> list) {
        Intrinsics.checkNotNullParameter(list, "components");
        this.f19569a = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SectionModel(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    public final List<ComponentModel> getComponents() {
        return this.f19569a;
    }

    public final void setComponents(List<ComponentModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f19569a = list;
    }
}
