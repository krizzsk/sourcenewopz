package com.didi.entrega.bill.model;

import android.view.View;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR5\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001a\u0010+\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001c\u0010.\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001c\u0010:\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\b¨\u0006="}, mo175978d2 = {"Lcom/didi/entrega/bill/model/PriceModel;", "", "()V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "isShowLoading", "", "()Z", "setShowLoading", "(Z)V", "onPayClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnPayClick", "()Lkotlin/jvm/functions/Function1;", "setOnPayClick", "(Lkotlin/jvm/functions/Function1;)V", "packageInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "getPackageInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "setPackageInfo", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;)V", "payBtnText", "getPayBtnText", "setPayBtnText", "priceSumOri", "", "getPriceSumOri", "()I", "setPriceSumOri", "(I)V", "priceSumOriText", "getPriceSumOriText", "setPriceSumOriText", "realPayPrice", "getRealPayPrice", "setRealPayPrice", "realPayPriceText", "getRealPayPriceText", "setRealPayPriceText", "receiverAddress", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "getReceiverAddress", "()Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "setReceiverAddress", "(Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;)V", "senderAddress", "getSenderAddress", "setSenderAddress", "sn", "getSn", "setSn", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PriceModel.kt */
public final class PriceModel {

    /* renamed from: a */
    private String f19554a;

    /* renamed from: b */
    private int f19555b;

    /* renamed from: c */
    private String f19556c;

    /* renamed from: d */
    private int f19557d;

    /* renamed from: e */
    private String f19558e;

    /* renamed from: f */
    private String f19559f;

    /* renamed from: g */
    private boolean f19560g;

    /* renamed from: h */
    private ContactStufEntity f19561h;

    /* renamed from: i */
    private AddressEntity f19562i;

    /* renamed from: j */
    private AddressEntity f19563j;

    /* renamed from: k */
    private String f19564k;
    public Function1<? super View, Unit> onPayClick;

    public final String getCartId() {
        return this.f19554a;
    }

    public final void setCartId(String str) {
        this.f19554a = str;
    }

    public final int getPriceSumOri() {
        return this.f19555b;
    }

    public final void setPriceSumOri(int i) {
        this.f19555b = i;
    }

    public final String getPriceSumOriText() {
        return this.f19556c;
    }

    public final void setPriceSumOriText(String str) {
        this.f19556c = str;
    }

    public final int getRealPayPrice() {
        return this.f19557d;
    }

    public final void setRealPayPrice(int i) {
        this.f19557d = i;
    }

    public final String getRealPayPriceText() {
        return this.f19558e;
    }

    public final void setRealPayPriceText(String str) {
        this.f19558e = str;
    }

    public final String getSn() {
        return this.f19559f;
    }

    public final void setSn(String str) {
        this.f19559f = str;
    }

    public final boolean isShowLoading() {
        return this.f19560g;
    }

    public final void setShowLoading(boolean z) {
        this.f19560g = z;
    }

    public final ContactStufEntity getPackageInfo() {
        return this.f19561h;
    }

    public final void setPackageInfo(ContactStufEntity contactStufEntity) {
        this.f19561h = contactStufEntity;
    }

    public final AddressEntity getReceiverAddress() {
        return this.f19562i;
    }

    public final void setReceiverAddress(AddressEntity addressEntity) {
        this.f19562i = addressEntity;
    }

    public final AddressEntity getSenderAddress() {
        return this.f19563j;
    }

    public final void setSenderAddress(AddressEntity addressEntity) {
        this.f19563j = addressEntity;
    }

    public final String getPayBtnText() {
        return this.f19564k;
    }

    public final void setPayBtnText(String str) {
        this.f19564k = str;
    }

    public final Function1<View, Unit> getOnPayClick() {
        Function1<? super View, Unit> function1 = this.onPayClick;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onPayClick");
        return null;
    }

    public final void setOnPayClick(Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onPayClick = function1;
    }
}
