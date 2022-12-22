package com.didi.entrega.customer.foundation.rpc.entity;

import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\u0018\u0000 02\u00020\u0001:\u00010B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00061"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/BillExtraData;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "updateType", "", "couponInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/CouponInfo;", "packageInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "payChannel", "Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "priceInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/PriceInfo;", "receiverAddress", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "senderAddress", "tipFeeInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo;", "topTips", "", "senderTitle", "receiverTitle", "(Ljava/lang/Integer;Lcom/didi/entrega/customer/foundation/rpc/entity/CouponInfo;Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;Lcom/didi/entrega/customer/foundation/rpc/entity/PriceInfo;Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCouponInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CouponInfo;", "setCouponInfo", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CouponInfo;)V", "getPackageInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "getPayChannel", "()Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "getPriceInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/PriceInfo;", "getReceiverAddress", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "getReceiverTitle", "()Ljava/lang/String;", "getSenderAddress", "getSenderTitle", "getTipFeeInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo;", "setTipFeeInfo", "(Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo;)V", "getTopTips", "getUpdateType", "()Ljava/lang/Integer;", "setUpdateType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillEntity.kt */
public final class BillExtraData implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 7780242077822166169L;
    private CouponInfo couponInfo;
    private final ContactStufEntity packageInfo;
    private final PayChannel payChannel;
    private final PriceInfo priceInfo;
    private final AddressEntity receiverAddress;
    private final String receiverTitle;
    private final AddressEntity senderAddress;
    private final String senderTitle;
    private TipFeeInfo tipFeeInfo;
    private final String topTips;
    private Integer updateType;

    public BillExtraData() {
        this((Integer) null, (CouponInfo) null, (ContactStufEntity) null, (PayChannel) null, (PriceInfo) null, (AddressEntity) null, (AddressEntity) null, (TipFeeInfo) null, (String) null, (String) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public BillExtraData(Integer num, CouponInfo couponInfo2, ContactStufEntity contactStufEntity, PayChannel payChannel2, PriceInfo priceInfo2, AddressEntity addressEntity, AddressEntity addressEntity2, TipFeeInfo tipFeeInfo2, String str, String str2, String str3) {
        this.updateType = num;
        this.couponInfo = couponInfo2;
        this.packageInfo = contactStufEntity;
        this.payChannel = payChannel2;
        this.priceInfo = priceInfo2;
        this.receiverAddress = addressEntity;
        this.senderAddress = addressEntity2;
        this.tipFeeInfo = tipFeeInfo2;
        this.topTips = str;
        this.senderTitle = str2;
        this.receiverTitle = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BillExtraData(java.lang.Integer r13, com.didi.entrega.customer.foundation.rpc.entity.CouponInfo r14, com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity r15, com.didi.entrega.customer.foundation.rpc.entity.PayChannel r16, com.didi.entrega.customer.foundation.rpc.entity.PriceInfo r17, com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r18, com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r19, com.didi.entrega.customer.foundation.rpc.entity.TipFeeInfo r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r14
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r15
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x0020
        L_0x001e:
            r5 = r16
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0028
        L_0x0026:
            r6 = r17
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002e
            r7 = r2
            goto L_0x0030
        L_0x002e:
            r7 = r18
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            r8 = r2
            goto L_0x0038
        L_0x0036:
            r8 = r19
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003e
            r9 = r2
            goto L_0x0040
        L_0x003e:
            r9 = r20
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r2
            goto L_0x0048
        L_0x0046:
            r10 = r21
        L_0x0048:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004e
            r11 = r2
            goto L_0x0050
        L_0x004e:
            r11 = r22
        L_0x0050:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r2 = r23
        L_0x0057:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.entity.BillExtraData.<init>(java.lang.Integer, com.didi.entrega.customer.foundation.rpc.entity.CouponInfo, com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity, com.didi.entrega.customer.foundation.rpc.entity.PayChannel, com.didi.entrega.customer.foundation.rpc.entity.PriceInfo, com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity, com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity, com.didi.entrega.customer.foundation.rpc.entity.TipFeeInfo, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getUpdateType() {
        return this.updateType;
    }

    public final void setUpdateType(Integer num) {
        this.updateType = num;
    }

    public final CouponInfo getCouponInfo() {
        return this.couponInfo;
    }

    public final void setCouponInfo(CouponInfo couponInfo2) {
        this.couponInfo = couponInfo2;
    }

    public final ContactStufEntity getPackageInfo() {
        return this.packageInfo;
    }

    public final PayChannel getPayChannel() {
        return this.payChannel;
    }

    public final PriceInfo getPriceInfo() {
        return this.priceInfo;
    }

    public final AddressEntity getReceiverAddress() {
        return this.receiverAddress;
    }

    public final AddressEntity getSenderAddress() {
        return this.senderAddress;
    }

    public final TipFeeInfo getTipFeeInfo() {
        return this.tipFeeInfo;
    }

    public final void setTipFeeInfo(TipFeeInfo tipFeeInfo2) {
        this.tipFeeInfo = tipFeeInfo2;
    }

    public final String getTopTips() {
        return this.topTips;
    }

    public final String getSenderTitle() {
        return this.senderTitle;
    }

    public final String getReceiverTitle() {
        return this.receiverTitle;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/BillExtraData$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
