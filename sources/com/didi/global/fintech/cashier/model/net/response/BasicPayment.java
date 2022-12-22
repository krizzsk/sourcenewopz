package com.didi.global.fintech.cashier.model.net.response;

import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0003R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "Ljava/io/Serializable;", "channelId", "", "extraInfo", "Lcom/didi/global/fintech/cashier/model/net/response/Payment$ExtraInfo;", "(Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/model/net/response/Payment$ExtraInfo;)V", "getChannelId", "()Ljava/lang/Integer;", "setChannelId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExtraInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/Payment$ExtraInfo;", "setExtraInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/Payment$ExtraInfo;)V", "toString", "", "uniqueId", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayInfoResponse.kt */
public class BasicPayment implements Serializable {
    @SerializedName("channel_id")
    private Integer channelId;
    @SerializedName("extra_info")
    private Payment.ExtraInfo extraInfo;

    public BasicPayment() {
        this((Integer) null, (Payment.ExtraInfo) null, 3, (DefaultConstructorMarker) null);
    }

    public BasicPayment(Integer num, Payment.ExtraInfo extraInfo2) {
        this.channelId = num;
        this.extraInfo = extraInfo2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasicPayment(Integer num, Payment.ExtraInfo extraInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : extraInfo2);
    }

    public final Integer getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(Integer num) {
        this.channelId = num;
    }

    public final Payment.ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final void setExtraInfo(Payment.ExtraInfo extraInfo2) {
        this.extraInfo = extraInfo2;
    }

    public final int uniqueId() {
        return toString().hashCode();
    }

    public String toString() {
        return "BasicPayment(channelId=" + this.channelId + ",extraInfo=" + this.extraInfo + VersionRange.RIGHT_OPEN;
    }
}
