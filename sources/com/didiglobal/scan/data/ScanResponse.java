package com.didiglobal.scan.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, mo175978d2 = {"Lcom/didiglobal/scan/data/ScanResponse;", "Ljava/io/Serializable;", "()V", "data", "Lcom/didiglobal/scan/data/ScanResultModel;", "getData", "()Lcom/didiglobal/scan/data/ScanResultModel;", "setData", "(Lcom/didiglobal/scan/data/ScanResultModel;)V", "errmsg", "", "getErrmsg", "()Ljava/lang/String;", "setErrmsg", "(Ljava/lang/String;)V", "errno", "", "getErrno", "()I", "setErrno", "(I)V", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ScanResponse.kt */
public final class ScanResponse implements Serializable {
    @SerializedName("data")
    private ScanResultModel data;
    @SerializedName("errmsg")
    private String errmsg = "";
    @SerializedName("errno")
    private int errno;

    public final int getErrno() {
        return this.errno;
    }

    public final void setErrno(int i) {
        this.errno = i;
    }

    public final String getErrmsg() {
        return this.errmsg;
    }

    public final void setErrmsg(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.errmsg = str;
    }

    public final ScanResultModel getData() {
        return this.data;
    }

    public final void setData(ScanResultModel scanResultModel) {
        this.data = scanResultModel;
    }
}
