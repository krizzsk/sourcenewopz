package com.didi.entrega.order;

import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/entrega/order/CreateOrderCallBack;", "T", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "()V", "preOrderId", "", "getPreOrderId", "()Ljava/lang/String;", "setPreOrderId", "(Ljava/lang/String;)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderCallBack.kt */
public abstract class CreateOrderCallBack<T> extends CustomerRpcCallback<T> {
    private String preOrderId;

    public final String getPreOrderId() {
        return this.preOrderId;
    }

    public final void setPreOrderId(String str) {
        this.preOrderId = str;
    }
}
