package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderAbnormalTip;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "title", "", "content", "ruleNotice", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/RuleNotice;", "(Ljava/lang/String;Ljava/lang/String;Lcom/didi/entrega/customer/foundation/rpc/entity/order/RuleNotice;)V", "getContent", "()Ljava/lang/String;", "getRuleNotice", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/RuleNotice;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class OrderAbnormalTip implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -910746848491860205L;
    private final String content;
    private final RuleNotice ruleNotice;
    private final String title;

    public OrderAbnormalTip() {
        this((String) null, (String) null, (RuleNotice) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderAbnormalTip copy$default(OrderAbnormalTip orderAbnormalTip, String str, String str2, RuleNotice ruleNotice2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderAbnormalTip.title;
        }
        if ((i & 2) != 0) {
            str2 = orderAbnormalTip.content;
        }
        if ((i & 4) != 0) {
            ruleNotice2 = orderAbnormalTip.ruleNotice;
        }
        return orderAbnormalTip.copy(str, str2, ruleNotice2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final RuleNotice component3() {
        return this.ruleNotice;
    }

    public final OrderAbnormalTip copy(String str, String str2, RuleNotice ruleNotice2) {
        return new OrderAbnormalTip(str, str2, ruleNotice2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderAbnormalTip)) {
            return false;
        }
        OrderAbnormalTip orderAbnormalTip = (OrderAbnormalTip) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) orderAbnormalTip.title) && Intrinsics.areEqual((Object) this.content, (Object) orderAbnormalTip.content) && Intrinsics.areEqual((Object) this.ruleNotice, (Object) orderAbnormalTip.ruleNotice);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        RuleNotice ruleNotice2 = this.ruleNotice;
        if (ruleNotice2 != null) {
            i = ruleNotice2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "OrderAbnormalTip(title=" + this.title + ", content=" + this.content + ", ruleNotice=" + this.ruleNotice + VersionRange.RIGHT_OPEN;
    }

    public OrderAbnormalTip(String str, String str2, RuleNotice ruleNotice2) {
        this.title = str;
        this.content = str2;
        this.ruleNotice = ruleNotice2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderAbnormalTip(String str, String str2, RuleNotice ruleNotice2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : ruleNotice2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    public final RuleNotice getRuleNotice() {
        return this.ruleNotice;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderAbnormalTip$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
