package com.didi.payment.pix.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixTopUpOptionResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/pix/net/response/PixTopUpOption;", "getData", "()Lcom/didi/payment/pix/net/response/PixTopUpOption;", "setData", "(Lcom/didi/payment/pix/net/response/PixTopUpOption;)V", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTopUpOptionResp.kt */
public final class PixTopUpOptionResp extends WBaseResp {
    private PixTopUpOption data;

    public final PixTopUpOption getData() {
        return this.data;
    }

    public final void setData(PixTopUpOption pixTopUpOption) {
        this.data = pixTopUpOption;
    }
}
