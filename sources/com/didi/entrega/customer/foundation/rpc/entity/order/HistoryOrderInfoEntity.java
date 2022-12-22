package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001d\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001c\u0010#\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000e¨\u0006'"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/HistoryOrderInfoEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "cityId", "", "getCityId", "()I", "setCityId", "(I)V", "createTime", "", "getCreateTime", "()Ljava/lang/String;", "setCreateTime", "(Ljava/lang/String;)V", "debtStatus", "getDebtStatus", "setDebtStatus", "isComplete", "setComplete", "orderId", "getOrderId", "setOrderId", "receiverAddressDisplay", "getReceiverAddressDisplay", "setReceiverAddressDisplay", "senderAddressDisplay", "getSenderAddressDisplay", "setSenderAddressDisplay", "serviceDesc", "getServiceDesc", "setServiceDesc", "status", "getStatus", "setStatus", "statusDesc", "getStatusDesc", "setStatusDesc", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HistoryOrderListEntity.kt */
public final class HistoryOrderInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 6874940760248549529L;
    private int cityId;
    private String createTime;
    private int debtStatus;
    private int isComplete;
    private String orderId;
    private String receiverAddressDisplay;
    private String senderAddressDisplay;
    private String serviceDesc;
    private int status;
    private String statusDesc;

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final int getCityId() {
        return this.cityId;
    }

    public final void setCityId(int i) {
        this.cityId = i;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(String str) {
        this.createTime = str;
    }

    public final String getServiceDesc() {
        return this.serviceDesc;
    }

    public final void setServiceDesc(String str) {
        this.serviceDesc = str;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final void setStatusDesc(String str) {
        this.statusDesc = str;
    }

    public final String getSenderAddressDisplay() {
        return this.senderAddressDisplay;
    }

    public final void setSenderAddressDisplay(String str) {
        this.senderAddressDisplay = str;
    }

    public final String getReceiverAddressDisplay() {
        return this.receiverAddressDisplay;
    }

    public final void setReceiverAddressDisplay(String str) {
        this.receiverAddressDisplay = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final int getDebtStatus() {
        return this.debtStatus;
    }

    public final void setDebtStatus(int i) {
        this.debtStatus = i;
    }

    public final int isComplete() {
        return this.isComplete;
    }

    public final void setComplete(int i) {
        this.isComplete = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/HistoryOrderInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HistoryOrderListEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
