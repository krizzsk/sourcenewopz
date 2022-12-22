package com.didi.payment.wallet.global.model.resp;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOptionList;", "", "options", "", "Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOption;", "(Ljava/util/List;)V", "getOptions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletBalanceOptionResp.kt */
public final class WalletBalanceOptionList {
    @SerializedName("options")
    private final List<WalletBalanceOption> options;

    public WalletBalanceOptionList() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WalletBalanceOptionList copy$default(WalletBalanceOptionList walletBalanceOptionList, List<WalletBalanceOption> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = walletBalanceOptionList.options;
        }
        return walletBalanceOptionList.copy(list);
    }

    public final List<WalletBalanceOption> component1() {
        return this.options;
    }

    public final WalletBalanceOptionList copy(List<WalletBalanceOption> list) {
        return new WalletBalanceOptionList(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletBalanceOptionList) && Intrinsics.areEqual((Object) this.options, (Object) ((WalletBalanceOptionList) obj).options);
    }

    public int hashCode() {
        List<WalletBalanceOption> list = this.options;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "WalletBalanceOptionList(options=" + this.options + VersionRange.RIGHT_OPEN;
    }

    public WalletBalanceOptionList(List<WalletBalanceOption> list) {
        this.options = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletBalanceOptionList(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<WalletBalanceOption> getOptions() {
        return this.options;
    }
}
