package com.didi.soda.address.manager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/address/manager/AddressKeyboardStatus;", "", "showType", "Lcom/didi/soda/address/manager/AutoShowType;", "alreadyLoaded", "", "(Lcom/didi/soda/address/manager/AutoShowType;Z)V", "getAlreadyLoaded", "()Z", "setAlreadyLoaded", "(Z)V", "getShowType", "()Lcom/didi/soda/address/manager/AutoShowType;", "setShowType", "(Lcom/didi/soda/address/manager/AutoShowType;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddressKeyboardStatus.kt */
public final class AddressKeyboardStatus {

    /* renamed from: a */
    private AutoShowType f38777a;

    /* renamed from: b */
    private boolean f38778b;

    public static /* synthetic */ AddressKeyboardStatus copy$default(AddressKeyboardStatus addressKeyboardStatus, AutoShowType autoShowType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            autoShowType = addressKeyboardStatus.f38777a;
        }
        if ((i & 2) != 0) {
            z = addressKeyboardStatus.f38778b;
        }
        return addressKeyboardStatus.copy(autoShowType, z);
    }

    public final AutoShowType component1() {
        return this.f38777a;
    }

    public final boolean component2() {
        return this.f38778b;
    }

    public final AddressKeyboardStatus copy(AutoShowType autoShowType, boolean z) {
        Intrinsics.checkNotNullParameter(autoShowType, "showType");
        return new AddressKeyboardStatus(autoShowType, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressKeyboardStatus)) {
            return false;
        }
        AddressKeyboardStatus addressKeyboardStatus = (AddressKeyboardStatus) obj;
        return this.f38777a == addressKeyboardStatus.f38777a && this.f38778b == addressKeyboardStatus.f38778b;
    }

    public int hashCode() {
        int hashCode = this.f38777a.hashCode() * 31;
        boolean z = this.f38778b;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "AddressKeyboardStatus(showType=" + this.f38777a + ", alreadyLoaded=" + this.f38778b + VersionRange.RIGHT_OPEN;
    }

    public AddressKeyboardStatus(AutoShowType autoShowType, boolean z) {
        Intrinsics.checkNotNullParameter(autoShowType, "showType");
        this.f38777a = autoShowType;
        this.f38778b = z;
    }

    public final boolean getAlreadyLoaded() {
        return this.f38778b;
    }

    public final AutoShowType getShowType() {
        return this.f38777a;
    }

    public final void setAlreadyLoaded(boolean z) {
        this.f38778b = z;
    }

    public final void setShowType(AutoShowType autoShowType) {
        Intrinsics.checkNotNullParameter(autoShowType, "<set-?>");
        this.f38777a = autoShowType;
    }
}
