package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import com.didi.payment.base.view.PayRichInfo;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Entry;", "Ljava/io/Serializable;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "()V", "iconUrl", "", "getIconUrl", "()Ljava/lang/String;", "setIconUrl", "(Ljava/lang/String;)V", "linkUrl", "getLinkUrl", "setLinkUrl", "name", "getName", "setName", "productLine", "getProductLine", "setProductLine", "promotionText", "Lcom/didi/payment/base/view/PayRichInfo;", "getPromotionText", "()Lcom/didi/payment/base/view/PayRichInfo;", "setPromotionText", "(Lcom/didi/payment/base/view/PayRichInfo;)V", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Entry */
/* compiled from: WalletHomeModel.kt */
public final class Entry implements IData, Serializable {
    private String iconUrl;
    private String linkUrl;
    private String name;
    private String productLine;
    private PayRichInfo promotionText;

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getProductLine() {
        return this.productLine;
    }

    public final void setProductLine(String str) {
        this.productLine = str;
    }

    public final PayRichInfo getPromotionText() {
        return this.promotionText;
    }

    public final void setPromotionText(PayRichInfo payRichInfo) {
        this.promotionText = payRichInfo;
    }
}
