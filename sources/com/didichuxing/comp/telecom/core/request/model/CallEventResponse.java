package com.didichuxing.comp.telecom.core.request.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/request/model/CallEventResponse;", "", "errmsg", "", "errno", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getErrmsg", "()Ljava/lang/String;", "setErrmsg", "(Ljava/lang/String;)V", "getErrno", "()Ljava/lang/Integer;", "setErrno", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/didichuxing/comp/telecom/core/request/model/CallEventResponse;", "equals", "", "other", "hashCode", "toString", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallEventResponse.kt */
public final class CallEventResponse {
    @SerializedName("errmsg")
    private String errmsg;
    @SerializedName("errno")
    private Integer errno;

    public static /* synthetic */ CallEventResponse copy$default(CallEventResponse callEventResponse, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = callEventResponse.errmsg;
        }
        if ((i & 2) != 0) {
            num = callEventResponse.errno;
        }
        return callEventResponse.copy(str, num);
    }

    public final String component1() {
        return this.errmsg;
    }

    public final Integer component2() {
        return this.errno;
    }

    public final CallEventResponse copy(String str, Integer num) {
        return new CallEventResponse(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallEventResponse)) {
            return false;
        }
        CallEventResponse callEventResponse = (CallEventResponse) obj;
        return Intrinsics.areEqual((Object) this.errmsg, (Object) callEventResponse.errmsg) && Intrinsics.areEqual((Object) this.errno, (Object) callEventResponse.errno);
    }

    public int hashCode() {
        String str = this.errmsg;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.errno;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CallEventResponse(errmsg=" + this.errmsg + ", errno=" + this.errno + ")";
    }

    public CallEventResponse(String str, Integer num) {
        this.errmsg = str;
        this.errno = num;
    }

    public final String getErrmsg() {
        return this.errmsg;
    }

    public final void setErrmsg(String str) {
        this.errmsg = str;
    }

    public final Integer getErrno() {
        return this.errno;
    }

    public final void setErrno(Integer num) {
        this.errno = num;
    }
}
