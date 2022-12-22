package com.didi.soda.cart.model;

import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\b\u0018\u0000 ?2\u00020\u0001:\u0002?@BY\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fBM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\fHÆ\u0003J]\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u000eHÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R8\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00162\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00160\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u001e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0014R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006A"}, mo175978d2 = {"Lcom/didi/soda/cart/model/SetItemAmountParams;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "shopId", "", "itemId", "itemUniKey", "cartId", "content", "Lcom/didi/soda/cart/model/SetItemAmountParams$Content;", "revision", "biData", "actInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "tyingItemsFlag", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/cart/model/SetItemAmountParams$Content;Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/cart/model/SetItemAmountParams$Content;Ljava/lang/String;Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;)V", "getActInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "getBiData", "()Ljava/lang/String;", "value", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "callback", "getCallback", "()Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "setCallback", "(Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;)V", "callbacks", "", "getCallbacks", "()Ljava/util/List;", "getCartId", "getContent", "()Lcom/didi/soda/cart/model/SetItemAmountParams$Content;", "contents", "getContents", "getItemId", "getItemUniKey", "getRevision", "setRevision", "(Ljava/lang/String;)V", "getShopId", "getTyingItemsFlag", "()I", "setTyingItemsFlag", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "Content", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddCartRequestParams.kt */
public final class SetItemAmountParams implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 5609253796491434305L;
    private final ActInfoEntity actInfo;
    private final String biData;
    private CustomerRpcCallback<CartInfoEntity> callback;
    private final List<CustomerRpcCallback<CartInfoEntity>> callbacks;
    private final String cartId;
    private final Content content;
    private final List<Content> contents;
    private final String itemId;
    private final String itemUniKey;
    private String revision;
    private final String shopId;
    private int tyingItemsFlag;

    public static /* synthetic */ SetItemAmountParams copy$default(SetItemAmountParams setItemAmountParams, String str, String str2, String str3, String str4, Content content2, String str5, String str6, ActInfoEntity actInfoEntity, int i, Object obj) {
        SetItemAmountParams setItemAmountParams2 = setItemAmountParams;
        int i2 = i;
        return setItemAmountParams.copy((i2 & 1) != 0 ? setItemAmountParams2.shopId : str, (i2 & 2) != 0 ? setItemAmountParams2.itemId : str2, (i2 & 4) != 0 ? setItemAmountParams2.itemUniKey : str3, (i2 & 8) != 0 ? setItemAmountParams2.cartId : str4, (i2 & 16) != 0 ? setItemAmountParams2.content : content2, (i2 & 32) != 0 ? setItemAmountParams2.revision : str5, (i2 & 64) != 0 ? setItemAmountParams2.biData : str6, (i2 & 128) != 0 ? setItemAmountParams2.actInfo : actInfoEntity);
    }

    public final String component1() {
        return this.shopId;
    }

    public final String component2() {
        return this.itemId;
    }

    public final String component3() {
        return this.itemUniKey;
    }

    public final String component4() {
        return this.cartId;
    }

    public final Content component5() {
        return this.content;
    }

    public final String component6() {
        return this.revision;
    }

    public final String component7() {
        return this.biData;
    }

    public final ActInfoEntity component8() {
        return this.actInfo;
    }

    public final SetItemAmountParams copy(String str, String str2, String str3, String str4, Content content2, String str5, String str6, ActInfoEntity actInfoEntity) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, BlocksConst.ACTION_PARAMS_ITEM_ID);
        Intrinsics.checkNotNullParameter(str4, Const.BundleKey.CART_ID);
        Intrinsics.checkNotNullParameter(content2, "content");
        String str7 = str5;
        Intrinsics.checkNotNullParameter(str7, "revision");
        String str8 = str6;
        Intrinsics.checkNotNullParameter(str8, "biData");
        return new SetItemAmountParams(str, str2, str3, str4, content2, str7, str8, actInfoEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetItemAmountParams)) {
            return false;
        }
        SetItemAmountParams setItemAmountParams = (SetItemAmountParams) obj;
        return Intrinsics.areEqual((Object) this.shopId, (Object) setItemAmountParams.shopId) && Intrinsics.areEqual((Object) this.itemId, (Object) setItemAmountParams.itemId) && Intrinsics.areEqual((Object) this.itemUniKey, (Object) setItemAmountParams.itemUniKey) && Intrinsics.areEqual((Object) this.cartId, (Object) setItemAmountParams.cartId) && Intrinsics.areEqual((Object) this.content, (Object) setItemAmountParams.content) && Intrinsics.areEqual((Object) this.revision, (Object) setItemAmountParams.revision) && Intrinsics.areEqual((Object) this.biData, (Object) setItemAmountParams.biData) && Intrinsics.areEqual((Object) this.actInfo, (Object) setItemAmountParams.actInfo);
    }

    public int hashCode() {
        int hashCode = ((this.shopId.hashCode() * 31) + this.itemId.hashCode()) * 31;
        String str = this.itemUniKey;
        int i = 0;
        int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.cartId.hashCode()) * 31) + this.content.hashCode()) * 31) + this.revision.hashCode()) * 31) + this.biData.hashCode()) * 31;
        ActInfoEntity actInfoEntity = this.actInfo;
        if (actInfoEntity != null) {
            i = actInfoEntity.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SetItemAmountParams(shopId=" + this.shopId + ", itemId=" + this.itemId + ", itemUniKey=" + this.itemUniKey + ", cartId=" + this.cartId + ", content=" + this.content + ", revision=" + this.revision + ", biData=" + this.biData + ", actInfo=" + this.actInfo + VersionRange.RIGHT_OPEN;
    }

    public SetItemAmountParams(String str, String str2, String str3, String str4, Content content2, String str5, String str6, ActInfoEntity actInfoEntity) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, BlocksConst.ACTION_PARAMS_ITEM_ID);
        Intrinsics.checkNotNullParameter(str4, Const.BundleKey.CART_ID);
        Intrinsics.checkNotNullParameter(content2, "content");
        Intrinsics.checkNotNullParameter(str5, "revision");
        Intrinsics.checkNotNullParameter(str6, "biData");
        this.shopId = str;
        this.itemId = str2;
        this.itemUniKey = str3;
        this.cartId = str4;
        this.content = content2;
        this.revision = str5;
        this.biData = str6;
        this.actInfo = actInfoEntity;
        this.callbacks = new ArrayList();
        this.contents = CollectionsKt.mutableListOf(this.content);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SetItemAmountParams(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, com.didi.soda.cart.model.SetItemAmountParams.Content r16, java.lang.String r17, java.lang.String r18, com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 64
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = ""
            r9 = r1
            goto L_0x000c
        L_0x000a:
            r9 = r18
        L_0x000c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0013
            r0 = 0
            r10 = r0
            goto L_0x0015
        L_0x0013:
            r10 = r19
        L_0x0015:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.model.SetItemAmountParams.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.didi.soda.cart.model.SetItemAmountParams$Content, java.lang.String, java.lang.String, com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public final String getCartId() {
        return this.cartId;
    }

    public final Content getContent() {
        return this.content;
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
    public /* synthetic */ SetItemAmountParams(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, com.didi.soda.cart.model.SetItemAmountParams.Content r17, java.lang.String r18, java.lang.String r19, com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity r20, int r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 64
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = ""
            r9 = r1
            goto L_0x000c
        L_0x000a:
            r9 = r19
        L_0x000c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0013
            r0 = 0
            r10 = r0
            goto L_0x0015
        L_0x0013:
            r10 = r20
        L_0x0015:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r11 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.model.SetItemAmountParams.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.didi.soda.cart.model.SetItemAmountParams$Content, java.lang.String, java.lang.String, com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SetItemAmountParams(String str, String str2, String str3, String str4, Content content2, String str5, String str6, ActInfoEntity actInfoEntity, int i) {
        this(str, str2, str3, str4 == null ? "" : str4, content2, str5, str6, actInfoEntity);
        String str7 = str;
        Intrinsics.checkNotNullParameter(str, "shopId");
        String str8 = str2;
        Intrinsics.checkNotNullParameter(str2, BlocksConst.ACTION_PARAMS_ITEM_ID);
        Content content3 = content2;
        Intrinsics.checkNotNullParameter(content2, "content");
        Intrinsics.checkNotNullParameter(str5, "revision");
        Intrinsics.checkNotNullParameter(str6, "biData");
        this.tyingItemsFlag = i;
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

    public final List<Content> getContents() {
        return this.contents;
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/cart/model/SetItemAmountParams$Content;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "mduId", "", "amount", "", "(Ljava/lang/String;I)V", "getAmount", "()I", "getMduId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AddCartRequestParams.kt */
    public static final class Content implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -5329735373993166451L;
        private final int amount;
        private final String mduId;

        public static /* synthetic */ Content copy$default(Content content, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = content.mduId;
            }
            if ((i2 & 2) != 0) {
                i = content.amount;
            }
            return content.copy(str, i);
        }

        public final String component1() {
            return this.mduId;
        }

        public final int component2() {
            return this.amount;
        }

        public final Content copy(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "mduId");
            return new Content(str, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return Intrinsics.areEqual((Object) this.mduId, (Object) content.mduId) && this.amount == content.amount;
        }

        public int hashCode() {
            return (this.mduId.hashCode() * 31) + this.amount;
        }

        public String toString() {
            return "Content(mduId=" + this.mduId + ", amount=" + this.amount + VersionRange.RIGHT_OPEN;
        }

        public Content(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "mduId");
            this.mduId = str;
            this.amount = i;
        }

        public final String getMduId() {
            return this.mduId;
        }

        public final int getAmount() {
            return this.amount;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/cart/model/SetItemAmountParams$Content$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: AddCartRequestParams.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/cart/model/SetItemAmountParams$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AddCartRequestParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
