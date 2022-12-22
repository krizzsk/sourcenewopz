package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 ;2\u00020\u0001:\u0001;B«\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¯\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u0007HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006<"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/DishItem;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "itemId", "", "itemName", "headImg", "amount", "", "price", "priceDisplay", "specialPrice", "specialPriceDisplay", "mduId", "mduType", "subItemDesc", "abnormalDesc", "actDesc", "actTag", "", "Lcom/didi/soda/customer/foundation/rpc/entity/ActTagEntity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAbnormalDesc", "()Ljava/lang/String;", "getActDesc", "getActTag", "()Ljava/util/List;", "getAmount", "()I", "getHeadImg", "getItemId", "getItemName", "getMduId", "getMduType", "getPrice", "getPriceDisplay", "getSpecialPrice", "getSpecialPriceDisplay", "getSubItemDesc", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class DishItem implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -3308911840047894324L;
    private final String abnormalDesc;
    private final String actDesc;
    private final List<ActTagEntity> actTag;
    private final int amount;
    private final String headImg;
    private final String itemId;
    private final String itemName;
    private final String mduId;
    private final int mduType;
    private final int price;
    private final String priceDisplay;
    private final int specialPrice;
    private final String specialPriceDisplay;
    private final String subItemDesc;

    public DishItem() {
        this((String) null, (String) null, (String) null, 0, 0, (String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (List) null, 16383, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DishItem copy$default(DishItem dishItem, String str, String str2, String str3, int i, int i2, String str4, int i3, String str5, String str6, int i4, String str7, String str8, String str9, List list, int i5, Object obj) {
        DishItem dishItem2 = dishItem;
        int i6 = i5;
        return dishItem.copy((i6 & 1) != 0 ? dishItem2.itemId : str, (i6 & 2) != 0 ? dishItem2.itemName : str2, (i6 & 4) != 0 ? dishItem2.headImg : str3, (i6 & 8) != 0 ? dishItem2.amount : i, (i6 & 16) != 0 ? dishItem2.price : i2, (i6 & 32) != 0 ? dishItem2.priceDisplay : str4, (i6 & 64) != 0 ? dishItem2.specialPrice : i3, (i6 & 128) != 0 ? dishItem2.specialPriceDisplay : str5, (i6 & 256) != 0 ? dishItem2.mduId : str6, (i6 & 512) != 0 ? dishItem2.mduType : i4, (i6 & 1024) != 0 ? dishItem2.subItemDesc : str7, (i6 & 2048) != 0 ? dishItem2.abnormalDesc : str8, (i6 & 4096) != 0 ? dishItem2.actDesc : str9, (i6 & 8192) != 0 ? dishItem2.actTag : list);
    }

    public final String component1() {
        return this.itemId;
    }

    public final int component10() {
        return this.mduType;
    }

    public final String component11() {
        return this.subItemDesc;
    }

    public final String component12() {
        return this.abnormalDesc;
    }

    public final String component13() {
        return this.actDesc;
    }

    public final List<ActTagEntity> component14() {
        return this.actTag;
    }

    public final String component2() {
        return this.itemName;
    }

    public final String component3() {
        return this.headImg;
    }

    public final int component4() {
        return this.amount;
    }

    public final int component5() {
        return this.price;
    }

    public final String component6() {
        return this.priceDisplay;
    }

    public final int component7() {
        return this.specialPrice;
    }

    public final String component8() {
        return this.specialPriceDisplay;
    }

    public final String component9() {
        return this.mduId;
    }

    public final DishItem copy(String str, String str2, String str3, int i, int i2, String str4, int i3, String str5, String str6, int i4, String str7, String str8, String str9, List<? extends ActTagEntity> list) {
        return new DishItem(str, str2, str3, i, i2, str4, i3, str5, str6, i4, str7, str8, str9, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DishItem)) {
            return false;
        }
        DishItem dishItem = (DishItem) obj;
        return Intrinsics.areEqual((Object) this.itemId, (Object) dishItem.itemId) && Intrinsics.areEqual((Object) this.itemName, (Object) dishItem.itemName) && Intrinsics.areEqual((Object) this.headImg, (Object) dishItem.headImg) && this.amount == dishItem.amount && this.price == dishItem.price && Intrinsics.areEqual((Object) this.priceDisplay, (Object) dishItem.priceDisplay) && this.specialPrice == dishItem.specialPrice && Intrinsics.areEqual((Object) this.specialPriceDisplay, (Object) dishItem.specialPriceDisplay) && Intrinsics.areEqual((Object) this.mduId, (Object) dishItem.mduId) && this.mduType == dishItem.mduType && Intrinsics.areEqual((Object) this.subItemDesc, (Object) dishItem.subItemDesc) && Intrinsics.areEqual((Object) this.abnormalDesc, (Object) dishItem.abnormalDesc) && Intrinsics.areEqual((Object) this.actDesc, (Object) dishItem.actDesc) && Intrinsics.areEqual((Object) this.actTag, (Object) dishItem.actTag);
    }

    public int hashCode() {
        String str = this.itemId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.itemName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.headImg;
        int hashCode3 = (((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.amount) * 31) + this.price) * 31;
        String str4 = this.priceDisplay;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.specialPrice) * 31;
        String str5 = this.specialPriceDisplay;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mduId;
        int hashCode6 = (((hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.mduType) * 31;
        String str7 = this.subItemDesc;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.abnormalDesc;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.actDesc;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        List<ActTagEntity> list = this.actTag;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "DishItem(itemId=" + this.itemId + ", itemName=" + this.itemName + ", headImg=" + this.headImg + ", amount=" + this.amount + ", price=" + this.price + ", priceDisplay=" + this.priceDisplay + ", specialPrice=" + this.specialPrice + ", specialPriceDisplay=" + this.specialPriceDisplay + ", mduId=" + this.mduId + ", mduType=" + this.mduType + ", subItemDesc=" + this.subItemDesc + ", abnormalDesc=" + this.abnormalDesc + ", actDesc=" + this.actDesc + ", actTag=" + this.actTag + VersionRange.RIGHT_OPEN;
    }

    public DishItem(String str, String str2, String str3, int i, int i2, String str4, int i3, String str5, String str6, int i4, String str7, String str8, String str9, List<? extends ActTagEntity> list) {
        this.itemId = str;
        this.itemName = str2;
        this.headImg = str3;
        this.amount = i;
        this.price = i2;
        this.priceDisplay = str4;
        this.specialPrice = i3;
        this.specialPriceDisplay = str5;
        this.mduId = str6;
        this.mduType = i4;
        this.subItemDesc = str7;
        this.abnormalDesc = str8;
        this.actDesc = str9;
        this.actTag = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DishItem(java.lang.String r16, java.lang.String r17, java.lang.String r18, int r19, int r20, java.lang.String r21, int r22, java.lang.String r23, java.lang.String r24, int r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.util.List r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r19
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r20
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r2
            goto L_0x0034
        L_0x0032:
            r8 = r21
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r22
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r2
            goto L_0x0044
        L_0x0042:
            r10 = r23
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = r2
            goto L_0x004c
        L_0x004a:
            r11 = r24
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r6 = r25
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r26
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r27
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r28
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r29
        L_0x0072:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r6
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.DishItem.<init>(java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getItemName() {
        return this.itemName;
    }

    public final String getHeadImg() {
        return this.headImg;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getPriceDisplay() {
        return this.priceDisplay;
    }

    public final int getSpecialPrice() {
        return this.specialPrice;
    }

    public final String getSpecialPriceDisplay() {
        return this.specialPriceDisplay;
    }

    public final String getMduId() {
        return this.mduId;
    }

    public final int getMduType() {
        return this.mduType;
    }

    public final String getSubItemDesc() {
        return this.subItemDesc;
    }

    public final String getAbnormalDesc() {
        return this.abnormalDesc;
    }

    public final String getActDesc() {
        return this.actDesc;
    }

    public final List<ActTagEntity> getActTag() {
        return this.actTag;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/DishItem$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
