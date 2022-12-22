package com.didi.entrega.bill.datastore;

import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcPath;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.CouponInfo;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.rpc.entity.TipFeeInfo;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00107\u001a\u00020\u000bH\u0016J\b\u00108\u001a\u000209H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006:"}, mo175978d2 = {"Lcom/didi/entrega/bill/datastore/BillUpdateRequest;", "Lcom/didi/entrega/bill/datastore/BillRequest;", "()V", "callback", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "getCallback", "()Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "setCallback", "(Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;)V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "packageInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "getPackageInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "setPackageInfo", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;)V", "payChannel", "Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "getPayChannel", "()Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "setPayChannel", "(Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;)V", "platCoupon", "Lcom/didi/entrega/customer/foundation/rpc/entity/CouponInfo;", "getPlatCoupon", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CouponInfo;", "setPlatCoupon", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CouponInfo;)V", "receiverAddress", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "getReceiverAddress", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "setReceiverAddress", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;)V", "senderAddress", "getSenderAddress", "setSenderAddress", "tipFee", "Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo;", "getTipFee", "()Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo;", "setTipFee", "(Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo;)V", "updateType", "", "getUpdateType", "()I", "setUpdateType", "(I)V", "getRequestName", "send", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillRequestFactory.kt */
public final class BillUpdateRequest extends BillRequest {

    /* renamed from: a */
    private String f19505a;

    /* renamed from: b */
    private int f19506b = -1;

    /* renamed from: c */
    private AddressEntity f19507c = ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).getSendContact();

    /* renamed from: d */
    private AddressEntity f19508d = ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).getReceiveContact();

    /* renamed from: e */
    private ContactStufEntity f19509e;

    /* renamed from: f */
    private PayChannel f19510f;

    /* renamed from: g */
    private TipFeeInfo f19511g;

    /* renamed from: h */
    private CouponInfo f19512h;

    /* renamed from: i */
    private CustomerRpcCallback<BillEntity> f19513i;

    public String getRequestName() {
        return CustomerRpcPath.BILL_UPDATE;
    }

    public final String getCartId() {
        return this.f19505a;
    }

    public final void setCartId(String str) {
        this.f19505a = str;
    }

    public final int getUpdateType() {
        return this.f19506b;
    }

    public final void setUpdateType(int i) {
        this.f19506b = i;
    }

    public final AddressEntity getSenderAddress() {
        return this.f19507c;
    }

    public final void setSenderAddress(AddressEntity addressEntity) {
        this.f19507c = addressEntity;
    }

    public final AddressEntity getReceiverAddress() {
        return this.f19508d;
    }

    public final void setReceiverAddress(AddressEntity addressEntity) {
        this.f19508d = addressEntity;
    }

    public final ContactStufEntity getPackageInfo() {
        return this.f19509e;
    }

    public final void setPackageInfo(ContactStufEntity contactStufEntity) {
        this.f19509e = contactStufEntity;
    }

    public final PayChannel getPayChannel() {
        return this.f19510f;
    }

    public final void setPayChannel(PayChannel payChannel) {
        this.f19510f = payChannel;
    }

    public final TipFeeInfo getTipFee() {
        return this.f19511g;
    }

    public final void setTipFee(TipFeeInfo tipFeeInfo) {
        this.f19511g = tipFeeInfo;
    }

    public final CouponInfo getPlatCoupon() {
        return this.f19512h;
    }

    public final void setPlatCoupon(CouponInfo couponInfo) {
        this.f19512h = couponInfo;
    }

    public final CustomerRpcCallback<BillEntity> getCallback() {
        return this.f19513i;
    }

    public final void setCallback(CustomerRpcCallback<BillEntity> customerRpcCallback) {
        this.f19513i = customerRpcCallback;
    }

    public void send() {
        super.send();
        CustomerRpcManagerProxy.get().billUpdate(this.f19505a, this.f19506b, this.f19507c, this.f19508d, this.f19509e, this.f19510f, this.f19511g, this.f19512h, this.f19513i);
    }
}
