package com.didi.soda.cart.model;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 L2\u00020\u0001:\u0001LB\u0001\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0002\u0010\u0015B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0016J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00107J\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\u00072\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020\tHÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR8\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001e2\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001f\u0010%\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e0&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010*R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u00101R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001cR\u001a\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u00105R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107¨\u0006M"}, mo175978d2 = {"Lcom/didi/soda/cart/model/SetItemParams;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "shopId", "", "itemId", "itemUniKey", "isMultiContents", "", "amount", "", "nodeList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/ItemNodeEntity;", "cartId", "mduId", "wineConfirm", "revision", "biData", "actInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "tyingItemsFlag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;)V", "getActInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "getAmount", "()I", "getBiData", "()Ljava/lang/String;", "value", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "callback", "getCallback", "()Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "setCallback", "(Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;)V", "callbacks", "", "getCallbacks", "()Ljava/util/List;", "getCartId", "()Z", "getItemId", "getItemUniKey", "getMduId", "getNodeList", "getRevision", "setRevision", "(Ljava/lang/String;)V", "getShopId", "getTyingItemsFlag", "setTyingItemsFlag", "(I)V", "getWineConfirm", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;)Lcom/didi/soda/cart/model/SetItemParams;", "equals", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddCartRequestParams.kt */
public final class SetItemParams implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 5549678927273636014L;
    private final ActInfoEntity actInfo;
    private final int amount;
    private final String biData;
    private CustomerRpcCallback<CartInfoEntity> callback;
    private final List<CustomerRpcCallback<CartInfoEntity>> callbacks;
    private final String cartId;
    private final boolean isMultiContents;
    private final String itemId;
    private final String itemUniKey;
    private final String mduId;
    private final List<ItemNodeEntity> nodeList;
    private String revision;
    private final String shopId;
    private int tyingItemsFlag;
    private final Integer wineConfirm;

    public static /* synthetic */ SetItemParams copy$default(SetItemParams setItemParams, String str, String str2, String str3, boolean z, int i, List list, String str4, String str5, Integer num, String str6, String str7, ActInfoEntity actInfoEntity, int i2, Object obj) {
        SetItemParams setItemParams2 = setItemParams;
        int i3 = i2;
        return setItemParams.copy((i3 & 1) != 0 ? setItemParams2.shopId : str, (i3 & 2) != 0 ? setItemParams2.itemId : str2, (i3 & 4) != 0 ? setItemParams2.itemUniKey : str3, (i3 & 8) != 0 ? setItemParams2.isMultiContents : z, (i3 & 16) != 0 ? setItemParams2.amount : i, (i3 & 32) != 0 ? setItemParams2.nodeList : list, (i3 & 64) != 0 ? setItemParams2.cartId : str4, (i3 & 128) != 0 ? setItemParams2.mduId : str5, (i3 & 256) != 0 ? setItemParams2.wineConfirm : num, (i3 & 512) != 0 ? setItemParams2.revision : str6, (i3 & 1024) != 0 ? setItemParams2.biData : str7, (i3 & 2048) != 0 ? setItemParams2.actInfo : actInfoEntity);
    }

    public final String component1() {
        return this.shopId;
    }

    public final String component10() {
        return this.revision;
    }

    public final String component11() {
        return this.biData;
    }

    public final ActInfoEntity component12() {
        return this.actInfo;
    }

    public final String component2() {
        return this.itemId;
    }

    public final String component3() {
        return this.itemUniKey;
    }

    public final boolean component4() {
        return this.isMultiContents;
    }

    public final int component5() {
        return this.amount;
    }

    public final List<ItemNodeEntity> component6() {
        return this.nodeList;
    }

    public final String component7() {
        return this.cartId;
    }

    public final String component8() {
        return this.mduId;
    }

    public final Integer component9() {
        return this.wineConfirm;
    }

    public final SetItemParams copy(String str, String str2, String str3, boolean z, int i, List<? extends ItemNodeEntity> list, String str4, String str5, Integer num, String str6, String str7, ActInfoEntity actInfoEntity) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        String str8 = str2;
        Intrinsics.checkNotNullParameter(str8, BlocksConst.ACTION_PARAMS_ITEM_ID);
        List<? extends ItemNodeEntity> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "nodeList");
        String str9 = str6;
        Intrinsics.checkNotNullParameter(str9, "revision");
        String str10 = str7;
        Intrinsics.checkNotNullParameter(str10, "biData");
        return new SetItemParams(str, str8, str3, z, i, list2, str4, str5, num, str9, str10, actInfoEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetItemParams)) {
            return false;
        }
        SetItemParams setItemParams = (SetItemParams) obj;
        return Intrinsics.areEqual((Object) this.shopId, (Object) setItemParams.shopId) && Intrinsics.areEqual((Object) this.itemId, (Object) setItemParams.itemId) && Intrinsics.areEqual((Object) this.itemUniKey, (Object) setItemParams.itemUniKey) && this.isMultiContents == setItemParams.isMultiContents && this.amount == setItemParams.amount && Intrinsics.areEqual((Object) this.nodeList, (Object) setItemParams.nodeList) && Intrinsics.areEqual((Object) this.cartId, (Object) setItemParams.cartId) && Intrinsics.areEqual((Object) this.mduId, (Object) setItemParams.mduId) && Intrinsics.areEqual((Object) this.wineConfirm, (Object) setItemParams.wineConfirm) && Intrinsics.areEqual((Object) this.revision, (Object) setItemParams.revision) && Intrinsics.areEqual((Object) this.biData, (Object) setItemParams.biData) && Intrinsics.areEqual((Object) this.actInfo, (Object) setItemParams.actInfo);
    }

    public int hashCode() {
        int hashCode = ((this.shopId.hashCode() * 31) + this.itemId.hashCode()) * 31;
        String str = this.itemUniKey;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.isMultiContents;
        if (z) {
            z = true;
        }
        int hashCode3 = (((((hashCode2 + (z ? 1 : 0)) * 31) + this.amount) * 31) + this.nodeList.hashCode()) * 31;
        String str2 = this.cartId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mduId;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.wineConfirm;
        int hashCode6 = (((((hashCode5 + (num == null ? 0 : num.hashCode())) * 31) + this.revision.hashCode()) * 31) + this.biData.hashCode()) * 31;
        ActInfoEntity actInfoEntity = this.actInfo;
        if (actInfoEntity != null) {
            i = actInfoEntity.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "SetItemParams(shopId=" + this.shopId + ", itemId=" + this.itemId + ", itemUniKey=" + this.itemUniKey + ", isMultiContents=" + this.isMultiContents + ", amount=" + this.amount + ", nodeList=" + this.nodeList + ", cartId=" + this.cartId + ", mduId=" + this.mduId + ", wineConfirm=" + this.wineConfirm + ", revision=" + this.revision + ", biData=" + this.biData + ", actInfo=" + this.actInfo + VersionRange.RIGHT_OPEN;
    }

    public SetItemParams(String str, String str2, String str3, boolean z, int i, List<? extends ItemNodeEntity> list, String str4, String str5, Integer num, String str6, String str7, ActInfoEntity actInfoEntity) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, BlocksConst.ACTION_PARAMS_ITEM_ID);
        Intrinsics.checkNotNullParameter(list, "nodeList");
        Intrinsics.checkNotNullParameter(str6, "revision");
        Intrinsics.checkNotNullParameter(str7, "biData");
        this.shopId = str;
        this.itemId = str2;
        this.itemUniKey = str3;
        this.isMultiContents = z;
        this.amount = i;
        this.nodeList = list;
        this.cartId = str4;
        this.mduId = str5;
        this.wineConfirm = num;
        this.revision = str6;
        this.biData = str7;
        this.actInfo = actInfoEntity;
        this.callbacks = new ArrayList();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SetItemParams(java.lang.String r16, java.lang.String r17, java.lang.String r18, boolean r19, int r20, java.util.List r21, java.lang.String r22, java.lang.String r23, java.lang.Integer r24, java.lang.String r25, java.lang.String r26, com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r6 = 0
            goto L_0x000b
        L_0x0009:
            r6 = r19
        L_0x000b:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0012
            r9 = r2
            goto L_0x0014
        L_0x0012:
            r9 = r22
        L_0x0014:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x001a
            r10 = r2
            goto L_0x001c
        L_0x001a:
            r10 = r23
        L_0x001c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0022
            r11 = r2
            goto L_0x0024
        L_0x0022:
            r11 = r24
        L_0x0024:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x002c
            java.lang.String r1 = ""
            r13 = r1
            goto L_0x002e
        L_0x002c:
            r13 = r26
        L_0x002e:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0034
            r14 = r2
            goto L_0x0036
        L_0x0034:
            r14 = r27
        L_0x0036:
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r7 = r20
            r8 = r21
            r12 = r25
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.model.SetItemParams.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getItemUniKey() {
        return this.itemUniKey;
    }

    public final boolean isMultiContents() {
        return this.isMultiContents;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final List<ItemNodeEntity> getNodeList() {
        return this.nodeList;
    }

    public final String getCartId() {
        return this.cartId;
    }

    public final String getMduId() {
        return this.mduId;
    }

    public final Integer getWineConfirm() {
        return this.wineConfirm;
    }

    public final String getRevision() {
        return this.revision;
    }

    public final void setRevision(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.revision = str;
    }

    public final String getBiData() {
        return this.biData;
    }

    public final ActInfoEntity getActInfo() {
        return this.actInfo;
    }

    public final int getTyingItemsFlag() {
        return this.tyingItemsFlag;
    }

    public final void setTyingItemsFlag(int i) {
        this.tyingItemsFlag = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SetItemParams(java.lang.String r17, java.lang.String r18, java.lang.String r19, boolean r20, int r21, java.util.List r22, java.lang.String r23, java.lang.String r24, java.lang.Integer r25, java.lang.String r26, java.lang.String r27, com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity r28, int r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r16 = this;
            r0 = r30
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r6 = 0
            goto L_0x000b
        L_0x0009:
            r6 = r20
        L_0x000b:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0012
            r9 = r2
            goto L_0x0014
        L_0x0012:
            r9 = r23
        L_0x0014:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x001a
            r10 = r2
            goto L_0x001c
        L_0x001a:
            r10 = r24
        L_0x001c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0022
            r11 = r2
            goto L_0x0024
        L_0x0022:
            r11 = r25
        L_0x0024:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x002c
            java.lang.String r1 = ""
            r13 = r1
            goto L_0x002e
        L_0x002c:
            r13 = r27
        L_0x002e:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0034
            r14 = r2
            goto L_0x0036
        L_0x0034:
            r14 = r28
        L_0x0036:
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r7 = r21
            r8 = r22
            r12 = r26
            r15 = r29
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.model.SetItemParams.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SetItemParams(String str, String str2, String str3, boolean z, int i, List<? extends ItemNodeEntity> list, String str4, String str5, Integer num, String str6, String str7, ActInfoEntity actInfoEntity, int i2) {
        this(str, str2, str3, z, i, list, str4, str5, num, str6, str7, actInfoEntity);
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, BlocksConst.ACTION_PARAMS_ITEM_ID);
        Intrinsics.checkNotNullParameter(list, "nodeList");
        Intrinsics.checkNotNullParameter(str6, "revision");
        Intrinsics.checkNotNullParameter(str7, "biData");
        this.tyingItemsFlag = i2;
    }

    public final CustomerRpcCallback<CartInfoEntity> getCallback() {
        return this.callback;
    }

    public final void setCallback(CustomerRpcCallback<CartInfoEntity> customerRpcCallback) {
        this.callback = customerRpcCallback;
        if (customerRpcCallback != null) {
            this.callbacks.add(customerRpcCallback);
        }
    }

    public final List<CustomerRpcCallback<CartInfoEntity>> getCallbacks() {
        return this.callbacks;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/cart/model/SetItemParams$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AddCartRequestParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
