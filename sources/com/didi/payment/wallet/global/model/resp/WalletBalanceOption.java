package com.didi.payment.wallet.global.model.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0013\u001a\u00020\u0005J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOption;", "", "label", "", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getLabel", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOption;", "equals", "", "other", "getOptionType", "hashCode", "toString", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletBalanceOptionResp.kt */
public final class WalletBalanceOption {
    @SerializedName("label")
    private final String label;
    @SerializedName("type")
    private final Integer type;

    public WalletBalanceOption() {
        this((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WalletBalanceOption copy$default(WalletBalanceOption walletBalanceOption, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = walletBalanceOption.label;
        }
        if ((i & 2) != 0) {
            num = walletBalanceOption.type;
        }
        return walletBalanceOption.copy(str, num);
    }

    public final String component1() {
        return this.label;
    }

    public final Integer component2() {
        return this.type;
    }

    public final WalletBalanceOption copy(String str, Integer num) {
        return new WalletBalanceOption(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletBalanceOption)) {
            return false;
        }
        WalletBalanceOption walletBalanceOption = (WalletBalanceOption) obj;
        return Intrinsics.areEqual((Object) this.label, (Object) walletBalanceOption.label) && Intrinsics.areEqual((Object) this.type, (Object) walletBalanceOption.type);
    }

    public int hashCode() {
        String str = this.label;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.type;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "WalletBalanceOption(label=" + this.label + ", type=" + this.type + VersionRange.RIGHT_OPEN;
    }

    public WalletBalanceOption(String str, Integer num) {
        this.label = str;
        this.type = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletBalanceOption(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
    }

    public final String getLabel() {
        return this.label;
    }

    public final Integer getType() {
        return this.type;
    }

    public final int getOptionType() {
        Integer num = this.type;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}
