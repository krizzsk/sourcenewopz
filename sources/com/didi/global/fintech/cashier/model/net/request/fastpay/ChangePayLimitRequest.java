package com.didi.global.fintech.cashier.model.net.request.fastpay;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayLimitRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayRequestCommonParams;", "to_amount", "", "password_token", "user_id", "role", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPassword_token", "()Ljava/lang/String;", "setPassword_token", "(Ljava/lang/String;)V", "getRole", "setRole", "getTo_amount", "setTo_amount", "getUser_id", "setUser_id", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChangePayLimitRequest.kt */
public final class ChangePayLimitRequest extends FastPayRequestCommonParams {
    @SerializedName("password_token")
    private String password_token;
    @SerializedName("role")
    private String role;
    @SerializedName("to_amount")
    private String to_amount;
    @SerializedName("user_id")
    private String user_id;

    public ChangePayLimitRequest() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChangePayLimitRequest copy$default(ChangePayLimitRequest changePayLimitRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = changePayLimitRequest.to_amount;
        }
        if ((i & 2) != 0) {
            str2 = changePayLimitRequest.password_token;
        }
        if ((i & 4) != 0) {
            str3 = changePayLimitRequest.user_id;
        }
        if ((i & 8) != 0) {
            str4 = changePayLimitRequest.role;
        }
        return changePayLimitRequest.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.to_amount;
    }

    public final String component2() {
        return this.password_token;
    }

    public final String component3() {
        return this.user_id;
    }

    public final String component4() {
        return this.role;
    }

    public final ChangePayLimitRequest copy(String str, String str2, String str3, String str4) {
        return new ChangePayLimitRequest(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangePayLimitRequest)) {
            return false;
        }
        ChangePayLimitRequest changePayLimitRequest = (ChangePayLimitRequest) obj;
        return Intrinsics.areEqual((Object) this.to_amount, (Object) changePayLimitRequest.to_amount) && Intrinsics.areEqual((Object) this.password_token, (Object) changePayLimitRequest.password_token) && Intrinsics.areEqual((Object) this.user_id, (Object) changePayLimitRequest.user_id) && Intrinsics.areEqual((Object) this.role, (Object) changePayLimitRequest.role);
    }

    public int hashCode() {
        String str = this.to_amount;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.password_token;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.user_id;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.role;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ChangePayLimitRequest(to_amount=" + this.to_amount + ", password_token=" + this.password_token + ", user_id=" + this.user_id + ", role=" + this.role + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChangePayLimitRequest(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getTo_amount() {
        return this.to_amount;
    }

    public final void setTo_amount(String str) {
        this.to_amount = str;
    }

    public final String getPassword_token() {
        return this.password_token;
    }

    public final void setPassword_token(String str) {
        this.password_token = str;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final void setUser_id(String str) {
        this.user_id = str;
    }

    public final String getRole() {
        return this.role;
    }

    public final void setRole(String str) {
        this.role = str;
    }

    public ChangePayLimitRequest(String str, String str2, String str3, String str4) {
        this.to_amount = str;
        this.password_token = str2;
        this.user_id = str3;
        this.role = str4;
    }
}
