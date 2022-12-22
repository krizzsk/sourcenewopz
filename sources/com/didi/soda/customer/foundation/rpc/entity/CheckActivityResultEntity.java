package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/CheckActivityResultEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "hitAct", "", "toast", "Lcom/didi/soda/customer/foundation/rpc/entity/ToastInfoEntity;", "(ILcom/didi/soda/customer/foundation/rpc/entity/ToastInfoEntity;)V", "getHitAct", "()I", "setHitAct", "(I)V", "getToast", "()Lcom/didi/soda/customer/foundation/rpc/entity/ToastInfoEntity;", "setToast", "(Lcom/didi/soda/customer/foundation/rpc/entity/ToastInfoEntity;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CheckActivityResultEntity.kt */
public final class CheckActivityResultEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -3415504172274520015L;
    private int hitAct;
    private ToastInfoEntity toast;

    public static /* synthetic */ CheckActivityResultEntity copy$default(CheckActivityResultEntity checkActivityResultEntity, int i, ToastInfoEntity toastInfoEntity, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = checkActivityResultEntity.hitAct;
        }
        if ((i2 & 2) != 0) {
            toastInfoEntity = checkActivityResultEntity.toast;
        }
        return checkActivityResultEntity.copy(i, toastInfoEntity);
    }

    public final int component1() {
        return this.hitAct;
    }

    public final ToastInfoEntity component2() {
        return this.toast;
    }

    public final CheckActivityResultEntity copy(int i, ToastInfoEntity toastInfoEntity) {
        return new CheckActivityResultEntity(i, toastInfoEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckActivityResultEntity)) {
            return false;
        }
        CheckActivityResultEntity checkActivityResultEntity = (CheckActivityResultEntity) obj;
        return this.hitAct == checkActivityResultEntity.hitAct && Intrinsics.areEqual((Object) this.toast, (Object) checkActivityResultEntity.toast);
    }

    public int hashCode() {
        int i = this.hitAct * 31;
        ToastInfoEntity toastInfoEntity = this.toast;
        return i + (toastInfoEntity == null ? 0 : toastInfoEntity.hashCode());
    }

    public String toString() {
        return "CheckActivityResultEntity(hitAct=" + this.hitAct + ", toast=" + this.toast + VersionRange.RIGHT_OPEN;
    }

    public CheckActivityResultEntity(int i, ToastInfoEntity toastInfoEntity) {
        this.hitAct = i;
        this.toast = toastInfoEntity;
    }

    public final int getHitAct() {
        return this.hitAct;
    }

    public final void setHitAct(int i) {
        this.hitAct = i;
    }

    public final ToastInfoEntity getToast() {
        return this.toast;
    }

    public final void setToast(ToastInfoEntity toastInfoEntity) {
        this.toast = toastInfoEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/CheckActivityResultEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CheckActivityResultEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
