package com.didi.soda.bill.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/bill/model/SectionModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "components", "Ljava/util/ArrayList;", "Lcom/didi/soda/bill/model/ComponentModel;", "Lkotlin/collections/ArrayList;", "getComponents", "()Ljava/util/ArrayList;", "setComponents", "(Ljava/util/ArrayList;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SectionModel.kt */
public final class SectionModel implements RecyclerModel {

    /* renamed from: a */
    private ArrayList<ComponentModel> f39070a = new ArrayList<>();

    public final ArrayList<ComponentModel> getComponents() {
        return this.f39070a;
    }

    public final void setComponents(ArrayList<ComponentModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f39070a = arrayList;
    }
}
