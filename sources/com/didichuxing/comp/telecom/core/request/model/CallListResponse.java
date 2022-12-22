package com.didichuxing.comp.telecom.core.request.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/request/model/CallListResponse;", "", "data", "Lcom/didichuxing/comp/telecom/core/request/model/CallListModel;", "errmsg", "", "errno", "", "(Lcom/didichuxing/comp/telecom/core/request/model/CallListModel;Ljava/lang/String;Ljava/lang/Integer;)V", "getData", "()Lcom/didichuxing/comp/telecom/core/request/model/CallListModel;", "setData", "(Lcom/didichuxing/comp/telecom/core/request/model/CallListModel;)V", "getErrmsg", "()Ljava/lang/String;", "setErrmsg", "(Ljava/lang/String;)V", "getErrno", "()Ljava/lang/Integer;", "setErrno", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Lcom/didichuxing/comp/telecom/core/request/model/CallListModel;Ljava/lang/String;Ljava/lang/Integer;)Lcom/didichuxing/comp/telecom/core/request/model/CallListResponse;", "equals", "", "other", "hashCode", "toString", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallListResponse.kt */
public final class CallListResponse {
    @SerializedName("data")
    private CallListModel data;
    @SerializedName("errmsg")
    private String errmsg;
    @SerializedName("errno")
    private Integer errno;

    public static /* synthetic */ CallListResponse copy$default(CallListResponse callListResponse, CallListModel callListModel, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            callListModel = callListResponse.data;
        }
        if ((i & 2) != 0) {
            str = callListResponse.errmsg;
        }
        if ((i & 4) != 0) {
            num = callListResponse.errno;
        }
        return callListResponse.copy(callListModel, str, num);
    }

    public final CallListModel component1() {
        return this.data;
    }

    public final String component2() {
        return this.errmsg;
    }

    public final Integer component3() {
        return this.errno;
    }

    public final CallListResponse copy(CallListModel callListModel, String str, Integer num) {
        return new CallListResponse(callListModel, str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallListResponse)) {
            return false;
        }
        CallListResponse callListResponse = (CallListResponse) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) callListResponse.data) && Intrinsics.areEqual((Object) this.errmsg, (Object) callListResponse.errmsg) && Intrinsics.areEqual((Object) this.errno, (Object) callListResponse.errno);
    }

    public int hashCode() {
        CallListModel callListModel = this.data;
        int i = 0;
        int hashCode = (callListModel != null ? callListModel.hashCode() : 0) * 31;
        String str = this.errmsg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.errno;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CallListResponse(data=" + this.data + ", errmsg=" + this.errmsg + ", errno=" + this.errno + ")";
    }

    public CallListResponse(CallListModel callListModel, String str, Integer num) {
        this.data = callListModel;
        this.errmsg = str;
        this.errno = num;
    }

    public final CallListModel getData() {
        return this.data;
    }

    public final void setData(CallListModel callListModel) {
        this.data = callListModel;
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
