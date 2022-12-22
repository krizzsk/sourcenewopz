package com.didi.wallet.dimina.rpc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/wallet/dimina/rpc/FastPayCashierEnvStringBody;", "", "thirdParty", "", "thirdPartyAbility", "(Ljava/lang/String;Ljava/lang/String;)V", "getThirdParty", "()Ljava/lang/String;", "getThirdPartyAbility", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletDiminaRpc.kt */
public final class FastPayCashierEnvStringBody {
    @SerializedName("thirdParty")
    private final String thirdParty;
    @SerializedName("thirdPartyAbility")
    private final String thirdPartyAbility;

    public static /* synthetic */ FastPayCashierEnvStringBody copy$default(FastPayCashierEnvStringBody fastPayCashierEnvStringBody, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPayCashierEnvStringBody.thirdParty;
        }
        if ((i & 2) != 0) {
            str2 = fastPayCashierEnvStringBody.thirdPartyAbility;
        }
        return fastPayCashierEnvStringBody.copy(str, str2);
    }

    public final String component1() {
        return this.thirdParty;
    }

    public final String component2() {
        return this.thirdPartyAbility;
    }

    public final FastPayCashierEnvStringBody copy(String str, String str2) {
        return new FastPayCashierEnvStringBody(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayCashierEnvStringBody)) {
            return false;
        }
        FastPayCashierEnvStringBody fastPayCashierEnvStringBody = (FastPayCashierEnvStringBody) obj;
        return Intrinsics.areEqual((Object) this.thirdParty, (Object) fastPayCashierEnvStringBody.thirdParty) && Intrinsics.areEqual((Object) this.thirdPartyAbility, (Object) fastPayCashierEnvStringBody.thirdPartyAbility);
    }

    public int hashCode() {
        String str = this.thirdParty;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.thirdPartyAbility;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "FastPayCashierEnvStringBody(thirdParty=" + this.thirdParty + ", thirdPartyAbility=" + this.thirdPartyAbility + VersionRange.RIGHT_OPEN;
    }

    public FastPayCashierEnvStringBody(String str, String str2) {
        this.thirdParty = str;
        this.thirdPartyAbility = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastPayCashierEnvStringBody(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getThirdParty() {
        return this.thirdParty;
    }

    public final String getThirdPartyAbility() {
        return this.thirdPartyAbility;
    }
}
