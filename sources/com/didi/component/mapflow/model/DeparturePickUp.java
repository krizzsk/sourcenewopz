package com.didi.component.mapflow.model;

import com.didi.map.global.component.departure.model.AddressExtendInfo;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.sdk.address.address.entity.Address;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00118FX\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/component/mapflow/model/DeparturePickUp;", "", "()V", "address", "Lcom/didi/sdk/address/address/entity/Address;", "getAddress", "()Lcom/didi/sdk/address/address/entity/Address;", "departure", "Lcom/didi/map/global/component/departure/model/DepartureAddress;", "getDeparture", "()Lcom/didi/map/global/component/departure/model/DepartureAddress;", "departureAddr", "departureExtends", "Lcom/didi/map/global/component/departure/model/AddressExtendInfo;", "getDepartureExtends", "()Lcom/didi/map/global/component/departure/model/AddressExtendInfo;", "departureZoneType", "", "getDepartureZoneType$annotations", "getDepartureZoneType", "()I", "isPickOtherArea", "", "()Z", "setPickOtherArea", "(Z)V", "pickUpAddress", "pickUpDirty", "clearPickUp", "", "pickUp", "reset", "update", "departureAddress", "comp-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DeparturePickUp.kt */
public final class DeparturePickUp {

    /* renamed from: a */
    private boolean f14336a;

    /* renamed from: b */
    private DepartureAddress f14337b;

    /* renamed from: c */
    private Address f14338c;

    /* renamed from: d */
    private boolean f14339d = true;

    public static /* synthetic */ void getDepartureZoneType$annotations() {
    }

    public final Address getAddress() {
        Address address = this.f14338c;
        if (address == null || !(!this.f14339d)) {
            address = null;
        }
        if (address != null) {
            return address;
        }
        DepartureAddress departureAddress = this.f14337b;
        if (departureAddress == null) {
            return null;
        }
        return departureAddress.getAddress();
    }

    public final DepartureAddress getDeparture() {
        return this.f14337b;
    }

    public final AddressExtendInfo getDepartureExtends() {
        DepartureAddress departure = getDeparture();
        if (departure == null) {
            return null;
        }
        return departure.getExtendInfo();
    }

    public final int getDepartureZoneType() {
        DepartureAddress departure = getDeparture();
        if (departure == null) {
            return -1;
        }
        return departure.getZoneType();
    }

    public final boolean isPickOtherArea() {
        return this.f14336a;
    }

    public final void setPickOtherArea(boolean z) {
        this.f14336a = z;
    }

    public final void update(DepartureAddress departureAddress) {
        Intrinsics.checkNotNullParameter(departureAddress, "departureAddress");
        this.f14337b = departureAddress;
        this.f14339d = true;
    }

    public final void pickUp(Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.f14338c = address;
        this.f14339d = false;
    }

    public final void reset() {
        this.f14337b = null;
    }

    public final void clearPickUp() {
        this.f14338c = null;
        this.f14339d = true;
    }
}
