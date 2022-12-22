package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import com.didi.payment.base.view.PayRichInfo;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountStatusMessage;", "Ljava/io/Serializable;", "()V", "linkUrl", "", "getLinkUrl", "()Ljava/lang/String;", "setLinkUrl", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "statusMessage", "Lcom/didi/payment/base/view/PayRichInfo;", "getStatusMessage", "()Lcom/didi/payment/base/view/PayRichInfo;", "setStatusMessage", "(Lcom/didi/payment/base/view/PayRichInfo;)V", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountStatusMessage */
/* compiled from: WalletHomeModel.kt */
public final class AccountStatusMessage implements Serializable {
    private String linkUrl;
    private String status;
    private PayRichInfo statusMessage;

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public final PayRichInfo getStatusMessage() {
        return this.statusMessage;
    }

    public final void setStatusMessage(PayRichInfo payRichInfo) {
        this.statusMessage = payRichInfo;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }
}
