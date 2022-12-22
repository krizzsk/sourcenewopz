package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderBranchInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "title", "", "content", "btn", "type", "", "uniqId", "ruleNotice", "Lcom/didi/soda/customer/foundation/rpc/entity/RuleNotice;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/RuleNotice;)V", "getBtn", "()Ljava/lang/String;", "getContent", "getRuleNotice", "()Lcom/didi/soda/customer/foundation/rpc/entity/RuleNotice;", "getTitle", "getType", "()I", "getUniqId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class OrderBranchInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 2165628451942328915L;
    private final String btn;
    private final String content;
    private final RuleNotice ruleNotice;
    private final String title;
    private final int type;
    private final String uniqId;

    public OrderBranchInfo() {
        this((String) null, (String) null, (String) null, 0, (String) null, (RuleNotice) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderBranchInfo copy$default(OrderBranchInfo orderBranchInfo, String str, String str2, String str3, int i, String str4, RuleNotice ruleNotice2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = orderBranchInfo.title;
        }
        if ((i2 & 2) != 0) {
            str2 = orderBranchInfo.content;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = orderBranchInfo.btn;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            i = orderBranchInfo.type;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str4 = orderBranchInfo.uniqId;
        }
        String str7 = str4;
        if ((i2 & 32) != 0) {
            ruleNotice2 = orderBranchInfo.ruleNotice;
        }
        return orderBranchInfo.copy(str, str5, str6, i3, str7, ruleNotice2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.btn;
    }

    public final int component4() {
        return this.type;
    }

    public final String component5() {
        return this.uniqId;
    }

    public final RuleNotice component6() {
        return this.ruleNotice;
    }

    public final OrderBranchInfo copy(String str, String str2, String str3, int i, String str4, RuleNotice ruleNotice2) {
        return new OrderBranchInfo(str, str2, str3, i, str4, ruleNotice2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderBranchInfo)) {
            return false;
        }
        OrderBranchInfo orderBranchInfo = (OrderBranchInfo) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) orderBranchInfo.title) && Intrinsics.areEqual((Object) this.content, (Object) orderBranchInfo.content) && Intrinsics.areEqual((Object) this.btn, (Object) orderBranchInfo.btn) && this.type == orderBranchInfo.type && Intrinsics.areEqual((Object) this.uniqId, (Object) orderBranchInfo.uniqId) && Intrinsics.areEqual((Object) this.ruleNotice, (Object) orderBranchInfo.ruleNotice);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.btn;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.type) * 31;
        String str4 = this.uniqId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        RuleNotice ruleNotice2 = this.ruleNotice;
        if (ruleNotice2 != null) {
            i = ruleNotice2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "OrderBranchInfo(title=" + this.title + ", content=" + this.content + ", btn=" + this.btn + ", type=" + this.type + ", uniqId=" + this.uniqId + ", ruleNotice=" + this.ruleNotice + VersionRange.RIGHT_OPEN;
    }

    public OrderBranchInfo(String str, String str2, String str3, int i, String str4, RuleNotice ruleNotice2) {
        this.title = str;
        this.content = str2;
        this.btn = str3;
        this.type = i;
        this.uniqId = str4;
        this.ruleNotice = ruleNotice2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderBranchInfo(java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, java.lang.String r10, com.didi.soda.customer.foundation.rpc.entity.RuleNotice r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001d
            r9 = 0
            r3 = 0
            goto L_0x001e
        L_0x001d:
            r3 = r9
        L_0x001e:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0024
            r4 = r0
            goto L_0x0025
        L_0x0024:
            r4 = r10
        L_0x0025:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002b
            r12 = r0
            goto L_0x002c
        L_0x002b:
            r12 = r11
        L_0x002c:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.OrderBranchInfo.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, com.didi.soda.customer.foundation.rpc.entity.RuleNotice, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getBtn() {
        return this.btn;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public final RuleNotice getRuleNotice() {
        return this.ruleNotice;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderBranchInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
