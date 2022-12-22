package com.didi.global.fintech.cashier.model.net.request;

import com.didi.global.fintech.cashier.model.net.response.PolicyData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/AgreePolicyRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "out_trade_id", "", "agree", "", "policy_info", "Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;)V", "getAgree", "()Ljava/lang/Boolean;", "setAgree", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getOut_trade_id", "()Ljava/lang/String;", "setOut_trade_id", "(Ljava/lang/String;)V", "getPolicy_info", "()Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;", "setPolicy_info", "(Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;)Lcom/didi/global/fintech/cashier/model/net/request/AgreePolicyRequest;", "equals", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AgreePolicyRequest.kt */
public final class AgreePolicyRequest extends CashierRequestCommonParams {
    @SerializedName("aggree")
    private Boolean agree;
    @SerializedName("out_trade_id")
    private String out_trade_id;
    @SerializedName("policy_info")
    private PolicyData policy_info;

    public AgreePolicyRequest() {
        this((String) null, (Boolean) null, (PolicyData) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AgreePolicyRequest copy$default(AgreePolicyRequest agreePolicyRequest, String str, Boolean bool, PolicyData policyData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = agreePolicyRequest.out_trade_id;
        }
        if ((i & 2) != 0) {
            bool = agreePolicyRequest.agree;
        }
        if ((i & 4) != 0) {
            policyData = agreePolicyRequest.policy_info;
        }
        return agreePolicyRequest.copy(str, bool, policyData);
    }

    public final String component1() {
        return this.out_trade_id;
    }

    public final Boolean component2() {
        return this.agree;
    }

    public final PolicyData component3() {
        return this.policy_info;
    }

    public final AgreePolicyRequest copy(String str, Boolean bool, PolicyData policyData) {
        return new AgreePolicyRequest(str, bool, policyData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgreePolicyRequest)) {
            return false;
        }
        AgreePolicyRequest agreePolicyRequest = (AgreePolicyRequest) obj;
        return Intrinsics.areEqual((Object) this.out_trade_id, (Object) agreePolicyRequest.out_trade_id) && Intrinsics.areEqual((Object) this.agree, (Object) agreePolicyRequest.agree) && Intrinsics.areEqual((Object) this.policy_info, (Object) agreePolicyRequest.policy_info);
    }

    public int hashCode() {
        String str = this.out_trade_id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.agree;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        PolicyData policyData = this.policy_info;
        if (policyData != null) {
            i = policyData.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "AgreePolicyRequest(out_trade_id=" + this.out_trade_id + ", agree=" + this.agree + ", policy_info=" + this.policy_info + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AgreePolicyRequest(String str, Boolean bool, PolicyData policyData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : policyData);
    }

    public final String getOut_trade_id() {
        return this.out_trade_id;
    }

    public final void setOut_trade_id(String str) {
        this.out_trade_id = str;
    }

    public final Boolean getAgree() {
        return this.agree;
    }

    public final void setAgree(Boolean bool) {
        this.agree = bool;
    }

    public final PolicyData getPolicy_info() {
        return this.policy_info;
    }

    public final void setPolicy_info(PolicyData policyData) {
        this.policy_info = policyData;
    }

    public AgreePolicyRequest(String str, Boolean bool, PolicyData policyData) {
        this.out_trade_id = str;
        this.agree = bool;
        this.policy_info = policyData;
    }
}
