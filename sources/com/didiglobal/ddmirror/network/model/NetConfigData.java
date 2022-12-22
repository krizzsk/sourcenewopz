package com.didiglobal.ddmirror.network.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BO\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J]\u0010\u001e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006%"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/network/model/NetConfigData;", "", "urlFlag", "", "", "bffKeyPath", "requestQueryRegex", "Lcom/didiglobal/ddmirror/network/model/Regx;", "requestBodyRegex", "responseRegex", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBffKeyPath", "()Ljava/lang/String;", "setBffKeyPath", "(Ljava/lang/String;)V", "getRequestBodyRegex", "()Ljava/util/List;", "setRequestBodyRegex", "(Ljava/util/List;)V", "getRequestQueryRegex", "setRequestQueryRegex", "getResponseRegex", "setResponseRegex", "getUrlFlag", "setUrlFlag", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: NetConfig.kt */
public final class NetConfigData {
    private String bffKeyPath;
    private List<Regx> requestBodyRegex;
    private List<Regx> requestQueryRegex;
    private List<Regx> responseRegex;
    private List<String> urlFlag;

    public static /* synthetic */ NetConfigData copy$default(NetConfigData netConfigData, List<String> list, String str, List<Regx> list2, List<Regx> list3, List<Regx> list4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = netConfigData.urlFlag;
        }
        if ((i & 2) != 0) {
            str = netConfigData.bffKeyPath;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list2 = netConfigData.requestQueryRegex;
        }
        List<Regx> list5 = list2;
        if ((i & 8) != 0) {
            list3 = netConfigData.requestBodyRegex;
        }
        List<Regx> list6 = list3;
        if ((i & 16) != 0) {
            list4 = netConfigData.responseRegex;
        }
        return netConfigData.copy(list, str2, list5, list6, list4);
    }

    public final List<String> component1() {
        return this.urlFlag;
    }

    public final String component2() {
        return this.bffKeyPath;
    }

    public final List<Regx> component3() {
        return this.requestQueryRegex;
    }

    public final List<Regx> component4() {
        return this.requestBodyRegex;
    }

    public final List<Regx> component5() {
        return this.responseRegex;
    }

    public final NetConfigData copy(List<String> list, String str, List<Regx> list2, List<Regx> list3, List<Regx> list4) {
        return new NetConfigData(list, str, list2, list3, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetConfigData)) {
            return false;
        }
        NetConfigData netConfigData = (NetConfigData) obj;
        return Intrinsics.areEqual((Object) this.urlFlag, (Object) netConfigData.urlFlag) && Intrinsics.areEqual((Object) this.bffKeyPath, (Object) netConfigData.bffKeyPath) && Intrinsics.areEqual((Object) this.requestQueryRegex, (Object) netConfigData.requestQueryRegex) && Intrinsics.areEqual((Object) this.requestBodyRegex, (Object) netConfigData.requestBodyRegex) && Intrinsics.areEqual((Object) this.responseRegex, (Object) netConfigData.responseRegex);
    }

    public int hashCode() {
        List<String> list = this.urlFlag;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.bffKeyPath;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<Regx> list2 = this.requestQueryRegex;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Regx> list3 = this.requestBodyRegex;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<Regx> list4 = this.responseRegex;
        if (list4 != null) {
            i = list4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "NetConfigData(urlFlag=" + this.urlFlag + ", bffKeyPath=" + this.bffKeyPath + ", requestQueryRegex=" + this.requestQueryRegex + ", requestBodyRegex=" + this.requestBodyRegex + ", responseRegex=" + this.responseRegex + ")";
    }

    public NetConfigData(List<String> list, String str, List<Regx> list2, List<Regx> list3, List<Regx> list4) {
        this.urlFlag = list;
        this.bffKeyPath = str;
        this.requestQueryRegex = list2;
        this.requestBodyRegex = list3;
        this.responseRegex = list4;
    }

    public final List<String> getUrlFlag() {
        return this.urlFlag;
    }

    public final void setUrlFlag(List<String> list) {
        this.urlFlag = list;
    }

    public final String getBffKeyPath() {
        return this.bffKeyPath;
    }

    public final void setBffKeyPath(String str) {
        this.bffKeyPath = str;
    }

    public final List<Regx> getRequestQueryRegex() {
        return this.requestQueryRegex;
    }

    public final void setRequestQueryRegex(List<Regx> list) {
        this.requestQueryRegex = list;
    }

    public final List<Regx> getRequestBodyRegex() {
        return this.requestBodyRegex;
    }

    public final void setRequestBodyRegex(List<Regx> list) {
        this.requestBodyRegex = list;
    }

    public final List<Regx> getResponseRegex() {
        return this.responseRegex;
    }

    public final void setResponseRegex(List<Regx> list) {
        this.responseRegex = list;
    }
}
