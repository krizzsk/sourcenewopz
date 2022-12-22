package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "", "result", "", "(Ljava/lang/Boolean;)V", "getResult", "()Ljava/lang/Boolean;", "setResult", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "equals", "other", "hashCode", "", "toString", "", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AgreePolicyResponse.kt */
public final class AgreePolicyResponse {
    @SerializedName("result")
    private Boolean result;

    public AgreePolicyResponse() {
        this((Boolean) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AgreePolicyResponse copy$default(AgreePolicyResponse agreePolicyResponse, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = agreePolicyResponse.result;
        }
        return agreePolicyResponse.copy(bool);
    }

    public final Boolean component1() {
        return this.result;
    }

    public final AgreePolicyResponse copy(Boolean bool) {
        return new AgreePolicyResponse(bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AgreePolicyResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((AgreePolicyResponse) obj).result);
    }

    public int hashCode() {
        Boolean bool = this.result;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "AgreePolicyResponse(result=" + this.result + VersionRange.RIGHT_OPEN;
    }

    public AgreePolicyResponse(Boolean bool) {
        this.result = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AgreePolicyResponse(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }

    public final Boolean getResult() {
        return this.result;
    }

    public final void setResult(Boolean bool) {
        this.result = bool;
    }
}
