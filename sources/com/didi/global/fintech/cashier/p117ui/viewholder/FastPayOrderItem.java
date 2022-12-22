package com.didi.global.fintech.cashier.p117ui.viewholder;

import com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\t\u0010D\u001a\u00020\fHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J \u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020\f2\b\u0010I\u001a\u0004\u0018\u00010JHÖ\u0003J\t\u0010K\u001a\u00020LHÖ\u0001J\t\u0010M\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001d¨\u0006N"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "Ljava/io/Serializable;", "type", "Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;", "content", "", "subContent", "icon", "clickEvent", "Lkotlin/Function0;", "", "available", "", "orderType", "Lcom/didi/global/fintech/cashier/ui/viewholder/OrderType;", "dragable", "card_index", "card_uni_id", "channel_id", "weight", "(Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Lcom/didi/global/fintech/cashier/ui/viewholder/OrderType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvailable", "()Ljava/lang/Boolean;", "setAvailable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCard_index", "()Ljava/lang/String;", "setCard_index", "(Ljava/lang/String;)V", "getCard_uni_id", "setCard_uni_id", "getChannel_id", "setChannel_id", "getClickEvent", "()Lkotlin/jvm/functions/Function0;", "setClickEvent", "(Lkotlin/jvm/functions/Function0;)V", "getContent", "setContent", "getDragable", "()Z", "setDragable", "(Z)V", "getIcon", "setIcon", "getOrderType", "()Lcom/didi/global/fintech/cashier/ui/viewholder/OrderType;", "setOrderType", "(Lcom/didi/global/fintech/cashier/ui/viewholder/OrderType;)V", "getSubContent", "setSubContent", "getType", "()Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;", "setType", "(Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;)V", "getWeight", "setWeight", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Lcom/didi/global/fintech/cashier/ui/viewholder/OrderType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "equals", "other", "", "hashCode", "", "toString", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPayOrderItem */
/* compiled from: FastPayOrderContentViewHolder.kt */
public final class FastPayOrderItem implements Serializable {
    private Boolean available;
    private String card_index;
    private String card_uni_id;
    private String channel_id;
    private Function0<Unit> clickEvent;
    private String content;
    private boolean dragable;
    private String icon;
    private OrderType orderType;
    private String subContent;
    private ItemViewFactory.Type type;
    private String weight;

    public FastPayOrderItem() {
        this((ItemViewFactory.Type) null, (String) null, (String) null, (String) null, (Function0) null, (Boolean) null, (OrderType) null, false, (String) null, (String) null, (String) null, (String) null, 4095, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FastPayOrderItem copy$default(FastPayOrderItem fastPayOrderItem, ItemViewFactory.Type type2, String str, String str2, String str3, Function0 function0, Boolean bool, OrderType orderType2, boolean z, String str4, String str5, String str6, String str7, int i, Object obj) {
        FastPayOrderItem fastPayOrderItem2 = fastPayOrderItem;
        int i2 = i;
        return fastPayOrderItem.copy((i2 & 1) != 0 ? fastPayOrderItem2.type : type2, (i2 & 2) != 0 ? fastPayOrderItem2.content : str, (i2 & 4) != 0 ? fastPayOrderItem2.subContent : str2, (i2 & 8) != 0 ? fastPayOrderItem2.icon : str3, (i2 & 16) != 0 ? fastPayOrderItem2.clickEvent : function0, (i2 & 32) != 0 ? fastPayOrderItem2.available : bool, (i2 & 64) != 0 ? fastPayOrderItem2.orderType : orderType2, (i2 & 128) != 0 ? fastPayOrderItem2.dragable : z, (i2 & 256) != 0 ? fastPayOrderItem2.card_index : str4, (i2 & 512) != 0 ? fastPayOrderItem2.card_uni_id : str5, (i2 & 1024) != 0 ? fastPayOrderItem2.channel_id : str6, (i2 & 2048) != 0 ? fastPayOrderItem2.weight : str7);
    }

    public final ItemViewFactory.Type component1() {
        return this.type;
    }

    public final String component10() {
        return this.card_uni_id;
    }

    public final String component11() {
        return this.channel_id;
    }

    public final String component12() {
        return this.weight;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.subContent;
    }

    public final String component4() {
        return this.icon;
    }

    public final Function0<Unit> component5() {
        return this.clickEvent;
    }

    public final Boolean component6() {
        return this.available;
    }

    public final OrderType component7() {
        return this.orderType;
    }

    public final boolean component8() {
        return this.dragable;
    }

    public final String component9() {
        return this.card_index;
    }

    public final FastPayOrderItem copy(ItemViewFactory.Type type2, String str, String str2, String str3, Function0<Unit> function0, Boolean bool, OrderType orderType2, boolean z, String str4, String str5, String str6, String str7) {
        OrderType orderType3 = orderType2;
        Intrinsics.checkNotNullParameter(orderType3, "orderType");
        return new FastPayOrderItem(type2, str, str2, str3, function0, bool, orderType3, z, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayOrderItem)) {
            return false;
        }
        FastPayOrderItem fastPayOrderItem = (FastPayOrderItem) obj;
        return this.type == fastPayOrderItem.type && Intrinsics.areEqual((Object) this.content, (Object) fastPayOrderItem.content) && Intrinsics.areEqual((Object) this.subContent, (Object) fastPayOrderItem.subContent) && Intrinsics.areEqual((Object) this.icon, (Object) fastPayOrderItem.icon) && Intrinsics.areEqual((Object) this.clickEvent, (Object) fastPayOrderItem.clickEvent) && Intrinsics.areEqual((Object) this.available, (Object) fastPayOrderItem.available) && this.orderType == fastPayOrderItem.orderType && this.dragable == fastPayOrderItem.dragable && Intrinsics.areEqual((Object) this.card_index, (Object) fastPayOrderItem.card_index) && Intrinsics.areEqual((Object) this.card_uni_id, (Object) fastPayOrderItem.card_uni_id) && Intrinsics.areEqual((Object) this.channel_id, (Object) fastPayOrderItem.channel_id) && Intrinsics.areEqual((Object) this.weight, (Object) fastPayOrderItem.weight);
    }

    public int hashCode() {
        ItemViewFactory.Type type2 = this.type;
        int i = 0;
        int hashCode = (type2 == null ? 0 : type2.hashCode()) * 31;
        String str = this.content;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subContent;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Function0<Unit> function0 = this.clickEvent;
        int hashCode5 = (hashCode4 + (function0 == null ? 0 : function0.hashCode())) * 31;
        Boolean bool = this.available;
        int hashCode6 = (((hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31) + this.orderType.hashCode()) * 31;
        boolean z = this.dragable;
        if (z) {
            z = true;
        }
        int i2 = (hashCode6 + (z ? 1 : 0)) * 31;
        String str4 = this.card_index;
        int hashCode7 = (i2 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.card_uni_id;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.channel_id;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.weight;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "FastPayOrderItem(type=" + this.type + ", content=" + this.content + ", subContent=" + this.subContent + ", icon=" + this.icon + ", clickEvent=" + this.clickEvent + ", available=" + this.available + ", orderType=" + this.orderType + ", dragable=" + this.dragable + ", card_index=" + this.card_index + ", card_uni_id=" + this.card_uni_id + ", channel_id=" + this.channel_id + ", weight=" + this.weight + VersionRange.RIGHT_OPEN;
    }

    public FastPayOrderItem(ItemViewFactory.Type type2, String str, String str2, String str3, Function0<Unit> function0, Boolean bool, OrderType orderType2, boolean z, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(orderType2, "orderType");
        this.type = type2;
        this.content = str;
        this.subContent = str2;
        this.icon = str3;
        this.clickEvent = function0;
        this.available = bool;
        this.orderType = orderType2;
        this.dragable = z;
        this.card_index = str4;
        this.card_uni_id = str5;
        this.channel_id = str6;
        this.weight = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FastPayOrderItem(com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, kotlin.jvm.functions.Function0 r18, java.lang.Boolean r19, com.didi.global.fintech.cashier.p117ui.viewholder.OrderType r20, boolean r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r1 = com.didi.global.fintech.cashier.p117ui.viewholder.ItemViewFactory.Type.Pay
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0011
            r2 = r3
            goto L_0x0012
        L_0x0011:
            r2 = r15
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r3
            goto L_0x001a
        L_0x0018:
            r4 = r16
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r3
            goto L_0x0022
        L_0x0020:
            r5 = r17
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r3
            goto L_0x002a
        L_0x0028:
            r6 = r18
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0034
            r7 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x0036
        L_0x0034:
            r7 = r19
        L_0x0036:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003d
            com.didi.global.fintech.cashier.ui.viewholder.OrderType r8 = com.didi.global.fintech.cashier.p117ui.viewholder.OrderType.Deduction
            goto L_0x003f
        L_0x003d:
            r8 = r20
        L_0x003f:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0045
            r9 = 0
            goto L_0x0047
        L_0x0045:
            r9 = r21
        L_0x0047:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004d
            r10 = r3
            goto L_0x004f
        L_0x004d:
            r10 = r22
        L_0x004f:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0055
            r11 = r3
            goto L_0x0057
        L_0x0055:
            r11 = r23
        L_0x0057:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005d
            r12 = r3
            goto L_0x005f
        L_0x005d:
            r12 = r24
        L_0x005f:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r3 = r25
        L_0x0066:
            r14 = r13
            r15 = r1
            r16 = r2
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r3
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p117ui.viewholder.FastPayOrderItem.<init>(com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, java.lang.Boolean, com.didi.global.fintech.cashier.ui.viewholder.OrderType, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ItemViewFactory.Type getType() {
        return this.type;
    }

    public final void setType(ItemViewFactory.Type type2) {
        this.type = type2;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getSubContent() {
        return this.subContent;
    }

    public final void setSubContent(String str) {
        this.subContent = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final Function0<Unit> getClickEvent() {
        return this.clickEvent;
    }

    public final void setClickEvent(Function0<Unit> function0) {
        this.clickEvent = function0;
    }

    public final Boolean getAvailable() {
        return this.available;
    }

    public final void setAvailable(Boolean bool) {
        this.available = bool;
    }

    public final OrderType getOrderType() {
        return this.orderType;
    }

    public final void setOrderType(OrderType orderType2) {
        Intrinsics.checkNotNullParameter(orderType2, "<set-?>");
        this.orderType = orderType2;
    }

    public final boolean getDragable() {
        return this.dragable;
    }

    public final void setDragable(boolean z) {
        this.dragable = z;
    }

    public final String getCard_index() {
        return this.card_index;
    }

    public final void setCard_index(String str) {
        this.card_index = str;
    }

    public final String getCard_uni_id() {
        return this.card_uni_id;
    }

    public final void setCard_uni_id(String str) {
        this.card_uni_id = str;
    }

    public final String getChannel_id() {
        return this.channel_id;
    }

    public final void setChannel_id(String str) {
        this.channel_id = str;
    }

    public final String getWeight() {
        return this.weight;
    }

    public final void setWeight(String str) {
        this.weight = str;
    }
}
