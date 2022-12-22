package com.didi.payment.wallet.global.wallet.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/entity/WalletRecordCountList;", "", "nextIndex", "", "walletRecordCountEntity", "Lcom/didi/payment/wallet/global/wallet/entity/WalletRecordCountEntity;", "(Ljava/lang/Integer;Lcom/didi/payment/wallet/global/wallet/entity/WalletRecordCountEntity;)V", "getNextIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWalletRecordCountEntity", "()Lcom/didi/payment/wallet/global/wallet/entity/WalletRecordCountEntity;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/didi/payment/wallet/global/wallet/entity/WalletRecordCountEntity;)Lcom/didi/payment/wallet/global/wallet/entity/WalletRecordCountList;", "equals", "", "other", "hashCode", "toString", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletRecordCountEntity.kt */
public final class WalletRecordCountList {
    @SerializedName("nextIndex")
    private final Integer nextIndex;
    @SerializedName("recordCount")
    private final WalletRecordCountEntity walletRecordCountEntity;

    public WalletRecordCountList() {
        this((Integer) null, (WalletRecordCountEntity) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WalletRecordCountList copy$default(WalletRecordCountList walletRecordCountList, Integer num, WalletRecordCountEntity walletRecordCountEntity2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = walletRecordCountList.nextIndex;
        }
        if ((i & 2) != 0) {
            walletRecordCountEntity2 = walletRecordCountList.walletRecordCountEntity;
        }
        return walletRecordCountList.copy(num, walletRecordCountEntity2);
    }

    public final Integer component1() {
        return this.nextIndex;
    }

    public final WalletRecordCountEntity component2() {
        return this.walletRecordCountEntity;
    }

    public final WalletRecordCountList copy(Integer num, WalletRecordCountEntity walletRecordCountEntity2) {
        return new WalletRecordCountList(num, walletRecordCountEntity2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletRecordCountList)) {
            return false;
        }
        WalletRecordCountList walletRecordCountList = (WalletRecordCountList) obj;
        return Intrinsics.areEqual((Object) this.nextIndex, (Object) walletRecordCountList.nextIndex) && Intrinsics.areEqual((Object) this.walletRecordCountEntity, (Object) walletRecordCountList.walletRecordCountEntity);
    }

    public int hashCode() {
        Integer num = this.nextIndex;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        WalletRecordCountEntity walletRecordCountEntity2 = this.walletRecordCountEntity;
        if (walletRecordCountEntity2 != null) {
            i = walletRecordCountEntity2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "WalletRecordCountList(nextIndex=" + this.nextIndex + ", walletRecordCountEntity=" + this.walletRecordCountEntity + VersionRange.RIGHT_OPEN;
    }

    public WalletRecordCountList(Integer num, WalletRecordCountEntity walletRecordCountEntity2) {
        this.nextIndex = num;
        this.walletRecordCountEntity = walletRecordCountEntity2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletRecordCountList(Integer num, WalletRecordCountEntity walletRecordCountEntity2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : walletRecordCountEntity2);
    }

    public final Integer getNextIndex() {
        return this.nextIndex;
    }

    public final WalletRecordCountEntity getWalletRecordCountEntity() {
        return this.walletRecordCountEntity;
    }
}
