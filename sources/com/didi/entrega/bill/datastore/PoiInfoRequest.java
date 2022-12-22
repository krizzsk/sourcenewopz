package com.didi.entrega.bill.datastore;

import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcPath;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/entrega/bill/datastore/PoiInfoRequest;", "Lcom/didi/entrega/bill/datastore/BillRequest;", "()V", "callback", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "getCallback", "()Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "setCallback", "(Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;)V", "getRequestName", "", "send", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillRequestFactory.kt */
public final class PoiInfoRequest extends BillRequest {

    /* renamed from: a */
    private CustomerRpcCallback<BillEntity> f19514a;

    public String getRequestName() {
        return CustomerRpcPath.POI_INFO;
    }

    public final CustomerRpcCallback<BillEntity> getCallback() {
        return this.f19514a;
    }

    public final void setCallback(CustomerRpcCallback<BillEntity> customerRpcCallback) {
        this.f19514a = customerRpcCallback;
    }

    public void send() {
        super.send();
        CustomerRpcManagerProxy.get().poiInfo(this.f19514a);
    }
}
