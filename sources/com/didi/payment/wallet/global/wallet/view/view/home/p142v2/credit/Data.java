package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.credit;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/Data;", "Ljava/io/Serializable;", "()V", "entryList", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/Entry;", "getEntryList", "()Ljava/util/List;", "setEntryList", "(Ljava/util/List;)V", "promotionText", "", "getPromotionText", "()Ljava/lang/String;", "setPromotionText", "(Ljava/lang/String;)V", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.credit.Data */
/* compiled from: BankCardResp.kt */
public final class Data implements Serializable {
    private List<Entry> entryList;
    private String promotionText;

    public final List<Entry> getEntryList() {
        return this.entryList;
    }

    public final void setEntryList(List<Entry> list) {
        this.entryList = list;
    }

    public final String getPromotionText() {
        return this.promotionText;
    }

    public final void setPromotionText(String str) {
        this.promotionText = str;
    }
}
