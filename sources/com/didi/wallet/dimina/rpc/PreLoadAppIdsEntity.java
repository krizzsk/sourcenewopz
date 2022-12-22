package com.didi.wallet.dimina.rpc;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/wallet/dimina/rpc/PreLoadAppIdsEntity;", "", "data", "Lcom/didi/wallet/dimina/rpc/PreLoadAppIdsEntity$PreLoadAppIdEntity;", "(Lcom/didi/wallet/dimina/rpc/PreLoadAppIdsEntity$PreLoadAppIdEntity;)V", "getData", "()Lcom/didi/wallet/dimina/rpc/PreLoadAppIdsEntity$PreLoadAppIdEntity;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "PreLoadAppIdEntity", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletDiminaRpc.kt */
public final class PreLoadAppIdsEntity {
    @SerializedName("data")
    private final PreLoadAppIdEntity data;

    public static /* synthetic */ PreLoadAppIdsEntity copy$default(PreLoadAppIdsEntity preLoadAppIdsEntity, PreLoadAppIdEntity preLoadAppIdEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            preLoadAppIdEntity = preLoadAppIdsEntity.data;
        }
        return preLoadAppIdsEntity.copy(preLoadAppIdEntity);
    }

    public final PreLoadAppIdEntity component1() {
        return this.data;
    }

    public final PreLoadAppIdsEntity copy(PreLoadAppIdEntity preLoadAppIdEntity) {
        return new PreLoadAppIdsEntity(preLoadAppIdEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PreLoadAppIdsEntity) && Intrinsics.areEqual((Object) this.data, (Object) ((PreLoadAppIdsEntity) obj).data);
    }

    public int hashCode() {
        PreLoadAppIdEntity preLoadAppIdEntity = this.data;
        if (preLoadAppIdEntity == null) {
            return 0;
        }
        return preLoadAppIdEntity.hashCode();
    }

    public String toString() {
        return "PreLoadAppIdsEntity(data=" + this.data + VersionRange.RIGHT_OPEN;
    }

    public PreLoadAppIdsEntity(PreLoadAppIdEntity preLoadAppIdEntity) {
        this.data = preLoadAppIdEntity;
    }

    public final PreLoadAppIdEntity getData() {
        return this.data;
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/wallet/dimina/rpc/PreLoadAppIdsEntity$PreLoadAppIdEntity;", "", "appIds", "", "", "(Ljava/util/List;)V", "getAppIds", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletDiminaRpc.kt */
    public static final class PreLoadAppIdEntity {
        @SerializedName("appIds")
        private final List<String> appIds;

        public static /* synthetic */ PreLoadAppIdEntity copy$default(PreLoadAppIdEntity preLoadAppIdEntity, List<String> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = preLoadAppIdEntity.appIds;
            }
            return preLoadAppIdEntity.copy(list);
        }

        public final List<String> component1() {
            return this.appIds;
        }

        public final PreLoadAppIdEntity copy(List<String> list) {
            return new PreLoadAppIdEntity(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PreLoadAppIdEntity) && Intrinsics.areEqual((Object) this.appIds, (Object) ((PreLoadAppIdEntity) obj).appIds);
        }

        public int hashCode() {
            List<String> list = this.appIds;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "PreLoadAppIdEntity(appIds=" + this.appIds + VersionRange.RIGHT_OPEN;
        }

        public PreLoadAppIdEntity(List<String> list) {
            this.appIds = list;
        }

        public final List<String> getAppIds() {
            return this.appIds;
        }
    }
}
