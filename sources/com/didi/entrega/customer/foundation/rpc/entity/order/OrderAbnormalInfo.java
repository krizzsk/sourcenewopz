package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003Ja\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006+"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderAbnormalInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "status", "", "title", "", "content", "btns", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderBtns;", "debtInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/DebtInfo;", "titleRuleNotice", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/RuleNotice;", "contentRuleNotice", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/didi/entrega/customer/foundation/rpc/entity/order/DebtInfo;Lcom/didi/entrega/customer/foundation/rpc/entity/order/RuleNotice;Lcom/didi/entrega/customer/foundation/rpc/entity/order/RuleNotice;)V", "getBtns", "()Ljava/util/List;", "getContent", "()Ljava/lang/String;", "getContentRuleNotice", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/RuleNotice;", "getDebtInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/DebtInfo;", "getStatus", "()I", "getTitle", "getTitleRuleNotice", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class OrderAbnormalInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 4022813285714652632L;
    private final List<OrderBtns> btns;
    private final String content;
    private final RuleNotice contentRuleNotice;
    private final DebtInfo debtInfo;
    private final int status;
    private final String title;
    private final RuleNotice titleRuleNotice;

    public OrderAbnormalInfo() {
        this(0, (String) null, (String) null, (List) null, (DebtInfo) null, (RuleNotice) null, (RuleNotice) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderAbnormalInfo copy$default(OrderAbnormalInfo orderAbnormalInfo, int i, String str, String str2, List<OrderBtns> list, DebtInfo debtInfo2, RuleNotice ruleNotice, RuleNotice ruleNotice2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = orderAbnormalInfo.status;
        }
        if ((i2 & 2) != 0) {
            str = orderAbnormalInfo.title;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = orderAbnormalInfo.content;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            list = orderAbnormalInfo.btns;
        }
        List<OrderBtns> list2 = list;
        if ((i2 & 16) != 0) {
            debtInfo2 = orderAbnormalInfo.debtInfo;
        }
        DebtInfo debtInfo3 = debtInfo2;
        if ((i2 & 32) != 0) {
            ruleNotice = orderAbnormalInfo.titleRuleNotice;
        }
        RuleNotice ruleNotice3 = ruleNotice;
        if ((i2 & 64) != 0) {
            ruleNotice2 = orderAbnormalInfo.contentRuleNotice;
        }
        return orderAbnormalInfo.copy(i, str3, str4, list2, debtInfo3, ruleNotice3, ruleNotice2);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.content;
    }

    public final List<OrderBtns> component4() {
        return this.btns;
    }

    public final DebtInfo component5() {
        return this.debtInfo;
    }

    public final RuleNotice component6() {
        return this.titleRuleNotice;
    }

    public final RuleNotice component7() {
        return this.contentRuleNotice;
    }

    public final OrderAbnormalInfo copy(int i, String str, String str2, List<OrderBtns> list, DebtInfo debtInfo2, RuleNotice ruleNotice, RuleNotice ruleNotice2) {
        return new OrderAbnormalInfo(i, str, str2, list, debtInfo2, ruleNotice, ruleNotice2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderAbnormalInfo)) {
            return false;
        }
        OrderAbnormalInfo orderAbnormalInfo = (OrderAbnormalInfo) obj;
        return this.status == orderAbnormalInfo.status && Intrinsics.areEqual((Object) this.title, (Object) orderAbnormalInfo.title) && Intrinsics.areEqual((Object) this.content, (Object) orderAbnormalInfo.content) && Intrinsics.areEqual((Object) this.btns, (Object) orderAbnormalInfo.btns) && Intrinsics.areEqual((Object) this.debtInfo, (Object) orderAbnormalInfo.debtInfo) && Intrinsics.areEqual((Object) this.titleRuleNotice, (Object) orderAbnormalInfo.titleRuleNotice) && Intrinsics.areEqual((Object) this.contentRuleNotice, (Object) orderAbnormalInfo.contentRuleNotice);
    }

    public int hashCode() {
        int i = this.status * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<OrderBtns> list = this.btns;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        DebtInfo debtInfo2 = this.debtInfo;
        int hashCode4 = (hashCode3 + (debtInfo2 == null ? 0 : debtInfo2.hashCode())) * 31;
        RuleNotice ruleNotice = this.titleRuleNotice;
        int hashCode5 = (hashCode4 + (ruleNotice == null ? 0 : ruleNotice.hashCode())) * 31;
        RuleNotice ruleNotice2 = this.contentRuleNotice;
        if (ruleNotice2 != null) {
            i2 = ruleNotice2.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        return "OrderAbnormalInfo(status=" + this.status + ", title=" + this.title + ", content=" + this.content + ", btns=" + this.btns + ", debtInfo=" + this.debtInfo + ", titleRuleNotice=" + this.titleRuleNotice + ", contentRuleNotice=" + this.contentRuleNotice + VersionRange.RIGHT_OPEN;
    }

    public OrderAbnormalInfo(int i, String str, String str2, List<OrderBtns> list, DebtInfo debtInfo2, RuleNotice ruleNotice, RuleNotice ruleNotice2) {
        this.status = i;
        this.title = str;
        this.content = str2;
        this.btns = list;
        this.debtInfo = debtInfo2;
        this.titleRuleNotice = ruleNotice;
        this.contentRuleNotice = ruleNotice2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderAbnormalInfo(int r6, java.lang.String r7, java.lang.String r8, java.util.List r9, com.didi.entrega.customer.foundation.rpc.entity.order.DebtInfo r10, com.didi.entrega.customer.foundation.rpc.entity.order.RuleNotice r11, com.didi.entrega.customer.foundation.rpc.entity.order.RuleNotice r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0005
            r6 = 0
        L_0x0005:
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L_0x000c
            r14 = r0
            goto L_0x000d
        L_0x000c:
            r14 = r7
        L_0x000d:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0013
            r1 = r0
            goto L_0x0014
        L_0x0013:
            r1 = r8
        L_0x0014:
            r7 = r13 & 8
            if (r7 == 0) goto L_0x001a
            r2 = r0
            goto L_0x001b
        L_0x001a:
            r2 = r9
        L_0x001b:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0021
            r3 = r0
            goto L_0x0022
        L_0x0021:
            r3 = r10
        L_0x0022:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x0028
            r4 = r0
            goto L_0x0029
        L_0x0028:
            r4 = r11
        L_0x0029:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = r12
        L_0x002f:
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.entity.order.OrderAbnormalInfo.<init>(int, java.lang.String, java.lang.String, java.util.List, com.didi.entrega.customer.foundation.rpc.entity.order.DebtInfo, com.didi.entrega.customer.foundation.rpc.entity.order.RuleNotice, com.didi.entrega.customer.foundation.rpc.entity.order.RuleNotice, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<OrderBtns> getBtns() {
        return this.btns;
    }

    public final DebtInfo getDebtInfo() {
        return this.debtInfo;
    }

    public final RuleNotice getTitleRuleNotice() {
        return this.titleRuleNotice;
    }

    public final RuleNotice getContentRuleNotice() {
        return this.contentRuleNotice;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderAbnormalInfo$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
