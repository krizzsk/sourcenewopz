package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/AbnormalItemInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "abnormalRemark", "", "getAbnormalRemark", "()Ljava/lang/String;", "setAbnormalRemark", "(Ljava/lang/String;)V", "amount", "", "getAmount", "()I", "setAmount", "(I)V", "itemName", "getItemName", "setItemName", "subItemDesc", "getSubItemDesc", "setSubItemDesc", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AbnormalItemInfoEntity.kt */
public final class AbnormalItemInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -1176462707802896322L;
    private String abnormalRemark;
    private int amount;
    private String itemName;
    private String subItemDesc;

    public final String getItemName() {
        return this.itemName;
    }

    public final void setItemName(String str) {
        this.itemName = str;
    }

    public final String getSubItemDesc() {
        return this.subItemDesc;
    }

    public final void setSubItemDesc(String str) {
        this.subItemDesc = str;
    }

    public final String getAbnormalRemark() {
        return this.abnormalRemark;
    }

    public final void setAbnormalRemark(String str) {
        this.abnormalRemark = str;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final void setAmount(int i) {
        this.amount = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/AbnormalItemInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AbnormalItemInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
