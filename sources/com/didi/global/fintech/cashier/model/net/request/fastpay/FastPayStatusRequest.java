package com.didi.global.fintech.cashier.model.net.request.fastpay;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayStatusRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayRequestCommonParams;", "pilot_switch", "", "password_token", "(Ljava/lang/String;Ljava/lang/String;)V", "getPassword_token", "()Ljava/lang/String;", "setPassword_token", "(Ljava/lang/String;)V", "getPilot_switch", "setPilot_switch", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayStatusRequest.kt */
public final class FastPayStatusRequest extends FastPayRequestCommonParams {
    @SerializedName("password_token")
    private String password_token;
    @SerializedName("pilot_switch")
    private String pilot_switch;

    public FastPayStatusRequest() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FastPayStatusRequest copy$default(FastPayStatusRequest fastPayStatusRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fastPayStatusRequest.pilot_switch;
        }
        if ((i & 2) != 0) {
            str2 = fastPayStatusRequest.password_token;
        }
        return fastPayStatusRequest.copy(str, str2);
    }

    public final String component1() {
        return this.pilot_switch;
    }

    public final String component2() {
        return this.password_token;
    }

    public final FastPayStatusRequest copy(String str, String str2) {
        return new FastPayStatusRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayStatusRequest)) {
            return false;
        }
        FastPayStatusRequest fastPayStatusRequest = (FastPayStatusRequest) obj;
        return Intrinsics.areEqual((Object) this.pilot_switch, (Object) fastPayStatusRequest.pilot_switch) && Intrinsics.areEqual((Object) this.password_token, (Object) fastPayStatusRequest.password_token);
    }

    public int hashCode() {
        String str = this.pilot_switch;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.password_token;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "FastPayStatusRequest(pilot_switch=" + this.pilot_switch + ", password_token=" + this.password_token + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastPayStatusRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getPilot_switch() {
        return this.pilot_switch;
    }

    public final void setPilot_switch(String str) {
        this.pilot_switch = str;
    }

    public final String getPassword_token() {
        return this.password_token;
    }

    public final void setPassword_token(String str) {
        this.password_token = str;
    }

    public FastPayStatusRequest(String str, String str2) {
        this.pilot_switch = str;
        this.password_token = str2;
    }
}
