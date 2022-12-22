package com.didi.wallet.dimina.rpc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/wallet/dimina/rpc/AntiCheatingEntity;", "", "data", "Lcom/didi/wallet/dimina/rpc/AntiCheatingEntity$AntiCheatingDataEntity;", "(Lcom/didi/wallet/dimina/rpc/AntiCheatingEntity$AntiCheatingDataEntity;)V", "getData", "()Lcom/didi/wallet/dimina/rpc/AntiCheatingEntity$AntiCheatingDataEntity;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AntiCheatingDataEntity", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletDiminaRpc.kt */
public final class AntiCheatingEntity {
    @SerializedName("data")
    private final AntiCheatingDataEntity data;

    public static /* synthetic */ AntiCheatingEntity copy$default(AntiCheatingEntity antiCheatingEntity, AntiCheatingDataEntity antiCheatingDataEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            antiCheatingDataEntity = antiCheatingEntity.data;
        }
        return antiCheatingEntity.copy(antiCheatingDataEntity);
    }

    public final AntiCheatingDataEntity component1() {
        return this.data;
    }

    public final AntiCheatingEntity copy(AntiCheatingDataEntity antiCheatingDataEntity) {
        return new AntiCheatingEntity(antiCheatingDataEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AntiCheatingEntity) && Intrinsics.areEqual((Object) this.data, (Object) ((AntiCheatingEntity) obj).data);
    }

    public int hashCode() {
        AntiCheatingDataEntity antiCheatingDataEntity = this.data;
        if (antiCheatingDataEntity == null) {
            return 0;
        }
        return antiCheatingDataEntity.hashCode();
    }

    public String toString() {
        return "AntiCheatingEntity(data=" + this.data + VersionRange.RIGHT_OPEN;
    }

    public AntiCheatingEntity(AntiCheatingDataEntity antiCheatingDataEntity) {
        this.data = antiCheatingDataEntity;
    }

    public final AntiCheatingDataEntity getData() {
        return this.data;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/wallet/dimina/rpc/AntiCheatingEntity$AntiCheatingDataEntity;", "", "accessFlag", "", "(Ljava/lang/Boolean;)V", "getAccessFlag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/didi/wallet/dimina/rpc/AntiCheatingEntity$AntiCheatingDataEntity;", "equals", "other", "hashCode", "", "toString", "", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletDiminaRpc.kt */
    public static final class AntiCheatingDataEntity {
        @SerializedName("accessFlag")
        private final Boolean accessFlag;

        public static /* synthetic */ AntiCheatingDataEntity copy$default(AntiCheatingDataEntity antiCheatingDataEntity, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = antiCheatingDataEntity.accessFlag;
            }
            return antiCheatingDataEntity.copy(bool);
        }

        public final Boolean component1() {
            return this.accessFlag;
        }

        public final AntiCheatingDataEntity copy(Boolean bool) {
            return new AntiCheatingDataEntity(bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AntiCheatingDataEntity) && Intrinsics.areEqual((Object) this.accessFlag, (Object) ((AntiCheatingDataEntity) obj).accessFlag);
        }

        public int hashCode() {
            Boolean bool = this.accessFlag;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public String toString() {
            return "AntiCheatingDataEntity(accessFlag=" + this.accessFlag + VersionRange.RIGHT_OPEN;
        }

        public AntiCheatingDataEntity(Boolean bool) {
            this.accessFlag = bool;
        }

        public final Boolean getAccessFlag() {
            return this.accessFlag;
        }
    }
}
