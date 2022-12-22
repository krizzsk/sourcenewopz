package com.didi.entrega.bill.model;

import com.didi.entrega.customer.foundation.rpc.entity.CouponInfo;
import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/CouponModel;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "activityId", "", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "batchId", "getBatchId", "setBatchId", "couponId", "getCouponId", "setCouponId", "selected", "", "getSelected", "()I", "setSelected", "(I)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CouponModel.kt */
public final class CouponModel implements IEntity {
    public static final int BILL_PLATFORM_COUPON = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SELECTED_PICKING = 1;
    public static final int SELECTED_RECOMMEND = 0;
    private String activityId;
    private String batchId;
    private String couponId;
    private int selected;

    public final String getActivityId() {
        return this.activityId;
    }

    public final void setActivityId(String str) {
        this.activityId = str;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final void setBatchId(String str) {
        this.batchId = str;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final void setCouponId(String str) {
        this.couponId = str;
    }

    public final int getSelected() {
        return this.selected;
    }

    public final void setSelected(int i) {
        this.selected = i;
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/CouponModel$Companion;", "", "()V", "BILL_PLATFORM_COUPON", "", "SELECTED_PICKING", "SELECTED_RECOMMEND", "convertModel", "Lcom/didi/entrega/bill/model/CouponModel;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/CouponInfo;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CouponModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CouponModel convertModel(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            CouponModel couponModel = new CouponModel();
            couponModel.setActivityId(couponInfo.getActivityId());
            couponModel.setBatchId(couponInfo.getBatchId());
            couponModel.setCouponId(couponInfo.getCouponId());
            couponModel.setSelected(couponInfo.getSelected());
            return couponModel;
        }
    }
}
