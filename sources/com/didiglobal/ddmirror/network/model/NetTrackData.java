package com.didiglobal.ddmirror.network.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006'"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/network/model/NetTrackData;", "", "errType", "", "urlFlag", "", "keyPath", "keyValue", "traceID", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getErrType", "()Ljava/lang/Integer;", "setErrType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getKeyPath", "()Ljava/lang/String;", "setKeyPath", "(Ljava/lang/String;)V", "getKeyValue", "()Ljava/lang/Object;", "setKeyValue", "(Ljava/lang/Object;)V", "getTraceID", "setTraceID", "getUrlFlag", "setUrlFlag", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/didiglobal/ddmirror/network/model/NetTrackData;", "equals", "", "other", "hashCode", "toString", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NetTrackData.kt */
public final class NetTrackData {
    private Integer errType;
    private String keyPath;
    private Object keyValue;
    private String traceID;
    private String urlFlag;

    public static /* synthetic */ NetTrackData copy$default(NetTrackData netTrackData, Integer num, String str, String str2, Object obj, String str3, int i, Object obj2) {
        if ((i & 1) != 0) {
            num = netTrackData.errType;
        }
        if ((i & 2) != 0) {
            str = netTrackData.urlFlag;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = netTrackData.keyPath;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            obj = netTrackData.keyValue;
        }
        Object obj3 = obj;
        if ((i & 16) != 0) {
            str3 = netTrackData.traceID;
        }
        return netTrackData.copy(num, str4, str5, obj3, str3);
    }

    public final Integer component1() {
        return this.errType;
    }

    public final String component2() {
        return this.urlFlag;
    }

    public final String component3() {
        return this.keyPath;
    }

    public final Object component4() {
        return this.keyValue;
    }

    public final String component5() {
        return this.traceID;
    }

    public final NetTrackData copy(Integer num, String str, String str2, Object obj, String str3) {
        return new NetTrackData(num, str, str2, obj, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetTrackData)) {
            return false;
        }
        NetTrackData netTrackData = (NetTrackData) obj;
        return Intrinsics.areEqual((Object) this.errType, (Object) netTrackData.errType) && Intrinsics.areEqual((Object) this.urlFlag, (Object) netTrackData.urlFlag) && Intrinsics.areEqual((Object) this.keyPath, (Object) netTrackData.keyPath) && Intrinsics.areEqual(this.keyValue, netTrackData.keyValue) && Intrinsics.areEqual((Object) this.traceID, (Object) netTrackData.traceID);
    }

    public int hashCode() {
        Integer num = this.errType;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.urlFlag;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.keyPath;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj = this.keyValue;
        int hashCode4 = (hashCode3 + (obj != null ? obj.hashCode() : 0)) * 31;
        String str3 = this.traceID;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "NetTrackData(errType=" + this.errType + ", urlFlag=" + this.urlFlag + ", keyPath=" + this.keyPath + ", keyValue=" + this.keyValue + ", traceID=" + this.traceID + ")";
    }

    public NetTrackData(Integer num, String str, String str2, Object obj, String str3) {
        this.errType = num;
        this.urlFlag = str;
        this.keyPath = str2;
        this.keyValue = obj;
        this.traceID = str3;
    }

    public final Integer getErrType() {
        return this.errType;
    }

    public final void setErrType(Integer num) {
        this.errType = num;
    }

    public final String getUrlFlag() {
        return this.urlFlag;
    }

    public final void setUrlFlag(String str) {
        this.urlFlag = str;
    }

    public final String getKeyPath() {
        return this.keyPath;
    }

    public final void setKeyPath(String str) {
        this.keyPath = str;
    }

    public final Object getKeyValue() {
        return this.keyValue;
    }

    public final void setKeyValue(Object obj) {
        this.keyValue = obj;
    }

    public final String getTraceID() {
        return this.traceID;
    }

    public final void setTraceID(String str) {
        this.traceID = str;
    }
}
