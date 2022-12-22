package com.didi.lockscreen.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/lockscreen/model/LockScreenModel;", "", "cbCheck", "", "(Z)V", "getCbCheck", "()Z", "setCbCheck", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LockScreenModel.kt */
public final class LockScreenModel {

    /* renamed from: a */
    private boolean f24403a;

    public LockScreenModel() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LockScreenModel copy$default(LockScreenModel lockScreenModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = lockScreenModel.f24403a;
        }
        return lockScreenModel.copy(z);
    }

    public final boolean component1() {
        return this.f24403a;
    }

    public final LockScreenModel copy(boolean z) {
        return new LockScreenModel(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LockScreenModel) && this.f24403a == ((LockScreenModel) obj).f24403a;
    }

    public int hashCode() {
        boolean z = this.f24403a;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "LockScreenModel(cbCheck=" + this.f24403a + VersionRange.RIGHT_OPEN;
    }

    public LockScreenModel(boolean z) {
        this.f24403a = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LockScreenModel(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getCbCheck() {
        return this.f24403a;
    }

    public final void setCbCheck(boolean z) {
        this.f24403a = z;
    }
}
