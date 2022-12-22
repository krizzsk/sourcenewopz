package global.didi.pay.threeds.network.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001d"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/model/ThreedsBaseResponse;", "T", "Ljava/io/Serializable;", "()V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errNo", "", "getErrNo", "()I", "setErrNo", "(I)V", "innerErrMsg", "getInnerErrMsg", "setInnerErrMsg", "innerErrNo", "getInnerErrNo", "setInnerErrNo", "toString", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsBaseResponse.kt */
public class ThreedsBaseResponse<T> implements Serializable {
    private T data;
    private String errMsg;
    private int errNo = -1;
    private String innerErrMsg;
    private String innerErrNo;

    public final int getErrNo() {
        return this.errNo;
    }

    public final void setErrNo(int i) {
        this.errNo = i;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final void setErrMsg(String str) {
        this.errMsg = str;
    }

    public final String getInnerErrNo() {
        return this.innerErrNo;
    }

    public final void setInnerErrNo(String str) {
        this.innerErrNo = str;
    }

    public final String getInnerErrMsg() {
        return this.innerErrMsg;
    }

    public final void setInnerErrMsg(String str) {
        this.innerErrMsg = str;
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T t) {
        this.data = t;
    }

    public String toString() {
        return "error:" + this.errNo + " ,errmsg:" + this.errMsg + ", data:" + this.data;
    }
}
