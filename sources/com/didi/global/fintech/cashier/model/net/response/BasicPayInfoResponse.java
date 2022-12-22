package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/BasicPayInfoResponse;", "Ljava/io/Serializable;", "payStatus", "", "(I)V", "getPayStatus", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BasicPayInfoResponse.kt */
public final class BasicPayInfoResponse implements Serializable {
    @SerializedName("pay_status")
    private final int payStatus;

    public static /* synthetic */ BasicPayInfoResponse copy$default(BasicPayInfoResponse basicPayInfoResponse, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = basicPayInfoResponse.payStatus;
        }
        return basicPayInfoResponse.copy(i);
    }

    public final int component1() {
        return this.payStatus;
    }

    public final BasicPayInfoResponse copy(int i) {
        return new BasicPayInfoResponse(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BasicPayInfoResponse) && this.payStatus == ((BasicPayInfoResponse) obj).payStatus;
    }

    public int hashCode() {
        return this.payStatus;
    }

    public String toString() {
        return "BasicPayInfoResponse(payStatus=" + this.payStatus + VersionRange.RIGHT_OPEN;
    }

    public BasicPayInfoResponse(int i) {
        this.payStatus = i;
    }

    public final int getPayStatus() {
        return this.payStatus;
    }
}
