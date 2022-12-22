package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeAmountStatus;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\b¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/PrepaidInfo;", "Ljava/io/Serializable;", "()V", "exp", "", "getExp", "()Ljava/lang/String;", "setExp", "(Ljava/lang/String;)V", "localExp", "getLocalExp", "localNum", "getLocalNum", "mum", "getMum", "setMum", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.PrepaidInfo */
/* compiled from: WalletHomeModel.kt */
public final class PrepaidInfo implements Serializable {
    private String exp;
    private String mum;

    public final String getExp() {
        return this.exp;
    }

    public final void setExp(String str) {
        this.exp = str;
    }

    public final String getMum() {
        return this.mum;
    }

    public final void setMum(String str) {
        this.mum = str;
    }

    public final String getLocalExp() {
        if (WalletHomeAmountStatus.Companion.isShowAmount()) {
            return String.valueOf(this.exp);
        }
        return WalletHomeAmountStatus.Companion.getEncryptionStr(3);
    }

    public final String getLocalNum() {
        if (WalletHomeAmountStatus.Companion.isShowAmount()) {
            return String.valueOf(this.mum);
        }
        return WalletHomeAmountStatus.Companion.getEncryptionStr(8);
    }
}
