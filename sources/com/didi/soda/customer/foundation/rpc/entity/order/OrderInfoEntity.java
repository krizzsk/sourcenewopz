package com.didi.soda.customer.foundation.rpc.entity.order;

import com.didi.soda.customer.foundation.rpc.entity.DebtInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006("}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "alertMsg", "", "getAlertMsg", "()Ljava/lang/String;", "setAlertMsg", "(Ljava/lang/String;)V", "createTime", "getCreateTime", "setCreateTime", "debtInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/DebtInfoEntity;", "getDebtInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/DebtInfoEntity;", "setDebtInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/DebtInfoEntity;)V", "orderId", "getOrderId", "setOrderId", "realPayPrice", "", "getRealPayPrice", "()I", "setRealPayPrice", "(I)V", "realPayPriceDisplay", "getRealPayPriceDisplay", "setRealPayPriceDisplay", "status", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "statusDesc", "getStatusDesc", "setStatusDesc", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderHistoryEntity.kt */
public final class OrderInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 6874940760248549528L;
    private String alertMsg;
    private String createTime;
    private DebtInfoEntity debtInfo;
    private String orderId;
    private int realPayPrice;
    private String realPayPriceDisplay;
    private Integer status = 0;
    private String statusDesc;

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final int getRealPayPrice() {
        return this.realPayPrice;
    }

    public final void setRealPayPrice(int i) {
        this.realPayPrice = i;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(String str) {
        this.createTime = str;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final void setStatusDesc(String str) {
        this.statusDesc = str;
    }

    public final String getRealPayPriceDisplay() {
        return this.realPayPriceDisplay;
    }

    public final void setRealPayPriceDisplay(String str) {
        this.realPayPriceDisplay = str;
    }

    public final String getAlertMsg() {
        return this.alertMsg;
    }

    public final void setAlertMsg(String str) {
        this.alertMsg = str;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final DebtInfoEntity getDebtInfo() {
        return this.debtInfo;
    }

    public final void setDebtInfo(DebtInfoEntity debtInfoEntity) {
        this.debtInfo = debtInfoEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderHistoryEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
