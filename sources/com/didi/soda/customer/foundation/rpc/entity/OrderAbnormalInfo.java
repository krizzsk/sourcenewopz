package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 82\u00020\u0001:\u00018B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00069"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderAbnormalInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "status", "", "title", "", "countDown", "content", "price", "btns", "", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderBtns;", "wordChain", "Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;", "debtInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/DebtInfo;", "shopId", "transId", "ruleNotice", "Lcom/didi/soda/customer/foundation/rpc/entity/RuleNotice;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;Lcom/didi/soda/customer/foundation/rpc/entity/DebtInfo;Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/RuleNotice;)V", "getBtns", "()Ljava/util/List;", "getContent", "()Ljava/lang/String;", "getCountDown", "()I", "getDebtInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/DebtInfo;", "getPrice", "getRuleNotice", "()Lcom/didi/soda/customer/foundation/rpc/entity/RuleNotice;", "getShopId", "getStatus", "getTitle", "getTransId", "getWordChain", "()Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class OrderAbnormalInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -3768320555752685578L;
    private final List<OrderBtns> btns;
    private final String content;
    private final int countDown;
    private final DebtInfo debtInfo;
    private final String price;
    private final RuleNotice ruleNotice;
    private final String shopId;
    private final int status;
    private final String title;
    private final String transId;
    private final WordChain wordChain;

    public OrderAbnormalInfo() {
        this(0, (String) null, 0, (String) null, (String) null, (List) null, (WordChain) null, (DebtInfo) null, (String) null, (String) null, (RuleNotice) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderAbnormalInfo copy$default(OrderAbnormalInfo orderAbnormalInfo, int i, String str, int i2, String str2, String str3, List list, WordChain wordChain2, DebtInfo debtInfo2, String str4, String str5, RuleNotice ruleNotice2, int i3, Object obj) {
        OrderAbnormalInfo orderAbnormalInfo2 = orderAbnormalInfo;
        int i4 = i3;
        return orderAbnormalInfo.copy((i4 & 1) != 0 ? orderAbnormalInfo2.status : i, (i4 & 2) != 0 ? orderAbnormalInfo2.title : str, (i4 & 4) != 0 ? orderAbnormalInfo2.countDown : i2, (i4 & 8) != 0 ? orderAbnormalInfo2.content : str2, (i4 & 16) != 0 ? orderAbnormalInfo2.price : str3, (i4 & 32) != 0 ? orderAbnormalInfo2.btns : list, (i4 & 64) != 0 ? orderAbnormalInfo2.wordChain : wordChain2, (i4 & 128) != 0 ? orderAbnormalInfo2.debtInfo : debtInfo2, (i4 & 256) != 0 ? orderAbnormalInfo2.shopId : str4, (i4 & 512) != 0 ? orderAbnormalInfo2.transId : str5, (i4 & 1024) != 0 ? orderAbnormalInfo2.ruleNotice : ruleNotice2);
    }

    public final int component1() {
        return this.status;
    }

    public final String component10() {
        return this.transId;
    }

    public final RuleNotice component11() {
        return this.ruleNotice;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.countDown;
    }

    public final String component4() {
        return this.content;
    }

    public final String component5() {
        return this.price;
    }

    public final List<OrderBtns> component6() {
        return this.btns;
    }

    public final WordChain component7() {
        return this.wordChain;
    }

    public final DebtInfo component8() {
        return this.debtInfo;
    }

    public final String component9() {
        return this.shopId;
    }

    public final OrderAbnormalInfo copy(int i, String str, int i2, String str2, String str3, List<OrderBtns> list, WordChain wordChain2, DebtInfo debtInfo2, String str4, String str5, RuleNotice ruleNotice2) {
        return new OrderAbnormalInfo(i, str, i2, str2, str3, list, wordChain2, debtInfo2, str4, str5, ruleNotice2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderAbnormalInfo)) {
            return false;
        }
        OrderAbnormalInfo orderAbnormalInfo = (OrderAbnormalInfo) obj;
        return this.status == orderAbnormalInfo.status && Intrinsics.areEqual((Object) this.title, (Object) orderAbnormalInfo.title) && this.countDown == orderAbnormalInfo.countDown && Intrinsics.areEqual((Object) this.content, (Object) orderAbnormalInfo.content) && Intrinsics.areEqual((Object) this.price, (Object) orderAbnormalInfo.price) && Intrinsics.areEqual((Object) this.btns, (Object) orderAbnormalInfo.btns) && Intrinsics.areEqual((Object) this.wordChain, (Object) orderAbnormalInfo.wordChain) && Intrinsics.areEqual((Object) this.debtInfo, (Object) orderAbnormalInfo.debtInfo) && Intrinsics.areEqual((Object) this.shopId, (Object) orderAbnormalInfo.shopId) && Intrinsics.areEqual((Object) this.transId, (Object) orderAbnormalInfo.transId) && Intrinsics.areEqual((Object) this.ruleNotice, (Object) orderAbnormalInfo.ruleNotice);
    }

    public int hashCode() {
        int i = this.status * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (((i + (str == null ? 0 : str.hashCode())) * 31) + this.countDown) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.price;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<OrderBtns> list = this.btns;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        WordChain wordChain2 = this.wordChain;
        int hashCode5 = (hashCode4 + (wordChain2 == null ? 0 : wordChain2.hashCode())) * 31;
        DebtInfo debtInfo2 = this.debtInfo;
        int hashCode6 = (hashCode5 + (debtInfo2 == null ? 0 : debtInfo2.hashCode())) * 31;
        String str4 = this.shopId;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.transId;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        RuleNotice ruleNotice2 = this.ruleNotice;
        if (ruleNotice2 != null) {
            i2 = ruleNotice2.hashCode();
        }
        return hashCode8 + i2;
    }

    public String toString() {
        return "OrderAbnormalInfo(status=" + this.status + ", title=" + this.title + ", countDown=" + this.countDown + ", content=" + this.content + ", price=" + this.price + ", btns=" + this.btns + ", wordChain=" + this.wordChain + ", debtInfo=" + this.debtInfo + ", shopId=" + this.shopId + ", transId=" + this.transId + ", ruleNotice=" + this.ruleNotice + VersionRange.RIGHT_OPEN;
    }

    public OrderAbnormalInfo(int i, String str, int i2, String str2, String str3, List<OrderBtns> list, WordChain wordChain2, DebtInfo debtInfo2, String str4, String str5, RuleNotice ruleNotice2) {
        this.status = i;
        this.title = str;
        this.countDown = i2;
        this.content = str2;
        this.price = str3;
        this.btns = list;
        this.wordChain = wordChain2;
        this.debtInfo = debtInfo2;
        this.shopId = str4;
        this.transId = str5;
        this.ruleNotice = ruleNotice2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderAbnormalInfo(int r13, java.lang.String r14, int r15, java.lang.String r16, java.lang.String r17, java.util.List r18, com.didi.soda.customer.foundation.rpc.entity.WordChain r19, com.didi.soda.customer.foundation.rpc.entity.DebtInfo r20, java.lang.String r21, java.lang.String r22, com.didi.soda.customer.foundation.rpc.entity.RuleNotice r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = r4
            goto L_0x0012
        L_0x0011:
            r3 = r14
        L_0x0012:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r2 = r15
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r4
            goto L_0x0020
        L_0x001e:
            r5 = r16
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r4
            goto L_0x0028
        L_0x0026:
            r6 = r17
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002e
            r7 = r4
            goto L_0x0030
        L_0x002e:
            r7 = r18
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            r8 = r4
            goto L_0x0038
        L_0x0036:
            r8 = r19
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003e
            r9 = r4
            goto L_0x0040
        L_0x003e:
            r9 = r20
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r4
            goto L_0x0048
        L_0x0046:
            r10 = r21
        L_0x0048:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004e
            r11 = r4
            goto L_0x0050
        L_0x004e:
            r11 = r22
        L_0x0050:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r4 = r23
        L_0x0057:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r2
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r4
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.OrderAbnormalInfo.<init>(int, java.lang.String, int, java.lang.String, java.lang.String, java.util.List, com.didi.soda.customer.foundation.rpc.entity.WordChain, com.didi.soda.customer.foundation.rpc.entity.DebtInfo, java.lang.String, java.lang.String, com.didi.soda.customer.foundation.rpc.entity.RuleNotice, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getCountDown() {
        return this.countDown;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getPrice() {
        return this.price;
    }

    public final List<OrderBtns> getBtns() {
        return this.btns;
    }

    public final WordChain getWordChain() {
        return this.wordChain;
    }

    public final DebtInfo getDebtInfo() {
        return this.debtInfo;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getTransId() {
        return this.transId;
    }

    public final RuleNotice getRuleNotice() {
        return this.ruleNotice;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderAbnormalInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
