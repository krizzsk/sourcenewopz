package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u000fJP\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderPickInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "title", "", "showList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/ShowList;", "subTitle", "desc", "hasCash", "", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDesc", "()Ljava/lang/String;", "getHasCash", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowList", "()Ljava/util/List;", "getSubTitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/didi/soda/customer/foundation/rpc/entity/OrderPickInfo;", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class OrderPickInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -8360570950453879958L;
    private final String desc;
    private final Integer hasCash;
    private final List<ShowList> showList;
    private final String subTitle;
    private final String title;

    public OrderPickInfo() {
        this((String) null, (List) null, (String) null, (String) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderPickInfo copy$default(OrderPickInfo orderPickInfo, String str, List<ShowList> list, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderPickInfo.title;
        }
        if ((i & 2) != 0) {
            list = orderPickInfo.showList;
        }
        List<ShowList> list2 = list;
        if ((i & 4) != 0) {
            str2 = orderPickInfo.subTitle;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = orderPickInfo.desc;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            num = orderPickInfo.hasCash;
        }
        return orderPickInfo.copy(str, list2, str4, str5, num);
    }

    public final String component1() {
        return this.title;
    }

    public final List<ShowList> component2() {
        return this.showList;
    }

    public final String component3() {
        return this.subTitle;
    }

    public final String component4() {
        return this.desc;
    }

    public final Integer component5() {
        return this.hasCash;
    }

    public final OrderPickInfo copy(String str, List<ShowList> list, String str2, String str3, Integer num) {
        return new OrderPickInfo(str, list, str2, str3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderPickInfo)) {
            return false;
        }
        OrderPickInfo orderPickInfo = (OrderPickInfo) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) orderPickInfo.title) && Intrinsics.areEqual((Object) this.showList, (Object) orderPickInfo.showList) && Intrinsics.areEqual((Object) this.subTitle, (Object) orderPickInfo.subTitle) && Intrinsics.areEqual((Object) this.desc, (Object) orderPickInfo.desc) && Intrinsics.areEqual((Object) this.hasCash, (Object) orderPickInfo.hasCash);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ShowList> list = this.showList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.subTitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.desc;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.hasCash;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "OrderPickInfo(title=" + this.title + ", showList=" + this.showList + ", subTitle=" + this.subTitle + ", desc=" + this.desc + ", hasCash=" + this.hasCash + VersionRange.RIGHT_OPEN;
    }

    public OrderPickInfo(String str, List<ShowList> list, String str2, String str3, Integer num) {
        this.title = str;
        this.showList = list;
        this.subTitle = str2;
        this.desc = str3;
        this.hasCash = num;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<ShowList> getShowList() {
        return this.showList;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getDesc() {
        return this.desc;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderPickInfo(java.lang.String r4, java.util.List r5, java.lang.String r6, java.lang.String r7, java.lang.Integer r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r6
        L_0x0016:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r7
        L_0x001c:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0025
            r4 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
        L_0x0025:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.OrderPickInfo.<init>(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getHasCash() {
        return this.hasCash;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderPickInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
