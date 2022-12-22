package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayOrderResponse;", "Ljava/io/Serializable;", "useNewVersion", "", "(Z)V", "getUseNewVersion", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChangePayOrderResponse.kt */
public final class ChangePayOrderResponse implements Serializable {
    @SerializedName("use_new_version")
    private final boolean useNewVersion;

    public static /* synthetic */ ChangePayOrderResponse copy$default(ChangePayOrderResponse changePayOrderResponse, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = changePayOrderResponse.useNewVersion;
        }
        return changePayOrderResponse.copy(z);
    }

    public final boolean component1() {
        return this.useNewVersion;
    }

    public final ChangePayOrderResponse copy(boolean z) {
        return new ChangePayOrderResponse(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChangePayOrderResponse) && this.useNewVersion == ((ChangePayOrderResponse) obj).useNewVersion;
    }

    public int hashCode() {
        boolean z = this.useNewVersion;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "ChangePayOrderResponse(useNewVersion=" + this.useNewVersion + VersionRange.RIGHT_OPEN;
    }

    public ChangePayOrderResponse(boolean z) {
        this.useNewVersion = z;
    }

    public final boolean getUseNewVersion() {
        return this.useNewVersion;
    }
}
