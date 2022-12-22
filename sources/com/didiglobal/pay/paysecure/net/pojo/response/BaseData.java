package com.didiglobal.pay.paysecure.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/net/pojo/response/BaseData;", "Ljava/io/Serializable;", "()V", "errorData", "Lcom/didiglobal/pay/paysecure/net/pojo/response/ErrorData;", "getErrorData", "()Lcom/didiglobal/pay/paysecure/net/pojo/response/ErrorData;", "setErrorData", "(Lcom/didiglobal/pay/paysecure/net/pojo/response/ErrorData;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "isSuccess", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseData.kt */
public class BaseData implements Serializable {
    @SerializedName("error_data")
    private ErrorData errorData;
    private String status = "";

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.status = str;
    }

    public final boolean isSuccess() {
        return Intrinsics.areEqual((Object) this.status, (Object) "success");
    }

    public final ErrorData getErrorData() {
        return this.errorData;
    }

    public final void setErrorData(ErrorData errorData2) {
        this.errorData = errorData2;
    }
}
