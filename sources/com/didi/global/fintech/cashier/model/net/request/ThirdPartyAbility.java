package com.didi.global.fintech.cashier.model.net.request;

import com.didi.unifiedPay.sdk.net.BaseParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/ThirdPartyAbility;", "Ljava/io/Serializable;", "virtual_3ds_sdk_version", "", "(Ljava/lang/String;)V", "getVirtual_3ds_sdk_version", "()Ljava/lang/String;", "setVirtual_3ds_sdk_version", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "update3DSSdkVersion", "version", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierRequestCommonParams.kt */
public final class ThirdPartyAbility implements Serializable {
    @SerializedName("virtual_3ds_sdk_version")
    private String virtual_3ds_sdk_version;

    public ThirdPartyAbility() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ThirdPartyAbility copy$default(ThirdPartyAbility thirdPartyAbility, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = thirdPartyAbility.virtual_3ds_sdk_version;
        }
        return thirdPartyAbility.copy(str);
    }

    public final String component1() {
        return this.virtual_3ds_sdk_version;
    }

    public final ThirdPartyAbility copy(String str) {
        Intrinsics.checkNotNullParameter(str, BaseParam.PARAM_VIRTUAL_3DS_SDK_VERSION);
        return new ThirdPartyAbility(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThirdPartyAbility) && Intrinsics.areEqual((Object) this.virtual_3ds_sdk_version, (Object) ((ThirdPartyAbility) obj).virtual_3ds_sdk_version);
    }

    public int hashCode() {
        return this.virtual_3ds_sdk_version.hashCode();
    }

    public String toString() {
        return "ThirdPartyAbility(virtual_3ds_sdk_version=" + this.virtual_3ds_sdk_version + VersionRange.RIGHT_OPEN;
    }

    public ThirdPartyAbility(String str) {
        Intrinsics.checkNotNullParameter(str, BaseParam.PARAM_VIRTUAL_3DS_SDK_VERSION);
        this.virtual_3ds_sdk_version = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThirdPartyAbility(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "1.1" : str);
    }

    public final String getVirtual_3ds_sdk_version() {
        return this.virtual_3ds_sdk_version;
    }

    public final void setVirtual_3ds_sdk_version(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.virtual_3ds_sdk_version = str;
    }

    public final ThirdPartyAbility update3DSSdkVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "version");
        ThirdPartyAbility thirdPartyAbility = this;
        thirdPartyAbility.setVirtual_3ds_sdk_version(str);
        return thirdPartyAbility;
    }
}
