package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeAmountStatus;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0011\u0010\f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/BankCard;", "Ljava/io/Serializable;", "()V", "cardNum", "", "getCardNum", "()Ljava/lang/String;", "setCardNum", "(Ljava/lang/String;)V", "linkUrl", "getLinkUrl", "setLinkUrl", "localCardNum", "getLocalCardNum", "promotionText", "Lcom/didi/payment/base/view/PayRichInfo;", "getPromotionText", "()Lcom/didi/payment/base/view/PayRichInfo;", "setPromotionText", "(Lcom/didi/payment/base/view/PayRichInfo;)V", "redDot", "getRedDot", "setRedDot", "title", "getTitle", "setTitle", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.BankCard */
/* compiled from: WalletHomeModel.kt */
public final class BankCard implements Serializable {
    private String cardNum;
    private String linkUrl;
    private PayRichInfo promotionText;
    private String redDot;
    private String title;

    public final String getCardNum() {
        return this.cardNum;
    }

    public final void setCardNum(String str) {
        this.cardNum = str;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final PayRichInfo getPromotionText() {
        return this.promotionText;
    }

    public final void setPromotionText(PayRichInfo payRichInfo) {
        this.promotionText = payRichInfo;
    }

    public final String getLocalCardNum() {
        if (WalletHomeAmountStatus.Companion.isShowAmount()) {
            return String.valueOf(this.cardNum);
        }
        return WalletHomeAmountStatus.Companion.getEncryptionStr(1);
    }

    public final String getRedDot() {
        return this.redDot;
    }

    public final void setRedDot(String str) {
        this.redDot = str;
    }
}
