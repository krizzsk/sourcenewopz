package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00002\u0006\u0010\"\u001a\u00020#H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/PayChannelModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "cardOrg", "", "getCardOrg", "()Ljava/lang/String;", "setCardOrg", "(Ljava/lang/String;)V", "cardPrefix", "getCardPrefix", "setCardPrefix", "cardSuffix", "getCardSuffix", "setCardSuffix", "channelId", "", "getChannelId", "()I", "setChannelId", "(I)V", "channelName", "getChannelName", "setChannelName", "combinedCardOrg", "getCombinedCardOrg", "setCombinedCardOrg", "payChannelEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "getPayChannelEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "setPayChannelEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;)V", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayChannelModel.kt */
public final class PayChannelModel extends ComponentAbsModel {

    /* renamed from: a */
    private int f39117a;

    /* renamed from: b */
    private String f39118b;

    /* renamed from: c */
    private String f39119c;

    /* renamed from: d */
    private String f39120d;

    /* renamed from: e */
    private String f39121e;

    /* renamed from: f */
    private String f39122f;

    /* renamed from: g */
    private PayChannelEntity f39123g;

    public final int getChannelId() {
        return this.f39117a;
    }

    public final void setChannelId(int i) {
        this.f39117a = i;
    }

    public final String getChannelName() {
        return this.f39118b;
    }

    public final void setChannelName(String str) {
        this.f39118b = str;
    }

    public final String getCardSuffix() {
        return this.f39119c;
    }

    public final void setCardSuffix(String str) {
        this.f39119c = str;
    }

    public final String getCardPrefix() {
        return this.f39120d;
    }

    public final void setCardPrefix(String str) {
        this.f39120d = str;
    }

    public final String getCardOrg() {
        return this.f39121e;
    }

    public final void setCardOrg(String str) {
        this.f39121e = str;
    }

    public final String getCombinedCardOrg() {
        return this.f39122f;
    }

    public final void setCombinedCardOrg(String str) {
        this.f39122f = str;
    }

    public final PayChannelEntity getPayChannelEntity() {
        return this.f39123g;
    }

    public final void setPayChannelEntity(PayChannelEntity payChannelEntity) {
        this.f39123g = payChannelEntity;
    }

    public PayChannelModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        PayChannelEntity payChannel = billComponentDataEntity.getPayChannel();
        String str = null;
        if (payChannel == null) {
            return null;
        }
        PayChannelModel payChannelModel = new PayChannelModel();
        payChannelModel.setChannelId(payChannel.channelId);
        payChannelModel.setChannelName(payChannel.channelName);
        payChannelModel.setCardSuffix(payChannel.cardSuffix);
        Collection collection = payChannel.combinedChannelList;
        if (collection == null || collection.isEmpty()) {
            payChannelModel.setCardOrg(payChannel.cardOrg);
        } else {
            List<PayChannelEntity> list = payChannel.combinedChannelList;
            if (list != null) {
                if (list.size() >= 1) {
                    PayChannelEntity payChannelEntity = list.get(0);
                    payChannelModel.setCardOrg(payChannelEntity == null ? null : payChannelEntity.cardOrg);
                }
                if (list.size() >= 2) {
                    PayChannelEntity payChannelEntity2 = list.get(1);
                    if (payChannelEntity2 != null) {
                        str = payChannelEntity2.cardOrg;
                    }
                    payChannelModel.setCombinedCardOrg(str);
                }
            }
        }
        payChannelModel.setCardPrefix(payChannel.cardPrefix);
        payChannelModel.setPayChannelEntity(payChannel);
        return payChannelModel;
    }
}
