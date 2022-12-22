package com.didi.entrega.foundation.rpc.entity;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.entrega.security.model.RiskControlModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001c\u0010*\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001c\u0010-\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001c\u00100\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011¨\u00064"}, mo175978d2 = {"Lcom/didi/entrega/foundation/rpc/entity/OrderCreateEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "clientPayType", "", "getClientPayType", "()I", "setClientPayType", "(I)V", "createTime", "getCreateTime", "setCreateTime", "orderId", "", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "payStatus", "getPayStatus", "setPayStatus", "progressingOrderId", "getProgressingOrderId", "setProgressingOrderId", "riskControl", "Lcom/didi/entrega/security/model/RiskControlModel;", "getRiskControl", "()Lcom/didi/entrega/security/model/RiskControlModel;", "setRiskControl", "(Lcom/didi/entrega/security/model/RiskControlModel;)V", "skipPaymentPoll", "", "getSkipPaymentPoll", "()Z", "setSkipPaymentPoll", "(Z)V", "status", "getStatus", "setStatus", "statusDesc", "getStatusDesc", "setStatusDesc", "statusSubDesc", "getStatusSubDesc", "setStatusSubDesc", "statusSubShortDesc", "getStatusSubShortDesc", "setStatusSubShortDesc", "transId", "getTransId", "setTransId", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderCreateEntity.kt */
public final class OrderCreateEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 5896162181013936238L;
    private int clientPayType;
    private int createTime;
    private String orderId;
    private int payStatus;
    private String progressingOrderId;
    private RiskControlModel riskControl;
    private boolean skipPaymentPoll;
    private int status;
    private String statusDesc;
    private String statusSubDesc;
    private String statusSubShortDesc;
    private String transId;

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getTransId() {
        return this.transId;
    }

    public final void setTransId(String str) {
        this.transId = str;
    }

    public final int getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(int i) {
        this.createTime = i;
    }

    public final int getPayStatus() {
        return this.payStatus;
    }

    public final void setPayStatus(int i) {
        this.payStatus = i;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final void setStatusDesc(String str) {
        this.statusDesc = str;
    }

    public final String getStatusSubDesc() {
        return this.statusSubDesc;
    }

    public final void setStatusSubDesc(String str) {
        this.statusSubDesc = str;
    }

    public final String getStatusSubShortDesc() {
        return this.statusSubShortDesc;
    }

    public final void setStatusSubShortDesc(String str) {
        this.statusSubShortDesc = str;
    }

    public final boolean getSkipPaymentPoll() {
        return this.skipPaymentPoll;
    }

    public final void setSkipPaymentPoll(boolean z) {
        this.skipPaymentPoll = z;
    }

    public final RiskControlModel getRiskControl() {
        return this.riskControl;
    }

    public final void setRiskControl(RiskControlModel riskControlModel) {
        this.riskControl = riskControlModel;
    }

    public final String getProgressingOrderId() {
        return this.progressingOrderId;
    }

    public final void setProgressingOrderId(String str) {
        this.progressingOrderId = str;
    }

    public final int getClientPayType() {
        return this.clientPayType;
    }

    public final void setClientPayType(int i) {
        this.clientPayType = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/foundation/rpc/entity/OrderCreateEntity$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderCreateEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
