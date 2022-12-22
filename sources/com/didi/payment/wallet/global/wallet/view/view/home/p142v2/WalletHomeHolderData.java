package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.IData;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007B%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "T", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "", "viewType", "", "contentObj", "(Ljava/lang/Integer;Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;)V", "title", "", "(Ljava/lang/Integer;Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;Ljava/lang/String;)V", "getContentObj", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "setContentObj", "(Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;)V", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "localIndex", "getLocalIndex", "()Ljava/lang/Integer;", "setLocalIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getViewType", "setViewType", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeHolderData */
/* compiled from: WalletHomeHolderData.kt */
public final class WalletHomeHolderData<T extends IData> {

    /* renamed from: a */
    private Integer f32640a;

    /* renamed from: b */
    private Integer f32641b;

    /* renamed from: c */
    private String f32642c;

    /* renamed from: d */
    private T f32643d;

    public WalletHomeHolderData(Integer num, T t) {
        this.f32640a = 0;
        this.f32641b = 0;
        this.f32642c = "";
        this.f32640a = num;
        this.f32643d = t;
    }

    public WalletHomeHolderData(Integer num, T t, String str) {
        this(num, t);
        this.f32642c = str;
    }

    public final Integer getViewType() {
        return this.f32640a;
    }

    public final void setViewType(Integer num) {
        this.f32640a = num;
    }

    public final Integer getLocalIndex() {
        return this.f32641b;
    }

    public final void setLocalIndex(Integer num) {
        this.f32641b = num;
    }

    public final String getTitle() {
        return this.f32642c;
    }

    public final void setTitle(String str) {
        this.f32642c = str;
    }

    public final T getContentObj() {
        return this.f32643d;
    }

    public final void setContentObj(T t) {
        this.f32643d = t;
    }
}
