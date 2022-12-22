package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001c\u0010 \u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010¨\u0006$"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/AbnormalItemsInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "items", "Ljava/util/ArrayList;", "Lcom/didi/soda/customer/foundation/rpc/entity/AbnormalItemInfoEntity;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "linkDesc", "", "getLinkDesc", "()Ljava/lang/String;", "setLinkDesc", "(Ljava/lang/String;)V", "payChannel", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "getPayChannel", "()Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "setPayChannel", "(Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;)V", "ruleDesc", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "getRuleDesc", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "setRuleDesc", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;)V", "totalDisplay", "getTotalDisplay", "setTotalDisplay", "totalName", "getTotalName", "setTotalName", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AbnormalItemsInfoEntity.kt */
public final class AbnormalItemsInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -4733823390363744465L;
    private ArrayList<AbnormalItemInfoEntity> items;
    private String linkDesc;
    private PayChannelEntity payChannel;
    private RuleDescEntity ruleDesc;
    private String totalDisplay;
    private String totalName;

    public final String getLinkDesc() {
        return this.linkDesc;
    }

    public final void setLinkDesc(String str) {
        this.linkDesc = str;
    }

    public final String getTotalName() {
        return this.totalName;
    }

    public final void setTotalName(String str) {
        this.totalName = str;
    }

    public final String getTotalDisplay() {
        return this.totalDisplay;
    }

    public final void setTotalDisplay(String str) {
        this.totalDisplay = str;
    }

    public final PayChannelEntity getPayChannel() {
        return this.payChannel;
    }

    public final void setPayChannel(PayChannelEntity payChannelEntity) {
        this.payChannel = payChannelEntity;
    }

    public final ArrayList<AbnormalItemInfoEntity> getItems() {
        return this.items;
    }

    public final void setItems(ArrayList<AbnormalItemInfoEntity> arrayList) {
        this.items = arrayList;
    }

    public final RuleDescEntity getRuleDesc() {
        return this.ruleDesc;
    }

    public final void setRuleDesc(RuleDescEntity ruleDescEntity) {
        this.ruleDesc = ruleDescEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/AbnormalItemsInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AbnormalItemsInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
