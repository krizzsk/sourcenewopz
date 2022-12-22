package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeAmountStatus;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Coupon;", "Ljava/io/Serializable;", "()V", "couponNum", "", "getCouponNum", "()Ljava/lang/String;", "setCouponNum", "(Ljava/lang/String;)V", "lastCouponTime", "getLastCouponTime", "setLastCouponTime", "linkUrl", "getLinkUrl", "setLinkUrl", "localCouponNum", "getLocalCouponNum", "title", "getTitle", "setTitle", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Coupon */
/* compiled from: WalletHomeModel.kt */
public final class Coupon implements Serializable {
    private String couponNum;
    private String lastCouponTime;
    private String linkUrl;
    private String title;

    public final String getCouponNum() {
        return this.couponNum;
    }

    public final void setCouponNum(String str) {
        this.couponNum = str;
    }

    public final String getLastCouponTime() {
        return this.lastCouponTime;
    }

    public final void setLastCouponTime(String str) {
        this.lastCouponTime = str;
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

    public final String getLocalCouponNum() {
        if (WalletHomeAmountStatus.Companion.isShowAmount()) {
            return String.valueOf(this.couponNum);
        }
        return WalletHomeAmountStatus.Companion.getEncryptionStr(1);
    }
}
