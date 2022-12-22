package com.didi.soda.address.component.selectlist.binder;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.OrderAddressListEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/address/component/selectlist/binder/SelectedAddressItemRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity;", "selectedAid", "", "bgType", "Lcom/didi/soda/address/component/selectlist/binder/TypeCorner;", "(Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity;Ljava/lang/String;Lcom/didi/soda/address/component/selectlist/binder/TypeCorner;)V", "getBgType", "()Lcom/didi/soda/address/component/selectlist/binder/TypeCorner;", "getEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity;", "mDragStatus", "", "getMDragStatus", "()I", "setMDragStatus", "(I)V", "getSelectedAid", "()Ljava/lang/String;", "isDragOut", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedAddressItemRvModel.kt */
public final class SelectedAddressItemRvModel implements RecyclerModel {

    /* renamed from: a */
    private final OrderAddressListEntity.AddrOptionStructEntity f38705a;

    /* renamed from: b */
    private final String f38706b;

    /* renamed from: c */
    private final TypeCorner f38707c;

    /* renamed from: d */
    private int f38708d;

    public SelectedAddressItemRvModel(OrderAddressListEntity.AddrOptionStructEntity addrOptionStructEntity, String str, TypeCorner typeCorner) {
        Intrinsics.checkNotNullParameter(addrOptionStructEntity, "entity");
        Intrinsics.checkNotNullParameter(str, "selectedAid");
        Intrinsics.checkNotNullParameter(typeCorner, "bgType");
        this.f38705a = addrOptionStructEntity;
        this.f38706b = str;
        this.f38707c = typeCorner;
    }

    public final TypeCorner getBgType() {
        return this.f38707c;
    }

    public final OrderAddressListEntity.AddrOptionStructEntity getEntity() {
        return this.f38705a;
    }

    public final String getSelectedAid() {
        return this.f38706b;
    }

    public final int getMDragStatus() {
        return this.f38708d;
    }

    public final void setMDragStatus(int i) {
        this.f38708d = i;
    }

    public final boolean isDragOut() {
        return this.f38708d == 1;
    }
}
