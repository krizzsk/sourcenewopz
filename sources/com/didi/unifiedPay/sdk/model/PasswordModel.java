package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/unifiedPay/sdk/model/PasswordModel;", "Ljava/io/Serializable;", "status", "", "paySessionId", "set", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getPaySessionId", "()Ljava/lang/String;", "setPaySessionId", "(Ljava/lang/String;)V", "getSet", "()Ljava/lang/Integer;", "setSet", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStatus", "setStatus", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/didi/unifiedPay/sdk/model/PasswordModel;", "equals", "", "other", "", "hashCode", "toString", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PasswordModel.kt */
public final class PasswordModel implements Serializable {
    @SerializedName("pay_session_id")
    private String paySessionId;
    @SerializedName("is_set")
    private Integer set;
    private String status;

    public static /* synthetic */ PasswordModel copy$default(PasswordModel passwordModel, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = passwordModel.status;
        }
        if ((i & 2) != 0) {
            str2 = passwordModel.paySessionId;
        }
        if ((i & 4) != 0) {
            num = passwordModel.set;
        }
        return passwordModel.copy(str, str2, num);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.paySessionId;
    }

    public final Integer component3() {
        return this.set;
    }

    public final PasswordModel copy(String str, String str2, Integer num) {
        return new PasswordModel(str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PasswordModel)) {
            return false;
        }
        PasswordModel passwordModel = (PasswordModel) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) passwordModel.status) && Intrinsics.areEqual((Object) this.paySessionId, (Object) passwordModel.paySessionId) && Intrinsics.areEqual((Object) this.set, (Object) passwordModel.set);
    }

    public int hashCode() {
        String str = this.status;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.paySessionId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.set;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "PasswordModel(status=" + this.status + ", paySessionId=" + this.paySessionId + ", set=" + this.set + VersionRange.RIGHT_OPEN;
    }

    public PasswordModel(String str, String str2, Integer num) {
        this.status = str;
        this.paySessionId = str2;
        this.set = num;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getPaySessionId() {
        return this.paySessionId;
    }

    public final void setPaySessionId(String str) {
        this.paySessionId = str;
    }

    public final Integer getSet() {
        return this.set;
    }

    public final void setSet(Integer num) {
        this.set = num;
    }
}
